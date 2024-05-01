package com.marketplace.ws.helper;

import com.buycorp.common.util.ObjectMapperUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.ws.model.RequestHeader;
import com.marketplace.ws.model.RequestMethod;
import com.marketplace.ws.request.beans.GetOrganizationUsersApiBeans;
import com.marketplace.ws.request.beans.GetStubsApiBeans;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = { WebServiceHelper.class })
public class WebServiceHelper {
	private static String charset = Charset.defaultCharset().name();
	private String requestContentType;
	private static final Log LOGGER = LogFactoryUtil.getLog(WebServiceHelper.class);

	public String invokePost(String requestURL, RequestHeader requestHeaders, String requestBodyContent,
			String requestBodyContentType, String accessToken) throws IOException {
		HttpPost httpPost = new HttpPost(requestURL);
		if (Validator.isNotNull(accessToken)) {
			httpPost.setHeader("Authorization", "Bearer " + accessToken);
		}

		StringEntity requestBody = new StringEntity(requestBodyContent);
		requestBody.setContentType(requestBodyContentType);
		requestBody.setContentEncoding(charset);
		if (Validator.isNotNull(requestHeaders)) {
			requestHeaders.getHeaderProperties().forEach(httpPost::setHeader);
		}

		httpPost.setEntity(requestBody);
		String result = null;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		HttpEntity entity = httpResponse.getEntity();
		if (Validator.isNotNull(entity)) {
			result = EntityUtils.toString(entity);
		}

		return result;
	}

	public String invokeGet(String requestUrl, String accessToken) throws IOException {
		HttpGet httpGet = new HttpGet(requestUrl);
		if (Validator.isNotNull(accessToken)) {
			httpGet.setHeader("Authorization", "Bearer " + accessToken);
		}

		String result = null;
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse response = httpClient.execute(httpGet);
		
		StatusLine statusLine = response.getStatusLine();
		
		int statusCode = statusLine.getStatusCode();
		HttpEntity entity = response.getEntity();
		if (statusCode == 200) {
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}

			return result;
		} 

		if (entity != null) {
			result = EntityUtils.toString(entity);
		}

		return result;

	}

	public RequestHeader initializeHeaders(RequestMethod requestMethod, String applicationType) {
		this.requestContentType = applicationType;
		return new RequestHeader(requestMethod, this.requestContentType);
	}

	public String constructStubApiRequest(String apiVersion, String apiName, String environment) {
		GetStubsApiBeans getStubsApiBeans = new GetStubsApiBeans(apiVersion, apiName, environment);
		return ObjectMapperUtil.parseToJSON(getStubsApiBeans);
	}

	public String constructOrgUsersApiRequest(String organizationId, String organizationRoles) {
		GetOrganizationUsersApiBeans getOrganizationUsersApiBeans = new GetOrganizationUsersApiBeans(organizationId,
				organizationRoles);
		return ObjectMapperUtil.parseToJSON(getOrganizationUsersApiBeans);
	}
}
