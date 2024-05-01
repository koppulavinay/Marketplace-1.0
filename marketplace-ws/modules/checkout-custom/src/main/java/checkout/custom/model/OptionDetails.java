package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class OptionDetails {

   @SerializedName("specification_id")
   Long specificationId;

   @SerializedName("specification_name")
   String specificationName;

   @SerializedName("specification_value")
   String specificationValue;

   @SerializedName("specification_desc")
   String specificationDesc;


   
    
    public Long getSpecificationId() {
	return specificationId;
}
public void setSpecificationId(Long specificationId) {
	this.specificationId = specificationId;
}
	public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }
    public String getSpecificationName() {
        return specificationName;
    }
    
    public void setSpecificationValue(String specificationValue) {
        this.specificationValue = specificationValue;
    }
    public String getSpecificationValue() {
        return specificationValue;
    }
    
    public void setSpecificationDesc(String specificationDesc) {
        this.specificationDesc = specificationDesc;
    }
    public String getSpecificationDesc() {
        return specificationDesc;
    }
    
}