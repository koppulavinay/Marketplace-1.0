package checkout.custom.cart.helper;

import checkout.custom.model.*;
import checkout.custom.util.CheckoutUtil;
import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalService;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.product.model.CPAttachmentFileEntry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue;
import com.liferay.commerce.product.model.CPSpecificationOption;
import com.liferay.commerce.product.service.CPSpecificationOptionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.checkout.consignee.model.CheckoutConsigneeDetails;
import com.marketplace.checkout.consignee.service.CheckoutConsigneeDetailsLocalService;
import com.marketplace.product.master.exception.NoSuchProductException;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Contains business logic for generating Seller-wise cart information.
 *
 * @author anubhav.kalra
 */
@Component(service = SellerCartHelper.class, immediate = true)
public class SellerCartHelper {

    /**
     * @param allCommerceOrderItems
     * @return
     */
    public List<SellerCarts> getSellerCarts(PortletRequest portletRequest, ThemeDisplay themeDisplay, CommerceContext commerceContext, List<CommerceOrderItem> allCommerceOrderItems) {

        this.themeDisplay = themeDisplay;
        this.commerceContext = commerceContext;
        this.portletRequest = portletRequest;

        List<SellerCarts> sellerCartsList = new ArrayList<>();

        Map<String, List<CommerceOrderItem>> groupedOrderItemsBySeller = getGroupedOrderItemsBySellers(allCommerceOrderItems);

        groupedOrderItemsBySeller.entrySet().stream()
                .forEach(orderItems -> {

                    List<CommerceOrderItem> commerceOrderItems = orderItems.getValue();

                    // Generating Unique Seller ID by combining Commerce Order ID and some random digits
                    int uniqueSellerCartId = (int) commerceContext.getCommerceOrder().getCommerceOrderId()
                            + CheckoutUtil.getRandomNumberUsingNextInt(345, 9835);

                    SellerCarts sellerCarts = new SellerCarts();

                    try {
                        sellerCarts.setSellerDetails(sellerDetailsHelper.getSellerDetails(orderItems.getKey(), portletRequest));
                    } catch (IOException e) {
                        LOGGER.error(e, e);
                    }

                    sellerCarts.setSellerCartId(uniqueSellerCartId);
                    sellerCarts.setItemDetails(getItemDetailsList(commerceOrderItems, commerceContext));

                    sellerCartsList.add(sellerCarts);
                });

        return sellerCartsList;

    }

    /**
     * Returns a grouping all Commerce Order Items on the basis of their Seller/Vendor ID
     *
     * @param orderItems
     * @return
     */
    private Map<String, List<CommerceOrderItem>> getGroupedOrderItemsBySellers(List<CommerceOrderItem> orderItems) {

        return orderItems.stream()
                .collect(Collectors.groupingBy(orderItem -> getVendorIdForOrderItem(orderItem.getCPDefinitionId())));
    }

    /**
     * Returns Vendor ID for an Order Item present in the commerce order.
     *
     * @param cpDefinitionId
     * @return
     */
    private String getVendorIdForOrderItem(long cpDefinitionId) {

        Product product;

        try {
            product = ProductLocalServiceUtil.findByCPDefinitionId(cpDefinitionId);
            return product.getVendorId();
        } catch (NoSuchProductException e) {
            LOGGER.warn("No Such product found with CPDefinitionId " + cpDefinitionId);
            LOGGER.error(e, e);
        }

        return StringPool.BLANK;
    }

    /**
     * @param commerceOrderItems
     * @param commerceContext
     * @return
     */
    private List<ItemDetails> getItemDetailsList(List<CommerceOrderItem> commerceOrderItems, CommerceContext commerceContext) {

        List<ItemDetails> itemDetailsList = new ArrayList<>();

        commerceOrderItems.stream().forEach(orderItem -> {
            try {
                itemDetailsList.add(getItemDetails(commerceContext, orderItem));
            } catch (PortalException e) {
                LOGGER.warn("Unable to get item details of an order item.");
                LOGGER.error(e, e);
            }
        });

        return itemDetailsList;

    }

