package checkout.custom.model;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class AmcCmcDetails {

   @SerializedName("type")
   String type;

   @SerializedName("total_no_of_years")
   String totalNoOfYears;

   @SerializedName("amc_cmc_formula")
   String amcCmcFormula;

   @SerializedName("year_wise_offering")
   List<YearWiseOffering> yearWiseOffering;


    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    
    public void setTotalNoOfYears(String totalNoOfYears) {
        this.totalNoOfYears = totalNoOfYears;
    }
    public String getTotalNoOfYears() {
        return totalNoOfYears;
    }
    
    public void setAmcCmcFormula(String amcCmcFormula) {
        this.amcCmcFormula = amcCmcFormula;
    }
    public String getAmcCmcFormula() {
        return amcCmcFormula;
    }
    
    public void setYearWiseOffering(List<YearWiseOffering> yearWiseOffering) {
        this.yearWiseOffering = yearWiseOffering;
    }
    public List<YearWiseOffering> getYearWiseOffering() {
        return yearWiseOffering;
    }
    
}