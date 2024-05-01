package checkout.custom.constants;

/**
 * @author avan
 */
public class CheckoutCustomPortletKeys {

	public static final String CHECKOUTCUSTOM =
		"checkoutCustom_CheckoutCustomPortlet";
	
	public static final String AUTHORIZATION = "Authorization";
	//Endpont:- http://172.16.176.33/order-service/Api/v2/orderservice/create-draft-order
	//public static final String OMS_CREATE_DRAFT_ORDER_API = "http://172.16.196.41/order-service/Api/v1/orderservice/create-draft-order";
	public static final String OMS_CREATE_DRAFT_ORDER_API = "http://172.16.176.33/order-service/Api/v2/orderservice/create-draft-order";
	//public static final String BID_API_URL = "http://172.16.196.41/bidpublish-service/cartdata/v1/push";
	public static final String BID_API_URL = "http://172.16.176.33/bidpublish-service/v2/cart/save";
	//public static final String OMS_CREATE_DRAFT_ORDER_API = "https://buycorpapi.intellectproduct.com/order-service/Api/v1/orderservice/create-draft-order";
	//public static final String BID_API_URL = "http://buycorpapi.intellectproduct.com/bidpublish-service/cartdata/v1/push";
	public static final String GST_NO = "07AALCP3918X1Z4";
	public static final String REGISTERED = "Registered";
	public static final String LOGGER_INFO_PREFIX = "::: ";
	public static final String LOGGER_INFO_SUFFIX = " :::";
	public static final String POST = "POST";
	public static final String BEARER = "Bearer";
	public static final String ACCESS_TOKEN = "accessToken";
	public static final String SUCCESS = "Success";

}