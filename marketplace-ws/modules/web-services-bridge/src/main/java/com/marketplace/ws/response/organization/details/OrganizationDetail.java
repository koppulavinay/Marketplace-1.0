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
@JsonPropertyOrder({"organizationType", "organization_identification", "organization_id", "organization_addresses", "dates", "organization_name"})
public class OrganizationDetail {
   @JsonProperty("organizationType")
   private String organizationType;
   @JsonProperty("organization_identification")
   private List<OrganizationIdentification> organizationIdentification;
   @JsonProperty("organization_id")
   private String organizationId;
   @JsonProperty("organization_addresses")
   private List<OrganizationAddress> organizationAddresses;
   @JsonProperty("dates")
   private List<Date> dates;
   @JsonProperty("organization_name")
   private String organizationName;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public OrganizationDetail() {
   }

   public OrganizationDetail(String organizationType, List<OrganizationIdentification> organizationIdentification, String organizationId, List<OrganizationAddress> organizationAddresses, List<Date> dates, String organizationName) {
      this.organizationType = organizationType;
      this.organizationIdentification = organizationIdentification;
      this.organizationId = organizationId;
      this.organizationAddresses = organizationAddresses;
      this.dates = dates;
      this.organizationName = organizationName;
   }

   @JsonProperty("organizationType")
   public String getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("organizationType")
   public void setOrganizationType(String organizationType) {
      this.organizationType = organizationType;
   }

   @JsonProperty("organization_identification")
   public List<OrganizationIdentification> getOrganizationIdentification() {
      return this.organizationIdentification;
   }

   @JsonProperty("organization_identification")
   public void setOrganizationIdentification(List<OrganizationIdentification> organizationIdentification) {
      this.organizationIdentification = organizationIdentification;
   }

   @JsonProperty("organization_id")
   public String getOrganizationId() {
      return this.organizationId;
   }

   @JsonProperty("organization_id")
   public void setOrganizationId(String organizationId) {
      this.organizationId = organizationId;
   }

   @JsonProperty("organization_addresses")
   public List<OrganizationAddress> getOrganizationAddresses() {
      return this.organizationAddresses;
   }

   @JsonProperty("organization_addresses")
   public void setOrganizationAddresses(List<OrganizationAddress> organizationAddresses) {
      this.organizationAddresses = organizationAddresses;
   }

   @JsonProperty("dates")
   public List<Date> getDates() {
      return this.dates;
   }

   @JsonProperty("dates")
   public void setDates(List<Date> dates) {
      this.dates = dates;
   }

   @JsonProperty("organization_name")
   public String getOrganizationName() {
      return this.organizationName;
   }

   @JsonProperty("organization_name")
   public void setOrganizationName(String organizationName) {
      this.organizationName = organizationName;
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
