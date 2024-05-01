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
@JsonPropertyOrder({"organizationType", "user_id", "organization_id", "name", "organization_name", "mobile_number", "organization_role", "email", "user_designation"})
public class UsersProfile {
   @JsonProperty("organizationType")
   private String organizationType;
   @JsonProperty("user_id")
   private String userId;
   @JsonProperty("organization_id")
   private String organizationId;
   @JsonProperty("name")
   private String name;
   @JsonProperty("organization_name")
   private String organizationName;
   @JsonProperty("mobile_number")
   private MobileNumber mobileNumber;
   @JsonProperty("organization_role")
   private String organizationRole;
   @JsonProperty("email")
   private String email;
   @JsonProperty("user_designation")
   private String userDesignation;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public UsersProfile() {
   }

   public UsersProfile(String organizationType, String userId, String organizationId, String name, String organizationName, MobileNumber mobileNumber, String organizationRole, String email, String userDesignation) {
      this.organizationType = organizationType;
      this.userId = userId;
      this.organizationId = organizationId;
      this.name = name;
      this.organizationName = organizationName;
      this.mobileNumber = mobileNumber;
      this.organizationRole = organizationRole;
      this.email = email;
      this.userDesignation = userDesignation;
   }

   @JsonProperty("organizationType")
   public String getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("organizationType")
   public void setOrganizationType(String organizationType) {
      this.organizationType = organizationType;
   }

   @JsonProperty("user_id")
   public String getUserId() {
      return this.userId;
   }

   @JsonProperty("user_id")
   public void setUserId(String userId) {
      this.userId = userId;
   }

   @JsonProperty("organization_id")
   public String getOrganizationId() {
      return this.organizationId;
   }

   @JsonProperty("organization_id")
   public void setOrganizationId(String organizationId) {
      this.organizationId = organizationId;
   }

   @JsonProperty("name")
   public String getName() {
      return this.name;
   }

   @JsonProperty("name")
   public void setName(String name) {
      this.name = name;
   }

   @JsonProperty("organization_name")
   public String getOrganizationName() {
      return this.organizationName;
   }

   @JsonProperty("organization_name")
   public void setOrganizationName(String organizationName) {
      this.organizationName = organizationName;
   }

   @JsonProperty("mobile_number")
   public MobileNumber getMobileNumber() {
      return this.mobileNumber;
   }

   @JsonProperty("mobile_number")
   public void setMobileNumber(MobileNumber mobileNumber) {
      this.mobileNumber = mobileNumber;
   }

   @JsonProperty("organization_role")
   public String getOrganizationRole() {
      return this.organizationRole;
   }

   @JsonProperty("organization_role")
   public void setOrganizationRole(String organizationRole) {
      this.organizationRole = organizationRole;
   }

   @JsonProperty("email")
   public String getEmail() {
      return this.email;
   }

   @JsonProperty("email")
   public void setEmail(String email) {
      this.email = email;
   }

   @JsonProperty("user_designation")
   public String getUserDesignation() {
      return this.userDesignation;
   }

   @JsonProperty("user_designation")
   public void setUserDesignation(String userDesignation) {
      this.userDesignation = userDesignation;
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
