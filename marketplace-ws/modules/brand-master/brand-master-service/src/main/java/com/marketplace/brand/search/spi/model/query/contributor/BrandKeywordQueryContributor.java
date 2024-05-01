package com.marketplace.brand.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.localization.SearchLocalizationHelper;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true,property = "indexer.class.name=com.marketplace.brand.model.Brand", service = KeywordQueryContributor.class)
public class BrandKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {

		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		QueryConfig queryConfig = searchContext.getQueryConfig();

		queryConfig.addHighlightFieldNames(_searchLocalizationHelper
				.getLocalizedFieldNames(new String[] { Field.CONTENT, Field.TITLE }, searchContext));

	}

	@Reference
	private QueryHelper _queryHelper;

	@Reference
	private SearchLocalizationHelper _searchLocalizationHelper;
}
