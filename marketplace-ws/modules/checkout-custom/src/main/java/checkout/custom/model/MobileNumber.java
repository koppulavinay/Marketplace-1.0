package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class MobileNumber {

   @SerializedName("mobile_code")
   String mobileCode;

   @SerializedName("mobile_number")
   String mobileNumber;


    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }
    public String getMobileCode() {
        return mobileCode;
    }
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    
}