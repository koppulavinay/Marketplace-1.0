package com.marketplace.ws.request.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"org_id", "org_roles"})
public class GetOrganizationUsersApiBeans {
   @JsonProperty("org_id")
   private String organizationId;
   @JsonProperty("org_roles")
   private String organizationRoles;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public GetOrganizationUsersApiBeans(String organizationId, String organizationRoles) {
      this.organizationId = organizationId;
      this.organizationRoles = organizationRoles;
   }

   @JsonProperty("org_id")
   public String getOrganizationId() {
      return this.organizationId;
   }

   @JsonProperty("org_id")
   public void setOrganizationId(String organizationId) {
      this.organizationId = organizationId;
   }

   @JsonProperty("org_roles")
   public String getOrganizationRoles() {
      return this.organizationRoles;
   }

   @JsonProperty("org_roles")
   public void setOrganizationRoles(String organizationRoles) {
      this.organizationRoles = organizationRoles;
   }
}
