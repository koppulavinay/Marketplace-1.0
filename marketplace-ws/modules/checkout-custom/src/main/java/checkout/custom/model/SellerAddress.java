package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class SellerAddress {

   @SerializedName("address_id")
   Integer addressId;

   @SerializedName("address_type")
   String addressType;

   @SerializedName("address_title")
   String addressTitle;

   @SerializedName("address_line_1")
   String addressLine1;

   @SerializedName("address_line_2")
   String addressLine2;

   @SerializedName("address_line_3")
   String addressLine3;

   @SerializedName("city")
   String city;

   @SerializedName("district_province")
   DistrictProvince districtProvince;

   @SerializedName("state")
   State state;

   @SerializedName("zip_code")
   String zipCode;

   @SerializedName("country")
   Country country;

   @SerializedName("geo_location")
   String geoLocation;

   @SerializedName("landline_details")
   LandlineDetails landlineDetails;

   @SerializedName("mobile_number")
   MobileNumber mobileNumber;

   @SerializedName("email")
   String email;


   
    
    public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}
	public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    public String getAddressType() {
        return addressType;
    }
    
    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }
    public String getAddressTitle() {
        return addressTitle;
    }
    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
    public String getAddressLine2() {
        return addressLine2;
    }
    
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }
    public String getAddressLine3() {
        return addressLine3;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    
    public void setDistrictProvince(DistrictProvince districtProvince) {
        this.districtProvince = districtProvince;
    }
    public DistrictProvince getDistrictProvince() {
        return districtProvince;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getZipCode() {
        return zipCode;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    public Country getCountry() {
        return country;
    }
    
    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }
    public String getGeoLocation() {
        return geoLocation;
    }
    
    public void setLandlineDetails(LandlineDetails landlineDetails) {
        this.landlineDetails = landlineDetails;
    }
    public LandlineDetails getLandlineDetails() {
        return landlineDetails;
    }
    
    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public MobileNumber getMobileNumber() {
        return mobileNumber;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    
}