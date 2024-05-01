package com.marketplace.custom.checkout.helper;

import com.buycorp.common.util.ObjectMapperUtil;
import com.liferay.account.model.AccountEntry;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionOptionRel;
import com.liferay.commerce.product.model.CPDefinitionOptionValueRel;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.service.CPDefinitionOptionRelLocalService;
import com.liferay.commerce.product.service.CPDefinitionOptionValueRelLocalService;
import com.liferay.commerce.product.util.CPJSONUtil;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.util.CommerceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;
import com.marketplace.checkout.consignee.service.CheckoutConsigneeDetailsLocalService;
import com.marketplace.custom.checkout.model.CommerceOrderItemModel;
import com.marketplace.custom.checkout.util.CheckoutConsigneeStepUtil;
import com.marketplace.product.master.exception.NoSuchProductException;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.ws.api.WebServiceApi;
import com.marketplace.ws.impl.WebServiceImpl;
import com.marketplace.ws.response.consignee.details.ConsigneeDetailsBeans;
import com.marketplace.ws.response.consignee.details.UserDetail;
import com.marketplace.ws.response.user.org.details.OrganizationAddress;
import com.marketplace.ws.response.user.org.details.UserOrgDetailsBean;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author anubhav.kalra
 */
@Component(immediate = true, service = CheckoutConsigneeStepHelper.class)
public class CheckoutConsigneeStepHelper {

    /**
     * Returns a list of Commerce Order Items by Processing them by adding required
     * details.
     *
     * @param commerceContext
     * @param commerceOrder
     * @param themeDisplay
     * @return
     */
    public List<CommerceOrderItemModel> getCommerceOrderItems(CommerceContext commerceContext,
                                                              CommerceOrder commerceOrder, ThemeDisplay themeDisplay) {

        List<CommerceOrderItemModel> commerceOrderItems = new ArrayList<>();

        long commerceAccountId = getCommerceAccountId(commerceContext);

        List<CommerceOrderItem> commerceOrderItemsLR = CheckoutConsigneeStepUtil.getCommerceOrderItems(commerceOrder);

        commerceOrderItemsLR.stream().forEach(commerceOrderItem -> {

            CPDefinition cpDefinition = getCPDefinitionByOrderItem(commerceOrderItem);
            Product product = getProductByCPDefinitionId(cpDefinition.getCPDefinitionId());

            CommerceOrderItemModel commerceOrderItemModel = new CommerceOrderItemModel();

            int totalConsignees = getTotalConsignees(commerceOrder.getCommerceOrderId(),
                    commerceOrderItem.getCommerceOrderItemId());

            commerceOrderItemModel.setProductImageUrl(getProductImageUrl(cpDefinition, commerceAccountId));
            commerceOrderItemModel.setProductName(cpDefinition.getName(themeDisplay.getLanguageId()));
            commerceOrderItemModel.setTotalConsignees(totalConsignees);

            if (Validator.isNotNull(product)) {
                commerceOrderItemModel.setModelName(product.getModelNumber());

                setBrandCategoryDetails(product, commerceOrderItemModel);
                setSellerDetails(product, commerceOrderItemModel);
            }

            commerceOrderItemModel.setCommerceOrderItemId(commerceOrderItem.getCommerceOrderItemId());
            setPDPFriendlyUrl(themeDisplay, commerceOrderItem, commerceOrderItemModel);
            setProductVariant(commerceOrderItem, commerceOrderItemModel, themeDisplay,
                    cpDefinition.getCPDefinitionId());
            setProductPriceDetails(commerceOrderItemModel, commerceOrderItem);
            setProductQuantity(commerceOrderItemModel, commerceOrderItem);

            commerceOrderItems.add(commerceOrderItemModel);

        });

        return commerceOrderItems;
    }

