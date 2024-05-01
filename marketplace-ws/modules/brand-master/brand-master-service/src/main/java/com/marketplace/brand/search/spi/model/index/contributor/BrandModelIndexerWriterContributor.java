package com.marketplace.brand.search.spi.model.index.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.brand.model.Brand", service = ModelIndexerWriterContributor.class)
public class BrandModelIndexerWriterContributor implements ModelIndexerWriterContributor<Brand> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((Brand brand) -> batchIndexingActionable
				.addDocuments(modelIndexerWriterDocumentHelper.getDocument(brand)));

	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory
				.getBatchIndexingActionable(_blogsEntryLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Brand brand) {
		return brand.getCompanyId();
	}

	@Reference
	private BrandLocalService _blogsEntryLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;

}
