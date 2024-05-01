package com.marketplace.ws.response.user.profile;

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
@JsonPropertyOrder({"mobile_code", "mobile_number"})
public class MobileNumber {
   @JsonProperty("mobile_code")
   private String mobileCode;
   @JsonProperty("mobile_number")
   private String mobileNumber;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public MobileNumber() {
   }

   public MobileNumber(String mobileCode, String mobileNumber) {
      this.mobileCode = mobileCode;
      this.mobileNumber = mobileNumber;
   }

   @JsonProperty("mobile_code")
   public String getMobileCode() {
      return this.mobileCode;
   }

   @JsonProperty("mobile_code")
   public void setMobileCode(String mobileCode) {
      this.mobileCode = mobileCode;
   }

   @JsonProperty("mobile_number")
   public String getMobileNumber() {
      return this.mobileNumber;
   }

   @JsonProperty("mobile_number")
   public void setMobileNumber(String mobileNumber) {
      this.mobileNumber = mobileNumber;
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
