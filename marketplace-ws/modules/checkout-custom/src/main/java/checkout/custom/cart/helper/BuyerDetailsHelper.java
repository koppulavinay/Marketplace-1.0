package checkout.custom.cart.helper;

import checkout.custom.cart.model.UserIdentificationBeans;
import checkout.custom.cart.model.UserInfoBeans;
import checkout.custom.model.*;
import checkout.custom.util.CheckoutUtil;
import com.liferay.petra.string.StringPool;
import com.marketplace.ws.response.user.org.details.OrganizationAddress;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author anubhav.kalra
 */
@Component(service = BuyerDetailsHelper.class, immediate = true)
public class BuyerDetailsHelper {

    public BuyerDetails getBuyerDetails(String userId, PortletRequest portletRequest) throws IOException {

        UserInfoBeans userInfoBeans = new UserInfoHelper().getUserInformation(userId, portletRequest);

        BuyerDetails buyerDetails = new BuyerDetails();

        buyerDetails.setBuyerUserId(userInfoBeans.getUserId());
        buyerDetails.setName(userInfoBeans.getName());
        buyerDetails.setMobileNumber(userInfoBeans.getMobileNumber());
        buyerDetails.setOrganizationId(Integer.valueOf(userInfoBeans.getOrganizationId()));
        buyerDetails.setOrganizationName(userInfoBeans.getOrganizationName());
        buyerDetails.setOrganizationRole(userInfoBeans.getOrganizationRole());
        buyerDetails.setUserDesignation(userInfoBeans.getUserDesignation());
        buyerDetails.setOrganizationRole("AVP-Finance");
        buyerDetails.setSystemRole(userInfoBeans.getSystemRole());
        buyerDetails.setBuyerIdentification(getBuyerIdentifications(userInfoBeans.getUserIdentificationList()));
        buyerDetails.setDates(CheckoutUtil.getDates("onboarding_date", new Date()));
        buyerDetails.setBuyerAddresses(getBuyerAddresses(userInfoBeans));

        return buyerDetails;

    }

    private List<BuyerIdentification> getBuyerIdentifications(List<UserIdentificationBeans> userIdentificationList) {

        List<BuyerIdentification> buyerIdentificationList = new ArrayList<>();

        userIdentificationList.stream().forEach(userIdentification -> {

            BuyerIdentification buyerIdentification = new BuyerIdentification();

            buyerIdentification.setIdCardNumber(userIdentification.getIdCardNumber());
            buyerIdentification.setIdCardType(userIdentification.getIdCardType());
            buyerIdentification.setIsVerified(userIdentification.getIsVerified());

            buyerIdentificationList.add(buyerIdentification);

        });

        return buyerIdentificationList;

    }

    private List<BuyerAddresses> getBuyerAddresses(UserInfoBeans userInfoBeans) {

        List<BuyerAddresses> buyerAddresses = new ArrayList<>();
        List<OrganizationAddress> organizationAddresses = userInfoBeans.getOrganizationAddresses();

        organizationAddresses.stream().forEach(organizationAddress -> {

            BuyerAddresses buyerAddress = new BuyerAddresses();

            buyerAddress.setAddressId(Integer.valueOf(organizationAddress.getAddressId()));
            buyerAddress.setAddressType(organizationAddress.getAddressType());
            buyerAddress.setAddressLine1(organizationAddress.getAddressLine1());
            buyerAddress.setAddressLine2(organizationAddress.getAddressLine2());
            buyerAddress.setAddressLine3(organizationAddress.getAddressLine3());
            buyerAddress.setAddressTitle(organizationAddress.getAddressTitle());
            buyerAddress.setCity(organizationAddress.getDistrictProvinceCode());
            buyerAddress.setCountry(CheckoutUtil.getCountry(organizationAddress.getCountryCode(), organizationAddress.getCountryCode()));
            buyerAddress.setDistrictProvince(CheckoutUtil.getDistrictProvince(organizationAddress.getDistrictProvinceCode(), organizationAddress.getDistrictProvinceCode()));
            buyerAddress.setEmail(userInfoBeans.getEmailId());
            buyerAddress.setState(CheckoutUtil.getState(organizationAddress.getStateCode(), organizationAddress.getStateCode()));
            buyerAddress.setGeoLocation(StringPool.BLANK);
            buyerAddress.setZipCode(organizationAddress.getZipCode());
            buyerAddress.setLandlineDetails(CheckoutUtil.getLandlineDetails(StringPool.BLANK, StringPool.BLANK));
            buyerAddress.setMobileNumber(userInfoBeans.getMobileNumber());

            buyerAddresses.add(buyerAddress);

        });

        return buyerAddresses;

    }

}
