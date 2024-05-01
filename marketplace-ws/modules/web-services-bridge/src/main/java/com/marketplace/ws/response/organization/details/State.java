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
@JsonPropertyOrder({"state_name", "state_code"})
public class State {
   @JsonProperty("state_name")
   private String stateName;
   @JsonProperty("state_code")
   private String stateCode;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public State() {
   }

   public State(String stateName, String stateCode) {
      this.stateName = stateName;
      this.stateCode = stateCode;
   }

   @JsonProperty("state_name")
   public String getStateName() {
      return this.stateName;
   }

   @JsonProperty("state_name")
   public void setStateName(String stateName) {
      this.stateName = stateName;
   }

   @JsonProperty("state_code")
   public String getStateCode() {
      return this.stateCode;
   }

   @JsonProperty("state_code")
   public void setStateCode(String stateCode) {
      this.stateCode = stateCode;
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