    /**
     * @param commerceContext
     * @param commerceOrderItem
     * @return
     * @throws PortalException
     */
    private ItemDetails getItemDetails(CommerceContext commerceContext, CommerceOrderItem commerceOrderItem) throws PortalException {

        String currencyCode = commerceContext.getCommerceCurrency().getCode();

        long cpDefinitionId = commerceOrderItem.getCPDefinitionId();
        Product product = ProductLocalServiceUtil.findByCPDefinitionId(cpDefinitionId);

        ItemDetails itemDetail = new ItemDetails();

        itemDetail.setChannelId(commerceContext.getCommerceChannelId());
        itemDetail.setItemId(commerceOrderItem.getCProductId());
        itemDetail.setCartItemId(commerceOrderItem.getCommerceOrderItemId());
        itemDetail.setItemTitle(commerceOrderItem.getName(themeDisplay.getLocale()));
        itemDetail.setModel(product.getModelNumber());
        itemDetail.setUom("each");
        itemDetail.setTotalQuantity(commerceOrderItem.getQuantity().intValueExact());
        itemDetail.setOfferingType("goods");
        itemDetail.setAmcCmcDetails(null);

        setItemDetailsDates(itemDetail, commerceOrderItem.getCreateDate());
        setItemCategories(commerceOrderItem.getCPDefinitionId(), itemDetail);
        setItemPricing(itemDetail, currencyCode, commerceOrderItem);
        setItemStandards(itemDetail);
        setItemURLs(commerceOrderItem, itemDetail);
        setSpecificationDetails(commerceOrderItem, itemDetail);
        setShipmentDetails(commerceOrderItem, itemDetail);

        return itemDetail;

    }

    /**
     * @param itemDetail
     * @param orderItemCreatedDate
     */
    private void setItemDetailsDates(ItemDetails itemDetail, Date orderItemCreatedDate) {

        List<Dates> datesList = new ArrayList<>();

        Dates dates = new Dates();

        dates.setDateType("item_created_at");
        dates.setDateValue("" + CheckoutUtil.dateConverter(orderItemCreatedDate));

        datesList.add(dates);
        itemDetail.setDates(datesList);

    }

    /**
     * @param cpDefinitionId
     * @param itemDetail
     */
    private void setItemCategories(long cpDefinitionId, ItemDetails itemDetail) {

        AssetEntry assetEntry = assetEntryLocalService.fetchEntry(CPDefinition.class.getName(), cpDefinitionId);
        List<AssetEntryAssetCategoryRel> assetCategoryRels = assetEntryAssetCategoryRelLocalService
                .getAssetEntryAssetCategoryRelsByAssetEntryId(assetEntry.getEntryId());

        assetCategoryRels.stream().forEach(assetCategoryRel -> {

            AssetCategory assetCategory = assetCategoryLocalService
                    .fetchAssetCategory(assetCategoryRel.getAssetCategoryId());
            AssetVocabulary assetVocabulary = null;

            try {
                assetVocabulary = assetVocabularyLocalService.getAssetVocabulary(assetCategory.getVocabularyId());
            } catch (PortalException e) {
                LOGGER.warn("Unable to get Asset Vocabulary. Please enable debug logs for full details.");
                LOGGER.debug(e, e);
            }

            if (assetVocabulary.getName().equalsIgnoreCase("select brand")) {

                BrandDetails brandDetails = new BrandDetails();
                Brand brand = brandLocalService.findByFBYAssetCategoryId(assetCategoryRel.getAssetCategoryId());

                brandDetails.setBrandId(brand.getBrandId());
                brandDetails.setBrandName(brand.getBrandName());
                brandDetails.setBrandType(brand.getBrandType());

                itemDetail.setBrandDetails(brandDetails);

            } else if (assetVocabulary.getName().equalsIgnoreCase("select category")) {

                ItemCategory itemCategory = new ItemCategory();
                Category category = categoryLocalService.findByFBYAssetCategoryId(assetCategoryRel.getAssetCategoryId());

                itemCategory.setCategoryId(category.getCategoryId());
                itemCategory.setCategoryName(assetCategory.getName());
                itemCategory.setCategoryType(category.getCategoryType());

                itemDetail.setItemCategory(itemCategory);

            }

        });

    }

