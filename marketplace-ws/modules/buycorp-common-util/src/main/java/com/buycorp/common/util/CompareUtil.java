package com.buycorp.common.util;

import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.commerce.product.catalog.CPCatalogEntry;
import com.liferay.commerce.product.catalog.CPSku;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionOptionRel;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.service.CPDefinitionOptionRelLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompareUtil {

	public static boolean compareCPDefinitionIds(List<CPCatalogEntry> cpCatalogEntries,
			List<AssetEntryAssetCategoryRel> assetEntryCategories) throws PortalException {
		boolean categoryProduct = false;
		List<Long> cpDefinitionIds = new ArrayList<>();
		List<Long> CpCatalogCPDefinitionIds = new ArrayList<>();
		for (AssetEntryAssetCategoryRel assetCategoryRel : assetEntryCategories) {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(assetCategoryRel.getAssetEntryId());
			cpDefinitionIds.add(assetEntry.getClassPK());
		}

		for (CPCatalogEntry cpCatalogEntry : cpCatalogEntries) {
			CpCatalogCPDefinitionIds.add(cpCatalogEntry.getCPDefinitionId());
		}

		int count = 0;
		for (long cpDefinitionId : CpCatalogCPDefinitionIds) {
			if (cpDefinitionIds.contains(cpDefinitionId)) {
				count++;
			}
		}

		if (CpCatalogCPDefinitionIds.size() == count) {
			categoryProduct = true;
		}

		return categoryProduct;
	}

	public static CPCatalogEntry getCpCatalogEntry(CPDefinition cpDefinition, CPInstance cpInstance, String languageId) {
		final CPDefinition cpDefinition1 = cpDefinition;
		final CPSku cpsku = getCPsku(cpInstance);
		return new CPCatalogEntry() {

			@Override
			public boolean isIgnoreSKUCombinations() {
				return false;
			}

			@Override
			public String getUrl() {
				return cpDefinition1.getURL(languageId);
			}

			@Override
			public String getShortDescription() {
				return cpDefinition1.getShortDescription();
			}

			@Override
			public String getProductTypeName() {
				return cpDefinition1.getProductTypeName();
			}

			@Override
			public String getName() {
				return cpDefinition1.getName();
			}

			@Override
			public String getMetaTitle(String languageId) {
				return cpDefinition1.getMetaTitle();
			}

			@Override
			public String getMetaKeywords(String languageId) {
				return cpDefinition1.getMetaKeywords();
			}

			@Override
			public String getMetaDescription(String languageId) {
				return cpDefinition1.getMetaDescription();
			}

			@Override
			public double getHeight() {
				return cpDefinition1.getHeight();
			}

			@Override
			public long getGroupId() {
				return cpDefinition1.getGroupId();
			}

			@Override
			public String getDescription() {
				return cpDefinition1.getDescription();
			}

			@Override
			public double getDepth() {
				return cpDefinition1.getDepth();
			}

			@Override
			public long getCProductId() {
				return cpDefinition1.getCProductId();
			}

			@Override
			public List<CPSku> getCPSkus() {
				List<CPSku> cpSkus = new ArrayList<>();
				cpSkus.add(cpsku);
				return cpSkus;
			}

			@Override
			public List<CPDefinitionOptionRel> getCPDefinitionOptionRels() {
				return CPDefinitionOptionRelLocalServiceUtil.getCPDefinitionOptionRels(-1, -1);
			}

			@Override
			public long getCPDefinitionId() {
				return cpDefinition1.getCPDefinitionId();
			}
		};
	}

	public static CPSku getCPsku(CPInstance cpInstance) {
		final CPInstance _cpInstance = cpInstance;
		CPSku cpSku = new CPSku() {

			@Override
			public long getCPInstanceId() {
				return _cpInstance.getCPInstanceId();
			}

			@Override
			public String getCPInstanceUuid() {
				return _cpInstance.getCPInstanceUuid();
			}

			@Override
			public Date getDiscontinuedDate() {
				return _cpInstance.getDiscontinuedDate();
			}

			@Override
			public String getExternalReferenceCode() {
				return _cpInstance.getExternalReferenceCode();
			}

			@Override
			public String getGtin() {
				return _cpInstance.getGtin();
			}

			@Override
			public String getManufacturerPartNumber() {
				return _cpInstance.getManufacturerPartNumber();
			}

			@Override
			public BigDecimal getPrice() {
				return _cpInstance.getPrice();
			}

			@Override
			public BigDecimal getPromoPrice() {
				return _cpInstance.getPromoPrice();
			}

			@Override
			public String getReplacementCPInstanceUuid() {
				return _cpInstance.getReplacementCPInstanceUuid();
			}

			@Override
			public long getReplacementCProductId() {
				return _cpInstance.getReplacementCProductId();
			}

			@Override
			public String getSku() {
				return _cpInstance.getSku();
			}

			@Override
			public boolean isDiscontinued() {
				return _cpInstance.isDiscontinued();
			}

			@Override
			public boolean isPublished() {
				return _cpInstance.isPublished();
			}

			@Override
			public boolean isPurchasable() {
				return _cpInstance.isPurchasable();
			}

		};
		return cpSku;
	}

}
