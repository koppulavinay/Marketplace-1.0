package com.marketplace.category.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.marketplace.category.constants.CategoryViewPortletKeys;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.category.service.CategoryLocalServiceUtil;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = "model.class.name=" + CategoryViewPortletKeys.CATEGORYVIEW, service = WorkflowHandler.class)

public class CategoryWorkflowHandler extends BaseWorkflowHandler<Category> {

	@Override
	public String getClassName() {
		return Category.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Category updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {

		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
		return categoryLocalService.updateStatus(userId, classPK, status, serviceContext);
	}

	@Reference
	private CategoryLocalService categoryLocalService;

}
