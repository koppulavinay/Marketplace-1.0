package checkout.custom.oms.api;

import checkout.custom.model.OMSCreateDraftOrderResponse;
import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.ActionRequest;

public interface OmsAPI {

    OMSCreateDraftOrderResponse getOmsCreateDraftOrder(ActionRequest actionRequest, String accessToken, String arxUserId) throws Exception;

}
