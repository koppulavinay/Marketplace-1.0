package com.marketplace.category.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;
import com.marketplace.category.model.Category;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = {})
public class CategorySearchRegistrar {
	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = _modelSearchRegistrarHelper.register(
			Category.class, bundleContext,
			modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
					Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
					Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
					Field.TITLE, Field.UID);
				modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
					Field.CONTENT, Field.TITLE);
				modelSearchDefinition.setModelIndexWriteContributor(
					_modelIndexWriterContributor);
				modelSearchDefinition.setModelSummaryContributor(
					_modelSummaryContributor);
				modelSearchDefinition.setModelVisibilityContributor(
					_modelVisibilityContributor);
			});
	}
	

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=com.marketplace.category.model.Category)")
	private ModelIndexerWriterContributor<Category> _modelIndexWriterContributor;

	@Reference
	private ModelSearchRegistrarHelper _modelSearchRegistrarHelper;

	@Reference(target = "(indexer.class.name=com.marketplace.category.model.Category)")
	private ModelSummaryContributor _modelSummaryContributor;

	@Reference(target = "(indexer.class.name=com.marketplace.category.model.Category)")
	private ModelVisibilityContributor _modelVisibilityContributor;

	private ServiceRegistration<?> _serviceRegistration;

}
