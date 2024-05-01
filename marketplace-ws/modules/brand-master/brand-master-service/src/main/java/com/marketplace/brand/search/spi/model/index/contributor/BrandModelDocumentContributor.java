package com.marketplace.brand.search.spi.model.index.contributor;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.HtmlParser;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.marketplace.brand.constants.BrandField;
import com.marketplace.brand.model.Brand;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.brand.model.Brand", service = ModelDocumentContributor.class)
public class BrandModelDocumentContributor implements ModelDocumentContributor<Brand> {

	@Override
	public void contribute(Document document, Brand brand) {

		document.addText(BrandField.BRAND_NAME, brand.getBrandName());
		document.addText(BrandField.BRAND_TYPE, brand.getBrandType());
		document.addText(BrandField.BRAND_DESCRIPTION, brand.getBrandDescription());

	}

	@Reference
	private HtmlParser _htmlParser;

	@Reference
	private Language _language;

	@Reference
	private Localization _localization;
}
