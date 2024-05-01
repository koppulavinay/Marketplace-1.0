package com.marketplace.category.search.spi.model.index.contributor;


import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.category.model.Category", service = ModelIndexerWriterContributor.class)

public class CategoryModelIndexerWriterContributor implements ModelIndexerWriterContributor<Category> {
	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((Category category) -> batchIndexingActionable
				.addDocuments(modelIndexerWriterDocumentHelper.getDocument(category)));

	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory
				.getBatchIndexingActionable(_categoryLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Category category) {
		return category.getCompanyId();
	}

	@Reference
	private CategoryLocalService _categoryLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;

}
