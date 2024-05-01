package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class ItemPricing {

   @SerializedName("price_type")
   String priceType;

   @SerializedName("value")
   Long value;

   @SerializedName("divisor")
   String divisor;

   @SerializedName("currency")
   String currency;

   @SerializedName("discount_name")
   String discountName;

   @SerializedName("discount_type")
   String discountType;

   @SerializedName("discount_value")
   String discountValue;


    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    public String getPriceType() {
        return priceType;
    }
    
 
    
    public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public void setDivisor(String divisor) {
        this.divisor = divisor;
    }
    public String getDivisor() {
        return divisor;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getCurrency() {
        return currency;
    }
    
    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }
    public String getDiscountName() {
        return discountName;
    }
    
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
    public String getDiscountType() {
        return discountType;
    }
    
    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }
    public String getDiscountValue() {
        return discountValue;
    }
    
}