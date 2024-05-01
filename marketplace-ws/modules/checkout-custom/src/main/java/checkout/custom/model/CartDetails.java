package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class CartDetails {

   @SerializedName("parent_cart_id")
   Long  parentCartId;

   @SerializedName("dates")
   List<Dates> dates;

   @SerializedName("source_details")
   SourceDetails sourceDetails;

   @SerializedName("purchase_mode")
   String purchaseMode;

   @SerializedName("buyer_details")
   BuyerDetails buyerDetails;

   @SerializedName("seller_carts")
   List<SellerCarts> sellerCarts;


   
    
    public Long getParentCartId() {
	return parentCartId;
}
public void setParentCartId(Long parentCartId) {
	this.parentCartId = parentCartId;
}
	public void setDates(List<Dates> dates) {
        this.dates = dates;
    }
    public List<Dates> getDates() {
        return dates;
    }
    
    public void setSourceDetails(SourceDetails sourceDetails) {
        this.sourceDetails = sourceDetails;
    }
    public SourceDetails getSourceDetails() {
        return sourceDetails;
    }
    
    public void setPurchaseMode(String purchaseMode) {
        this.purchaseMode = purchaseMode;
    }
    public String getPurchaseMode() {
        return purchaseMode;
    }
    
    public void setBuyerDetails(BuyerDetails buyerDetails) {
        this.buyerDetails = buyerDetails;
    }
    public BuyerDetails getBuyerDetails() {
        return buyerDetails;
    }
    
    public void setSellerCarts(List<SellerCarts> sellerCarts) {
        this.sellerCarts = sellerCarts;
    }
    public List<SellerCarts> getSellerCarts() {
        return sellerCarts;
    }
    
}