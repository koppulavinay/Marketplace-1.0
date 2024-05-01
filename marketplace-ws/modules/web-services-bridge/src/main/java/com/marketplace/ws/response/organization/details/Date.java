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
@JsonPropertyOrder({"date_type", "date_value"})
public class Date {
   @JsonProperty("date_type")
   private String dateType;
   @JsonProperty("date_value")
   private String dateValue;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public Date() {
   }

   public Date(String dateType, String dateValue) {
      this.dateType = dateType;
      this.dateValue = dateValue;
   }

   @JsonProperty("date_type")
   public String getDateType() {
      return this.dateType;
   }

   @JsonProperty("date_type")
   public void setDateType(String dateType) {
      this.dateType = dateType;
   }

   @JsonProperty("date_value")
   public String getDateValue() {
      return this.dateValue;
   }

   @JsonProperty("date_value")
   public void setDateValue(String dateValue) {
      this.dateValue = dateValue;
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
