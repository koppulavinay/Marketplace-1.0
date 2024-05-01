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
@JsonPropertyOrder({"country", "geo_location", "address_type", "address_title", "city", "district_province", "address_id", "address_line_1", "address_line_3", "address_line_2", "state", "zip_code"})
public class OrganizationAddress {
   @JsonProperty("country")
   private Country country;
   @JsonProperty("geo_location")
   private String geoLocation;
   @JsonProperty("address_type")
   private String addressType;
   @JsonProperty("address_title")
   private String addressTitle;
   @JsonProperty("city")
   private String city;
   @JsonProperty("district_province")
   private DistrictProvince districtProvince;
   @JsonProperty("address_id")
   private String addressId;
   @JsonProperty("address_line_1")
   private String addressLine1;
   @JsonProperty("address_line_3")
   private String addressLine3;
   @JsonProperty("address_line_2")
   private String addressLine2;
   @JsonProperty("state")
   private State state;
   @JsonProperty("zip_code")
   private String zipCode;
   @JsonIgnore
   private Map<String, Object> additionalProperties = new LinkedHashMap();

   public OrganizationAddress() {
   }

   public OrganizationAddress(Country country, String geoLocation, String addressType, String addressTitle, String city, DistrictProvince districtProvince, String addressId, String addressLine1, String addressLine3, String addressLine2, State state, String zipCode) {
      this.country = country;
      this.geoLocation = geoLocation;
      this.addressType = addressType;
      this.addressTitle = addressTitle;
      this.city = city;
      this.districtProvince = districtProvince;
      this.addressId = addressId;
      this.addressLine1 = addressLine1;
      this.addressLine3 = addressLine3;
      this.addressLine2 = addressLine2;
      this.state = state;
      this.zipCode = zipCode;
   }

   @JsonProperty("country")
   public Country getCountry() {
      return this.country;
   }

   @JsonProperty("country")
   public void setCountry(Country country) {
      this.country = country;
   }

   @JsonProperty("geo_location")
   public String getGeoLocation() {
      return this.geoLocation;
   }

   @JsonProperty("geo_location")
   public void setGeoLocation(String geoLocation) {
      this.geoLocation = geoLocation;
   }

   @JsonProperty("address_type")
   public String getAddressType() {
      return this.addressType;
   }

   @JsonProperty("address_type")
   public void setAddressType(String addressType) {
      this.addressType = addressType;
   }

   @JsonProperty("address_title")
   public String getAddressTitle() {
      return this.addressTitle;
   }

   @JsonProperty("address_title")
   public void setAddressTitle(String addressTitle) {
      this.addressTitle = addressTitle;
   }

   @JsonProperty("city")
   public String getCity() {
      return this.city;
   }

   @JsonProperty("city")
   public void setCity(String city) {
      this.city = city;
   }

   @JsonProperty("district_province")
   public DistrictProvince getDistrictProvince() {
      return this.districtProvince;
   }

   @JsonProperty("district_province")
   public void setDistrictProvince(DistrictProvince districtProvince) {
      this.districtProvince = districtProvince;
   }

   @JsonProperty("address_id")
   public String getAddressId() {
      return this.addressId;
   }

   @JsonProperty("address_id")
   public void setAddressId(String addressId) {
      this.addressId = addressId;
   }

   @JsonProperty("address_line_1")
   public String getAddressLine1() {
      return this.addressLine1;
   }

   @JsonProperty("address_line_1")
   public void setAddressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
   }

   @JsonProperty("address_line_3")
   public String getAddressLine3() {
      return this.addressLine3;
   }

   @JsonProperty("address_line_3")
   public void setAddressLine3(String addressLine3) {
      this.addressLine3 = addressLine3;
   }

   @JsonProperty("address_line_2")
   public String getAddressLine2() {
      return this.addressLine2;
   }

   @JsonProperty("address_line_2")
   public void setAddressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
   }

   @JsonProperty("state")
   public State getState() {
      return this.state;
   }

   @JsonProperty("state")
   public void setState(State state) {
      this.state = state;
   }

   @JsonProperty("zip_code")
   public String getZipCode() {
      return this.zipCode;
   }

   @JsonProperty("zip_code")
   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
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
