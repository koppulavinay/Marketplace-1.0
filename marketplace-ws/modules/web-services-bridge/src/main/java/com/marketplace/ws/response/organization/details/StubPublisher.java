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
@JsonPropertyOrder({"stub_id", "environment", "scenario", "api_name", "mock_response", "module_name", "api_version"})
public class StubPublisher {
   @JsonProperty("stub_id")
   private String stubId;
   @JsonProperty("environment")
   private String environment;
   @JsonProperty("scenario")
   private String scenario;
   @JsonProperty("api_name")
   private String apiName;
   @JsonProperty("mock_response")
   private MockResponse mockResponse;
   @JsonProperty("module_name")
   private String moduleName;
   @JsonProperty("api_version")
   private String apiVersion;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public StubPublisher() {
   }

   public StubPublisher(String stubId, String environment, String scenario, String apiName, MockResponse mockResponse, String moduleName, String apiVersion) {
      this.stubId = stubId;
      this.environment = environment;
      this.scenario = scenario;
      this.apiName = apiName;
      this.mockResponse = mockResponse;
      this.moduleName = moduleName;
      this.apiVersion = apiVersion;
   }

   @JsonProperty("stub_id")
   public String getStubId() {
      return this.stubId;
   }

   @JsonProperty("stub_id")
   public void setStubId(String stubId) {
      this.stubId = stubId;
   }

   @JsonProperty("environment")
   public String getEnvironment() {
      return this.environment;
   }

   @JsonProperty("environment")
   public void setEnvironment(String environment) {
      this.environment = environment;
   }

   @JsonProperty("scenario")
   public String getScenario() {
      return this.scenario;
   }

   @JsonProperty("scenario")
   public void setScenario(String scenario) {
      this.scenario = scenario;
   }

   @JsonProperty("api_name")
   public String getApiName() {
      return this.apiName;
   }

   @JsonProperty("api_name")
   public void setApiName(String apiName) {
      this.apiName = apiName;
   }

   @JsonProperty("mock_response")
   public MockResponse getMockResponse() {
      return this.mockResponse;
   }

   @JsonProperty("mock_response")
   public void setMockResponse(MockResponse mockResponse) {
      this.mockResponse = mockResponse;
   }

   @JsonProperty("module_name")
   public String getModuleName() {
      return this.moduleName;
   }

   @JsonProperty("module_name")
   public void setModuleName(String moduleName) {
      this.moduleName = moduleName;
   }

   @JsonProperty("api_version")
   public String getApiVersion() {
      return this.apiVersion;
   }

   @JsonProperty("api_version")
   public void setApiVersion(String apiVersion) {
      this.apiVersion = apiVersion;
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
