package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class ConsigneeLotDetails {

   @SerializedName("quantity")
   int quantity;

   @SerializedName("delivery_start_day")
   String deliveryStartDay;

   @SerializedName("delivery_end_day")
   String deliveryEndDay;


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    
    public void setDeliveryStartDay(String deliveryStartDay) {
        this.deliveryStartDay = deliveryStartDay;
    }
    public String getDeliveryStartDay() {
        return deliveryStartDay;
    }
    
    public void setDeliveryEndDay(String deliveryEndDay) {
        this.deliveryEndDay = deliveryEndDay;
    }
    public String getDeliveryEndDay() {
        return deliveryEndDay;
    }
    
}