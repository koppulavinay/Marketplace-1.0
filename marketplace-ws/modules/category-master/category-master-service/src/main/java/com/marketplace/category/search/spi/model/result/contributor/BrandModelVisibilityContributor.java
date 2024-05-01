package com.marketplace.category.search.spi.model.result.contributor;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import com.marketplace.category.service.CategoryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = "indexer.class.name=com.marketplace.category.model.Category", service = ModelVisibilityContributor.class)
public class BrandModelVisibilityContributor implements ModelVisibilityContributor {

	@Override
	public boolean isVisible(long classPK, int status) {
		try {
			categoryLocalService.getCategory(classPK);

			return true;
		} catch (PortalException portalException) {
			if (logger.isWarnEnabled()) {
				logger.warn("Unable to check visibility for brand ", portalException);
			}

			return false;
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(BrandModelVisibilityContributor.class);

	@Reference
	private CategoryLocalService categoryLocalService;
}
