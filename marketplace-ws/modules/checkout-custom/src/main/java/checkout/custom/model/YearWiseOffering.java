package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class YearWiseOffering {

   @SerializedName("year_sequence")
   String yearSequence;

   @SerializedName("offering_amount_value")
   String offeringAmountValue;

   @SerializedName("offering_amount_divisor")
   String offeringAmountDivisor;

   @SerializedName("offering_amount_currency")
   String offeringAmountCurrency;


    public void setYearSequence(String yearSequence) {
        this.yearSequence = yearSequence;
    }
    public String getYearSequence() {
        return yearSequence;
    }
    
    public void setOfferingAmountValue(String offeringAmountValue) {
        this.offeringAmountValue = offeringAmountValue;
    }
    public String getOfferingAmountValue() {
        return offeringAmountValue;
    }
    
    public void setOfferingAmountDivisor(String offeringAmountDivisor) {
        this.offeringAmountDivisor = offeringAmountDivisor;
    }
    public String getOfferingAmountDivisor() {
        return offeringAmountDivisor;
    }
    
    public void setOfferingAmountCurrency(String offeringAmountCurrency) {
        this.offeringAmountCurrency = offeringAmountCurrency;
    }
    public String getOfferingAmountCurrency() {
        return offeringAmountCurrency;
    }
    
}