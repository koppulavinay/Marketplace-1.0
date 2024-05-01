package checkout.custom.oms.impl;

import checkout.custom.model.OMSCreateDraftOrderResponse;
import checkout.custom.oms.api.OmsAPI;
import checkout.custom.oms.helper.OmsAPIHelper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;

@Component(service = OmsAPI.class, immediate = true)
public class OmsImpl implements OmsAPI {

    @Override
    public OMSCreateDraftOrderResponse getOmsCreateDraftOrder(ActionRequest actionRequest, String accessToken, String arxUserId) throws Exception {

        LOGGER.info("---------- Inside OMS Create Draft Order -----------");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        return omsAPIHelper.getOMSDraftOrderAPIResponse(actionRequest, themeDisplay, arxUserId, accessToken);
    }

    @Reference
    private OmsAPIHelper omsAPIHelper;

    private static final Log LOGGER = LogFactoryUtil.getLog(OmsImpl.class);

}
