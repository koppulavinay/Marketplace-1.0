package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class ItemDetails {

   @SerializedName("channel_id")
   Long channelId;

   @SerializedName("item_id")
   Long itemId;

   @SerializedName("cart_item_id")
   Long cartItemId;

   @SerializedName("item_title")
   String itemTitle;

   @SerializedName("model")
   String model;

   @SerializedName("uom")
   String uom;

   @SerializedName("total_quantity")
   Integer totalQuantity;

   @SerializedName("offering_type")
   String offeringType;

   @SerializedName("amc_cmc_details")
   AmcCmcDetails amcCmcDetails;

   @SerializedName("item_urls")
   List<ItemUrls> itemUrls;

   @SerializedName("item_pricing")
   List<ItemPricing> itemPricing;

   @SerializedName("dates")
   List<Dates> dates;

   @SerializedName("item_standards")
   List<ItemStandards> itemStandards;

   @SerializedName("item_category")
   ItemCategory itemCategory;

   @SerializedName("brand_details")
   BrandDetails brandDetails;

   @SerializedName("item_specifications")
   ItemSpecifications itemSpecifications;

   @SerializedName("shipments")
   List<Shipments> shipments;


   
    
    public Long getChannelId() {
	return channelId;
}
public void setChannelId(Long channelId) {
	this.channelId = channelId;
}
	
    
   
    
    public Long getItemId() {
	return itemId;
}
public void setItemId(Long itemId) {
	this.itemId = itemId;
}
	public Long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
    public String getItemTitle() {
        return itemTitle;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    
    public void setUom(String uom) {
        this.uom = uom;
    }
    public String getUom() {
        return uom;
    }
    

    
    public Integer getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public void setOfferingType(String offeringType) {
        this.offeringType = offeringType;
    }
    public String getOfferingType() {
        return offeringType;
    }
    
    public void setAmcCmcDetails(AmcCmcDetails amcCmcDetails) {
        this.amcCmcDetails = amcCmcDetails;
    }
    public AmcCmcDetails getAmcCmcDetails() {
        return amcCmcDetails;
    }
    
    public void setItemUrls(List<ItemUrls> itemUrls) {
        this.itemUrls = itemUrls;
    }
    public List<ItemUrls> getItemUrls() {
        return itemUrls;
    }
    
    public void setItemPricing(List<ItemPricing> itemPricing) {
        this.itemPricing = itemPricing;
    }
    public List<ItemPricing> getItemPricing() {
        return itemPricing;
    }
    
    public void setDates(List<Dates> dates) {
        this.dates = dates;
    }
    public List<Dates> getDates() {
        return dates;
    }
    
    public void setItemStandards(List<ItemStandards> itemStandards) {
        this.itemStandards = itemStandards;
    }
    public List<ItemStandards> getItemStandards() {
        return itemStandards;
    }
    
    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
    public ItemCategory getItemCategory() {
        return itemCategory;
    }
    
    public void setBrandDetails(BrandDetails brandDetails) {
        this.brandDetails = brandDetails;
    }
    public BrandDetails getBrandDetails() {
        return brandDetails;
    }
    
    public void setItemSpecifications(ItemSpecifications itemSpecifications) {
        this.itemSpecifications = itemSpecifications;
    }
    public ItemSpecifications getItemSpecifications() {
        return itemSpecifications;
    }
    
    public void setShipments(List<Shipments> shipments) {
        this.shipments = shipments;
    }
    public List<Shipments> getShipments() {
        return shipments;
    }
    
}