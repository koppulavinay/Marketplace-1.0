package com.buycorp.common.util;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * A common place to create utilities which can be used globally.
 * 
 * @author anubhav.kalra
 */
public interface CommonUtil {

	/**
	 * 
	 * This method is used to get a Custom field value.
	 * 
	 * @param customFieldName
	 * @return
	 */
	static String getCustomFieldValue(String customFieldName) {

		List<ExpandoColumn> expandoColumns = ExpandoColumnLocalServiceUtil.getExpandoColumns(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<ExpandoValue> expandoValues = ExpandoValueLocalServiceUtil.getExpandoValues(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		ExpandoColumn customFieldNameObj = expandoColumns.stream()
				.filter(element -> element.getName().equalsIgnoreCase(customFieldName.trim())).findFirst().get();

		ExpandoValue customFieldValueObj = expandoValues.stream()
				.filter(element -> element.getColumnId() == customFieldNameObj.getColumnId()).findFirst().get();

		return customFieldValueObj.getData();

	}

	static JSONObject getJsonFromRequestBody(PortletRequest portletRequest) {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(portletRequest);

		try {

			String body = request.getReader().lines().reduce(StringPool.BLANK,
					(accumulator, actual) -> accumulator + actual);

			return JSONFactoryUtil.createJSONObject(body);
		} catch (Exception e) {

			_log.error(e, e);

		}

		return null;

	}

	static PrintWriter getPrintWriter(ResourceResponse resourceResponse) {

		try {

			return resourceResponse.getWriter();
		} catch (IOException e) {

			_log.error(e, e);
		}

		return null;
	}

	static final Log _log = LogFactoryUtil.getLog(CommonUtil.class);

}