package com.marketplace.category.search.spi.model.index.contributor;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.HtmlParser;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.marketplace.category.constants.CategoryField;
import com.marketplace.category.model.Category;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.category.model.Category", service = ModelDocumentContributor.class)
public class CategoryModelDocumentContributor implements ModelDocumentContributor<Category> {
	@Override
	public void contribute(Document document, Category category) {

		document.addText(CategoryField.CATEGORY_NAME, category.getCategoryName());
		document.addText(CategoryField.CATEGORY_TYPE, category.getCategoryType());
		document.addText(CategoryField.CATEGORY_DESCRIPTION, category.getCategoryDescription());

	}

	@Reference
	private HtmlParser _htmlParser;

	@Reference
	private Language _language;

	@Reference
	private Localization _localization;
}