package com.marketplace.ws.response.user.org.details;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "deleted_on", "user_id", "user_info", "organization_bank_details", "organization_id",
		"organization_address", "organization_name", "designation", "organization_role", "association_id",
		"organization_code" })
@Generated("jsonschema2pojo")
public class UserOrgAssociation implements Serializable {

	@JsonProperty("deleted_on")
	private String deletedOn;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("user_info")
	private UserInfo userInfo;
	@JsonProperty("organization_bank_details")
	private List<OrganizationBankDetail> organizationBankDetails;
	@JsonProperty("organization_id")
	private String organizationId;
	@JsonProperty("organization_address")
	private List<OrganizationAddress> organizationAddress;
	@JsonProperty("organization_name")
	private String organizationName;
	@JsonProperty("designation")
	private String designation;
	@JsonProperty("organization_role")
	private String organizationRole;
	@JsonProperty("association_id")
	private String associationId;
	@JsonProperty("organization_code")
	private String organizationCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
	private final static long serialVersionUID = 8526600540624905673L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserOrgAssociation() {
	}

	/**
	 *
	 * @param organizationId
	 * @param userInfo
	 * @param organizationAddress
	 * @param organizationName
	 * @param organizationRole
	 * @param organizationCode
	 * @param deletedOn
	 * @param organizationBankDetails
	 * @param designation
	 * @param userId
	 * @param associationId
	 */
	public UserOrgAssociation(String deletedOn, String userId, UserInfo userInfo,
			List<OrganizationBankDetail> organizationBankDetails, String organizationId,
			List<OrganizationAddress> organizationAddress, String organizationName, String designation,
			String organizationRole, String associationId, String organizationCode) {
		super();
		this.deletedOn = deletedOn;
		this.userId = userId;
		this.userInfo = userInfo;
		this.organizationBankDetails = organizationBankDetails;
		this.organizationId = organizationId;
		this.organizationAddress = organizationAddress;
		this.organizationName = organizationName;
		this.designation = designation;
		this.organizationRole = organizationRole;
		this.associationId = associationId;
		this.organizationCode = organizationCode;
	}

	@JsonProperty("deleted_on")
	public String getDeletedOn() {
		return deletedOn;
	}

	@JsonProperty("deleted_on")
	public void setDeletedOn(String deletedOn) {
		this.deletedOn = deletedOn;
	}

	@JsonProperty("user_id")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("user_info")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	@JsonProperty("user_info")
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@JsonProperty("organization_bank_details")
	public List<OrganizationBankDetail> getOrganizationBankDetails() {
		return organizationBankDetails;
	}

	@JsonProperty("organization_bank_details")
	public void setOrganizationBankDetails(List<OrganizationBankDetail> organizationBankDetails) {
		this.organizationBankDetails = organizationBankDetails;
	}

	@JsonProperty("organization_id")
	public String getOrganizationId() {
		return organizationId;
	}

	@JsonProperty("organization_id")
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	@JsonProperty("organization_address")
	public List<OrganizationAddress> getOrganizationAddress() {
		return organizationAddress;
	}

	@JsonProperty("organization_address")
	public void setOrganizationAddress(List<OrganizationAddress> organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	@JsonProperty("organization_name")
	public String getOrganizationName() {
		return organizationName;
	}

	@JsonProperty("organization_name")
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	@JsonProperty("designation")
	public String getDesignation() {
		return designation;
	}

	@JsonProperty("designation")
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@JsonProperty("organization_role")
	public String getOrganizationRole() {
		return organizationRole;
	}

	@JsonProperty("organization_role")
	public void setOrganizationRole(String organizationRole) {
		this.organizationRole = organizationRole;
	}

	@JsonProperty("association_id")
	public String getAssociationId() {
		return associationId;
	}

	@JsonProperty("association_id")
	public void setAssociationId(String associationId) {
		this.associationId = associationId;
	}

	@JsonProperty("organization_code")
	public String getOrganizationCode() {
		return organizationCode;
	}

	@JsonProperty("organization_code")
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
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