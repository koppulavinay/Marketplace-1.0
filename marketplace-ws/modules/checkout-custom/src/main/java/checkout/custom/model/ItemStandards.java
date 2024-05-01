package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class ItemStandards {

   @SerializedName("standard_type")
   String standardType;

   @SerializedName("value")
   String value;


    public void setStandardType(String standardType) {
        this.standardType = standardType;
    }
    public String getStandardType() {
        return standardType;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    
}