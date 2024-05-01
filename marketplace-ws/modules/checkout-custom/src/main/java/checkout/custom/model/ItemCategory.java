package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class ItemCategory {

   @SerializedName("category_id")
   Long categoryId;

   @SerializedName("category_name")
   String categoryName;

   @SerializedName("category_type")
   String categoryType;


    
    public Long getCategoryId() {
	return categoryId;
}
public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}
	public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
    public String getCategoryType() {
        return categoryType;
    }
    
}