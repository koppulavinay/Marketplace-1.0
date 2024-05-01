package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class Dates {

   @SerializedName("date_type")
   String dateType;

   @SerializedName("date_value")
   String dateValue;


    public void setDateType(String dateType) {
        this.dateType = dateType;
    }
    public String getDateType() {
        return dateType;
    }
    
    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
    }
    public String getDateValue() {
        return dateValue;
    }
    
}