    /**
     * @param itemDetail
     * @param currencyCode
     * @param commerceOrderItem
     */
    private void setItemPricing(ItemDetails itemDetail, String currencyCode, CommerceOrderItem commerceOrderItem) {

        long basePrice = new BigDecimal(commerceOrderItem.getUnitPrice().toString()).longValue() * 100;
        long unitPrice = new BigDecimal(commerceOrderItem.getPromoPrice().toString()).longValue() * 100;

        List<ItemPricing> itemPricingList = new ArrayList<>();

        itemPricingList.add(getItemPricing(basePrice, "base price", currencyCode));
        itemPricingList.add(getItemPricing(unitPrice, "unit price", currencyCode));

        itemDetail.setItemPricing(itemPricingList);

    }

    private void setItemStandards(ItemDetails itemDetails) {
        List<ItemStandards> itemStandardsList = new ArrayList<>();
        itemStandardsList.add(CheckoutUtil.getItemStandards("HSN Code", StringPool.BLANK));
        itemDetails.setItemStandards(itemStandardsList);
    }

    /**
     * @param price
     * @param priceType
     * @param currencyCode
     * @return
     */
    private ItemPricing getItemPricing(long price, String priceType, String currencyCode) {

        ItemPricing itemPricing = new ItemPricing();

        itemPricing.setCurrency(currencyCode);
        itemPricing.setDiscountName("");
        itemPricing.setDiscountType("");
        itemPricing.setDiscountValue("");
        itemPricing.setDivisor("100");
        itemPricing.setPriceType(priceType);
        itemPricing.setValue(price);

        return itemPricing;

    }

    /**
     * @param commerceOrderItem
     * @param itemDetail
     * @throws PortalException
     */
    private void setItemURLs(CommerceOrderItem commerceOrderItem, ItemDetails itemDetail) throws PortalException {

        String productImageUrl = getProductImageUrl(commerceOrderItem.getCPDefinition(),
                commerceOrderItem.getCommerceOrder().getCommerceAccountId());
        String productImageDocumentId = String.valueOf(getDocumentId(commerceOrderItem.getCPDefinition()));

        String pdpUrl = getPDPFriendlyURL(commerceOrderItem.getCPDefinition());

        List<ItemUrls> itemUrls = new ArrayList<>();

        itemUrls.add(getItemURL("item_image_url", productImageUrl, productImageDocumentId));
        itemUrls.add(getItemURL("pdp_url", pdpUrl, String.valueOf(commerceOrderItem.getCPDefinitionId())));

        itemDetail.setItemUrls(itemUrls);

    }

    private long getDocumentId(CPDefinition cpDefinition) throws PortalException {

        List<CPAttachmentFileEntry> fileEntries = cpDefinition.getCPAttachmentFileEntries(WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_APPROVED);

        if (!fileEntries.isEmpty())
            return fileEntries.get(0).getFileEntryId();

        return 0;
    }

    /**
     * @param urlType
     * @param urlPath
     * @return
     */
    private ItemUrls getItemURL(String urlType, String urlPath, String documentId) {

        ItemUrls itemUrl = new ItemUrls();

        itemUrl.setUrlType(urlType);
        itemUrl.setUrlPath(urlPath);
        itemUrl.setDocumentId(documentId);

        return itemUrl;

    }

    /**
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
     * @param cpDefinition
     * @return
     */
    private String getPDPFriendlyURL(CPDefinition cpDefinition) {

        return themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic()
                + themeDisplay.getLayout().getGroup().getFriendlyURL() + "/p/"
                + cpDefinition.getURL(themeDisplay.getLocale().getLanguage());
    }

    /**
     * @param commerceOrderItem
     * @param itemDetail
     * @throws PortalException
     */
    private void setSpecificationDetails(CommerceOrderItem commerceOrderItem, ItemDetails itemDetail) throws PortalException {

        ItemSpecifications itemSpecifications = new ItemSpecifications();
        List<OptionDetails> optionDetailsList = new ArrayList<>();

        List<CPDefinitionSpecificationOptionValue> cpDefinitionSpecificationOptionValuesList = commerceOrderItem.getCPDefinition().getCPDefinitionSpecificationOptionValues();

        cpDefinitionSpecificationOptionValuesList.stream().forEach(optionValue -> {

            CPSpecificationOption cpSpecificationOption = null;

            try {
                cpSpecificationOption = cpSpecificationOptionLocalService.getCPSpecificationOption(optionValue.getCPSpecificationOptionId());

                OptionDetails optionDetails = new OptionDetails();

                optionDetails.setSpecificationDesc(cpSpecificationOption.getDescription(themeDisplay.getLocale()));
                optionDetails.setSpecificationId(optionValue.getCPSpecificationOptionId());
                optionDetails.setSpecificationName(cpSpecificationOption.getTitle(themeDisplay.getLocale()));
                optionDetails.setSpecificationValue(optionValue.getValue(themeDisplay.getLocale()));

                optionDetailsList.add(optionDetails);
            } catch (PortalException e) {
                LOGGER.error(e, e);
            }

        });

        itemSpecifications.setOptionDetails(optionDetailsList);
        itemDetail.setItemSpecifications(itemSpecifications);

    }

