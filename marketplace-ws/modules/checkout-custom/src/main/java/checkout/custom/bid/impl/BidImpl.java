package checkout.custom.bid.impl;

import checkout.custom.bid.api.BidApi;
import checkout.custom.bid.helper.BidApiHelper;
import checkout.custom.constants.CheckoutCustomPortletKeys;
import checkout.custom.model.BIDResponse;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import java.text.ParseException;

@Component(service = BidApi.class, immediate = true)
public class BidImpl implements BidApi {

    @Override
    public BIDResponse getBidRequest(ActionRequest actionRequest, String accessToken, String arxUserId) throws Exception {

        LOGGER.info(CheckoutCustomPortletKeys.LOGGER_INFO_PREFIX + "Inside getBidRequest Method" + CheckoutCustomPortletKeys.LOGGER_INFO_SUFFIX);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        return bidApiHelper.getBidApiResponse(actionRequest, themeDisplay, arxUserId, accessToken);

    }

    @Reference
    private BidApiHelper bidApiHelper;

    private static final Log LOGGER = LogFactoryUtil.getLog(BidImpl.class);

}
