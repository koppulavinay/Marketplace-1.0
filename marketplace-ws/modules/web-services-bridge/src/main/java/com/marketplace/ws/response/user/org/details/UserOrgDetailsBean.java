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
@JsonPropertyOrder({ "userOrgAssociation" })
@Generated("jsonschema2pojo")
public class UserOrgDetailsBean implements Serializable {

	@JsonProperty("userOrgAssociation")
	private List<UserOrgAssociation> userOrgAssociation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
	private final static long serialVersionUID = 8745184728892851811L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public UserOrgDetailsBean() {
	}

	/**
	 *
	 * @param userOrgAssociation
	 */
	public UserOrgDetailsBean(List<UserOrgAssociation> userOrgAssociation) {
		super();
		this.userOrgAssociation = userOrgAssociation;
	}

	@JsonProperty("userOrgAssociation")
	public List<UserOrgAssociation> getUserOrgAssociation() {
		return userOrgAssociation;
	}

	@JsonProperty("userOrgAssociation")
	public void setUserOrgAssociation(List<UserOrgAssociation> userOrgAssociation) {
		this.userOrgAssociation = userOrgAssociation;
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