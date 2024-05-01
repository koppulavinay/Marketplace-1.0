package com.marketplace.ws.response.user.org.details;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "country_code", "address_type", "address_title", "organization_id", "address_line_1", "address_id",
		"address_line_3", "address_line_2", "state_code", "district_province_code", "landmark", "zip_code" })
@Generated("jsonschema2pojo")
public class OrganizationAddress implements Serializable {

	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("address_type")
	private String addressType;
	@JsonProperty("address_title")
	private String addressTitle;
	@JsonProperty("organization_id")
	private String organizationId;
	@JsonProperty("address_line_1")
	private String addressLine1;
	@JsonProperty("address_id")
	private String addressId;
	@JsonProperty("address_line_3")
	private String addressLine3;
	@JsonProperty("address_line_2")
	private String addressLine2;
	@JsonProperty("state_code")
	private String stateCode;
	@JsonProperty("district_province_code")
	private String districtProvinceCode;
	@JsonProperty("landmark")
	private String landmark;
	@JsonProperty("zip_code")
	private String zipCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
	private final static long serialVersionUID = -4560736284426451753L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public OrganizationAddress() {
	}

	/**
	 *
	 * @param organizationId
	 * @param zipCode
	 * @param districtProvinceCode
	 * @param addressTitle
	 * @param countryCode
	 * @param addressType
	 * @param addressLine1
	 * @param addressLine2
	 * @param stateCode
	 * @param addressLine3
	 * @param landmark
	 * @param addressId
	 */
	public OrganizationAddress(String countryCode, String addressType, String addressTitle, String organizationId,
			String addressLine1, String addressId, String addressLine3, String addressLine2, String stateCode,
			String districtProvinceCode, String landmark, String zipCode) {
		super();
		this.countryCode = countryCode;
		this.addressType = addressType;
		this.addressTitle = addressTitle;
		this.organizationId = organizationId;
		this.addressLine1 = addressLine1;
		this.addressId = addressId;
		this.addressLine3 = addressLine3;
		this.addressLine2 = addressLine2;
		this.stateCode = stateCode;
		this.districtProvinceCode = districtProvinceCode;
		this.landmark = landmark;
		this.zipCode = zipCode;
	}

	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	@JsonProperty("country_code")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@JsonProperty("address_type")
	public String getAddressType() {
		return addressType;
	}

	@JsonProperty("address_type")
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@JsonProperty("address_title")
	public String getAddressTitle() {
		return addressTitle;
	}

	@JsonProperty("address_title")
	public void setAddressTitle(String addressTitle) {
		this.addressTitle = addressTitle;
	}

	@JsonProperty("organization_id")
	public String getOrganizationId() {
		return organizationId;
	}

	@JsonProperty("organization_id")
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	@JsonProperty("address_line_1")
	public String getAddressLine1() {
		return addressLine1;
	}

	@JsonProperty("address_line_1")
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@JsonProperty("address_id")
	public String getAddressId() {
		return addressId;
	}

	@JsonProperty("address_id")
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@JsonProperty("address_line_3")
	public String getAddressLine3() {
		return addressLine3;
	}

	@JsonProperty("address_line_3")
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	@JsonProperty("address_line_2")
	public String getAddressLine2() {
		return addressLine2;
	}

	@JsonProperty("address_line_2")
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@JsonProperty("state_code")
	public String getStateCode() {
		return stateCode;
	}

	@JsonProperty("state_code")
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	@JsonProperty("district_province_code")
	public String getDistrictProvinceCode() {
		return districtProvinceCode;
	}

	@JsonProperty("district_province_code")
	public void setDistrictProvinceCode(String districtProvinceCode) {
		this.districtProvinceCode = districtProvinceCode;
	}

	@JsonProperty("landmark")
	public String getLandmark() {
		return landmark;
	}

	@JsonProperty("landmark")
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@JsonProperty("zip_code")
	public String getZipCode() {
		return zipCode;
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