    /**
     * @param commerceOrderItem
     * @param itemDetail
     */
    private void setShipmentDetails(CommerceOrderItem commerceOrderItem, ItemDetails itemDetail) {

        List<Shipments> shipmentsList = new ArrayList<>();

        long commerceOrderItemId = commerceOrderItem.getCommerceOrderItemId();
        long commerceOrderId = commerceOrderItem.getCommerceOrderId();

        List<CheckoutConsigneeDetails> consigneesDetails = checkoutConsigneeDetailsLocalService.getCheckoutConsigneeDetails(commerceOrderId, commerceOrderItemId);

        consigneesDetails.stream().forEach(consignee -> {

            Shipments shipment = new Shipments();
            ConsigneeDetails consigneeDetails = new ConsigneeDetails();

            try {
                setConsigneeUserDetails(consignee, consigneeDetails);

                // Adding Organization ID, Organization name and Organization Role statically
                consigneeDetails.setOrganizationId(String.valueOf(63));
                consigneeDetails.setOrganizationName("BuyerOrg");
                consigneeDetails.setOrganizationRole("CONSIGNEE");

                ConsigneeAddress consigneeAddress = getShippingConsigneeAddress(consignee);
                consigneeDetails.setConsigneeAddress(consigneeAddress);
            } catch (JSONException e) {
                LOGGER.error(e, e);
            }

            consigneeDetails.setDates(CheckoutUtil.getDates("cart_creation_date", commerceOrderItem.getCreateDate()));
            consigneeDetails.setConsigneeIdentifications(getConsigneeIdentifications());
            consigneeDetails.setConsigneeLotDetails(getConsigneeLotsDetails(consignee));

            shipment.setConsigneeDetails(consigneeDetails);
            shipmentsList.add(shipment);

        });


        itemDetail.setShipments(shipmentsList);

    }

    /**
     * @param consigneeDetails
     * @return
     * @throws JSONException
     */
    private ConsigneeAddress getShippingConsigneeAddress(CheckoutConsigneeDetails consigneeDetails) throws JSONException {

        ConsigneeAddress consigneeAddress = new ConsigneeAddress();

        String shippingConsigneeAddress = consigneeDetails.getShipConsigneeAddressJson();

        JSONObject shippingConsigneeAddressJson = JSONFactoryUtil.createJSONObject(shippingConsigneeAddress);

        consigneeAddress.setAddressId((int) shippingConsigneeAddressJson.getLong("address_id"));
        consigneeAddress.setAddressLine1(shippingConsigneeAddressJson.getString("address_line_1"));
        consigneeAddress.setAddressLine2(shippingConsigneeAddressJson.getString("address_line_3"));
        consigneeAddress.setAddressLine3(shippingConsigneeAddressJson.getString("address_line_3"));
        consigneeAddress.setAddressTitle(shippingConsigneeAddressJson.getString("address_title"));
        consigneeAddress.setAddressType(shippingConsigneeAddressJson.getString("address_type"));
        consigneeAddress.setCity(shippingConsigneeAddressJson.getString("state_code"));
        consigneeAddress.setZipCode(shippingConsigneeAddressJson.getString("zip_code"));
        consigneeAddress.setGeoLocation(StringPool.BLANK);
        consigneeAddress.setLandlineDetails(CheckoutUtil.getLandlineDetails(StringPool.BLANK, StringPool.BLANK));
        consigneeAddress.setMobileNumber(CheckoutUtil.getMobileNumberDetails("+91", StringPool.BLANK));
        consigneeAddress.setState(CheckoutUtil.getState(shippingConsigneeAddressJson.getString("state_code"),
                shippingConsigneeAddressJson.getString("state_code")));
        consigneeAddress.setDistrictProvince(CheckoutUtil
                .getDistrictProvince(shippingConsigneeAddressJson.getString("district_province_code"),
                        shippingConsigneeAddressJson.getString("district_province_code")));
        consigneeAddress.setCountry(CheckoutUtil.getCountry(shippingConsigneeAddressJson.getString("country_code"),
                shippingConsigneeAddressJson.getString("country_code")));
        return consigneeAddress;

    }

