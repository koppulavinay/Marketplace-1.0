package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class State {

   @SerializedName("state_name")
   String stateName;

   @SerializedName("state_code")
   String stateCode;


    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateName() {
        return stateName;
    }
    
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getStateCode() {
        return stateCode;
    }
    
}