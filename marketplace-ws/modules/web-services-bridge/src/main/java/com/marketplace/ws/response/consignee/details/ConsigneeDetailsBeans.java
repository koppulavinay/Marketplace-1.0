package com.marketplace.ws.response.consignee.details;

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
@JsonPropertyOrder({"user_details", "organization_id", "organization_type", "organization_name"})
public class ConsigneeDetailsBeans {
   @JsonProperty("user_details")
   private List<UserDetail> userDetails;
   @JsonProperty("organization_id")
   private String organizationId;
   @JsonProperty("organization_type")
   private String organizationType;
   @JsonProperty("organization_name")
   private String organizationName;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public ConsigneeDetailsBeans() {
   }

   public ConsigneeDetailsBeans(List<UserDetail> userDetails, String organizationId, String organizationType, String organizationName) {
      this.userDetails = userDetails;
      this.organizationId = organizationId;
      this.organizationType = organizationType;
      this.organizationName = organizationName;
   }

   @JsonProperty("user_details")
   public List<UserDetail> getUserDetails() {
      return this.userDetails;
   }

   @JsonProperty("user_details")
   public void setUserDetails(List<UserDetail> userDetails) {
      this.userDetails = userDetails;
   }

   @JsonProperty("organization_id")
   public String getOrganizationId() {
      return this.organizationId;
   }

   @JsonProperty("organization_id")
   public void setOrganizationId(String organizationId) {
      this.organizationId = organizationId;
   }

   @JsonProperty("organization_type")
   public String getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("organization_type")
   public void setOrganizationType(String organizationType) {
      this.organizationType = organizationType;
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
