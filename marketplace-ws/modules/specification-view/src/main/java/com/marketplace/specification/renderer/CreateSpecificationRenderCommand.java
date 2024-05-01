package com.marketplace.specification.renderer;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.field.data.type.model.SpecFieldDataType;
import com.marketplace.specification.field.data.type.service.SpecFieldDataTypeLocalService;
import com.marketplace.specification.field.type.model.SpecFieldType;
import com.marketplace.specification.field.type.service.SpecFieldTypeLocalService;
import com.marketplace.specification.value.uoms.model.SpecValueUom;
import com.marketplace.specification.value.uoms.service.SpecValueUomLocalService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW,
"mvc.command.name=createSpecificationRender" }, service = MVCRenderCommand.class)

public class CreateSpecificationRenderCommand implements MVCRenderCommand {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(CreateSpecificationRenderCommand.class.getName());

	// before creation of specification this file will redirect to add specification jsp
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside CreateSpecificationRenderCommand Method" + SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);
		
		List<SpecFieldType> specFieldTypes = specFieldTypeLocalService.getSpecFieldTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<SpecFieldDataType> specFieldDataTypes = specFieldDataTypeLocalService.getSpecFieldDataTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<SpecValueUom> specValueUoms = specValueUomLocalService.getSpecValueUoms(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<Category> categories = categoryLocalService.getbyStatus(SpecificationViewPortletKeys.APPROVED);
		
		renderRequest.setAttribute("specFieldTypes", specFieldTypes);
		renderRequest.setAttribute("specFieldDataTypes", specFieldDataTypes);
		renderRequest.setAttribute("specValueUoms", specValueUoms);
		renderRequest.setAttribute("categories", categories);
		
		return SpecificationViewPortletKeys.ADD_JSP;
	}
	
	@Reference
	private SpecFieldTypeLocalService specFieldTypeLocalService;
	
	@Reference
	private SpecFieldDataTypeLocalService specFieldDataTypeLocalService;
	
	@Reference
	private SpecValueUomLocalService specValueUomLocalService;
	
	@Reference
	private CategoryLocalService categoryLocalService;

}
