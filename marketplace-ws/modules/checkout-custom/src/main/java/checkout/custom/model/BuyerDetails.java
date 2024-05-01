package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class BuyerDetails {

   @SerializedName("buyer_user_id")
   String buyerUserId;

   @SerializedName("name")
   String name;

   @SerializedName("mobile_number")
   MobileNumber mobileNumber;

   @SerializedName("organization_id")
   Integer organizationId;

   @SerializedName("organization_name")
   String organizationName;

   @SerializedName("organization_role")
   String organizationRole;

   @SerializedName("user_designation")
   String userDesignation;

   @SerializedName("system_role")
   String systemRole;

   @SerializedName("dates")
   List<Dates> dates;

   @SerializedName("buyer_identification")
   List<BuyerIdentification> buyerIdentification;

   @SerializedName("buyer_addresses")
   List<BuyerAddresses> buyerAddresses;


    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }
    public String getBuyerUserId() {
        return buyerUserId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public MobileNumber getMobileNumber() {
        return mobileNumber;
    }
    
   
    
    public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public String getOrganizationName() {
        return organizationName;
    }
    
    public void setOrganizationRole(String organizationRole) {
        this.organizationRole = organizationRole;
    }
    public String getOrganizationRole() {
        return organizationRole;
    }
    
    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }
    public String getUserDesignation() {
        return userDesignation;
    }
    
    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }
    public String getSystemRole() {
        return systemRole;
    }
    
    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }
    public List<Dates> getDates() {
        return dates;
    }
    
    public void setBuyerIdentification(List<BuyerIdentification> buyerIdentification) {
        this.buyerIdentification = buyerIdentification;
    }
    public List<BuyerIdentification> getBuyerIdentification() {
        return buyerIdentification;
    }
    
    public void setBuyerAddresses(List<BuyerAddresses> buyerAddresses) {
        this.buyerAddresses = buyerAddresses;
    }
    public List<BuyerAddresses> getBuyerAddresses() {
        return buyerAddresses;
    }
    
}