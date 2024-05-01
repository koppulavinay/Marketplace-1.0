package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class BrandDetails {

   @SerializedName("brand_id")
   Long brandId;

   @SerializedName("brand_name")
   String brandName;

   @SerializedName("brand_type")
   String brandType;


  
    
    public Long getBrandId() {
	return brandId;
}
public void setBrandId(Long brandId) {
	this.brandId = brandId;
}
	public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public String getBrandName() {
        return brandName;
    }
    
    public void setBrandType(String brandType) {
        this.brandType = brandType;
    }
    public String getBrandType() {
        return brandType;
    }
    
}