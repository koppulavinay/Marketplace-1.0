package com.marketplace.ws.response.organization.details;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"district_province_name", "district_province_code"})
public class DistrictProvince {
   @JsonProperty("district_province_name")
   private String districtProvinceName;
   @JsonProperty("district_province_code")
   private String districtProvinceCode;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public DistrictProvince() {
   }

   public DistrictProvince(String districtProvinceName, String districtProvinceCode) {
      this.districtProvinceName = districtProvinceName;
      this.districtProvinceCode = districtProvinceCode;
   }

   @JsonProperty("district_province_name")
   public String getDistrictProvinceName() {
      return this.districtProvinceName;
   }

   @JsonProperty("district_province_name")
   public void setDistrictProvinceName(String districtProvinceName) {
      this.districtProvinceName = districtProvinceName;
   }

   @JsonProperty("district_province_code")
   public String getDistrictProvinceCode() {
      return this.districtProvinceCode;
   }

   @JsonProperty("district_province_code")
   public void setDistrictProvinceCode(String districtProvinceCode) {
      this.districtProvinceCode = districtProvinceCode;
   }

   @JsonAnyGetter
   public Map<String, Object> getAdditionalProperties() {
      return this.additionalProperties;
   }

   @JsonAnySetter
   public void setAdditionalProperty(String name, Object value) {
      this.additionalProperties.put(name, value);
   }
}
