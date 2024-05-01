package com.marketplace.product.view.constants;

/**
 * @author ashishinani
 */
public class ProductViewPortletKeys {
	
	// Loggers
    public static final String LOGGER_INFO_PREFIX = "::: ";
    public static final String LOGGER_INFO_SUFFIX = " :::";
    
    // status
    public static final String APPROVED = "Approved";
    
    // Jsp's
    public static final String BRAND_CATEGORY_SELECTION = "/brand_category_selection.jsp";
    public static final String BASIC_INFO_JSP = "/basic_information.jsp";
    public static final String VARIANT_CREATION_JSP = "/variant_creation.jsp";
    public static final String SKU_CREATION_JSP = "/sku_creation.jsp";
    public static final String VIEW_JSP = "/view.jsp";
    
    // Command Name
    public static final String MVC_RENDER_COMMAND_NAME = "mvcRenderCommandName";
    
    // Render's
    public static final String BRAND_CATEGORY_SELECT_RENDER_CMD = "/brand/category/select/render";
    public static final String BASIC_INFO_RENDER_CMD = "/basic/information/render";
    public static final String SELECT_SPECIFICATIONS_RENDER_CMD = "/select/specifications/render";
    public static final String PRODUCT_SUMMARY_RENDER_CMD = "/product/summary/render";
    public static final String ADDITIONAL_INFORMATION_RENDER_CMD = "/additional/information/render";
    public static final String VARIANT_CREATION_RENDER = "variantCreationRenderer";
    public static final String SKU_CREATION_RENDER = "skuCreationRender";
    public static final String SELECT_SKU_RENDER_CMD = "/select/sku/render";
    public static final String PIM_PRODUCT_LISTING_RENDER_CMD = "/pim/product/listing/render";
    public static final String EDIT_PRODUCT_STEP_ACTION_CMD = "/edit/product/step/action";
    
    // attributes
    public static final String PRODUCT = "product";
    public static final String BRAND_ID = "brandId";
    public static final String CATEGORY_ID = "categoryId";
    public static final String BRANDS = "brands";
    public static final String PRODUCT_TYPES = "productTypes";
    public static final String CATEGORY_NAME = "categoryName";
    public static final String CREATE_FLAG = "createFlag";
    public static final String UTF_8 = "UTF-8";
    public static final String IP_ADDRESS = "ipAddress";
    public static final String GROUP_ID = "groupId";
    public static final String COMPANY_ID = "companyId";
    public static final String USER_ID = "userId";
    public static final String USER_NAME = "userName";
    public static final String MODIFIED_DATE = "modifiedDate";
    
    // Jsp Parameters
    public static final String DRAFT_PRODUCT_ID = "draftProductId";
    public static final String BRAND = "brand";
    public static final String CATEGORY = "category";
    public static final String PRODUCT_NAME = "productName";
    public static final String PRODUCT_TYPE = "productType";

	public static final String PRODUCTVIEW = "com_marketplace_product_view_ProductViewPortlet";

	// Action Commands
	public static final String BASIC_INFORMATION_ACTION_CMD = "/basic/information/action";
	public static final String SELECT_SPECIFICATION_ACTION_CMD = "/select/specification/action";
	public static final String ADDITIONAL_INFORMATION_ACTION_CMD = "/additional/information/action";
	public static final String SELECT_SKU_ACTION_CMD = "/select/sku/action";

	public static final String SKU_MEDIA_ACTION_CMD = "/sku/media/action";

	public static final String SAVE_SKU_DETAILS_RESOURCE_CMD = "/save/sku/details/resource";
	public static final String GET_SPEC_VALUES_BY_SPEC_ID_RESOURCE_CMD = "/get/spec/values/by/spec/id/resource";
	public static final String SKU_MEDIA_RESOURCE_CMD = "/sku/media/resource";
	public static final String SKU_MEDIA_REMOVE_RESOURCE_CMD = "/sku/media/remove/resource";
	
	public static final String SKU_DELETE_RESOURCE_CMD = "/sku/delete/resource";
	
	public static final String SAVE_VARIANT_VALUE_RESOURCE_CMD = "/save/variant/value/resource";
	
	public enum BasicInformationConstants {

		SHORT_DESCRIPTION("shortDescription"), 
		LONG_DESCRIPTION("longDescription"), 
		MODEL_NUMBER("modelNumber");

		BasicInformationConstants(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		private String value;

	}

	public enum SpecificationSelectionConstants {

		SPECIFICATION_ID("specificationId"),
		SPECIFICATIONS("specifications"),
		SPECIFICATION_LABEL("specificationLabel"),
		SPECIFICATION_FIELD_TYPE("specificationFieldType"),
		SPECIFICATION_FIELD_TYPE_ID("specificationFieldTypeId"),
		SPECIFICATION_FIELD_DATA_TYPE_ID("specificationFieldDataTypeId"),
		SPECIFICATION_FIELD_TYPE_NAME("specFieldTypeName"),
		SPECIFICATION_FIELD_DATA_TYPE_NAME("specFieldDataTypeName"),
		SPECIFICATION_VALUE_LABEL_ID("specificationValueLabelId"),
		SPECIFICATION_VALUE_LABEL("specificationValueLabel"),
		SPECIFICATION_VALUE_ID("specificationValueId"),
		SPECIFICATION_VALUE_UOM("specificationValueUOM"),
		SPECIFICATION_VALUES("specificationValues"),
		APPROVED_SPECIFICATIONS("approvedSpecifications"),
		MANDATORY_SPEC_CATEGORIES("mandatorySpecCategories"),
		NON_MANDATORY_SPEC_CATEGORIES("nonMandatorySpecCategories"),
		PRODUCT_SPECIFICATIONS("productSpecifications"),
		PRODUCT_SPECIFICATION_ID("productSpecificationId"),
		PRODUCT_SPEC_VALUE_ID("productSpecValueId"),
		SPECIFICATIONS_JSON("specificationsJSON"),
		ADDITIONAL_INFO_JSON("additionalInfoJson"),
		SEARCH_KEYWORDS("searchKeywords"),
		PACKAGE_CONTENTS("packageContents"),
		ITEM_NAME("itemName"),
		ITEM_QTY("itemQty"),
		SPECIFICATION_SELECTION_JSP("/specification_selection.jsp");

		SpecificationSelectionConstants(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		private String value;

	}
	
	public enum AdditionalConfigurationConstants {
		
		ADDITIONAL_INFORMATION_JSP("/additional_information.jsp");
		
		AdditionalConfigurationConstants(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		private String value;
		
	}
	
	public enum ProductSummaryConstants {
		
		PRODUCT_SUMMARY_JSP("/product_summary.jsp");
		
		ProductSummaryConstants(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		private String value;
		
	}
	
	public enum SKUMediaConstants {
		
		SKU_ID("skuId"),
		PRODUCTS("Products"),
		SKU_FOLDER_ID("skuFolderId"),
		DOCUMENTS("documents"),
		IMAGE("image"),
		IMAGES("Images"),
		DOCUMENTS_CAPITAL("Documents"),
		DOCUMENT_ID("documentId"),
		DOCUMENT_URL("documentURL");
		
		SKUMediaConstants(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return this.value;
		}
		
		private String value;
		
	}

}