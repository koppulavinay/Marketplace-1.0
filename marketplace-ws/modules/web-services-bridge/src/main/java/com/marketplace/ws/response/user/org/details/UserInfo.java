package com.marketplace.ws.response.user.org.details;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email_id", "user_id", "dob", "mobile_no", "system_role", "last_name", "first_name" })
@Generated("jsonschema2pojo")
public class UserInfo implements Serializable {

	@JsonProperty("email_id")
	private String emailId;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("dob")
	private String dob;
	@JsonProperty("mobile_no")
	private String mobileNo;
	@JsonProperty("system_role")
	private String systemRole;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("first_name")
	private String firstName;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
	private final static long serialVersionUID = 5051038484392939132L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserInfo() {
	}

	/**
	 *
	 * @param lastName
	 * @param firstName
	 * @param systemRole
	 * @param dob
	 * @param emailId
	 * @param mobileNo
	 * @param userId
	 */
	public UserInfo(String emailId, String userId, String dob, String mobileNo, String systemRole, String lastName,
			String firstName) {
		super();
		this.emailId = emailId;
		this.userId = userId;
		this.dob = dob;
		this.mobileNo = mobileNo;
		this.systemRole = systemRole;
		this.lastName = lastName;
		this.firstName = firstName;
	}

	@JsonProperty("email_id")
	public String getEmailId() {
		return emailId;
	}

	@JsonProperty("email_id")
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@JsonProperty("user_id")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("dob")
	public String getDob() {
		return dob;
	}

	@JsonProperty("dob")
	public void setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty("mobile_no")
	public String getMobileNo() {
		return mobileNo;
	}

	@JsonProperty("mobile_no")
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@JsonProperty("system_role")
	public String getSystemRole() {
		return systemRole;
	}

	@JsonProperty("system_role")
	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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