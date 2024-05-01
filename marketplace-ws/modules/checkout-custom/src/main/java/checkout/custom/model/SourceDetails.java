package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class SourceDetails {

   @SerializedName("id")
   int id;

   @SerializedName("name")
   String name;

   @SerializedName("code")
   String code;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    
}