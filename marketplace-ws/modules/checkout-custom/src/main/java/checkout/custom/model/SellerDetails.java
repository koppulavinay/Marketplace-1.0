package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class SellerDetails {

   @SerializedName("seller_user_id")
   String sellerUserId;

   @SerializedName("name")
   String name;

   @SerializedName("mobile_number")
   MobileNumber mobileNumber;

   @SerializedName("organization_id")
   int organizationId;

   @SerializedName("organization_name")
   String organizationName;

   @SerializedName("system_role")
   String systemRole;

   @SerializedName("dates")
   List<Dates> dates;

   @SerializedName("seller_identification")
   List<SellerIdentification> sellerIdentification;

   @SerializedName("seller_address")
   List<SellerAddress> sellerAddress;


    public void setSellerUserId(String sellerUserId) {
        this.sellerUserId = sellerUserId;
    }
    public String getSellerUserId() {
        return sellerUserId;
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
    
    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
    public int getOrganizationId() {
        return organizationId;
    }
    
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    public String getOrganizationName() {
        return organizationName;
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
    
    public void setSellerIdentification(List<SellerIdentification> sellerIdentification) {
        this.sellerIdentification = sellerIdentification;
    }
    public List<SellerIdentification> getSellerIdentification() {
        return sellerIdentification;
    }
    
    public void setSellerAddress(List<SellerAddress> sellerAddress) {
        this.sellerAddress = sellerAddress;
    }
    public List<SellerAddress> getSellerAddress() {
        return sellerAddress;
    }
    
}