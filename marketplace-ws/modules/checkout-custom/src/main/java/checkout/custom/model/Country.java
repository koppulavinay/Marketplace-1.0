package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class Country {

   @SerializedName("country_name")
   String countryName;

   @SerializedName("country_code")
   String countryCode;


    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getCountryName() {
        return countryName;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountryCode() {
        return countryCode;
    }
    
}