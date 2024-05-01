package com.marketplace.ws.invokers;

import com.marketplace.ws.helper.WebServiceHelper;
import com.marketplace.ws.model.RequestHeader;
import com.marketplace.ws.model.RequestMethod;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.osgi.service.component.annotations.Component;

@Component(
   immediate = true,
   service = {WebServices.class}
)
public class WebServices {
   public String getStubsApiResponse(String requestBody) throws IOException {
      String requestURL = "http://172.16.171.72:8232/olive/publisher/getStubs";
      RequestHeader requestHeader = this.getWebServiceHelperInstance().initializeHeaders(RequestMethod.POST, "application/json");
      requestHeader = this.addHeaderProperties(requestHeader);
      String response = this.getWebServiceHelperInstance().invokePost(requestURL, requestHeader, requestBody, "application/json", (String)null);
      return response;
   }

   public String getOrgUsersResponse(String requestBody, HttpServletRequest httpServletRequest) throws IOException {
     // String requestURL = "http://172.16.171.72:8232/olive/publisher/ums/v1/org-users";
      String requestURL = "http://172.16.176.33/turmeric/publisher/ums/v1/org-users";
      RequestHeader requestHeader = this.getWebServiceHelperInstance().initializeHeaders(RequestMethod.POST, "application/json");
      requestHeader = this.addHeaderProperties(requestHeader);
      HttpSession httpSession = httpServletRequest.getSession();
      String accessToken = (String)httpSession.getAttribute("accessToken");
      String response = this.getWebServiceHelperInstance().invokePost(requestURL, requestHeader, requestBody, "application/json", accessToken);
      return response;
   }

   public String getUserOrgAssociationResponse(HttpServletRequest httpServletRequest, String userId) throws IOException {
      HttpSession httpSession = httpServletRequest.getSession();
      String accessToken = (String)httpSession.getAttribute("accessToken");
      String requestURL = "http://172.16.176.33/turmeric/publisher/ums/v1/user-org-association/" + userId;
      return this.getWebServiceHelperInstance().invokeGet(requestURL, accessToken);
   }

   public String getOMSAPIResponse(String accessToken, String requestURL, String requestBody) throws IOException {
      RequestHeader requestHeader = this.getWebServiceHelperInstance().initializeHeaders(RequestMethod.POST, "application/json");
      requestHeader = this.addHeaderProperties(requestHeader);
      return this.getWebServiceHelperInstance().invokePost(requestURL, requestHeader, requestBody, "application/json", accessToken);
   }

   public String getBidAPIResponse(String accessToken, String requestURL, String requestBody) throws IOException {
      RequestHeader requestHeader = this.getWebServiceHelperInstance().initializeHeaders(RequestMethod.POST, "application/json");
      requestHeader = this.addHeaderProperties(requestHeader);
      return this.getWebServiceHelperInstance().invokePost(requestURL, requestHeader, requestBody, "application/json", accessToken);
   }



   private RequestHeader addHeaderProperties(RequestHeader requestHeader) {
      requestHeader.addHeaderProperty("Accept", "application/json");
      return requestHeader;
   }

   private WebServiceHelper getWebServiceHelperInstance() {
      return new WebServiceHelper();
   }
}
