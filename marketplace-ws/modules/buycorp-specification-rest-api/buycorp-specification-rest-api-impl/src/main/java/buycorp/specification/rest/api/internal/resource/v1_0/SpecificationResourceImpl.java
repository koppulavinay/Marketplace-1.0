package buycorp.specification.rest.api.internal.resource.v1_0;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.marketplace.specification.master.service.SpecificationLocalService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import buycorp.specification.rest.api.constants.SpecificationApiKeys;
import buycorp.specification.rest.api.dto.v1_0.Category;
import buycorp.specification.rest.api.dto.v1_0.SpecificationCreateObject;
import buycorp.specification.rest.api.dto.v1_0.SpecificationObject;
import buycorp.specification.rest.api.dto.v1_0.SpecificationUpdateObject;
import buycorp.specification.rest.api.dto.v1_0.SpecificationValue;
import buycorp.specification.rest.api.helper.SpecificationRestApiHelper;
import buycorp.specification.rest.api.resource.v1_0.SpecificationResource;

/**
 * @author kashyap.mishra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/specification.properties",
	scope = ServiceScope.PROTOTYPE, service = SpecificationResource.class
)
public class SpecificationResourceImpl extends BaseSpecificationResourceImpl {
	
	@Reference
	   private SpecificationRestApiHelper specificationRestApiHelper;
	   @Reference
	   private SpecificationLocalService specificationLocalService;
	   private static final Log _log = LogFactoryUtil.getLog(SpecificationResourceImpl.class.getName());

	   @Override
	   public String getSpecificationById(Long specificationId) throws Exception {
	      try {
	         SpecificationObject specificationObject = specificationRestApiHelper.getSpecificationById(specificationId);
	         if (specificationObject.getSpecificationLabel() != null) {
	            _log.info("Specification by id---------->" + specificationObject);
	            specificationObject.setStatus("SUCCESS");
	            return specificationObject.toString();
	         } else {
	            return "{ \"message\": \"Specification not found for the given specificationId.\" , \"error_code\": 7016,\"status\": \"FAIL\"}";
	         }
	      } catch (Exception var3) {
	         var3.printStackTrace();
	         return "{ \"message\": \"An error occurred while fetching the Specification.\" , \"error_code\": 7017,\"status\": \"FAIL\"}";
	      }
	   }

	   @Override
	   public String getAllSpecification(Pagination pagination) {
	      try {
	         List<SpecificationObject> specificationObjects = specificationRestApiHelper.getAllSpecifications();

	         return specificationObjects.toString();
	      } catch (Exception e) {
	         e.printStackTrace();
	         return "{ \"message\": \"An error occurred while fetching Specification.\" , \"error_code\": 7018,\"status\": \"FAIL\"}";
	      }
	   }

	   @Override
	   public Response updateSpecification(SpecificationUpdateObject specificationUpdateObject) {
	      ResponseBuilder responseBuilder = null;
		   Pattern pattern =Pattern.compile(SpecificationApiKeys.PATTERN);
		   @Valid Category[] categoryValues = specificationUpdateObject.getCategories();
		   for(Category categoryValue:categoryValues) {
			   String categoryName = categoryValue.getCategoryName();
			   Matcher categoryNameMatcher = pattern.matcher(categoryName);
			   if (categoryNameMatcher.find()) {
				   responseBuilder = Response.status(404).entity(SpecificationApiKeys.JS_STRING);
			   } else {
				   String specificationLabel = specificationUpdateObject.getSpecificationLabel();
				   String specificationDescription = specificationUpdateObject.getSpecificationDescription();
				   Matcher specificationLabelmatcher = pattern.matcher(specificationLabel);
				   Matcher specificationDescmatcher = pattern.matcher(specificationDescription);

				   if (specificationLabelmatcher.find() || specificationDescmatcher.find()) {
					   responseBuilder = Response.status(404).entity(SpecificationApiKeys.JS_STRING);
				   } else {

					   responseBuilder = validateSpecificationUpdateRequest(specificationUpdateObject,pattern);
				   }
			   }
		   }
			   return responseBuilder.build();
		   }

		@Override
	   public Response createSpecification(SpecificationCreateObject specificationCreateObject) {
	      ResponseBuilder responseBuilder = null;

			Pattern pattern =Pattern.compile(SpecificationApiKeys.PATTERN);
			@Valid Category[] categoryValues = specificationCreateObject.getCategories();
			for(Category categoryValue:categoryValues){
				String categoryName = categoryValue.getCategoryName();
				Matcher categoryNameMatcher = pattern.matcher(categoryName);
				if(categoryNameMatcher.find()){
					responseBuilder = Response.status(404).entity(SpecificationApiKeys.JS_STRING);
				}else {

					String specificationLabel = specificationCreateObject.getSpecificationLabel();
					String specificationDescription = specificationCreateObject.getSpecificationDescription();
					Matcher specificationLabelmatcher = pattern.matcher(specificationLabel);
					Matcher specificationDescmatcher = pattern.matcher(specificationDescription);

					if(specificationLabelmatcher.find() || specificationDescmatcher.find()){
						responseBuilder = Response.status(404).entity(SpecificationApiKeys.JS_STRING);
					} else{

						responseBuilder = validateSpecificationCreateRequest(specificationCreateObject,pattern);
					}
				}

			}
			return responseBuilder.build();
       }

	   private ResponseBuilder validateSpecificationCreateRequest(SpecificationCreateObject specificationCreateObject, Pattern pattern){

		   ResponseBuilder responseBuilder = null;
		   buycorp.specification.rest.api.dto.v1_0.@Valid SpecificationValue[] specificationValues = specificationCreateObject.getSpecificationValues();
		   for(SpecificationValue specValue:specificationValues){
			   String specificationUOM = specValue.getSpecificationUOM();
			   String specificationValueLabel = specValue.getSpecificationValueLabel();
			   Matcher specificationUOMmatcher = pattern.matcher(specificationUOM);
			   Matcher specificationvalueLabelmatcher = pattern.matcher(specificationValueLabel);
			   if(specificationUOMmatcher.find() || specificationvalueLabelmatcher.find()){
				   Response.status(404).entity(SpecificationApiKeys.JS_STRING);
			   }else {

				   if (Validator.isNotNull(specificationCreateObject.getSpecificationLabel()) && Validator.isNotNull(specificationCreateObject.getSpecificationFieldDataType()) && Validator.isNotNull(specificationCreateObject.getSpecificationFieldType())) {
					   specificationRestApiHelper.createSpecification(specificationCreateObject);
					   responseBuilder = Response.ok().status(200).entity(SpecificationApiKeys.CREATE_RESPONSE);
				   }else {
					   responseBuilder = Response.status(400).entity(SpecificationApiKeys.CREATE_FAILURE);
				   }
				   return responseBuilder;
			   }

		   }
		   return null;
	   }

	   private ResponseBuilder validateSpecificationUpdateRequest(SpecificationUpdateObject specificationUpdateObject,Pattern pattern){

		   ResponseBuilder responseBuilder = null;
		   buycorp.specification.rest.api.dto.v1_0.@Valid SpecificationValue[] specificationValues = specificationUpdateObject.getSpecificationValues();
		   for (SpecificationValue specValue : specificationValues) {
			   String specificationUOM = specValue.getSpecificationUOM();
			   String specificationValueLabel = specValue.getSpecificationValueLabel();
			   Matcher specificationUOMmatcher = pattern.matcher(specificationUOM);
			   Matcher specificationvalueLabelmatcher = pattern.matcher(specificationValueLabel);
			   if (specificationUOMmatcher.find() || specificationvalueLabelmatcher.find()) {
				   Response.status(404).entity(SpecificationApiKeys.JS_STRING);
			   } else {
				   if (Validator.isNotNull(specificationUpdateObject.getSpecificationLabel()) && Validator.isNotNull(specificationUpdateObject.getSpecificationFieldDataType()) && Validator.isNotNull(specificationUpdateObject.getSpecificationFieldType())) {
					   specificationRestApiHelper.updateSpecification(specificationUpdateObject);
					   responseBuilder = Response.ok().status(200).entity(SpecificationApiKeys.UPDATE_RESPONSE);
				   } else {
					   responseBuilder = Response.status(400).entity(SpecificationApiKeys.UPDATE_FAILURE);
				   }
				   return responseBuilder;
			   }
		   }
           return null;
       }
}