package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class SellerCarts {

   @SerializedName("seller_cart_id")
   int sellerCartId;

   @SerializedName("dates")
   List<Dates> dates;

   @SerializedName("seller_details")
   SellerDetails sellerDetails;

   @SerializedName("item_details")
   List<ItemDetails> itemDetails;


    public void setSellerCartId(int sellerCartId) {
        this.sellerCartId = sellerCartId;
    }
    public int getSellerCartId() {
        return sellerCartId;
    }
    
    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }
    public List<Dates> getDates() {
        return dates;
    }
    
    public void setSellerDetails(SellerDetails sellerDetails) {
        this.sellerDetails = sellerDetails;
    }
    public SellerDetails getSellerDetails() {
        return sellerDetails;
    }
    
    public void setItemDetails(List<ItemDetails> itemDetails) {
        this.itemDetails = itemDetails;
    }
    public List<ItemDetails> getItemDetails() {
        return itemDetails;
    }
    
}