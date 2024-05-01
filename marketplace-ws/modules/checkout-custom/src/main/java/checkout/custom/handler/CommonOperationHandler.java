package checkout.custom.handler;

import checkout.custom.constants.CheckoutCustomPortletKeys;
import com.google.gson.Gson;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.marketplace.checkout.master.model.CheckoutCustom;
import com.marketplace.checkout.master.service.CheckoutCustomLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author anubhav.kalra
 */
@Component(service = CommonOperationHandler.class, immediate = true)
public class CommonOperationHandler {

    public String invokeWebService(String requestURL, Object requestBeans, String accessToken) {

        String requestBody = new Gson().toJson(requestBeans, requestBeans.getClass());

        String outputJson = "";

        try {

            URL getUrl = new URL(requestURL);

            LOGGER.info("Connection URL from service --------> " + getUrl);

            HttpURLConnection conn = (HttpURLConnection) getUrl.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod(CheckoutCustomPortletKeys.POST);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty(CheckoutCustomPortletKeys.AUTHORIZATION, CheckoutCustomPortletKeys.BEARER + " " + accessToken);

            LOGGER.info("Final Cart JSON V2 --------------> " + requestBody);

            OutputStream os = conn.getOutputStream();
            os.write(new Gson().toJson(requestBody).getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                outputJson = outputJson + output;
            }

            LOGGER.debug("Output JSON -------------> " + outputJson);
            conn.disconnect();

            return outputJson;

        } catch (Exception e) {
            LOGGER.error("Exception while fetching response from API : " + e.getMessage());
        }

        return null;

    }

    public void persistDataSentToAPI(CommerceOrder commerceOrder, Object requestBody, Object responseBody, String moduleName) {

        CheckoutCustom checkoutCustom = checkoutCustomLocalService.createCheckoutCustom(counterLocalService.increment());

        checkoutCustom.setCommerceOrderId(commerceOrder.getCommerceOrderId());
        checkoutCustom.setRequestJson(new Gson().toJson(requestBody, requestBody.getClass()));
        checkoutCustom.setResponseJson(new Gson().toJson(responseBody, responseBody.getClass()));
        checkoutCustom.setModule(moduleName);
        checkoutCustom.setCreateDate(new Date());

        checkoutCustomLocalService.updateCheckoutCustom(checkoutCustom);

    }

    @Reference
    private CheckoutCustomLocalService checkoutCustomLocalService;

    @Reference
    private CounterLocalService counterLocalService;

    private static final Log LOGGER = LogFactoryUtil.getLog(CommonOperationHandler.class);

}