    /**
     * Need to change the method implementation as consignee identifications are not coming from the API
     *
     * @return
     */
    private List<ConsigneeIdentifications> getConsigneeIdentifications() {

        List<ConsigneeIdentifications> consigneeIdentificationsList = new ArrayList<>();

        consigneeIdentificationsList.add(getConsigneeIdentification("XXXXXXXXXX", "PAN", "y"));
        consigneeIdentificationsList.add(getConsigneeIdentification("XXXXXXCP3918XYYYY", "GSTIN", "y"));

        return consigneeIdentificationsList;

    }

    /**
     * @param idCardNumber
     * @param idCardType
     * @param isVerified
     * @return
     */
    private ConsigneeIdentifications getConsigneeIdentification(String idCardNumber, String idCardType, String isVerified) {

        ConsigneeIdentifications consigneeIdentifications = new ConsigneeIdentifications();

        consigneeIdentifications.setIdCardNumber(idCardNumber);
        consigneeIdentifications.setIdCardType(idCardType);
        consigneeIdentifications.setIsVerified(isVerified);

        return consigneeIdentifications;

    }

    /**
     * @param consigneeDetails
     * @return
     */
    private List<ConsigneeLotDetails> getConsigneeLotsDetails(CheckoutConsigneeDetails consigneeDetails) {

        List<ConsigneeLotDetails> consigneeLotDetailsList = new ArrayList<>();

        ConsigneeLotDetails consigneeLotDetails = new ConsigneeLotDetails();
        consigneeLotDetails.setDeliveryEndDay("");
        consigneeLotDetails.setDeliveryStartDay("");
        consigneeLotDetails.setQuantity((int) consigneeDetails.getQuantity());

        consigneeLotDetailsList.add(consigneeLotDetails);

        return consigneeLotDetailsList;
    }

    /**
     * @param consignee
     * @param consigneeDetails
     * @throws JSONException
     */
    private void setConsigneeUserDetails(CheckoutConsigneeDetails consignee, ConsigneeDetails consigneeDetails) throws JSONException {

        String shippingConsigneeDetails = consignee.getShipConsigneeJson();
        JSONObject shippingConsigneeDetailsJson = JSONFactoryUtil.createJSONObject(shippingConsigneeDetails);

        consigneeDetails.setName((shippingConsigneeDetailsJson.getString("first_name") + StringPool.SPACE + shippingConsigneeDetailsJson.getString("last_name")));
        consigneeDetails.setConsigneeUserId(shippingConsigneeDetailsJson.getString("user_id"));
        consigneeDetails.setOrganizationId("");
        consigneeDetails.setOrganizationName("");
        consigneeDetails.setOrganizationRole("");
        consigneeDetails.setUserDesignation(shippingConsigneeDetailsJson.getString("user_designation"));
        consigneeDetails.setSystemRole("");
        consigneeDetails.setMobileNumber(CheckoutUtil.getMobileNumberDetails("+91", shippingConsigneeDetailsJson.getString("mobile_number")));

    }

    @Reference
    private AssetEntryLocalService assetEntryLocalService;

    @Reference
    private AssetEntryAssetCategoryRelLocalService assetEntryAssetCategoryRelLocalService;

    @Reference
    private AssetCategoryLocalService assetCategoryLocalService;

    @Reference
    private AssetVocabularyLocalService assetVocabularyLocalService;

    @Reference
    private BrandLocalService brandLocalService;

    @Reference
    private CategoryLocalService categoryLocalService;

    @Reference
    private CPSpecificationOptionLocalService cpSpecificationOptionLocalService;

    @Reference
    private CheckoutConsigneeDetailsLocalService checkoutConsigneeDetailsLocalService;

    @Reference
    private SellerDetailsHelper sellerDetailsHelper;

    private ThemeDisplay themeDisplay;

    private CommerceContext commerceContext;

    private PortletRequest portletRequest;

    private static final Log LOGGER = LogFactoryUtil.getLog(SellerCartHelper.class);
}
