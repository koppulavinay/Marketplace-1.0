package com.marketplace.ws.request.beans;

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
@JsonPropertyOrder({"api_version", "api_name", "environment"})
public class GetStubsApiBeans {
   @JsonProperty("api_version")
   private String apiVersion;
   @JsonProperty("api_name")
   private String apiName;
   @JsonProperty("environment")
   private String environment;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public GetStubsApiBeans() {
   }

   public GetStubsApiBeans(String apiVersion, String apiName, String environment) {
      this.apiVersion = apiVersion;
      this.apiName = apiName;
      this.environment = environment;
   }

   @JsonProperty("api_version")
   public String getApiVersion() {
      return this.apiVersion;
   }

   @JsonProperty("api_version")
   public void setApiVersion(String apiVersion) {
      this.apiVersion = apiVersion;
   }

   @JsonProperty("api_name")
   public String getApiName() {
      return this.apiName;
   }

   @JsonProperty("api_name")
   public void setApiName(String apiName) {
      this.apiName = apiName;
   }

   @JsonProperty("environment")
   public String getEnvironment() {
      return this.environment;
   }

   @JsonProperty("environment")
   public void setEnvironment(String environment) {
      this.environment = environment;
   }

   @JsonAnyGetter
   public Map<String, Object> getAdditionalProperties() {
      return this.additionalProperties;
   }

   @JsonAnySetter
   public void setAdditionalProperties(Map<String, Object> additionalProperties) {
      this.additionalProperties = additionalProperties;
   }
}
