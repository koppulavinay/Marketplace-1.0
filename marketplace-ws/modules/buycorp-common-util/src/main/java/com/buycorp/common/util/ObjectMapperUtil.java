package com.buycorp.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Class to convert JSON to POJO and vice versa
 * 
 * @author anubhav.kalra
 *
 */
public interface ObjectMapperUtil {
	
	static String parseToJSON(Object beanObject) {
		String jsonData = StringPool.BLANK;
		
		try {
			jsonData = _objectMapper.writeValueAsString(beanObject);
		} catch (JsonProcessingException e) {
			_log.warn("Unable to parse POJO to JSON. Please enable debug logs for full details.");
			_log.debug(e, e);
		}
		
		return jsonData;
	}
	
	static <T> T parseToBean(String json, Class<T> type) {
		T t = null;
		
		try {
			t = _objectMapper.readValue(json, type);
		} catch (JsonProcessingException e) {
			_log.warn("Unable to parse JSON to POJO. Please enable debug logs for full details.");
			_log.debug(e, e);
		}
		
		return t;
	}
	
	static final Log _log = LogFactoryUtil.getLog(ObjectMapperUtil.class);
	
	static final ObjectMapper _objectMapper = new ObjectMapper();

}
