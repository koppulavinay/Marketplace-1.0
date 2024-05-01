package checkout.custom.model;

import com.google.gson.annotations.SerializedName;

   
public class DistrictProvince {

   @SerializedName("district_province_code")
   String districtProvinceCode;

   @SerializedName("district_province_name")
   String districtProvinceName;


    public void setDistrictProvinceCode(String districtProvinceCode) {
        this.districtProvinceCode = districtProvinceCode;
    }
    public String getDistrictProvinceCode() {
        return districtProvinceCode;
    }
    
    public void setDistrictProvinceName(String districtProvinceName) {
        this.districtProvinceName = districtProvinceName;
    }
    public String getDistrictProvinceName() {
        return districtProvinceName;
    }
    
}