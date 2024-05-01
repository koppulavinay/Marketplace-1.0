package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class CartV2 {

   @SerializedName("cart_details")
   CartDetails cartDetails;


    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }
    public CartDetails getCartDetails() {
        return cartDetails;
    }
    
}