package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class LandlineDetails {

   @SerializedName("landline_code")
   String landlineCode;

   @SerializedName("landline_number")
   String landlineNumber;


    public void setLandlineCode(String landlineCode) {
        this.landlineCode = landlineCode;
    }
    public String getLandlineCode() {
        return landlineCode;
    }
    
    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }
    public String getLandlineNumber() {
        return landlineNumber;
    }
    
}