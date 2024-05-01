package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class SellerIdentification {

   @SerializedName("id_card_type")
   String idCardType;

   @SerializedName("id_card_number")
   String idCardNumber;

   @SerializedName("is_verified")
   String isVerified;


    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }
    public String getIdCardType() {
        return idCardType;
    }
    
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
    public String getIdCardNumber() {
        return idCardNumber;
    }
    
    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }
    public String getIsVerified() {
        return isVerified;
    }
    
}