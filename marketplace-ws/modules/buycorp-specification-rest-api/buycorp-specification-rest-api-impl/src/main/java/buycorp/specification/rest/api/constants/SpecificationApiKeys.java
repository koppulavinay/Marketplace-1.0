package buycorp.specification.rest.api.constants;

public class SpecificationApiKeys {

	public static final String PATTERN = "(.*<[^>]+>.*)";
    public static final String JS_STRING = "{ \"message\": \"String contains JS code\" , \"error_code\": 7019,\"status\": \"FAIL\"}";
    public static final String CREATE_RESPONSE = "{ \"message\": \"Specification is created successfully\" ,\"status\": \"SUCCESS\"}";
    public static final String UPDATE_RESPONSE = "{ \"message\": \"Specification is updated successfully\" , \"status\": \"SUCCESS\"}";
    public static final String CREATE_FAILURE = "{ \"message\": \"Unable to create Specification\" , \"error_code\": 7020,\"status\": \"FAIL\"}";
    public static final String UPDATE_FAILURE = "{ \"message\": \"Unable to update Specification\" , \"error_code\": 7021,\"status\": \"FAIL\"}";

}
