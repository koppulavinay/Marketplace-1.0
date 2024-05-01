package com.marketplace.brand.search.spi.model.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.brand.model.Brand", service = ModelSummaryContributor.class)
public class BrandModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {

		String languageId = LocaleUtil.toLanguageId(locale);

		return _createSummary(document, _localization.getLocalizedName(Field.CONTENT, languageId),
				_localization.getLocalizedName(Field.TITLE, languageId));
	}

	private Summary _createSummary(Document document, String contentField, String titleField) {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		Summary summary = new Summary(document.get(prefix + titleField, titleField),
				document.get(prefix + contentField, contentField));

		summary.setMaxContentLength(200);

		return summary;
	}

	@Reference
	private Localization _localization;
}
