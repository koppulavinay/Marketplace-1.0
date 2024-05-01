package checkout.custom.bid.api;

import checkout.custom.model.BIDResponse;
import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.ActionRequest;
import java.text.ParseException;

public interface BidApi {

    BIDResponse getBidRequest(ActionRequest actionRequest, String accessToken, String arxUserId) throws Exception;

}
