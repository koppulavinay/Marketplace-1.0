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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Product service. Represents a row in the &quot;marketplace_product&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.marketplace.product.master.model.impl.ProductModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.marketplace.product.master.model.impl.ProductImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Product
 * @generated
 */
@ProviderType
public interface ProductModel
	extends BaseModel<Product>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a product model instance should use the {@link Product} interface instead.
	 */

	/**
	 * Returns the primary key of this product.
	 *
	 * @return the primary key of this product
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this product.
	 *
	 * @param primaryKey the primary key of this product
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this product.
	 *
	 * @return the uuid of this product
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this product.
	 *
	 * @param uuid the uuid of this product
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the draft product ID of this product.
	 *
	 * @return the draft product ID of this product
	 */
	public long getDraftProductId();

	/**
	 * Sets the draft product ID of this product.
	 *
	 * @param draftProductId the draft product ID of this product
	 */
	public void setDraftProductId(long draftProductId);

	/**
	 * Returns the group ID of this product.
	 *
	 * @return the group ID of this product
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this product.
	 *
	 * @param groupId the group ID of this product
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the brand ID of this product.
	 *
	 * @return the brand ID of this product
	 */
	public long getBrandId();

	/**
	 * Sets the brand ID of this product.
	 *
	 * @param brandId the brand ID of this product
	 */
	public void setBrandId(long brandId);

	/**
	 * Returns the category ID of this product.
	 *
	 * @return the category ID of this product
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this product.
	 *
	 * @param categoryId the category ID of this product
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the product name of this product.
	 *
	 * @return the product name of this product
	 */
	public String getProductName();

	/**
	 * Returns the localized product name of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized product name of this product
	 */
	@AutoEscape
	public String getProductName(Locale locale);

	/**
	 * Returns the localized product name of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized product name of this product. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getProductName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized product name of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized product name of this product
	 */
	@AutoEscape
	public String getProductName(String languageId);

	/**
	 * Returns the localized product name of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized product name of this product
	 */
	@AutoEscape
	public String getProductName(String languageId, boolean useDefault);

	@AutoEscape
	public String getProductNameCurrentLanguageId();

	@AutoEscape
	public String getProductNameCurrentValue();

	/**
	 * Returns a map of the locales and localized product names of this product.
	 *
	 * @return the locales and localized product names of this product
	 */
	public Map<Locale, String> getProductNameMap();

	/**
	 * Sets the product name of this product.
	 *
	 * @param productName the product name of this product
	 */
	public void setProductName(String productName);

	/**
	 * Sets the localized product name of this product in the language.
	 *
	 * @param productName the localized product name of this product
	 * @param locale the locale of the language
	 */
	public void setProductName(String productName, Locale locale);

	/**
	 * Sets the localized product name of this product in the language, and sets the default locale.
	 *
	 * @param productName the localized product name of this product
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setProductName(
		String productName, Locale locale, Locale defaultLocale);

	public void setProductNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized product names of this product from the map of locales and localized product names.
	 *
	 * @param productNameMap the locales and localized product names of this product
	 */
	public void setProductNameMap(Map<Locale, String> productNameMap);

	/**
	 * Sets the localized product names of this product from the map of locales and localized product names, and sets the default locale.
	 *
	 * @param productNameMap the locales and localized product names of this product
	 * @param defaultLocale the default locale
	 */
	public void setProductNameMap(
		Map<Locale, String> productNameMap, Locale defaultLocale);

	/**
	 * Returns the product type of this product.
	 *
	 * @return the product type of this product
	 */
	@AutoEscape
	public String getProductType();

	/**
	 * Sets the product type of this product.
	 *
	 * @param productType the product type of this product
	 */
	public void setProductType(String productType);

	/**
	 * Returns the short description of this product.
	 *
	 * @return the short description of this product
	 */
	public String getShortDescription();

	/**
	 * Returns the localized short description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized short description of this product
	 */
	@AutoEscape
	public String getShortDescription(Locale locale);

	/**
	 * Returns the localized short description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized short description of this product. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getShortDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized short description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized short description of this product
	 */
	@AutoEscape
	public String getShortDescription(String languageId);

	/**
	 * Returns the localized short description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized short description of this product
	 */
	@AutoEscape
	public String getShortDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getShortDescriptionCurrentLanguageId();

	@AutoEscape
	public String getShortDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized short descriptions of this product.
	 *
	 * @return the locales and localized short descriptions of this product
	 */
	public Map<Locale, String> getShortDescriptionMap();

	/**
	 * Sets the short description of this product.
	 *
	 * @param shortDescription the short description of this product
	 */
	public void setShortDescription(String shortDescription);

	/**
	 * Sets the localized short description of this product in the language.
	 *
	 * @param shortDescription the localized short description of this product
	 * @param locale the locale of the language
	 */
	public void setShortDescription(String shortDescription, Locale locale);

	/**
	 * Sets the localized short description of this product in the language, and sets the default locale.
	 *
	 * @param shortDescription the localized short description of this product
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setShortDescription(
		String shortDescription, Locale locale, Locale defaultLocale);

	public void setShortDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized short descriptions of this product from the map of locales and localized short descriptions.
	 *
	 * @param shortDescriptionMap the locales and localized short descriptions of this product
	 */
	public void setShortDescriptionMap(Map<Locale, String> shortDescriptionMap);

	/**
	 * Sets the localized short descriptions of this product from the map of locales and localized short descriptions, and sets the default locale.
	 *
	 * @param shortDescriptionMap the locales and localized short descriptions of this product
	 * @param defaultLocale the default locale
	 */
	public void setShortDescriptionMap(
		Map<Locale, String> shortDescriptionMap, Locale defaultLocale);

	/**
	 * Returns the long description of this product.
	 *
	 * @return the long description of this product
	 */
	public String getLongDescription();

	/**
	 * Returns the localized long description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized long description of this product
	 */
	@AutoEscape
	public String getLongDescription(Locale locale);

	/**
	 * Returns the localized long description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized long description of this product. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getLongDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized long description of this product in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized long description of this product
	 */
	@AutoEscape
	public String getLongDescription(String languageId);

	/**
	 * Returns the localized long description of this product in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized long description of this product
	 */
	@AutoEscape
	public String getLongDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getLongDescriptionCurrentLanguageId();

	@AutoEscape
	public String getLongDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized long descriptions of this product.
	 *
	 * @return the locales and localized long descriptions of this product
	 */
	public Map<Locale, String> getLongDescriptionMap();

	/**
	 * Sets the long description of this product.
	 *
	 * @param longDescription the long description of this product
	 */
	public void setLongDescription(String longDescription);

	/**
	 * Sets the localized long description of this product in the language.
	 *
	 * @param longDescription the localized long description of this product
	 * @param locale the locale of the language
	 */
	public void setLongDescription(String longDescription, Locale locale);

	/**
	 * Sets the localized long description of this product in the language, and sets the default locale.
	 *
	 * @param longDescription the localized long description of this product
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setLongDescription(
		String longDescription, Locale locale, Locale defaultLocale);

	public void setLongDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized long descriptions of this product from the map of locales and localized long descriptions.
	 *
	 * @param longDescriptionMap the locales and localized long descriptions of this product
	 */
	public void setLongDescriptionMap(Map<Locale, String> longDescriptionMap);

	/**
	 * Sets the localized long descriptions of this product from the map of locales and localized long descriptions, and sets the default locale.
	 *
	 * @param longDescriptionMap the locales and localized long descriptions of this product
	 * @param defaultLocale the default locale
	 */
	public void setLongDescriptionMap(
		Map<Locale, String> longDescriptionMap, Locale defaultLocale);

	/**
	 * Returns the model number of this product.
	 *
	 * @return the model number of this product
	 */
	@AutoEscape
	public String getModelNumber();

	/**
	 * Sets the model number of this product.
	 *
	 * @param modelNumber the model number of this product
	 */
	public void setModelNumber(String modelNumber);

	/**
	 * Returns the product status of this product.
	 *
	 * @return the product status of this product
	 */
	@AutoEscape
	public String getProductStatus();

	/**
	 * Sets the product status of this product.
	 *
	 * @param productStatus the product status of this product
	 */
	public void setProductStatus(String productStatus);

	/**
	 * Returns the step number of this product.
	 *
	 * @return the step number of this product
	 */
	public long getStepNumber();

	/**
	 * Sets the step number of this product.
	 *
	 * @param stepNumber the step number of this product
	 */
	public void setStepNumber(long stepNumber);

	/**
	 * Returns the product mapping ID of this product.
	 *
	 * @return the product mapping ID of this product
	 */
	@AutoEscape
	public String getProductMappingId();

	/**
	 * Sets the product mapping ID of this product.
	 *
	 * @param productMappingId the product mapping ID of this product
	 */
	public void setProductMappingId(String productMappingId);

	/**
	 * Returns the tax category ID of this product.
	 *
	 * @return the tax category ID of this product
	 */
	public long getTaxCategoryId();

	/**
	 * Sets the tax category ID of this product.
	 *
	 * @param taxCategoryId the tax category ID of this product
	 */
	public void setTaxCategoryId(long taxCategoryId);

	/**
	 * Returns the cp definition ID of this product.
	 *
	 * @return the cp definition ID of this product
	 */
	public long getCpDefinitionId();

	/**
	 * Sets the cp definition ID of this product.
	 *
	 * @param cpDefinitionId the cp definition ID of this product
	 */
	public void setCpDefinitionId(long cpDefinitionId);

	/**
	 * Returns the vendor ID of this product.
	 *
	 * @return the vendor ID of this product
	 */
	@AutoEscape
	public String getVendorId();

	/**
	 * Sets the vendor ID of this product.
	 *
	 * @param vendorId the vendor ID of this product
	 */
	public void setVendorId(String vendorId);

	/**
	 * Returns the vendor name of this product.
	 *
	 * @return the vendor name of this product
	 */
	@AutoEscape
	public String getVendorName();

	/**
	 * Sets the vendor name of this product.
	 *
	 * @param vendorName the vendor name of this product
	 */
	public void setVendorName(String vendorName);

	/**
	 * Returns the organization ID of this product.
	 *
	 * @return the organization ID of this product
	 */
	@AutoEscape
	public String getOrganizationId();

	/**
	 * Sets the organization ID of this product.
	 *
	 * @param organizationId the organization ID of this product
	 */
	public void setOrganizationId(String organizationId);

	/**
	 * Returns the organization name of this product.
	 *
	 * @return the organization name of this product
	 */
	@AutoEscape
	public String getOrganizationName();

	/**
	 * Sets the organization name of this product.
	 *
	 * @param organizationName the organization name of this product
	 */
	public void setOrganizationName(String organizationName);

	/**
	 * Returns the company ID of this product.
	 *
	 * @return the company ID of this product
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this product.
	 *
	 * @param companyId the company ID of this product
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this product.
	 *
	 * @return the user ID of this product
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this product.
	 *
	 * @param userId the user ID of this product
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this product.
	 *
	 * @return the user uuid of this product
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this product.
	 *
	 * @param userUuid the user uuid of this product
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this product.
	 *
	 * @return the user name of this product
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this product.
	 *
	 * @param userName the user name of this product
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the created by of this product.
	 *
	 * @return the created by of this product
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this product.
	 *
	 * @param createdBy the created by of this product
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified by of this product.
	 *
	 * @return the modified by of this product
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this product.
	 *
	 * @param modifiedBy the modified by of this product
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the create date of this product.
	 *
	 * @return the create date of this product
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this product.
	 *
	 * @param createDate the create date of this product
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this product.
	 *
	 * @return the modified date of this product
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this product.
	 *
	 * @param modifiedDate the modified date of this product
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ip address of this product.
	 *
	 * @return the ip address of this product
	 */
	@AutoEscape
	public String getIpAddress();

	/**
	 * Sets the ip address of this product.
	 *
	 * @param ipAddress the ip address of this product
	 */
	public void setIpAddress(String ipAddress);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Product cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}