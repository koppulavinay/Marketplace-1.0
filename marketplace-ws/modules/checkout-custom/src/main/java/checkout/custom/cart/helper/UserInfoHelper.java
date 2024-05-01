package checkout.custom.cart.helper;

import checkout.custom.cart.model.UserIdentificationBeans;
import checkout.custom.cart.model.UserInfoBeans;
import checkout.custom.model.MobileNumber;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.ws.api.WebServiceApi;
import com.marketplace.ws.impl.WebServiceImpl;
import com.marketplace.ws.response.user.org.details.OrganizationAddress;
import com.marketplace.ws.response.user.org.details.UserInfo;
import com.marketplace.ws.response.user.org.details.UserOrgAssociation;
import com.marketplace.ws.response.user.org.details.UserOrgDetailsBean;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anubhav.kalra
 */
@Component(service = UserInfoHelper.class, immediate = true)
public class UserInfoHelper {

    public UserInfoBeans getUserInformation(String userId, PortletRequest portletRequest) throws IOException {

        HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));

        WebServiceApi webServiceApi = new WebServiceImpl();
        UserOrgDetailsBean userOrgDetailsBean = webServiceApi.getUserOrganisationDetails(httpServletRequest, userId);
        UserOrgAssociation userOrgAssociation = userOrgDetailsBean.getUserOrgAssociation().get(0);

        UserInfoBeans userInfoBeans = new UserInfoBeans();

        setUserDetails(userInfoBeans, userOrgAssociation);
        userInfoBeans.setUserIdentificationList(getUserIdentificationsList());
        userInfoBeans.setOrganizationAddresses(getOrganizationAddresses(userOrgAssociation));

        return userInfoBeans;

    }

    private void setUserDetails(UserInfoBeans userInfoBeans, UserOrgAssociation userOrgAssociation) {

        String userId = "N/A";
        String emailId = "N/A";
        String name = "N/A";
        String organizationId = "0";
        String organizationName = "N/A";
        String organizationRole = "N/A";
        String userDesignation = "N/A";
        String systemRole = "N/A";

        MobileNumber mobileNumber = new MobileNumber();
        mobileNumber.setMobileCode("+91");
        mobileNumber.setMobileNumber("N/A");

        UserInfo userInfo = userOrgAssociation.getUserInfo();

        if (Validator.isNotNull(userInfo)) {
            userId = userInfo.getUserId();
            emailId = userInfo.getEmailId();
            name = userInfo.getFirstName() + StringPool.SPACE + userInfo.getLastName();
            mobileNumber = getMobileNumber(userInfo);
            organizationId = userOrgAssociation.getOrganizationId();
            organizationName = userOrgAssociation.getOrganizationName();
            organizationRole = userOrgAssociation.getOrganizationRole();
            userDesignation = userOrgAssociation.getDesignation();
            systemRole = userInfo.getSystemRole();
        }

        userInfoBeans.setUserId(userId);
        userInfoBeans.setEmailId(emailId);
        userInfoBeans.setName(name);
        userInfoBeans.setMobileNumber(mobileNumber);
        userInfoBeans.setOrganizationId(organizationId);
        userInfoBeans.setOrganizationName(organizationName);
        userInfoBeans.setOrganizationRole(organizationRole);
        userInfoBeans.setUserDesignation(userDesignation);
        userInfoBeans.setSystemRole(systemRole);

    }

    private MobileNumber getMobileNumber(UserInfo userInfo) {

        MobileNumber mobileNumber = new MobileNumber();

        mobileNumber.setMobileCode("+91");
        mobileNumber.setMobileNumber(userInfo.getMobileNo());

        return mobileNumber;

    }

    /**
     * Need to change the method implementation as consignee identifications are not coming from the API
     *
     * @return
     */
    private List<UserIdentificationBeans> getUserIdentificationsList() {

        List<UserIdentificationBeans> userIdentificationList = new ArrayList<>();

        userIdentificationList.add(getUserIdentification("XXXXXXXXXX", "PAN", "y"));
        userIdentificationList.add(getUserIdentification("XXXXXXCP3918XYYYY", "GSTIN", "y"));

        return userIdentificationList;

    }

    /**
     * @param idCardNumber
     * @param idCardType
     * @param isVerified
     * @return
     */
    private UserIdentificationBeans getUserIdentification(String idCardNumber, String idCardType, String isVerified) {

        UserIdentificationBeans userIdentificationBeans = new UserIdentificationBeans();

        userIdentificationBeans.setIdCardNumber(idCardNumber);
        userIdentificationBeans.setIdCardType(idCardType);
        userIdentificationBeans.setIsVerified(isVerified);

        return userIdentificationBeans;

    }

    private List<OrganizationAddress> getOrganizationAddresses(UserOrgAssociation userOrgAssociation) {

    	if (Validator.isNull(userOrgAssociation) || Validator.isNull(userOrgAssociation.getOrganizationAddress())) {

            String countryCode = "N/A";
            String addressType = "N/A";
            String addressTitle = "N/A";
            String organizationId = "N/A";
            String addressId = "0";
            String addressLine1 = "N/A";
            String addressLine2 = "N/A";
            String addressLine3 = "N/A";
            String stateCode = "N/A";
            String districtProvinceCode = "N/A";
            String landmark = "N/A";
            String zipCode = "N/A";

            List<OrganizationAddress> organizationAddresses = new ArrayList<>();

            organizationAddresses.add(new OrganizationAddress(countryCode, addressType, addressTitle, organizationId, addressLine1,
                    addressId, addressLine3, addressLine2, stateCode, districtProvinceCode, landmark, zipCode));

            return organizationAddresses;
        }

        return userOrgAssociation.getOrganizationAddress();
    }

}
