package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class ConsigneeDetails {

   @SerializedName("name")
   String name;

   @SerializedName("mobile_number")
   MobileNumber mobileNumber;

   @SerializedName("consignee_user_id")
   String consigneeUserId;

   @SerializedName("organization_id")
   String organizationId;

   @SerializedName("organization_name")
   String organizationName;

   @SerializedName("organization_role")
   String organizationRole;

   @SerializedName("user_designation")
   String userDesignation;

   @SerializedName("system_role")
   String systemRole;
   
   @SerializedName("total_item_consignee_qty")
   String totalItemConsigneeQty;
   

   @SerializedName("dates")
   List<Dates> dates;

   @SerializedName("consignee_identifications")
   List<ConsigneeIdentifications> consigneeIdentifications;

   @SerializedName("consignee_address")
   ConsigneeAddress consigneeAddress;

   @SerializedName("consignee_lot_details")
   List<ConsigneeLotDetails> consigneeLotDetails;


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
    
    public void setConsigneeUserId(String consigneeUserId) {
        this.consigneeUserId = consigneeUserId;
    }
    public String getConsigneeUserId() {
        return consigneeUserId;
    }
    
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
    public String getOrganizationId() {
        return organizationId;
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
    
    public void setConsigneeIdentifications(List<ConsigneeIdentifications> consigneeIdentifications) {
        this.consigneeIdentifications = consigneeIdentifications;
    }
    public List<ConsigneeIdentifications> getConsigneeIdentifications() {
        return consigneeIdentifications;
    }
    
    public void setConsigneeAddress(ConsigneeAddress consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }
    public ConsigneeAddress getConsigneeAddress() {
        return consigneeAddress;
    }
    
    public void setConsigneeLotDetails(List<ConsigneeLotDetails> consigneeLotDetails) {
        this.consigneeLotDetails = consigneeLotDetails;
    }
    public List<ConsigneeLotDetails> getConsigneeLotDetails() {
        return consigneeLotDetails;
    }
	public String getTotalItemConsigneeQty() {
		return totalItemConsigneeQty;
	}
	public void setTotalItemConsigneeQty(String totalItemConsigneeQty) {
		this.totalItemConsigneeQty = totalItemConsigneeQty;
	}
    
    
}