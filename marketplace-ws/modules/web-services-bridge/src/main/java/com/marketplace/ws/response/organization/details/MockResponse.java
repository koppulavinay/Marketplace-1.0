package com.marketplace.ws.response.organization.details;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"organization_details"})
public class MockResponse {
   @JsonProperty("organization_details")
   private List<OrganizationDetail> organizationDetails;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public MockResponse() {
   }

   public MockResponse(List<OrganizationDetail> organizationDetails) {
      this.organizationDetails = organizationDetails;
   }

   @JsonProperty("organization_details")
   public List<OrganizationDetail> getOrganizationDetails() {
      return this.organizationDetails;
   }

   @JsonProperty("organization_details")
   public void setOrganizationDetails(List<OrganizationDetail> organizationDetails) {
      this.organizationDetails = organizationDetails;
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