    /**
     * Returns a commerce Product object from a commerce order item.
     *
     * @param commerceOrderItem
     * @return
     */
    private CPDefinition getCPDefinitionByOrderItem(CommerceOrderItem commerceOrderItem) {

        try {
            return commerceOrderItem.getCPDefinition();
        } catch (PortalException e) {
            LOGGER.warn(
                    "Unable to get CPDefinition instance of Commerce Order Item. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }
        return null;

    }

    /**
     * Returns Commerce Account Id of a Commerce Order by fetching it from Commerce
     * context.
     *
     * @param commerceContext
     * @return
     */
    private long getCommerceAccountId(CommerceContext commerceContext) {
        try {
            return CommerceUtil.getCommerceAccountId(commerceContext);
        } catch (PortalException e) {
            LOGGER.warn("Unable to fetch CommerceAccountId. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }
        return 0;
    }

    /**
     * Returns the Product's default Image URL if present, if not then returns
     * false.
     *
     * @param cpDefinition
     * @param commerceAccountId
     * @return
     */
    private String getProductImageUrl(CPDefinition cpDefinition, long commerceAccountId) {

        try {
            return cpDefinition.getDefaultImageThumbnailSrc(commerceAccountId);
        } catch (Exception e) {
            LOGGER.warn("Unable to get product thumbnail url. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }
        return StringPool.BLANK;
    }

    /**
     * Returns an object of Marketplace Product by a CPDefinitionId.
     *
     * @param cpDefinitionId
     * @return
     */
    private Product getProductByCPDefinitionId(long cpDefinitionId) {
        try {
            return productLocalService.findByCPDefinitionId(cpDefinitionId);
        } catch (NoSuchProductException e) {
            LOGGER.warn("Unable to get Product Instance by CPDefinitionId. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }
        return null;
    }

    /**
     * Sets brand and category details of a product in the Commerce Order Item
     * beans.
     *
     * @param product
     * @param commerceOrderItemModel
     */
    private void setBrandCategoryDetails(Product product, CommerceOrderItemModel commerceOrderItemModel) {

        try {
            Brand brand = brandLocalService.getBrand(product.getBrandId());
            Category category = categoryLocalService.getCategory(product.getCategoryId());

            commerceOrderItemModel.setBrandId(brand.getBrandId());
            commerceOrderItemModel.setBrandName(brand.getBrandName());
            commerceOrderItemModel.setBrandType(brand.getBrandType());
            commerceOrderItemModel.setCategoryId(category.getCategoryId());
            commerceOrderItemModel.setCategoryName(category.getCategoryName());

        } catch (PortalException e) {
            LOGGER.warn("Unable to set Brand & Category Details in POJO. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }
    }

    /**
     * @param themeDisplay
     * @param commerceOrderItem
     * @param commerceOrderItemModel
     */
    private void setPDPFriendlyUrl(ThemeDisplay themeDisplay, CommerceOrderItem commerceOrderItem,
                                   CommerceOrderItemModel commerceOrderItemModel) {
        try {
            String productDisplayUrl = CheckoutConsigneeStepUtil.getPDPFriendlyUrl(themeDisplay, commerceOrderItem);
            commerceOrderItemModel.setProductDisplayUrl(productDisplayUrl);
        } catch (PortalException e) {
            LOGGER.warn("Unable to set PDP Friendly Url in POJO. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }
    }

    /**
     * @param commerceOrderItem
     * @param commerceOrderItemModel
     * @param themeDisplay
     * @param cpDefinitionId
     */
    private void setProductVariant(CommerceOrderItem commerceOrderItem, CommerceOrderItemModel commerceOrderItemModel,
                                   ThemeDisplay themeDisplay, long cpDefinitionId) {

        List<KeyValuePair> keyValuePairList = getProductVariant(commerceOrderItem, themeDisplay, cpDefinitionId);

        if (Validator.isNull(keyValuePairList) || keyValuePairList.isEmpty())
            return;

        StringJoiner stringJoiner = new StringJoiner(StringPool.COMMA);

        for (KeyValuePair keyValuePair : keyValuePairList) {
            stringJoiner.add(keyValuePair.getValue());
        }

        commerceOrderItemModel.setProductVariant(stringJoiner.toString());

    }

    /**
     * @param commerceOrderItem
     * @param themeDisplay
     * @param cpDefinitionId
     * @return
     */
    private List<KeyValuePair> getProductVariant(CommerceOrderItem commerceOrderItem, ThemeDisplay themeDisplay,
                                                 long cpDefinitionId) {

        List<KeyValuePair> values = new ArrayList<>();

        if (Validator.isNull(commerceOrderItem.getJson()))
            return values;

        JSONArray jsonArray;

        try {
            jsonArray = CPJSONUtil.toJSONArray(commerceOrderItem.getJson());
        } catch (JSONException e) {
            LOGGER.warn("Unable to get Commerce Order JSON. Please enable debug logs for full details");
            LOGGER.debug(e, e);
            return null;
        }

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String key = jsonObject.getString("key");

            CPDefinitionOptionRel cpDefinitionOptionRel = cpDefinitionOptionRelLocalService
                    .fetchCPDefinitionOptionRelByKey(cpDefinitionId, key);

            if (cpDefinitionOptionRel == null) {
                continue;
            }

            JSONArray valueJSONArray = CPJSONUtil.getJSONArray(jsonObject, "value");

            for (int j = 0; j < valueJSONArray.length(); j++) {
                String value = valueJSONArray.getString(j);

                CPDefinitionOptionValueRel cpDefinitionOptionValueRel = cpDefinitionOptionValueRelLocalService
                        .fetchCPDefinitionOptionValueRel(cpDefinitionOptionRel.getCPDefinitionOptionRelId(), value);

                if (cpDefinitionOptionValueRel != null) {
                    value = cpDefinitionOptionValueRel.getName(themeDisplay.getLocale());
                } else {
                    value = valueJSONArray.getString(j);
                }

                KeyValuePair keyValuePair = new KeyValuePair();

                keyValuePair.setKey(cpDefinitionOptionRel.getName(themeDisplay.getLocale()));
                keyValuePair.setValue(value);

                values.add(keyValuePair);
            }
        }

        return values;

    }

    /**
     *
     * @param product
     * @param commerceOrderItemModel
     */
    private void setSellerDetails(Product product, CommerceOrderItemModel commerceOrderItemModel) {
        commerceOrderItemModel.setSellerId(product.getVendorId());
        commerceOrderItemModel.setSellerName(product.getOrganizationName());
    }

    /**
     * @param commerceOrderItemModel
     * @param commerceOrderItem
     */
    private void setProductPriceDetails(CommerceOrderItemModel commerceOrderItemModel,
                                        CommerceOrderItem commerceOrderItem) {

        CPInstance cpInstance = commerceOrderItem.fetchCPInstance();

        BigDecimal originalPrice = cpInstance.getPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal discountedPrice = cpInstance.getPromoPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal priceDifference = originalPrice.subtract(discountedPrice);
        BigDecimal percentageDiscount;

        if (originalPrice.compareTo(BigDecimal.ZERO) != 0) {
            percentageDiscount = priceDifference.divide(originalPrice, 2, RoundingMode.HALF_EVEN)
                    .multiply(BigDecimal.valueOf(100));
        } else {
            percentageDiscount = BigDecimal.ZERO;
        }

        commerceOrderItem.getFinalPrice();

        commerceOrderItemModel.setUnitPrice(cpInstance.getPromoPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN));
        commerceOrderItemModel.setBasePrice(cpInstance.getPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN));
        commerceOrderItemModel
                .setDiscountPercentage(percentageDiscount + StringPool.PERCENT + StringPool.SPACE + "off");
        commerceOrderItemModel
                .setTotalAmount(commerceOrderItem.getFinalPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN));

    }

    /**
     * @param commerceOrderItemModel
     * @param commerceOrderItem
     */
    private void setProductQuantity(CommerceOrderItemModel commerceOrderItemModel,
                                    CommerceOrderItem commerceOrderItem) {
        int quantity = commerceOrderItem.getQuantity().intValueExact();

        commerceOrderItemModel.setQuantity(quantity);
    }

    /**
     * Constructs Consginee Details by fetching Consignees and Organization
     * Addresses and storing them in their respective Maps.
     *
     * @param httpServletRequest
     */
    public void constructConsigneeDetails(HttpServletRequest httpServletRequest, PortletSession portletSession,
                                          PortletRequest portletRequest) {

        httpServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);

        Map<String, JSONObject> consigneeDetailsMap = new HashMap<>();
        Map<Long, JSONObject> addressesMap = new HashMap<>();

        WebServiceApi webServiceApi = new WebServiceImpl();

        HttpSession httpSession = httpServletRequest.getSession();

        /*httpSession.setAttribute("arxUserId", "CPDLG2");
        httpSession.setAttribute("accessToken", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImFyeF9kZWZhdWx0In0.eyJzdWIiOiJDUERMRzIiLCJmbmFtZSI6InN1YmFybmEiLCJ1c2Vyc3RhdHVzIjoiMSIsImVudGl0eWxpc3QiOlsiQnV5Q29ycFYyIl0sInVzZXJObyI6IjIwMjQwMzA3MTg2MSIsInJvbGVzIjpbIkJVWUVSIl0sImlzcyI6Imh0dHA6Ly8xNzIuMTYuMTc2LjMxOjMxMDEwL2FyeC1zc28vb2F1dGgvIiwiYXVkIjoiZGVmYXVsdCIsImxuYW1lIjoiYnV5ZXIiLCJzX2lkIjo0Mzk5NzAsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIiwibmlja25hbWUiOiJDUERMRzIiLCJ1c2VyVHlwZSI6IjEiLCJleHAiOjE3MTI4MTIzNzksImxhbmciOiJlbl9VUyIsImlhdCI6MTcxMjgxMTQ3OSwianRpIjoiN2UzNzM3OWItYTdkOC00Njc4LWJiYjUtYjk4YmIwYjcyNGVlIiwiZW50aXR5IjoiQnV5Q29ycCJ9.T2qaM4ST89WFUI1jylggwgX-msQM2IrVUYtqgmmY0e-E_LgN-fq76XLyfcm3dlNW9OFh9PVYtes36lqTyTkowvEax0khoKuJPkXQmHRXI2g565SkPLld236fErflyNmPxSfqHBTx57a1FGRXL4dDYKuiCjUbc7_7c1jhAXQ5MKuEawNWTsR-fsrNL00OJnTn-RQ2vuyf6OlAeZAPWhFGM9NgDqYfoEnV1Ojdg8Bnc1isc-Nh0MpXFfGCevHTfjqjsUMSy5SlataprLdmm7EFpS4j3EqAXnSnTvbbQZZFJ5Am5lYaCp1LKzniHIMEpmIFNOjM8a2rvDdaj-KSj3hE7g");*/

        LOGGER.info("Access Token--------------------> " + httpSession.getAttribute("accessToken"));
        LOGGER.info("ARX User Id--------------------> " + httpSession.getAttribute("arxUserId"));

        ConsigneeDetailsBeans consigneeDetailsBeans;
        UserOrgDetailsBean organizationDetailsBeans;

        try {
            consigneeDetailsBeans = webServiceApi.getOrganizationUsers("63", "CONSIGNEE", httpServletRequest);
            consigneeDetailsMap = getConsigneesDetails(consigneeDetailsBeans, portletRequest);
            portletSession.setAttribute("consigneeDetailsMap", consigneeDetailsMap);
        } catch (Exception e) {
            LOGGER.warn("Unable to fetch Consignee Details from API. Please enable debug logs for full details.");
            LOGGER.debug(e, e);

            SessionErrors.add(httpServletRequest, "consignee-api-failure");
            return;
        }

        try {
            organizationDetailsBeans = webServiceApi.getUserOrganisationDetails(httpServletRequest,
                    (String) httpSession.getAttribute("arxUserId"));
            addressesMap = getAddressMap(organizationDetailsBeans, portletRequest);
            portletSession.setAttribute("addresses", addressesMap);
        } catch (Exception e) {
            LOGGER.warn("Unable to fetch Organization Details from API. Please enable debug logs for full details.");
            LOGGER.debug(e, e);

            SessionErrors.add(httpServletRequest, "address-api-failure");
            return;
        }

    }

    /**
     * Returns a Map of Consignee Details associated with their unique Id.
     *
     * @param consigneeDetailsBeans
     * @return
     */
    private Map<String, JSONObject> getConsigneesDetails(ConsigneeDetailsBeans consigneeDetailsBeans,
                                                         PortletRequest portletRequest) {

        Map<String, JSONObject> consigneesDetailsMap = new HashMap<>();
        Map<String, String> consigneeDetails = new HashMap<>();

        consigneeDetailsBeans.getUserDetails().stream().forEach(consigneeDetail -> {

            try {

                JSONObject consigneeUserDetails = JSONFactoryUtil
                        .createJSONObject(ObjectMapperUtil.parseToJSON(consigneeDetail));

                consigneesDetailsMap.put(consigneeDetail.getUserId(), consigneeUserDetails);

                consigneeDetails.put(consigneeDetail.getUserId(),
                        consigneeDetail.getFirstName() + StringPool.SPACE + consigneeDetail.getLastName());

            } catch (JSONException e) {
                LOGGER.warn(
                        "Unable to parse consignee user details to Json. Please enable debug logs for full details.");
                LOGGER.debug(e, e);
            }

        });

        portletRequest.setAttribute("consigneeDetails", consigneeDetails);

        return consigneesDetailsMap;

    }

    /**
     * Returns a map of Organization Addresses associated with a uniquely generated
     * Id. Unique Id of each address will contain current date and time stamp.
     *
     * @param organizationDetailsBeans
     * @return
     */
    private Map<Long, JSONObject> getAddressMap(UserOrgDetailsBean organizationDetailsBeans,
                                                PortletRequest portletRequest) {

        Map<Long, JSONObject> organizationAddressMap = new HashMap<>();
        Map<Long, String> organizationAddresses = new HashMap<>();

        organizationDetailsBeans.getUserOrgAssociation().get(0).getOrganizationAddress().stream().forEach(address -> {

            Long consigneeAddressId = Long.valueOf(address.getAddressId());

            try {

                JSONObject organizationAddressDetails = JSONFactoryUtil
                        .createJSONObject(ObjectMapperUtil.parseToJSON(address));

                organizationAddressMap.put(consigneeAddressId, organizationAddressDetails);

                String consigneeAddress = address.getAddressTitle() + StringPool.COMMA_AND_SPACE
                        + address.getAddressLine1() + StringPool.COMMA_AND_SPACE + address.getLandmark()
                        + StringPool.COMMA_AND_SPACE + address.getStateCode() + StringPool.COMMA_AND_SPACE
                        + address.getCountryCode() + StringPool.COMMA_AND_SPACE + address.getZipCode() + " ("
                        + address.getAddressType() + ")";

                organizationAddresses.put(consigneeAddressId, consigneeAddress);

            } catch (JSONException e) {
                LOGGER.warn(
                        "Unable to parse organization address details to Json. Please enable debug logs for full details.");
                LOGGER.debug(e, e);
            }

        });

        portletRequest.setAttribute("organizationAddresses", organizationAddresses);

        return organizationAddressMap;

    }

    /**
     * @param jsonObject
     * @param themeDisplay
     * @param portletSession
     */
    @SuppressWarnings({"unchecked"})
    public void updateCheckoutConsigneeDetails(JSONObject jsonObject, ThemeDisplay themeDisplay,
                                               PortletSession portletSession) {

        List<Long> checkoutConsigneeDetailIdList = new ArrayList<>();

        List<CheckoutConsigneeDetails> checkoutConsigneeDetailsList = checkoutConsigneeDetailsLocalService
                .getCheckoutConsigneeDetails(jsonObject.getLong("parentCartId"), jsonObject.getLong("orderItemId"));

        Map<String, JSONObject> consigneeDetailsMap = (Map<String, JSONObject>) portletSession
                .getAttribute("consigneeDetailsMap");
        Map<Long, JSONObject> organizationAddressesMap = (Map<Long, JSONObject>) portletSession
                .getAttribute("addresses");

        JSONArray consignees = jsonObject.getJSONArray("consignees");

        for (int index = 0; index < consignees.length(); index++) {

            JSONObject consignee = consignees.getJSONObject(index);

            CheckoutConsigneeDetails checkoutConsigneeDetails;

            try {

                checkoutConsigneeDetails = checkoutConsigneeDetailsLocalService
                        .getCheckoutConsigneeDetails(consignee.getLong("checkoutConsigneeId"));

            } catch (PortalException e) {

                LOGGER.info("No Checkout Consignee Mapping found. Creating new checkout consignee mapping.");

                checkoutConsigneeDetails = createCheckoutConsigneeDetails(consignee, themeDisplay,
                        jsonObject.getLong("parentCartId"), jsonObject.getLong("orderItemId"));

            }

            String shippingConsigneeJson = consigneeDetailsMap.get(consignee.getString("shippingConsigneeName"))
                    .toString();

            String billingConsigneeJson = consigneeDetailsMap.get(consignee.getString("billingConsigneeName"))
                    .toString();

            long shippingConsigneeAddressId = Long.valueOf(consignee.getString("shippingConsigneeAddress"));

            String shippingConsigneeAddressJson = StringPool.BLANK;

            if (Validator.isNotNull(organizationAddressesMap.get(shippingConsigneeAddressId)))
                shippingConsigneeAddressJson = organizationAddressesMap.get(shippingConsigneeAddressId).toString();

            long billingConsigneeAddressId = Long.valueOf(consignee.getString("billingConsigneeAddress"));

            String billingConsigneeAddressJson = StringPool.BLANK;

            if (Validator.isNotNull(organizationAddressesMap.get(billingConsigneeAddressId)))
                billingConsigneeAddressJson = organizationAddressesMap.get(billingConsigneeAddressId).toString();

            checkoutConsigneeDetails.setShippingConsigneeId(consignee.getString("shippingConsigneeName"));
            checkoutConsigneeDetails.setShipConsigneeJson(shippingConsigneeJson);
            checkoutConsigneeDetails.setShipConsigneeAddressID(consignee.getString("shippingConsigneeAddress"));
            checkoutConsigneeDetails.setShipConsigneeAddressJson(shippingConsigneeAddressJson);
            checkoutConsigneeDetails.setBillingConsigneeId(consignee.getString("billingConsigneeName"));
            checkoutConsigneeDetails.setBillConsigneeJson(billingConsigneeJson);
            checkoutConsigneeDetails.setBillConsigneeAddressId(consignee.getString("billingConsigneeAddress"));
            checkoutConsigneeDetails.setBillConsigneeAddressJson(billingConsigneeAddressJson);
            checkoutConsigneeDetails.setQuantity(consignee.getLong("quantity"));
            checkoutConsigneeDetails.setModifiedDate(new Date());
            checkoutConsigneeDetails.setModifiedBy(themeDisplay.getUserId());

            checkoutConsigneeDetails = checkoutConsigneeDetailsLocalService
                    .updateCheckoutConsigneeDetails(checkoutConsigneeDetails);

            checkoutConsigneeDetailIdList.add(checkoutConsigneeDetails.getCheckoutConsigneeId());

        }

        deleteUnusedConsigneeList(checkoutConsigneeDetailsList, checkoutConsigneeDetailIdList);

    }

    /**
     * @param consignee
     * @param themeDisplay
     * @param parentCartId
     * @param orderItemId
     * @return
     */
    private CheckoutConsigneeDetails createCheckoutConsigneeDetails(JSONObject consignee, ThemeDisplay themeDisplay,
                                                                    long parentCartId, long orderItemId) {

        CheckoutConsigneeDetails checkoutConsigneeDetails = checkoutConsigneeDetailsLocalService
                .createCheckoutConsigneeDetails(counterLocalService.increment());

        checkoutConsigneeDetails.setParentCartId(parentCartId);
        checkoutConsigneeDetails.setOrderItemId(orderItemId);
        checkoutConsigneeDetails.setUserId(themeDisplay.getUserId());
        checkoutConsigneeDetails.setCreateDate(new Date());
        checkoutConsigneeDetails.setCreatedBy(themeDisplay.getUserId());
        checkoutConsigneeDetails.setCompanyId(themeDisplay.getCompanyId());
        checkoutConsigneeDetails.setGroupId(themeDisplay.getScopeGroupId());
        checkoutConsigneeDetails.setUserName(themeDisplay.getUser().getFullName());

        return checkoutConsigneeDetails;

    }

    /**
     * @param checkoutConsigneeDetailsList
     * @param checkoutConsigneeDetailIdList
     */
    private void deleteUnusedConsigneeList(List<CheckoutConsigneeDetails> checkoutConsigneeDetailsList,
                                           List<Long> checkoutConsigneeDetailIdList) {

        checkoutConsigneeDetailsList.stream().filter(
                        consigneeDetails -> !checkoutConsigneeDetailIdList.contains(consigneeDetails.getCheckoutConsigneeId()))
                .forEach(element -> {
                    deleteCheckoutConsigneeDetails(element.getCheckoutConsigneeId());
                });

    }

    /**
     * @param checkoutConsigneeDetailsId
     */
    private void deleteCheckoutConsigneeDetails(long checkoutConsigneeDetailsId) {

        try {
            checkoutConsigneeDetailsLocalService.deleteCheckoutConsigneeDetails(checkoutConsigneeDetailsId);
        } catch (PortalException e) {
            LOGGER.warn("Unable to delete consignee Details. Please enable debug logs for full details");
            LOGGER.debug(e, e);
        }

    }

    /**
     * @param jsonObject
     * @param portletSession
     * @return
     */
    @SuppressWarnings("unchecked")
    public JSONObject getCheckoutConsigneeDetails(JSONObject jsonObject, PortletSession portletSession) {

        JSONObject orderConsigneeDetails = JSONFactoryUtil.createJSONObject();
        JSONArray consignees = JSONFactoryUtil.createJSONArray();

        long parentCartId = jsonObject.getLong("parentCartId");
        long orderItemId = jsonObject.getLong("orderItemId");

        List<CheckoutConsigneeDetails> checkoutConsigneeDetailsList = checkoutConsigneeDetailsLocalService
                .getCheckoutConsigneeDetails(parentCartId, orderItemId);

        Map<String, JSONObject> consigneeDetailsMap = (Map<String, JSONObject>) portletSession
                .getAttribute("consigneeDetailsMap");
        Map<Long, JSONObject> organizationAddressesMap = (Map<Long, JSONObject>) portletSession
                .getAttribute("addresses");

        if (Validator.isNotNull(checkoutConsigneeDetailsList) && !checkoutConsigneeDetailsList.isEmpty()) {
            for (CheckoutConsigneeDetails consignee : checkoutConsigneeDetailsList) {

                JSONArray shippingConsigneeArray = getConsigneeDetailsArray(consigneeDetailsMap,
                        consignee.getShippingConsigneeId());
                JSONArray shippingConsigneeAddressArray = getOrganizationAddressArray(organizationAddressesMap,
                        Long.valueOf(consignee.getShipConsigneeAddressID()));

                JSONArray billingConsigneeArray = getConsigneeDetailsArray(consigneeDetailsMap,
                        consignee.getBillingConsigneeId());
                JSONArray billingConsigneeAddressArray = getOrganizationAddressArray(organizationAddressesMap,
                        Long.valueOf(consignee.getBillConsigneeAddressId()));

                JSONObject consigneeDetails = JSONFactoryUtil.createJSONObject();

                consigneeDetails.put("checkoutConsigneeId", consignee.getCheckoutConsigneeId());
                consigneeDetails.put("shippingConsignees", shippingConsigneeArray);
                consigneeDetails.put("shippingConsigneeAddresses", shippingConsigneeAddressArray);
                consigneeDetails.put("billingConsignees", billingConsigneeArray);
                consigneeDetails.put("billingConsigneeAddresses", billingConsigneeAddressArray);
                consigneeDetails.put("quantity", consignee.getQuantity());

                consignees.put(consigneeDetails);

            }
        } else {

            JSONArray shippingConsigneeArray = getConsigneeDetailsArray(consigneeDetailsMap, StringPool.BLANK);
            JSONArray shippingConsigneeAddressArray = getOrganizationAddressArray(organizationAddressesMap, 0);

            JSONArray billingConsigneeArray = getConsigneeDetailsArray(consigneeDetailsMap, StringPool.BLANK);
            JSONArray billingConsigneeAddressArray = getOrganizationAddressArray(organizationAddressesMap, 0);

            JSONObject consigneeDetails = JSONFactoryUtil.createJSONObject();

            consigneeDetails.put("checkoutConsigneeId", "");
            consigneeDetails.put("shippingConsignees", shippingConsigneeArray);
            consigneeDetails.put("shippingConsigneeAddresses", shippingConsigneeAddressArray);
            consigneeDetails.put("billingConsignees", billingConsigneeArray);
            consigneeDetails.put("billingConsigneeAddresses", billingConsigneeAddressArray);
            consigneeDetails.put("quantity", 0);

            consignees.put(consigneeDetails);

        }

        return orderConsigneeDetails.put("orderConsigneeDetails", consignees);

    }

    private JSONArray getConsigneeDetailsArray(Map<String, JSONObject> consigneeDetailsMap, String uniqueId) {

        return consigneeDetailsMap.entrySet().stream().map(entry -> {
            UserDetail userDetails = ObjectMapperUtil.parseToBean(entry.getValue().toString(), UserDetail.class);

            JSONObject consigneeObject = JSONFactoryUtil.createJSONObject();
            consigneeObject.put("isSelected", entry.getKey().equals(uniqueId));
            consigneeObject.put("userId", entry.getKey());
            consigneeObject.put("userName", userDetails.getFirstName() + StringPool.SPACE + userDetails.getLastName());
            return consigneeObject;

        }).collect(JSONFactoryUtil::createJSONArray, JSONArray::put, JSONArray::put);
    }

    private JSONArray getOrganizationAddressArray(Map<Long, JSONObject> organizationAddressesMap,
                                                  long organizationAddressId) {

        return organizationAddressesMap.entrySet().stream().map(entry -> {

            OrganizationAddress address = ObjectMapperUtil.parseToBean(entry.getValue().toString(),
                    OrganizationAddress.class);

            String consigneeAddress = address.getAddressTitle() + StringPool.COMMA_AND_SPACE + address.getAddressLine1()
                    + StringPool.COMMA_AND_SPACE + address.getLandmark() + StringPool.COMMA_AND_SPACE
                    + address.getStateCode() + StringPool.COMMA_AND_SPACE + address.getCountryCode()
                    + StringPool.COMMA_AND_SPACE + address.getZipCode() + " (" + address.getAddressType() + ")";

            JSONObject orgAddressObject = JSONFactoryUtil.createJSONObject();
            orgAddressObject.put("isSelected", entry.getKey().equals(organizationAddressId));
            orgAddressObject.put("organizationAddressId", entry.getKey());
            orgAddressObject.put("organizationAddress", consigneeAddress);
            return orgAddressObject;

        }).collect(JSONFactoryUtil::createJSONArray, JSONArray::put, JSONArray::put);
    }

    public List<CommerceOrderItemModel> getCommerceOrderItemsWithConsignees(CommerceContext commerceContext,
                                                                            CommerceOrder commerceOrder, ThemeDisplay themeDisplay) {

        List<CommerceOrderItemModel> commerceOrderItems = new ArrayList<>();

        long commerceAccountId = getCommerceAccountId(commerceContext);

        List<CommerceOrderItem> commerceOrderItemsLR = CheckoutConsigneeStepUtil.getCommerceOrderItems(commerceOrder);

        commerceOrderItemsLR.stream().forEach(commerceOrderItem -> {

            CPDefinition cpDefinition = getCPDefinitionByOrderItem(commerceOrderItem);
            Product product = getProductByCPDefinitionId(cpDefinition.getCPDefinitionId());
            CommerceOrderItemModel commerceOrderItemModel = new CommerceOrderItemModel();

            int totalConsignees = getTotalConsignees(commerceOrder.getCommerceOrderId(),
                    commerceOrderItem.getCommerceOrderItemId());

            commerceOrderItemModel.setProductImageUrl(getProductImageUrl(cpDefinition, commerceAccountId));
            commerceOrderItemModel.setProductName(cpDefinition.getName(themeDisplay.getLanguageId()));
            commerceOrderItemModel.setTotalConsignees(totalConsignees);

            if (Validator.isNotNull(product)) {
                commerceOrderItemModel.setModelName(product.getModelNumber());

                setBrandCategoryDetails(product, commerceOrderItemModel);
                setSellerDetails(product, commerceOrderItemModel);
            }

            commerceOrderItemModel.setCommerceOrderItemId(commerceOrderItem.getCommerceOrderItemId());
            setPDPFriendlyUrl(themeDisplay, commerceOrderItem, commerceOrderItemModel);
            setProductVariant(commerceOrderItem, commerceOrderItemModel, themeDisplay,
                    cpDefinition.getCPDefinitionId());
            setProductPriceDetails(commerceOrderItemModel, commerceOrderItem);
            setProductQuantity(commerceOrderItemModel, commerceOrderItem);

            commerceOrderItems.add(commerceOrderItemModel);

        });

        return commerceOrderItems;
    }

    private int getTotalConsignees(long parentCartId, long orderItemId) {

        return (int) checkoutConsigneeDetailsLocalService.getCheckoutConsigneeDetails(parentCartId, orderItemId)
                .stream().count();
    }

    public void renderOrderTotal(HttpSession httpSession, PortletRequest portletRequest, CommerceOrder commerceOrder,
                                 String renderType) {

        BigDecimal subtotalAmount = commerceOrder.getSubtotal().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal taxAmount = commerceOrder.getTaxAmount().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal totalAmountWithShippment = commerceOrder.getTotal().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal shippmentAmount = commerceOrder.getShippingAmount().setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal totalAmountWithoutShippment = totalAmountWithShippment.subtract(shippmentAmount);

        if (renderType.equals("redirect-to-order-summary")) {
            httpSession.setAttribute("orderSubTotal", subtotalAmount);
            httpSession.setAttribute("taxAmount", taxAmount);
            httpSession.setAttribute("orderTotalAmount", totalAmountWithoutShippment);
        } else {
            portletRequest.setAttribute("orderSubTotal", subtotalAmount);
            portletRequest.setAttribute("taxAmount", taxAmount);
            portletRequest.setAttribute("orderTotalAmount", totalAmountWithoutShippment);
        }

    }

    public void pushShipNBillAddressToCommerce(PortletSession portletSession, ThemeDisplay themeDisplay, CommerceOrder commerceOrder) {

        LOGGER.info("---------- Pushing Default Address for Shipping and Billing in Commerce Order ----------");

        long classNameId = classNameLocalService.getClassNameId(AccountEntry.class.getName());

        // Constructing default address of a logged-in user
        createDefaultAddress(portletSession, themeDisplay, commerceOrder.getCommerceAccountId(), classNameId);

        try {
            classNameId = classNameLocalService.getClassNameId(CommerceOrder.class.getName());

            Address billingAddress = createDefaultAddress(portletSession, themeDisplay, commerceOrder.getCommerceOrderId(), classNameId);
            Address shippingAddress = createDefaultAddress(portletSession, themeDisplay, commerceOrder.getCommerceOrderId(), classNameId);

            commerceOrderLocalService.updateBillingAddress(commerceOrder.getCommerceOrderId(), billingAddress.getAddressId());
            commerceOrderLocalService.updateShippingAddress(commerceOrder.getCommerceOrderId(), shippingAddress.getAddressId());

        } catch (PortalException e) {
            LOGGER.warn("Unable to push default address in liferay commerce order. Please enable debug logs for full details.");
            LOGGER.debug(e, e);
        }

    }

    /**
     * Constructs default address for the logged-in user
     *
     * @param portletSession
     * @param themeDisplay
     * @return
     */
    private Address createDefaultAddress(PortletSession portletSession, ThemeDisplay themeDisplay, long classPK, long classNameId) {

        Map<String, JSONObject> consignees = (Map<String, JSONObject>) portletSession.getAttribute("addresses");
        Map.Entry<String, JSONObject> defaultUser = consignees.entrySet().stream().findFirst().get();
        Map<Long, JSONObject> addresses = (Map<Long, JSONObject>) portletSession.getAttribute("addresses");
        Map.Entry<Long, JSONObject> defaultAddress = addresses.entrySet().stream().findFirst().get();

        JSONObject defaultAddressJson = defaultAddress.getValue();
        JSONObject defaultUserJson = defaultUser.getValue();

        String countryCode = defaultAddressJson.getString("country_code");
        String regionName = defaultAddressJson.getString("state_code");
        String city = defaultAddressJson.getString("district_province_code");
        String street1 = defaultAddressJson.getString("address_line_1");
        String street2 = defaultAddressJson.getString("address_line_2");
        String street3 = defaultAddressJson.getString("address_line_3");
        String zip = defaultAddressJson.getString("zip_code");
        String name = defaultUserJson.getString("first_name") + StringPool.SPACE + defaultUserJson.getString("last_name");

        Country country = countryLocalService.fetchCountryByName(themeDisplay.getCompanyId(), countryCode.toLowerCase());
        ListType shippingBillingListType = listTypeLocalService.getListType("billing-and-shipping", "com.liferay.account.model.AccountEntry.address");
        List<Region> regions = regionLocalService.getRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        Region region = regions.stream().filter(region1 -> regionName.equalsIgnoreCase(region1.getName())).findFirst().get();

        Address address = addressLocalService.createAddress(counterLocalService.increment());

        setAddressAuditFields(address, themeDisplay, classPK, classNameId);
        setPrimaryAddressDetails(address, country.getCountryId(), shippingBillingListType.getListTypeId(), region.getRegionId(), city);
        setSecondaryAddressDetails(address, name, street1, street2, street3, zip);

        return addressLocalService.updateAddress(address);

    }

    private void setAddressAuditFields(Address address, ThemeDisplay themeDisplay, long classPK, long classNameId) {
        address.setCompanyId(themeDisplay.getCompanyId());
        address.setUserId(themeDisplay.getUserId());
        address.setUserName(themeDisplay.getUser().getFullName());
        address.setCreateDate(new Date());
        address.setModifiedDate(new Date());
        address.setClassPK(classPK);
        address.setClassNameId(classNameId);
    }

    private void setPrimaryAddressDetails(Address address, long countryId, long listTypeId, long regionId, String city) {
        address.setCountryId(countryId);
        address.setListTypeId(listTypeId);
        address.setRegionId(regionId);
        address.setCity(city);
    }

    private void setSecondaryAddressDetails(Address address, String name, String street1, String street2, String street3, String zip) {
        address.setName(name);
        address.setStreet1(street1);
        address.setStreet2(street2);
        address.setStreet3(street3);
        address.setZip(zip);
    }

    @Reference
    private ProductLocalService productLocalService;

    @Reference
    private BrandLocalService brandLocalService;

    @Reference
    private CategoryLocalService categoryLocalService;

    @Reference
    private CPDefinitionOptionRelLocalService cpDefinitionOptionRelLocalService;

    @Reference
    private CPDefinitionOptionValueRelLocalService cpDefinitionOptionValueRelLocalService;

    @Reference
    private CheckoutConsigneeDetailsLocalService checkoutConsigneeDetailsLocalService;

    @Reference
    private CountryLocalService countryLocalService;

    @Reference
    private ListTypeLocalService listTypeLocalService;

    @Reference
    private RegionLocalService regionLocalService;

    @Reference
    private AddressLocalService addressLocalService;

    @Reference
    private CommerceOrderLocalService commerceOrderLocalService;

    @Reference
    private ClassNameLocalService classNameLocalService;

    @Reference
    private CounterLocalService counterLocalService;

    private static final Log LOGGER = LogFactoryUtil.getLog(CheckoutConsigneeStepHelper.class);

}
