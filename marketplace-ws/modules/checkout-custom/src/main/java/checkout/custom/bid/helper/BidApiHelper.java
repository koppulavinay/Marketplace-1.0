package checkout.custom.bid.helper;

import checkout.custom.cart.helper.CartDetailsHelper;
import checkout.custom.constants.CheckoutCustomPortletKeys;
import checkout.custom.handler.CommonOperationHandler;
import checkout.custom.model.BIDRequest;
import checkout.custom.model.BIDResponse;
import checkout.custom.model.CartDetails;
import checkout.custom.model.CartV2;
import com.google.gson.Gson;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.ws.api.WebServiceApi;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import java.io.IOException;

/**
 *
 * @author anubhav.kalra
 *
 */
@Component(service = BidApiHelper.class, immediate = true)
public class BidApiHelper {

    public BIDResponse getBidApiResponse(PortletRequest portletRequest, ThemeDisplay themeDisplay, String arxUserId, String accessToken) throws Exception {

        LOGGER.info("--------------- Creating Cart Details for Send to Bid --------------");
        CartDetails cartDetails = new CartDetails();

        CommerceContext commerceContext = (CommerceContext) portletRequest
                .getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);
        CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

        // Generating Cart Details
        cartDetailsHelper.setCartDetails(cartDetails, commerceOrder, commerceContext, portletRequest, themeDisplay, arxUserId);

        CartV2 cartV2 = new CartV2();
        cartV2.setCartDetails(cartDetails);

        //Final Request of API
        BIDRequest bidRequest = new BIDRequest();
        bidRequest.setToken("");
        bidRequest.setPayload(cartV2);

        LOGGER.info("Final Cart JSON for Send to BID -----------> " + new Gson().toJson(bidRequest));

        BIDResponse bidResponse = invokeBidAPI(cartV2, accessToken);

        if(Validator.isNull(bidResponse))
            throw new Exception();

        LOGGER.info("Bid API Response -------------> " + new Gson().toJson(bidResponse));

        // Persisting Request and Response body sent to the Bid API
        commonOperationHandler.persistDataSentToAPI(commerceOrder, bidRequest, bidResponse, "BID");

        return bidResponse;

    }

    private BIDResponse invokeBidAPI(CartV2 bidRequest, String accessToken) {
        /*String responseBody = commonOperationHandler.invokeWebService(CheckoutCustomPortletKeys.BID_API_URL, bidRequest, accessToken);*/

        String responseBody = null;

        try {
            responseBody = webServiceApi.getOMSAPIResponse(accessToken, CheckoutCustomPortletKeys.BID_API_URL, new Gson().toJson(bidRequest, bidRequest.getClass()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(responseBody, BIDResponse.class);
    }

    @Reference
    private CartDetailsHelper cartDetailsHelper;

    @Reference
    private CommonOperationHandler commonOperationHandler;

    @Reference
    private WebServiceApi webServiceApi;

    private static final Log LOGGER = LogFactoryUtil.getLog(BidApiHelper.class);
    
}
