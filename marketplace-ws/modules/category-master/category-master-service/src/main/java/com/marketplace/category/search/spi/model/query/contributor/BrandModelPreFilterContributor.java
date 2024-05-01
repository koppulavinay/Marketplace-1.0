package com.marketplace.category.search.spi.model.query.contributor;


import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.category.model.Category", service = ModelPreFilterContributor.class)
public class BrandModelPreFilterContributor implements ModelPreFilterContributor {

	@Override
	public void contribute(BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
			SearchContext searchContext) {

		_workflowStatusModelPreFilterContributor.contribute(booleanFilter, modelSearchSettings, searchContext);

	}

	@Reference(target = "(model.pre.filter.contributor.id=WorkflowStatus)")
	private ModelPreFilterContributor _workflowStatusModelPreFilterContributor;
}
