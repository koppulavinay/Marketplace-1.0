package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class Shipments {

   @SerializedName("consignee_details")
   ConsigneeDetails consigneeDetails;


    public void setConsigneeDetails(ConsigneeDetails consigneeDetails) {
        this.consigneeDetails = consigneeDetails;
    }
    public ConsigneeDetails getConsigneeDetails() {
        return consigneeDetails;
    }
    
}