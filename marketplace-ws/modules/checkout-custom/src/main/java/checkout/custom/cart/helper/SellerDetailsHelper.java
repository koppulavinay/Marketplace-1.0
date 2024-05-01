package checkout.custom.cart.helper;

import checkout.custom.cart.model.UserIdentificationBeans;
import checkout.custom.cart.model.UserInfoBeans;
import checkout.custom.model.SellerAddress;
import checkout.custom.model.SellerDetails;
import checkout.custom.model.SellerIdentification;
import checkout.custom.util.CheckoutUtil;
import com.liferay.petra.string.StringPool;
import com.marketplace.ws.response.user.org.details.OrganizationAddress;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author anubhav.kalra
 */
@Component(service = SellerDetailsHelper.class, immediate = true)
public class SellerDetailsHelper {

    public SellerDetails getSellerDetails(String userId, PortletRequest portletRequest) throws IOException {

        UserInfoBeans userInfoBeans = userInfoHelper.getUserInformation(userId, portletRequest);

        SellerDetails sellerDetails = new SellerDetails();

        sellerDetails.setSellerUserId(userInfoBeans.getUserId());
        sellerDetails.setSellerIdentification(getSellerIdentifications(userInfoBeans.getUserIdentificationList()));
        sellerDetails.setName(userInfoBeans.getName());
        sellerDetails.setMobileNumber(userInfoBeans.getMobileNumber());
        sellerDetails.setOrganizationId(Integer.valueOf(userInfoBeans.getOrganizationId()));
        sellerDetails.setOrganizationName(userInfoBeans.getOrganizationName());
        sellerDetails.setSystemRole(userInfoBeans.getSystemRole());
        sellerDetails.setDates(CheckoutUtil.getDates("seller_details", new Date()));
        sellerDetails.setSellerAddress(getSellerAddresses(userInfoBeans));

        return sellerDetails;

    }

    private List<SellerIdentification> getSellerIdentifications(List<UserIdentificationBeans> userIdentificationList) {

        List<SellerIdentification> sellerIdentificationList = new ArrayList<>();

        userIdentificationList.stream().forEach(userIdentification -> {

            SellerIdentification sellerIdentification = new SellerIdentification();

            sellerIdentification.setIdCardNumber(userIdentification.getIdCardNumber());
            sellerIdentification.setIdCardType(userIdentification.getIdCardType());
            sellerIdentification.setIsVerified(userIdentification.getIsVerified());

            sellerIdentificationList.add(sellerIdentification);

        });

        return sellerIdentificationList;

    }

    private List<SellerAddress> getSellerAddresses(UserInfoBeans userInfoBeans) {

        List<SellerAddress> sellerAddresses = new ArrayList<>();
        List<OrganizationAddress> organizationAddresses = userInfoBeans.getOrganizationAddresses();

        organizationAddresses.stream().forEach(organizationAddress -> {

            SellerAddress sellerAddress = new SellerAddress();

            sellerAddress.setAddressId(Integer.valueOf(organizationAddress.getAddressId()));
            sellerAddress.setAddressLine1(organizationAddress.getAddressLine1());
            sellerAddress.setAddressLine2(organizationAddress.getAddressLine2());
            sellerAddress.setAddressLine3(organizationAddress.getAddressLine3());
            sellerAddress.setAddressTitle(organizationAddress.getAddressTitle());
            sellerAddress.setCity(organizationAddress.getDistrictProvinceCode());
            sellerAddress.setCountry(CheckoutUtil.getCountry(organizationAddress.getCountryCode(), organizationAddress.getCountryCode()));
            sellerAddress.setDistrictProvince(CheckoutUtil.getDistrictProvince(organizationAddress.getDistrictProvinceCode(), organizationAddress.getDistrictProvinceCode()));
            sellerAddress.setEmail(userInfoBeans.getEmailId());
            sellerAddress.setState(CheckoutUtil.getState(organizationAddress.getStateCode(), organizationAddress.getStateCode()));
            sellerAddress.setGeoLocation(StringPool.BLANK);
            sellerAddress.setZipCode(organizationAddress.getZipCode());
            sellerAddress.setLandlineDetails(CheckoutUtil.getLandlineDetails(StringPool.BLANK, StringPool.BLANK));
            sellerAddress.setMobileNumber(userInfoBeans.getMobileNumber());

            sellerAddresses.add(sellerAddress);

        });

        return sellerAddresses;

    }

    @Reference
    private UserInfoHelper userInfoHelper;

}
