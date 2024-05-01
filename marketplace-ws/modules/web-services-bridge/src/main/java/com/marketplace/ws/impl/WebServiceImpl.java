package com.marketplace.ws.impl;

import com.buycorp.common.util.ObjectMapperUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.marketplace.ws.api.WebServiceApi;
import com.marketplace.ws.helper.WebServiceHelper;
import com.marketplace.ws.invokers.WebServices;
import com.marketplace.ws.response.consignee.details.ConsigneeDetailsBeans;
import com.marketplace.ws.response.user.org.details.UserOrgDetailsBean;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;

@Component(
   immediate = true,
   service = {WebServiceApi.class}
)
public class WebServiceImpl implements WebServiceApi {
   public UserOrgDetailsBean getUserOrganisationDetails(HttpServletRequest httpServletRequest, String userId) throws IOException {
      String response = this.getWebServicesInstance().getUserOrgAssociationResponse(httpServletRequest, userId);
      LOGGER.info("User Org Association API Response ---------------> " + response);
      return (UserOrgDetailsBean)ObjectMapperUtil.parseToBean(response, UserOrgDetailsBean.class);
   }

   public ConsigneeDetailsBeans getOrganizationUsers(String organizationId, String organizationRoles, HttpServletRequest httpServletRequest) throws IOException {
      String responseBody = this.getOrganizationUsersResponse(organizationId, organizationRoles, httpServletRequest);
      LOGGER.info("Organization Users API Response ---------------> " + responseBody);
      return (ConsigneeDetailsBeans)ObjectMapperUtil.parseToBean(responseBody, ConsigneeDetailsBeans.class);
   }

   public String getOrganizationUsersResponse(String organizationId, String organizationRoles, HttpServletRequest httpServletRequest) throws IOException {
      String requestBody = this.getWebServiceHelperInstance().constructOrgUsersApiRequest(organizationId, organizationRoles);
      LOGGER.info("Organization Users API Request ---------------> " + requestBody);
      String responseBody = this.getWebServicesInstance().getOrgUsersResponse(requestBody, httpServletRequest);
      LOGGER.info("Organization Users API Response ---------------> " + responseBody);
      return responseBody;
   }

   public String getOMSAPIResponse(String accessToken, String requestURL, String requestBody) throws IOException {
      return this.getWebServicesInstance().getOMSAPIResponse(accessToken, requestURL, requestBody);
   }

   public String getBidAPIResponse(String accessToken, String requestURL, String requestBody) throws IOException {
      return this.getWebServicesInstance().getOMSAPIResponse(accessToken, requestURL, requestBody);
   }

   private WebServices getWebServicesInstance() {
      return new WebServices();
   }

   private WebServiceHelper getWebServiceHelperInstance() {
      return new WebServiceHelper();
   }

   private static final Log LOGGER = LogFactoryUtil.getLog(WebServiceImpl.class);
}
