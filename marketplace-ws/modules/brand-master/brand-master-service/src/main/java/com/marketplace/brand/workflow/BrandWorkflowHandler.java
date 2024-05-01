package com.marketplace.brand.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.marketplace.brand.constants.BrandWebPortletKeys;
import com.marketplace.brand.model.Brand;
import com.marketplace.brand.service.BrandLocalService;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = "model.class.name=" + BrandWebPortletKeys.BRAND_CLASS_NAME, service = WorkflowHandler.class)
public class BrandWorkflowHandler extends BaseWorkflowHandler<Brand> {

	@Override
	public String getClassName() {
		return Brand.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Brand updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
			return brandLocalService.updateStatus(userId, classPK, status, serviceContext);
	}

	@Reference
	private BrandLocalService brandLocalService;

}
