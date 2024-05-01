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
@JsonPropertyOrder({ "bank_acc_id", "bank_account_number", "bank_code_name", "account_holder_name", "organization_id",
		"branch_name", "bank_name", "bank_account_type", "is_primary_bank_account" })
@Generated("jsonschema2pojo")
public class OrganizationBankDetail implements Serializable {

	@JsonProperty("bank_acc_id")
	private String bankAccId;
	@JsonProperty("bank_account_number")
	private String bankAccountNumber;
	@JsonProperty("bank_code_name")
	private String bankCodeName;
	@JsonProperty("account_holder_name")
	private String accountHolderName;
	@JsonProperty("organization_id")
	private String organizationId;
	@JsonProperty("branch_name")
	private String branchName;
	@JsonProperty("bank_name")
	private String bankName;
	@JsonProperty("bank_account_type")
	private String bankAccountType;
	@JsonProperty("is_primary_bank_account")
	private String isPrimaryBankAccount;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
	private final static long serialVersionUID = -7850090231490588331L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public OrganizationBankDetail() {
	}

	/**
	 *
	 * @param organizationId
	 * @param isPrimaryBankAccount
	 * @param bankAccountType
	 * @param bankCodeName
	 * @param branchName
	 * @param bankAccId
	 * @param bankAccountNumber
	 * @param bankName
	 * @param accountHolderName
	 */
	public OrganizationBankDetail(String bankAccId, String bankAccountNumber, String bankCodeName,
			String accountHolderName, String organizationId, String branchName, String bankName, String bankAccountType,
			String isPrimaryBankAccount) {
		super();
		this.bankAccId = bankAccId;
		this.bankAccountNumber = bankAccountNumber;
		this.bankCodeName = bankCodeName;
		this.accountHolderName = accountHolderName;
		this.organizationId = organizationId;
		this.branchName = branchName;
		this.bankName = bankName;
		this.bankAccountType = bankAccountType;
		this.isPrimaryBankAccount = isPrimaryBankAccount;
	}

	@JsonProperty("bank_acc_id")
	public String getBankAccId() {
		return bankAccId;
	}

	@JsonProperty("bank_acc_id")
	public void setBankAccId(String bankAccId) {
		this.bankAccId = bankAccId;
	}

	@JsonProperty("bank_account_number")
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	@JsonProperty("bank_account_number")
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@JsonProperty("bank_code_name")
	public String getBankCodeName() {
		return bankCodeName;
	}

	@JsonProperty("bank_code_name")
	public void setBankCodeName(String bankCodeName) {
		this.bankCodeName = bankCodeName;
	}

	@JsonProperty("account_holder_name")
	public String getAccountHolderName() {
		return accountHolderName;
	}

	@JsonProperty("account_holder_name")
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	@JsonProperty("organization_id")
	public String getOrganizationId() {
		return organizationId;
	}

	@JsonProperty("organization_id")
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	@JsonProperty("branch_name")
	public String getBranchName() {
		return branchName;
	}

	@JsonProperty("branch_name")
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@JsonProperty("bank_name")
	public String getBankName() {
		return bankName;
	}

	@JsonProperty("bank_name")
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@JsonProperty("bank_account_type")
	public String getBankAccountType() {
		return bankAccountType;
	}

	@JsonProperty("bank_account_type")
	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	@JsonProperty("is_primary_bank_account")
	public String getIsPrimaryBankAccount() {
		return isPrimaryBankAccount;
	}

	@JsonProperty("is_primary_bank_account")
	public void setIsPrimaryBankAccount(String isPrimaryBankAccount) {
		this.isPrimaryBankAccount = isPrimaryBankAccount;
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