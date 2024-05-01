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
@JsonPropertyOrder({"id_card_number", "id_card_type", "is_verified"})
public class OrganizationIdentification {
   @JsonProperty("id_card_number")
   private String idCardNumber;
   @JsonProperty("id_card_type")
   private String idCardType;
   @JsonProperty("is_verified")
   private String isVerified;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public OrganizationIdentification() {
   }

   public OrganizationIdentification(String idCardNumber, String idCardType, String isVerified) {
      this.idCardNumber = idCardNumber;
      this.idCardType = idCardType;
      this.isVerified = isVerified;
   }

   @JsonProperty("id_card_number")
   public String getIdCardNumber() {
      return this.idCardNumber;
   }

   @JsonProperty("id_card_number")
   public void setIdCardNumber(String idCardNumber) {
      this.idCardNumber = idCardNumber;
   }

   @JsonProperty("id_card_type")
   public String getIdCardType() {
      return this.idCardType;
   }

   @JsonProperty("id_card_type")
   public void setIdCardType(String idCardType) {
      this.idCardType = idCardType;
   }

   @JsonProperty("is_verified")
   public String getIsVerified() {
      return this.isVerified;
   }

   @JsonProperty("is_verified")
   public void setIsVerified(String isVerified) {
      this.isVerified = isVerified;
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
