/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.marketplace.product.master.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
public class ProductWrapper
	extends BaseModelWrapper<Product>
	implements ModelWrapper<Product>, Product {

	public ProductWrapper(Product product) {
		super(product);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("draftProductId", getDraftProductId());
		attributes.put("groupId", getGroupId());
		attributes.put("brandId", getBrandId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("productName", getProductName());
		attributes.put("productType", getProductType());
		attributes.put("shortDescription", getShortDescription());
		attributes.put("longDescription", getLongDescription());
		attributes.put("modelNumber", getModelNumber());
		attributes.put("productStatus", getProductStatus());
		attributes.put("stepNumber", getStepNumber());
		attributes.put("productMappingId", getProductMappingId());
		attributes.put("taxCategoryId", getTaxCategoryId());
		attributes.put("cpDefinitionId", getCpDefinitionId());
		attributes.put("vendorId", getVendorId());
		attributes.put("vendorName", getVendorName());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("organizationName", getOrganizationName());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long draftProductId = (Long)attributes.get("draftProductId");

		if (draftProductId != null) {
			setDraftProductId(draftProductId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String productType = (String)attributes.get("productType");

		if (productType != null) {
			setProductType(productType);
		}

		String shortDescription = (String)attributes.get("shortDescription");

		if (shortDescription != null) {
			setShortDescription(shortDescription);
		}

		String longDescription = (String)attributes.get("longDescription");

		if (longDescription != null) {
			setLongDescription(longDescription);
		}

		String modelNumber = (String)attributes.get("modelNumber");

		if (modelNumber != null) {
			setModelNumber(modelNumber);
		}

		String productStatus = (String)attributes.get("productStatus");

		if (productStatus != null) {
			setProductStatus(productStatus);
		}

		Long stepNumber = (Long)attributes.get("stepNumber");

		if (stepNumber != null) {
			setStepNumber(stepNumber);
		}

		String productMappingId = (String)attributes.get("productMappingId");

		if (productMappingId != null) {
			setProductMappingId(productMappingId);
		}

		Long taxCategoryId = (Long)attributes.get("taxCategoryId");

		if (taxCategoryId != null) {
			setTaxCategoryId(taxCategoryId);
		}

		Long cpDefinitionId = (Long)attributes.get("cpDefinitionId");

		if (cpDefinitionId != null) {
			setCpDefinitionId(cpDefinitionId);
		}

		String vendorId = (String)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		String vendorName = (String)attributes.get("vendorName");

		if (vendorName != null) {
			setVendorName(vendorName);
		}

		String organizationId = (String)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String organizationName = (String)attributes.get("organizationName");

		if (organizationName != null) {
			setOrganizationName(organizationName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public Product cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the brand ID of this product.
	 *
	 * @return the brand ID of this product
	 */
	@Override
	public long getBrandId() {
		return model.getBrandId();
	}

	/**
	 * Returns the category ID of this product.
	 *
	 * @return the category ID of this product
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the company ID of this product.
	 *
	 * @return the company ID of this product
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the cp definition ID of this product.
	 *
	 * @return the cp definition ID of this product
	 */
	@Override
	public long getCpDefinitionId() {
		return model.getCpDefinitionId();
	}

	/**
	 * Returns the create date of this product.
	 *
	 * @return the create date of this product
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this product.
	 *
	 * @return the created by of this product
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the draft product ID of this product.
	 *
	 * @return the draft product ID of this product
	 */
	@Override
	public long getDraftProductId() {
		return model.getDraftProductId();
	}

	/**
	 * Returns the group ID of this product.
	 *
	 * @return the group ID of this product
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this product.
	 *
	 * @return the ip address of this product
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the long description of this product.
	 *
	 * @return the long description of this product
	 */
	@Override
	public String getLongDescription() {
		return model.getLongDescription();
	}

	/**
	 * Returns the localized long description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized long description of this product
	 */
	@Override
	public String getLongDescription(java.util.Locale locale) {
		return model.getLongDescription(locale);
	}

	/**
	 * Returns the localized long description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized long description of this product. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLongDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getLongDescription(locale, useDefault);
	}

	/**
	 * Returns the localized long description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized long description of this product
	 */
	@Override
	public String getLongDescription(String languageId) {
		return model.getLongDescription(languageId);
	}

	/**
	 * Returns the localized long description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized long description of this product
	 */
	@Override
	public String getLongDescription(String languageId, boolean useDefault) {
		return model.getLongDescription(languageId, useDefault);
	}

	@Override
	public String getLongDescriptionCurrentLanguageId() {
		return model.getLongDescriptionCurrentLanguageId();
	}

	@Override
	public String getLongDescriptionCurrentValue() {
		return model.getLongDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized long descriptions of this product.
	 *
	 * @return the locales and localized long descriptions of this product
	 */
	@Override
	public Map<java.util.Locale, String> getLongDescriptionMap() {
		return model.getLongDescriptionMap();
	}

	/**
	 * Returns the model number of this product.
	 *
	 * @return the model number of this product
	 */
	@Override
	public String getModelNumber() {
		return model.getModelNumber();
	}

	/**
	 * Returns the modified by of this product.
	 *
	 * @return the modified by of this product
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this product.
	 *
	 * @return the modified date of this product
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the organization ID of this product.
	 *
	 * @return the organization ID of this product
	 */
	@Override
	public String getOrganizationId() {
		return model.getOrganizationId();
	}

	/**
	 * Returns the organization name of this product.
	 *
	 * @return the organization name of this product
	 */
	@Override
	public String getOrganizationName() {
		return model.getOrganizationName();
	}

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product mapping ID of this product.
	 *
	 * @return the product mapping ID of this product
	 */
	@Override
	public String getProductMappingId() {
		return model.getProductMappingId();
	}

	/**
	 * Returns the product name of this product.
	 *
	 * @return the product name of this product
	 */
	@Override
	public String getProductName() {
		return model.getProductName();
	}

	/**
	 * Returns the localized product name of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized product name of this product
	 */
	@Override
	public String getProductName(java.util.Locale locale) {
		return model.getProductName(locale);
	}

	/**
	 * Returns the localized product name of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized product name of this product. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProductName(java.util.Locale locale, boolean useDefault) {
		return model.getProductName(locale, useDefault);
	}

	/**
	 * Returns the localized product name of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized product name of this product
	 */
	@Override
	public String getProductName(String languageId) {
		return model.getProductName(languageId);
	}

	/**
	 * Returns the localized product name of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized product name of this product
	 */
	@Override
	public String getProductName(String languageId, boolean useDefault) {
		return model.getProductName(languageId, useDefault);
	}

	@Override
	public String getProductNameCurrentLanguageId() {
		return model.getProductNameCurrentLanguageId();
	}

	@Override
	public String getProductNameCurrentValue() {
		return model.getProductNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized product names of this product.
	 *
	 * @return the locales and localized product names of this product
	 */
	@Override
	public Map<java.util.Locale, String> getProductNameMap() {
		return model.getProductNameMap();
	}

	/**
	 * Returns the product status of this product.
	 *
	 * @return the product status of this product
	 */
	@Override
	public String getProductStatus() {
		return model.getProductStatus();
	}

	/**
	 * Returns the product type of this product.
	 *
	 * @return the product type of this product
	 */
	@Override
	public String getProductType() {
		return model.getProductType();
	}

	/**
	 * Returns the short description of this product.
	 *
	 * @return the short description of this product
	 */
	@Override
	public String getShortDescription() {
		return model.getShortDescription();
	}

	/**
	 * Returns the localized short description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized short description of this product
	 */
	@Override
	public String getShortDescription(java.util.Locale locale) {
		return model.getShortDescription(locale);
	}

	/**
	 * Returns the localized short description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized short description of this product. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getShortDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getShortDescription(locale, useDefault);
	}

	/**
	 * Returns the localized short description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized short description of this product
	 */
	@Override
	public String getShortDescription(String languageId) {
		return model.getShortDescription(languageId);
	}

	/**
	 * Returns the localized short description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized short description of this product
	 */
	@Override
	public String getShortDescription(String languageId, boolean useDefault) {
		return model.getShortDescription(languageId, useDefault);
	}

	@Override
	public String getShortDescriptionCurrentLanguageId() {
		return model.getShortDescriptionCurrentLanguageId();
	}

	@Override
	public String getShortDescriptionCurrentValue() {
		return model.getShortDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized short descriptions of this product.
	 *
	 * @return the locales and localized short descriptions of this product
	 */
	@Override
	public Map<java.util.Locale, String> getShortDescriptionMap() {
		return model.getShortDescriptionMap();
	}

	/**
	 * Returns the step number of this product.
	 *
	 * @return the step number of this product
	 */
	@Override
	public long getStepNumber() {
		return model.getStepNumber();
	}

	/**
	 * Returns the tax category ID of this product.
	 *
	 * @return the tax category ID of this product
	 */
	@Override
	public long getTaxCategoryId() {
		return model.getTaxCategoryId();
	}

	/**
	 * Returns the user ID of this product.
	 *
	 * @return the user ID of this product
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this product.
	 *
	 * @return the user name of this product
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this product.
	 *
	 * @return the user uuid of this product
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this product.
	 *
	 * @return the uuid of this product
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the vendor ID of this product.
	 *
	 * @return the vendor ID of this product
	 */
	@Override
	public String getVendorId() {
		return model.getVendorId();
	}

	/**
	 * Returns the vendor name of this product.
	 *
	 * @return the vendor name of this product
	 */
	@Override
	public String getVendorName() {
		return model.getVendorName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the brand ID of this product.
	 *
	 * @param brandId the brand ID of this product
	 */
	@Override
	public void setBrandId(long brandId) {
		model.setBrandId(brandId);
	}

	/**
	 * Sets the category ID of this product.
	 *
	 * @param categoryId the category ID of this product
	 */
	@Override
	public void setCategoryId(long categoryId) {
		model.setCategoryId(categoryId);
	}

	/**
	 * Sets the company ID of this product.
	 *
	 * @param companyId the company ID of this product
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the cp definition ID of this product.
	 *
	 * @param cpDefinitionId the cp definition ID of this product
	 */
	@Override
	public void setCpDefinitionId(long cpDefinitionId) {
		model.setCpDefinitionId(cpDefinitionId);
	}

	/**
	 * Sets the create date of this product.
	 *
	 * @param createDate the create date of this product
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this product.
	 *
	 * @param createdBy the created by of this product
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the draft product ID of this product.
	 *
	 * @param draftProductId the draft product ID of this product
	 */
	@Override
	public void setDraftProductId(long draftProductId) {
		model.setDraftProductId(draftProductId);
	}

	/**
	 * Sets the group ID of this product.
	 *
	 * @param groupId the group ID of this product
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this product.
	 *
	 * @param ipAddress the ip address of this product
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the long description of this product.
	 *
	 * @param longDescription the long description of this product
	 */
	@Override
	public void setLongDescription(String longDescription) {
		model.setLongDescription(longDescription);
	}

	/**
	 * Sets the localized long description of this product in the language.
	 *
	 * @param longDescription the localized long description of this product
	 * @param locale the locale of the language
	 */
	@Override
	public void setLongDescription(
		String longDescription, java.util.Locale locale) {

		model.setLongDescription(longDescription, locale);
	}

	/**
	 * Sets the localized long description of this product in the language, and sets the default locale.
	 *
	 * @param longDescription the localized long description of this product
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLongDescription(
		String longDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLongDescription(longDescription, locale, defaultLocale);
	}

	@Override
	public void setLongDescriptionCurrentLanguageId(String languageId) {
		model.setLongDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized long descriptions of this product from the map of locales and localized long descriptions.
	 *
	 * @param longDescriptionMap the locales and localized long descriptions of this product
	 */
	@Override
	public void setLongDescriptionMap(
		Map<java.util.Locale, String> longDescriptionMap) {

		model.setLongDescriptionMap(longDescriptionMap);
	}

	/**
	 * Sets the localized long descriptions of this product from the map of locales and localized long descriptions, and sets the default locale.
	 *
	 * @param longDescriptionMap the locales and localized long descriptions of this product
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLongDescriptionMap(
		Map<java.util.Locale, String> longDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setLongDescriptionMap(longDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the model number of this product.
	 *
	 * @param modelNumber the model number of this product
	 */
	@Override
	public void setModelNumber(String modelNumber) {
		model.setModelNumber(modelNumber);
	}

	/**
	 * Sets the modified by of this product.
	 *
	 * @param modifiedBy the modified by of this product
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this product.
	 *
	 * @param modifiedDate the modified date of this product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the organization ID of this product.
	 *
	 * @param organizationId the organization ID of this product
	 */
	@Override
	public void setOrganizationId(String organizationId) {
		model.setOrganizationId(organizationId);
	}

	/**
	 * Sets the organization name of this product.
	 *
	 * @param organizationName the organization name of this product
	 */
	@Override
	public void setOrganizationName(String organizationName) {
		model.setOrganizationName(organizationName);
	}

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product mapping ID of this product.
	 *
	 * @param productMappingId the product mapping ID of this product
	 */
	@Override
	public void setProductMappingId(String productMappingId) {
		model.setProductMappingId(productMappingId);
	}

	/**
	 * Sets the product name of this product.
	 *
	 * @param productName the product name of this product
	 */
	@Override
	public void setProductName(String productName) {
		model.setProductName(productName);
	}

	/**
	 * Sets the localized product name of this product in the language.
	 *
	 * @param productName the localized product name of this product
	 * @param locale the locale of the language
	 */
	@Override
	public void setProductName(String productName, java.util.Locale locale) {
		model.setProductName(productName, locale);
	}

	/**
	 * Sets the localized product name of this product in the language, and sets the default locale.
	 *
	 * @param productName the localized product name of this product
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProductName(
		String productName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setProductName(productName, locale, defaultLocale);
	}

	@Override
	public void setProductNameCurrentLanguageId(String languageId) {
		model.setProductNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized product names of this product from the map of locales and localized product names.
	 *
	 * @param productNameMap the locales and localized product names of this product
	 */
	@Override
	public void setProductNameMap(
		Map<java.util.Locale, String> productNameMap) {

		model.setProductNameMap(productNameMap);
	}

	/**
	 * Sets the localized product names of this product from the map of locales and localized product names, and sets the default locale.
	 *
	 * @param productNameMap the locales and localized product names of this product
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProductNameMap(
		Map<java.util.Locale, String> productNameMap,
		java.util.Locale defaultLocale) {

		model.setProductNameMap(productNameMap, defaultLocale);
	}

	/**
	 * Sets the product status of this product.
	 *
	 * @param productStatus the product status of this product
	 */
	@Override
	public void setProductStatus(String productStatus) {
		model.setProductStatus(productStatus);
	}

	/**
	 * Sets the product type of this product.
	 *
	 * @param productType the product type of this product
	 */
	@Override
	public void setProductType(String productType) {
		model.setProductType(productType);
	}

	/**
	 * Sets the short description of this product.
	 *
	 * @param shortDescription the short description of this product
	 */
	@Override
	public void setShortDescription(String shortDescription) {
		model.setShortDescription(shortDescription);
	}

	/**
	 * Sets the localized short description of this product in the language.
	 *
	 * @param shortDescription the localized short description of this product
	 * @param locale the locale of the language
	 */
	@Override
	public void setShortDescription(
		String shortDescription, java.util.Locale locale) {

		model.setShortDescription(shortDescription, locale);
	}

	/**
	 * Sets the localized short description of this product in the language, and sets the default locale.
	 *
	 * @param shortDescription the localized short description of this product
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setShortDescription(
		String shortDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setShortDescription(shortDescription, locale, defaultLocale);
	}

	@Override
	public void setShortDescriptionCurrentLanguageId(String languageId) {
		model.setShortDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized short descriptions of this product from the map of locales and localized short descriptions.
	 *
	 * @param shortDescriptionMap the locales and localized short descriptions of this product
	 */
	@Override
	public void setShortDescriptionMap(
		Map<java.util.Locale, String> shortDescriptionMap) {

		model.setShortDescriptionMap(shortDescriptionMap);
	}

	/**
	 * Sets the localized short descriptions of this product from the map of locales and localized short descriptions, and sets the default locale.
	 *
	 * @param shortDescriptionMap the locales and localized short descriptions of this product
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setShortDescriptionMap(
		Map<java.util.Locale, String> shortDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setShortDescriptionMap(shortDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the step number of this product.
	 *
	 * @param stepNumber the step number of this product
	 */
	@Override
	public void setStepNumber(long stepNumber) {
		model.setStepNumber(stepNumber);
	}

	/**
	 * Sets the tax category ID of this product.
	 *
	 * @param taxCategoryId the tax category ID of this product
	 */
	@Override
	public void setTaxCategoryId(long taxCategoryId) {
		model.setTaxCategoryId(taxCategoryId);
	}

	/**
	 * Sets the user ID of this product.
	 *
	 * @param userId the user ID of this product
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this product.
	 *
	 * @param userName the user name of this product
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this product.
	 *
	 * @param userUuid the user uuid of this product
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this product.
	 *
	 * @param uuid the uuid of this product
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the vendor ID of this product.
	 *
	 * @param vendorId the vendor ID of this product
	 */
	@Override
	public void setVendorId(String vendorId) {
		model.setVendorId(vendorId);
	}

	/**
	 * Sets the vendor name of this product.
	 *
	 * @param vendorName the vendor name of this product
	 */
	@Override
	public void setVendorName(String vendorName) {
		model.setVendorName(vendorName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProductWrapper wrap(Product product) {
		return new ProductWrapper(product);
	}

}