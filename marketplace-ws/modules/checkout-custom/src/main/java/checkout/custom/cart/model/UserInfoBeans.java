package checkout.custom.cart.model;

import checkout.custom.model.Dates;
import checkout.custom.model.MobileNumber;
import checkout.custom.model.SellerAddress;
import checkout.custom.model.SellerIdentification;
import com.marketplace.ws.response.user.org.details.OrganizationAddress;

import java.util.List;


public class UserInfoBeans {

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MobileNumber getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public List<UserIdentificationBeans> getUserIdentificationList() {
        return userIdentificationList;
    }

    public void setUserIdentificationList(List<UserIdentificationBeans> userIdentificationList) {
        this.userIdentificationList = userIdentificationList;
    }

    public List<OrganizationAddress> getOrganizationAddresses() {
        return organizationAddresses;
    }

    public void setOrganizationAddresses(List<OrganizationAddress> organizationAddresses) {
        this.organizationAddresses = organizationAddresses;
    }
    public String getEmailId() {
        return emailId;
    }

    public String getOrganizationRole() {
        return organizationRole;
    }

    public void setOrganizationRole(String organizationRole) {
        this.organizationRole = organizationRole;
    }

    public String getUserDesignation() {
        return userDesignation;
    }

    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String userId;
    private String emailId;
    private String name;
    private MobileNumber mobileNumber;
    private String organizationId;
    private String organizationName;
    private String organizationRole;
    private String userDesignation;
    private String systemRole;
    private Dates dates;
    private List<UserIdentificationBeans> userIdentificationList;
    private List<OrganizationAddress> organizationAddresses;


}
