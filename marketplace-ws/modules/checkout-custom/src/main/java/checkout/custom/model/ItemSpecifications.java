package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class ItemSpecifications {

   @SerializedName("specification_details")
   List<SpecificationDetails> specificationDetails;

   @SerializedName("option_details")
   List<OptionDetails> optionDetails;


    public void setSpecificationDetails(List<SpecificationDetails> specificationDetails) {
        this.specificationDetails = specificationDetails;
    }
    public List<SpecificationDetails> getSpecificationDetails() {
        return specificationDetails;
    }
    
    public void setOptionDetails(List<OptionDetails> optionDetails) {
        this.optionDetails = optionDetails;
    }
    public List<OptionDetails> getOptionDetails() {
        return optionDetails;
    }
    
}