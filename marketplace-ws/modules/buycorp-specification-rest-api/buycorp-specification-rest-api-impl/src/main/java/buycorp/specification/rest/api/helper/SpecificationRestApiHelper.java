package buycorp.specification.rest.api.helper;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.category.model.Category;
import com.marketplace.category.service.CategoryLocalService;
import com.marketplace.specification.category.map.model.SpecCategoryMap;
import com.marketplace.specification.category.map.service.SpecCategoryMapLocalService;
import com.marketplace.specification.master.model.Specification;
import com.marketplace.specification.master.service.SpecificationLocalService;
import com.marketplace.specifications.value.master.model.SpecificationValue;
import com.marketplace.specifications.value.master.service.SpecificationValueLocalService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import buycorp.specification.rest.api.dto.v1_0.SpecificationCreateObject;
import buycorp.specification.rest.api.dto.v1_0.SpecificationObject;
import buycorp.specification.rest.api.dto.v1_0.SpecificationUpdateObject;

/**
 * 
 * @author kashyap.mishra
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, service = SpecificationRestApiHelper.class)
public class SpecificationRestApiHelper {

	/**
	 * 
	 * Get all BuyCorp Specification in API response using service builder of
	 * specification
	 * 
	 * @return
	 */
	public List<SpecificationObject> getAllSpecifications() {

		List<SpecificationObject> specificationObjects = new ArrayList<>();
		List<Specification> allSpecificationList = specificationLocalService.getSpecifications(-1, -1);

		for (Specification specificationList : allSpecificationList) {

			long specificationId = specificationList.getSpecificationId();

			SpecificationObject specificationObject = new SpecificationObject();

			specificationObject.setSpecificationLabel(specificationList.getSpecificationLabel());
			specificationObject.setSpecificationDescription(specificationList.getSpecificationDescription());
			specificationObject.setSpecificationFieldDataType(specificationList.getSpecificationFieldDataType());
			specificationObject.setSpecificationFieldType(specificationList.getSpecificationFieldType());
			specificationObject.setSpecificationId(specificationList.getSpecificationId());

			// Setting specification values in the array.
			specificationObject.setSpecificationValues(getSpecificationValues(specificationId));

			// Setting Categories in the array
			specificationObject.setCategories(getCategoriesBySpecification(specificationId));

			_log.info("specification object --------->" + specificationObject);

			specificationObjects.add(specificationObject);

		}

		return specificationObjects;

	}

	/**
	 * 
	 * This method is used to return a specification details in the API response.
	 * 
	 * @param specificationId
	 * @return
	 */
	public SpecificationObject getSpecificationById(long specificationId) {

		_log.info("Specification id------------>" + specificationId);

		SpecificationObject specificationObject = new SpecificationObject();

		try {
			Specification specification = getSpecificationBySpecId(specificationId);

			specificationObject.setSpecificationLabel(specification.getSpecificationLabel());
			specificationObject.setSpecificationDescription(specification.getSpecificationDescription());
			specificationObject.setSpecificationFieldDataType(specification.getSpecificationFieldDataType());
			specificationObject.setSpecificationFieldType(specification.getSpecificationFieldType());
			specificationObject.setSpecificationId(specification.getSpecificationId());

			// Setting specification values in the array.
			specificationObject.setSpecificationValues(getSpecificationValues(specificationId));

			// Setting Categories in the array
			specificationObject.setCategories(getCategoriesBySpecification(specificationId));

		} catch (PortalException e) {

			e.printStackTrace();
		}

		return specificationObject;

	}

	/**
	 * 
	 * This method will update a specification and its mapping details in the
	 * database tables by taking input from the API's request.
	 * 
	 * @param specificationUpdateObject
	 * @return
	 */
	public String updateSpecification(SpecificationUpdateObject specificationUpdateObject) {

		try {

			long specificationId = specificationUpdateObject.getSpecificationId();

			Specification specification = getSpecificationBySpecId(specificationId);

			// Updating a particular specification in the database
			updateSpecificationMaster(specificationUpdateObject, specification);

			// Updating mapping of categories with a specification in the database
			updateSpecCategoryMapping(specification, specificationUpdateObject);
			
			// Updating Specification Value mapping with a specification in the database.
			updateSpecValuesMapping(specificationUpdateObject, specification);

			JSONObject specificationJSONObject = JSONFactoryUtil.createJSONObject();
			specificationJSONObject.put("message", "Specification updated successfully");
			
			return specificationJSONObject.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StringPool.BLANK;

	}

	 public String createSpecification(SpecificationCreateObject specificationCreateObject) {
	      try {
	         long specificationId = CounterLocalServiceUtil.increment(Specification.class.getName());
	         createSpecificationMaster(specificationCreateObject, specificationId);
	         createSpecCategoryMapping(specificationCreateObject, specificationId);
	         createSpecValuesMapping(specificationCreateObject, specificationId);
	         JSONObject specificationJSONObject = JSONFactoryUtil.createJSONObject();
	         specificationJSONObject.put("message", "Specification created successfully");
	         return specificationJSONObject.toString();
	      } catch (Exception e) {
	         e.printStackTrace();
	         return "";
	      }
	   }

	   private void createSpecificationMaster(SpecificationCreateObject specificationCreateObject, long specificationId) {
		   
	      Specification specification = specificationLocalService.createSpecification(specificationId);
	      specification.setSpecificationId(specificationId);
		  specification.setSpecificationLabel(HtmlUtil.escape(specificationCreateObject.getSpecificationLabel()));
	      specification.setSpecificationDescription(HtmlUtil.escape(specificationCreateObject.getSpecificationDescription()));
	      specification.setSpecificationFieldDataType(specificationCreateObject.getSpecificationFieldDataType());
	      specification.setSpecificationFieldType(specificationCreateObject.getSpecificationFieldType());
		  specification.setSpecificationStatus("Approved");
		  specification.setModifiedBy(specificationCreateObject.getModifiedBy());
		  specification.setCreatedBy(specificationCreateObject.getModifiedBy());
	      specificationLocalService.updateSpecification(specification);
	   }

	   private void createSpecCategoryMapping(SpecificationCreateObject specificationCreateObject, long specificationId) {
	      
		   buycorp.specification.rest.api.dto.v1_0.@Valid Category[] categories = specificationCreateObject.getCategories();
		   long specCategoryMapId = CounterLocalServiceUtil.increment(SpecCategoryMap.class.getName());
		   for (buycorp.specification.rest.api.dto.v1_0.Category category : categories) {

			   createSpecCategoryMapping(category, specificationId, specCategoryMapId, specificationCreateObject.getModifiedBy());
			   
		   }

	   }

	   private void createSpecValuesMapping(SpecificationCreateObject specificationCreateObject, long specificationId) {
	      buycorp.specification.rest.api.dto.v1_0.@Valid SpecificationValue[] specificationValues = specificationCreateObject.getSpecificationValues();
	      
	      for(buycorp.specification.rest.api.dto.v1_0.@Valid SpecificationValue specificationValueObj : specificationValues)
	      
	    	  createSpecificationValuesMapping(specificationValueObj, specificationId, specificationValueObj.getSpecificationValueId(), specificationCreateObject.getModifiedBy());
	   }
	      /**
	  	 * 
	  	 * Adding new specification category mapping in SpecCategoryMap database table.
	  	 * param specificationUpdateObject
	  	 * param specCategoryMapId
	  	 */
	  	private void createSpecCategoryMapping(buycorp.specification.rest.api.dto.v1_0.Category category, long specificationId, long specCategoryMapId, long modifiedBy) {

	  		SpecCategoryMap specCategoryMapObj = specCategoryMapLocalService.createSpecCategoryMap(specCategoryMapId);

	  		specCategoryMapObj.setSpecificationId(specificationId);
			specCategoryMapObj.setCategoryId(category.getCategoryId());
			specCategoryMapObj.setIsCategoryMandatory(category.getIscategorymandatory());
	  		specCategoryMapObj.setCompanyId(0);
	  		specCategoryMapObj.setCreateDate(new Date());
	  		specCategoryMapObj.setModifiedDate(new Date());
	  		specCategoryMapObj.setCreatedBy(modifiedBy);
	  		specCategoryMapObj.setModifiedBy(modifiedBy);
	  		specCategoryMapObj.setIpAddress(StringPool.BLANK);

	  		specCategoryMapLocalService.updateSpecCategoryMap(specCategoryMapObj);

	  	}

	  	/**
		 * 
		 * @param specificationValuesObj
		 * @param specificationId
		 * @param specificationValuesMapId
		 */
		private void createSpecificationValuesMapping(buycorp.specification.rest.api.dto.v1_0.SpecificationValue specificationValuesObj, long specificationId, long specificationValuesMapId,long modifiedBy) {
			
			SpecificationValue specificationValuesMapObj = specificationValueLocalService.createSpecificationValue(specificationValuesMapId);
			
			specificationValuesMapObj.setSpecificationId(specificationId);
			specificationValuesMapObj.setSpecificationValueLabel(HtmlUtil.escape(specificationValuesObj.getSpecificationValueLabel()));
			specificationValuesMapObj.setSpecificationUOM(HtmlUtil.escape(specificationValuesObj.getSpecificationUOM()));
			specificationValuesMapObj.setGroupId(0);
			specificationValuesMapObj.setCompanyId(0);
			specificationValuesMapObj.setCreateDate(new Date());
			specificationValuesMapObj.setModifiedDate(new Date());
			specificationValuesMapObj.setCreatedBy(modifiedBy);
			specificationValuesMapObj.setModifiedBy(modifiedBy);
			specificationValuesMapObj.setIpAddress(StringPool.BLANK);
			specificationValuesMapObj.setUserId(0);
			specificationValuesMapObj.setUserName(StringPool.BLANK);
			
			specificationValueLocalService.updateSpecificationValue(specificationValuesMapObj);
			
		}

	
	/**
	 * 
	 * This method will update a specification in the Specification Master table.
	 * 
	 * @param specificationUpdateObject
	 * @param specification
	 */
	private void updateSpecificationMaster(SpecificationUpdateObject specificationUpdateObject,
			Specification specification) {

		if (Validator.isNotNull(specificationUpdateObject.getSpecificationLabel()))
			specification.setSpecificationLabel(HtmlUtil.escape(specificationUpdateObject.getSpecificationLabel()));

		specification.setSpecificationDescription(HtmlUtil.escape(specificationUpdateObject.getSpecificationDescription()));

		if (Validator.isNotNull(specificationUpdateObject.getSpecificationFieldType()))
			specification.setSpecificationFieldType(specificationUpdateObject.getSpecificationFieldType());

		if (Validator.isNotNull(specificationUpdateObject.getSpecificationFieldDataType()))
			specification.setSpecificationFieldDataType(specificationUpdateObject.getSpecificationFieldDataType());

		specificationLocalService.updateSpecification(specification);

	}

	/**
	 * 
	 * This method will update the mapping of categories with a specification in the
	 * Specification Category mapping table.
	 * 
	 * 1. If no categories are available in the request then it will delete all the specification categories mapping records for a particular specification.
	 * 2. If the same category is updated in the record then it will update the mapping table by adding modified date and modified by columns.
	 * 3. If new category is added then it will add a new mapping records in the database table.
	 * 4. It will also delete the other specification category mapping records which are previously recorded in the database table but not sent in the request body.
	 *
	 * @param specification
	 * @param specificationUpdateObject
	 * @throws PortalException
	 */
	private void updateSpecCategoryMapping(Specification specification,
			SpecificationUpdateObject specificationUpdateObject) throws PortalException {

		buycorp.specification.rest.api.dto.v1_0.@Valid Category[] categories = specificationUpdateObject.getCategories();

		// Fetch the list of categories mapped with specification
		List<SpecCategoryMap> specCategoryMappingList = getSpecCategoryMappingBySpecId(
				specification.getSpecificationId());

		// Deleting all categories mapping with a specification if categories are not
		// selected.
		if (Arrays.asList(categories).isEmpty()) {

			for (SpecCategoryMap specCategoryMap : specCategoryMappingList)
				deleteSpecCategoryMapById(specCategoryMap.getSpecCategoryMapId());

			return;
		}

		List<Long> specCategoryIdList = new ArrayList<>();

		for (buycorp.specification.rest.api.dto.v1_0.Category category : categories) {

			SpecCategoryMap specCategoryMap;
            specCategoryMap = specCategoryMappingList.stream()
                    .filter(element -> element.getCategoryId() == category.getCategoryId()).findFirst().get();

            if (Validator.isNotNull(specCategoryMap)) { // Updating specification category mapping in
														// SpecCategoryMapping database table.

				specCategoryIdList.add(specCategoryMap.getSpecCategoryMapId());
				specCategoryIdList.add(specCategoryMap.getCompanyId());

				specCategoryMap.setModifiedDate(new Date());
				specCategoryMap.setModifiedBy(0);
				specCategoryMap.setCategoryId(category.getCategoryId());
				specCategoryMap.setIsCategoryMandatory(category.getIscategorymandatory());

				specCategoryMapLocalService.updateSpecCategoryMap(specCategoryMap);

			} else { // Adding new specification category mapping in the SpecCategoryMapping database
						// table.

				long specCategoryMapId = counterLocalService.increment(SpecCategoryMap.class.getName());

				specCategoryIdList.add(specCategoryMapId);

				addSpecCategoryMapping(category, specificationUpdateObject.getSpecificationId(), specCategoryMapId);

			}

		}

		specCategoryMappingList.stream().forEach(element -> {

			if (!specCategoryIdList.contains(element.getSpecCategoryMapId())) {
				try {

					deleteSpecCategoryMapById(element.getSpecCategoryMapId());

				} catch (PortalException e) {
					_log.warn(
							"Unable to delete Specification catory mapping. Please enable debug logs for full details.");
					_log.debug(e, e);
				}
			}

		});

	}

	/**
	 * 
	 * This method will update the mapping of Specification Values with a specification in the SpecificationsValue mapping table.
	 * 
	 * 1. If no Specification Values are available in the request body then it will delete all the Specification Value mapping records for a particular specification.
	 * 2. If the same Specification Value is updated in the request body then it will update the mapping table by adding modified date and modified by columns.
	 * 3. If new Specification Value is added into the request body then it will add a new mapping records in the database table.
	 * 4. It will also delete the other Specification Value mapping records which are previously recorded in the database table but not sent in the request body.
	 *
	 * @param specification
	 * @param specificationUpdateObject
	 * @throws PortalException
	 */
	private void updateSpecValuesMapping(SpecificationUpdateObject specificationUpdateObject,
			Specification specification) throws PortalException {

		buycorp.specification.rest.api.dto.v1_0.SpecificationValue[] specificationValues = specificationUpdateObject
				.getSpecificationValues();

		List<SpecificationValue> specificationValueMappingList = getSpecificationValuesBySpecId(
				specification.getSpecificationId());

		// Deleting all Specification Values mapping with a specification if specification values are not selected.
		if (Arrays.asList(specificationValues).isEmpty()) {
			
			  for(SpecificationValue specValueObj : specificationValueMappingList)
				  deleteSpecValuesMapById(specValueObj.getSpecificationValueId());
			 
			return;
		}
		
		List<Long> specificationValueIdList = new ArrayList<>();
		
		for(buycorp.specification.rest.api.dto.v1_0.SpecificationValue specificationValuesObj : specificationValues) {
			
			SpecificationValue specificationValueMap;
            specificationValueMap = specificationValueMappingList.stream().filter(element -> element.getSpecificationValueId() == specificationValuesObj.getSpecificationValueId()).findFirst().get();

            if(Validator.isNotNull(specificationValueMap)) {
				
				specificationValueIdList.add(specificationValueMap.getSpecificationValueId());
				
				specificationValueMap.setModifiedDate(new Date());
				specificationValueMap.setModifiedBy(specificationUpdateObject.getModifiedBy());
				specificationValueMap.setSpecificationValueLabel(specificationValuesObj.getSpecificationValueLabel());
				specificationValueMap.setSpecificationUOM(specificationValuesObj.getSpecificationUOM());
				
				specificationValueLocalService.updateSpecificationValue(specificationValueMap);
				
			} else {
				
				long specificationValueMapId = counterLocalService.increment(SpecificationValue.class.getName());
				
				specificationValueIdList.add(specificationValueMapId);
				
				addSpecificationValuesMapping(specificationValuesObj, specificationUpdateObject.getSpecificationId(), specificationValueMapId);
				
			}
			
		}
		
		specificationValueMappingList.stream().forEach(element -> {
			
			if (!specificationValueIdList.contains(element.getSpecificationValueId())) {
				try {
					
					deleteSpecValuesMapById(element.getSpecificationValueId());
					
				} catch (PortalException e) {
					_log.warn("Unable to delete Specification Value mapping. Please enable debug logs for full details.");
					_log.debug(e, e);
				}
			}
			
		});

	}

	/**
	 * 
	 * Adding new specification category mapping in SpecCategoryMap database table.
	 *
	 * @param specCategoryMapId
	 */
	private void addSpecCategoryMapping(buycorp.specification.rest.api.dto.v1_0.Category category, long specificationId, long specCategoryMapId) {

		SpecCategoryMap specCategoryMapObj = specCategoryMapLocalService.createSpecCategoryMap(specCategoryMapId);

		specCategoryMapObj.setSpecificationId(specificationId);
		specCategoryMapObj.setCategoryId(category.getCategoryId());
		specCategoryMapObj.setIsCategoryMandatory(category.getIscategorymandatory());
		specCategoryMapObj.setCompanyId(0);
		specCategoryMapObj.setCreateDate(new Date());
		specCategoryMapObj.setModifiedDate(new Date());
		specCategoryMapObj.setCreatedBy(specCategoryMapObj.getModifiedBy());
		specCategoryMapObj.setModifiedBy(specCategoryMapObj.getModifiedBy());
		specCategoryMapObj.setIpAddress(StringPool.BLANK);

		specCategoryMapLocalService.updateSpecCategoryMap(specCategoryMapObj);

	}
	
	/**
	 * 
	 * @param specificationValuesObj
	 * @param specificationId
	 * @param specificationValuesMapId
	 */
	private void addSpecificationValuesMapping(buycorp.specification.rest.api.dto.v1_0.SpecificationValue specificationValuesObj, long specificationId, long specificationValuesMapId) {
		
		SpecificationValue specificationValuesMapObj = specificationValueLocalService.createSpecificationValue(specificationValuesMapId);
		
		specificationValuesMapObj.setSpecificationId(specificationId);
		specificationValuesMapObj.setSpecificationValueLabel(HtmlUtil.escape(specificationValuesObj.getSpecificationValueLabel()));
		specificationValuesMapObj.setSpecificationUOM(HtmlUtil.escape(specificationValuesObj.getSpecificationUOM()));
		specificationValuesMapObj.setGroupId(0);
		specificationValuesMapObj.setCompanyId(0);
		specificationValuesMapObj.setCreateDate(new Date());
		specificationValuesMapObj.setModifiedDate(new Date());
		specificationValuesMapObj.setCreatedBy(specificationValuesMapObj.getModifiedBy());
		specificationValuesMapObj.setModifiedBy(specificationValuesMapObj.getModifiedBy());
		specificationValuesMapObj.setIpAddress(StringPool.BLANK);
		specificationValuesMapObj.setUserId(specificationValuesMapObj.getUserId());
		specificationValuesMapObj.setUserName(StringPool.BLANK);
		
		specificationValueLocalService.updateSpecificationValue(specificationValuesMapObj);
		
	}

	/**
	 * 
	 * @param specificationId
	 * @return
	 */
	private buycorp.specification.rest.api.dto.v1_0.SpecificationValue[] getSpecificationValues(long specificationId) {

		List<SpecificationValue> specificationValues = getSpecificationValuesBySpecId(specificationId);

		List<buycorp.specification.rest.api.dto.v1_0.SpecificationValue> specificationValuesObj = new ArrayList<>();

		specificationValues.stream().forEach(element -> {

			buycorp.specification.rest.api.dto.v1_0.SpecificationValue specificationValue = new buycorp.specification.rest.api.dto.v1_0.SpecificationValue();
			
			specificationValue.setSpecificationValueId(element.getSpecificationValueId());
			specificationValue.setSpecificationValueLabel(element.getSpecificationValueLabel());
			specificationValue.setSpecificationUOM(element.getSpecificationUOM());

			specificationValuesObj.add(specificationValue);

		});

		_log.info("specification specificationValues --------->" + specificationValues);

		return specificationValuesObj
				.toArray(new buycorp.specification.rest.api.dto.v1_0.SpecificationValue[specificationValuesObj.size()]);

	}

	/**
	 * 
	 * @param specificationId
	 * @return
	 */
	private buycorp.specification.rest.api.dto.v1_0.Category[] getCategoriesBySpecification(long specificationId) {

		List<SpecCategoryMap> specCategoryMapList = getSpecCategoryMappingBySpecId(specificationId);

		List<buycorp.specification.rest.api.dto.v1_0.Category> categories = new ArrayList<>();

		specCategoryMapList.stream().forEach(element -> {
			try {
				Category categoryObj = getCategoryById(element.getCategoryId());

				buycorp.specification.rest.api.dto.v1_0.Category category = new buycorp.specification.rest.api.dto.v1_0.Category();

				category.setCategoryId(categoryObj.getCategoryId());
				category.setCategoryName(categoryObj.getCategoryName());
				categories.add(category);

			} catch (PortalException e) {
				e.printStackTrace();

			}
		});

		return categories.toArray(new buycorp.specification.rest.api.dto.v1_0.Category[categories.size()]);

	}

	private List<SpecCategoryMap> getSpecCategoryMappingBySpecId(long specificationId) {

		return specCategoryMapLocalService.findByFBYSpecificationId(specificationId);
	}

	private Category getCategoryById(long categoryId) throws PortalException {

		return categoryLocalService.getCategory(categoryId);
	}

	private List<SpecificationValue> getSpecificationValuesBySpecId(long specificationId) {

		return specificationValueLocalService.findByFBYSpecificationId(specificationId);
	}

	private Specification getSpecificationBySpecId(long specificationId) throws PortalException {

		return specificationLocalService.getSpecification(specificationId);
	}

	private SpecCategoryMap deleteSpecCategoryMapById(long specCategoryMapId) throws PortalException {

		return specCategoryMapLocalService.deleteSpecCategoryMap(specCategoryMapId);
	}
	
	private SpecificationValue deleteSpecValuesMapById(long specValueMapId) throws PortalException {
		
		return specificationValueLocalService.deleteSpecificationValue(specValueMapId);
	}

	@Reference
	private SpecCategoryMapLocalService specCategoryMapLocalService;

	@Reference
	private CategoryLocalService categoryLocalService;

	@Reference
	private SpecificationValueLocalService specificationValueLocalService;

	@Reference
	private SpecificationLocalService specificationLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _log = LogFactoryUtil.getLog(SpecificationRestApiHelper.class);
	
}
