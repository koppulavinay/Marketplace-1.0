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
@JsonPropertyOrder({"country_code", "country_name"})
public class Country {
   @JsonProperty("country_code")
   private String countryCode;
   @JsonProperty("country_name")
   private String countryName;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public Country() {
   }

   public Country(String countryCode, String countryName) {
      this.countryCode = countryCode;
      this.countryName = countryName;
   }

   @JsonProperty("country_code")
   public String getCountryCode() {
      return this.countryCode;
   }

   @JsonProperty("country_code")
   public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
   }

   @JsonProperty("country_name")
   public String getCountryName() {
      return this.countryName;
   }

   @JsonProperty("country_name")
   public void setCountryName(String countryName) {
      this.countryName = countryName;
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
