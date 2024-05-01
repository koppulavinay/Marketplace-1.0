package com.marketplace.ws.response.consignee.details;

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
@JsonPropertyOrder({"email_id", "user_role", "user_id", "last_name", "mobile_number", "first_name", "user_designation"})
public class UserDetail {
   @JsonProperty("email_id")
   private String emailId;
   @JsonProperty("user_role")
   private String userRole;
   @JsonProperty("user_id")
   private String userId;
   @JsonProperty("last_name")
   private String lastName;
   @JsonProperty("mobile_number")
   private String mobileNumber;
   @JsonProperty("first_name")
   private String firstName;
   @JsonProperty("user_designation")
   private String userDesignation;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public UserDetail() {
   }

   public UserDetail(String emailId, String userRole, String userId, String lastName, String mobileNumber, String firstName, String userDesignation) {
      this.emailId = emailId;
      this.userRole = userRole;
      this.userId = userId;
      this.lastName = lastName;
      this.mobileNumber = mobileNumber;
      this.firstName = firstName;
      this.userDesignation = userDesignation;
   }

   @JsonProperty("email_id")
   public String getEmailId() {
      return this.emailId;
   }

   @JsonProperty("email_id")
   public void setEmailId(String emailId) {
      this.emailId = emailId;
   }

   @JsonProperty("user_role")
   public String getUserRole() {
      return this.userRole;
   }

   @JsonProperty("user_role")
   public void setUserRole(String userRole) {
      this.userRole = userRole;
   }

   @JsonProperty("user_id")
   public String getUserId() {
      return this.userId;
   }

   @JsonProperty("user_id")
   public void setUserId(String userId) {
      this.userId = userId;
   }

   @JsonProperty("last_name")
   public String getLastName() {
      return this.lastName;
   }

   @JsonProperty("last_name")
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   @JsonProperty("mobile_number")
   public String getMobileNumber() {
      return this.mobileNumber;
   }

   @JsonProperty("mobile_number")
   public void setMobileNumber(String mobileNumber) {
      this.mobileNumber = mobileNumber;
   }

   @JsonProperty("first_name")
   public String getFirstName() {
      return this.firstName;
   }

   @JsonProperty("first_name")
   public void setFirstName(String firstName) {
      this.firstName = firstName;
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
