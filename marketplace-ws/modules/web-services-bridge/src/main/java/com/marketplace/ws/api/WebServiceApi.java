package com.marketplace.ws.api;

import com.marketplace.ws.response.consignee.details.ConsigneeDetailsBeans;
import com.marketplace.ws.response.user.org.details.UserOrgDetailsBean;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public interface WebServiceApi {
   UserOrgDetailsBean getUserOrganisationDetails(HttpServletRequest httpServletRequest, String userId) throws IOException;

   ConsigneeDetailsBeans getOrganizationUsers(String organizationId, String organizationRoles, HttpServletRequest httpServletRequest) throws IOException;

   String getOMSAPIResponse(String accessToken, String requestURL, String requestBody) throws IOException;

   String getBidAPIResponse(String accessToken, String requestURL, String requestBody) throws IOException;

}
