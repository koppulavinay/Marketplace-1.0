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
@JsonPropertyOrder({"stubPublisher"})
public class UserProfileBeans {
   @JsonProperty("stubPublisher")
   private List<StubPublisher> stubPublisher;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public UserProfileBeans() {
   }

   public UserProfileBeans(List<StubPublisher> stubPublisher) {
      this.stubPublisher = stubPublisher;
   }

   @JsonProperty("stubPublisher")
   public List<StubPublisher> getStubPublisher() {
      return this.stubPublisher;
   }

   @JsonProperty("stubPublisher")
   public void setStubPublisher(List<StubPublisher> stubPublisher) {
      this.stubPublisher = stubPublisher;
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
