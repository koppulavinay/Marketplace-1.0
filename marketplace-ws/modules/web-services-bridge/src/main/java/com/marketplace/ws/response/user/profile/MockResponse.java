package com.marketplace.ws.response.user.profile;

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
@JsonPropertyOrder({"reporting_managers", "usersProfile"})
public class MockResponse {
   @JsonProperty("reporting_managers")
   private List<ReportingManager> reportingManagers;
   @JsonProperty("usersProfile")
   private UsersProfile usersProfile;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public MockResponse() {
   }

   public MockResponse(List<ReportingManager> reportingManagers, UsersProfile usersProfile) {
      this.reportingManagers = reportingManagers;
      this.usersProfile = usersProfile;
   }

   @JsonProperty("reporting_managers")
   public List<ReportingManager> getReportingManagers() {
      return this.reportingManagers;
   }

   @JsonProperty("reporting_managers")
   public void setReportingManagers(List<ReportingManager> reportingManagers) {
      this.reportingManagers = reportingManagers;
   }

   @JsonProperty("usersProfile")
   public UsersProfile getUsersProfile() {
      return this.usersProfile;
   }

   @JsonProperty("usersProfile")
   public void setUsersProfile(UsersProfile usersProfile) {
      this.usersProfile = usersProfile;
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
