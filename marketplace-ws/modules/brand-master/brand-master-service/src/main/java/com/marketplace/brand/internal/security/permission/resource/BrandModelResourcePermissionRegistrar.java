package com.marketplace.brand.internal.security.permission.resource;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.marketplace.brand.constants.BrandConstants;
import com.marketplace.brand.constants.BrandWebPortletKeys;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;

@Component(immediate = true)
public class BrandModelResourcePermissionRegistrar {

	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("model.class.name", Brand.class.getName());

		_serviceRegistration = bundleContext.registerService(ModelResourcePermission.class,
				ModelResourcePermissionFactory.create(Brand.class, Brand::getBrandId, _brandLocalService::getBrand,
						_portletResourcePermission, (modelResourcePermission, consumer) -> {
							consumer.accept(new StagedModelPermissionLogic<>(_stagingPermission,
									BrandWebPortletKeys.BRANDWEB, Brand::getBrandId));
							consumer.accept(new WorkflowedModelPermissionLogic<>(_workflowPermission,
									modelResourcePermission, _groupLocalService, Brand::getBrandId));
						}),
				properties);
	}

	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference
	private BrandLocalService _brandLocalService;

	@Reference(target = "(resource.name=" + BrandConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;

	private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private WorkflowPermission _workflowPermission;

	@Reference
	private GroupLocalService _groupLocalService;
}