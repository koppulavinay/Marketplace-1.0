package com.marketplace.specification.renderer;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.SpecCategoryMapLocalService;
import com.marketplace.specification.constants.SpecificationViewPortletKeys;
import com.marketplace.specification.field.data.type.model.SpecFieldDataType;
import com.marketplace.specification.field.data.type.service.SpecFieldDataTypeLocalService;
import com.marketplace.specification.field.type.model.SpecFieldType;
import com.marketplace.specification.field.type.service.SpecFieldTypeLocalService;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specification.model.SpecificationCategoryModel;
import com.marketplace.specification.value.uoms.model.SpecValueUom;
import com.marketplace.specification.value.uoms.service.SpecValueUomLocalService;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + SpecificationViewPortletKeys.SPECIFICATIONVIEW,
		"mvc.command.name=updateSpecificationRender" }, service = MVCRenderCommand.class)
public class UpdateSpecificationRenderCommand implements MVCRenderCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(UpdateSpecificationRenderCommand.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		LOGGER.info(SpecificationViewPortletKeys.LOGGER_INFO_PREFIX + "Inside UpdateSpecificationRenderCommand Method"
				+ SpecificationViewPortletKeys.LOGGER_INFO_SUFFIX);

		long specificationId = ParamUtil.getLong(renderRequest, SpecificationViewPortletKeys.SPECIFICATION_ID);

		List<SpecFieldType> specFieldTypes = specFieldTypeLocalService.getSpecFieldTypes(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<SpecFieldDataType> specFieldDataTypes = specFieldDataTypeLocalService
				.getSpecFieldDataTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<SpecValueUom> specValueUoms = specValueUomLocalService.getSpecValueUoms(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<SpecCategoryMap> specCategoryMaps = specCategoryMapLocalService.findByFBYSpecificationId(specificationId);
		List<Category> categories = categoryLocalService.getbyStatus(SpecificationViewPortletKeys.APPROVED);

		Specification specification = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd, HH:mm");
		String formattedDate = "";

		try {
			specification = specificationLocalService.getSpecification(specificationId);
			formattedDate = simpleDateFormat.format(specification.getModifiedDate());
		} catch (Exception e) {
			LOGGER.error("Error while getting specification :: " + e.getMessage());
		}

		renderRequest.setAttribute("specification", specification);
		renderRequest.setAttribute("formattedDate", formattedDate);
		renderRequest.setAttribute("specFieldTypes", specFieldTypes);
		renderRequest.setAttribute("specFieldDataTypes", specFieldDataTypes);
		renderRequest.setAttribute("specValueUoms", specValueUoms);
		renderRequest.setAttribute("specificationValues", getAllSpecificationValues(specificationId));
		renderRequest.setAttribute("selectedSpecCategories", getSelectedSpecCategories(specCategoryMaps, categories));
		renderRequest.setAttribute("allCategoriesWithSelection",
				getAllCategoriesWithSelection(specCategoryMaps, categories));

		return SpecificationViewPortletKeys.UPDATE_JSP;
	}

	private List<SpecificationValue> getAllSpecificationValues(long specificationId) {
		return specificationValueLocalService.findByFBYSpecificationId(specificationId);
	}

	private List<SpecificationCategoryModel> getSelectedSpecCategories(List<SpecCategoryMap> specCategoryMaps,
			List<Category> categories) {

		List<SpecificationCategoryModel> specCategories = new ArrayList<>();

		specCategoryMaps.stream().forEach(specificationCategory -> {
			categories.stream().filter(category -> category.getCategoryId() == specificationCategory.getCategoryId())
					.forEach(category -> {
						specCategories.add(new SpecificationCategoryModel(category.getCategoryId(),
								specificationCategory.getSpecCategoryMapId(), category.getCategoryName(),
								specificationCategory.getIsCategoryMandatory()));
					});
		});

		return specCategories;

	}

	private List<SpecificationCategoryModel> getAllCategoriesWithSelection(List<SpecCategoryMap> specCategoryMaps,
			List<Category> categories) {

		List<SpecificationCategoryModel> allCategoriesWithSelection = new ArrayList<>();

		categories.stream().forEach(category -> {

			Optional<SpecCategoryMap> specCategoryMap = specCategoryMaps.stream()
					.filter(specCategory -> specCategory.getCategoryId() == category.getCategoryId()).findAny();

			boolean isCategorySelected = Boolean.FALSE;

			if (specCategoryMap.isPresent()) {
				isCategorySelected = specCategoryMap.get().getIsCategoryMandatory()
						? specCategoryMap.get().getIsCategoryMandatory()
						: Boolean.FALSE;
			}

			allCategoriesWithSelection.add(new SpecificationCategoryModel(category.getCategoryId(),
					category.getCategoryName(), isCategorySelected));

		});

		return allCategoriesWithSelection;

	}

	@Reference
	private SpecificationLocalService specificationLocalService;

	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

	@Reference
	private SpecFieldTypeLocalService specFieldTypeLocalService;

	@Reference
	private SpecFieldDataTypeLocalService specFieldDataTypeLocalService;

	@Reference
	private SpecValueUomLocalService specValueUomLocalService;

	@Reference
	private SpecCategoryMapLocalService specCategoryMapLocalService;

	@Reference
	private CategoryLocalService categoryLocalService;

}
