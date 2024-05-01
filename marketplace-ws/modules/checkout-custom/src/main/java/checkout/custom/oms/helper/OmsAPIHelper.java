package checkout.custom.oms.helper;

import checkout.custom.cart.helper.CartDetailsHelper;
import checkout.custom.constants.CheckoutCustomPortletKeys;
import checkout.custom.handler.CommonOperationHandler;
import checkout.custom.model.CartDetails;
import checkout.custom.model.CartV2;
import checkout.custom.model.OMSCreateDraftOrderRequest;
import checkout.custom.model.OMSCreateDraftOrderResponse;
import com.google.gson.Gson;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.checkout.master.model.CheckoutCustom;
import com.marketplace.checkout.master.service.CheckoutCustomLocalServiceUtil;
import com.marketplace.ws.api.WebServiceApi;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author anubhav.kalra
 */
@Component(service = OmsAPIHelper.class, immediate = true)
public class OmsAPIHelper {

    public OMSCreateDraftOrderResponse getOMSDraftOrderAPIResponse(ActionRequest actionRequest, ThemeDisplay themeDisplay, String arxUserId, String accessToken) throws Exception {

        LOGGER.info("---------- Creating Cart Details -------------");
        CartDetails cartDetails = new CartDetails();

        CommerceContext commerceContext = (CommerceContext) actionRequest
                .getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);
        CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

        // Generating Cart Details
        cartDetailsHelper.setCartDetails(cartDetails, commerceOrder, commerceContext, actionRequest, themeDisplay, arxUserId);

        //Final Request of API
        CartV2 cartV2 = new CartV2();
        cartV2.setCartDetails(cartDetails);

        OMSCreateDraftOrderRequest omsCreateDraftOrderRequest = new OMSCreateDraftOrderRequest();
        omsCreateDraftOrderRequest.setToken("");
        omsCreateDraftOrderRequest.setPayload(cartV2);

        LOGGER.info("Final Cart JSON V2 ------------> " + new Gson().toJson(cartV2));

        OMSCreateDraftOrderResponse omsCreateDraftOrderResponse = invokeOMSDraftOrderAPI(cartV2, accessToken);

        if (Validator.isNull(omsCreateDraftOrderResponse))
            throw new Exception();

        LOGGER.info("OMS Draft Order API Response ------------> " + new Gson().toJson(omsCreateDraftOrderResponse));

        // Persisting Request and Response body sent to the OMS Draft Order API
        commonOperationHandler.persistDataSentToAPI(commerceOrder, omsCreateDraftOrderRequest, omsCreateDraftOrderResponse, "OMS");

        return omsCreateDraftOrderResponse;

    }

    private OMSCreateDraftOrderResponse invokeOMSDraftOrderAPI(CartV2 omsRequest, String accessToken) {

        //String responseBody = commonOperationHandler.invokeWebService(CheckoutCustomPortletKeys.OMS_CREATE_DRAFT_ORDER_API, omsRequest, accessToken);

        String responseBody = null;

        try {
            responseBody = webServiceApi.getOMSAPIResponse(accessToken, CheckoutCustomPortletKeys.OMS_CREATE_DRAFT_ORDER_API, new Gson().toJson(omsRequest, omsRequest.getClass()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        OMSCreateDraftOrderResponse omsResponse = new Gson().fromJson(responseBody, OMSCreateDraftOrderResponse.class);

        return omsResponse;
    }

    @Reference
    private CartDetailsHelper cartDetailsHelper;

    @Reference
    private CommonOperationHandler commonOperationHandler;

    @Reference
    private WebServiceApi webServiceApi;

    private static final Log LOGGER = LogFactoryUtil.getLog(OmsAPIHelper.class);

}
