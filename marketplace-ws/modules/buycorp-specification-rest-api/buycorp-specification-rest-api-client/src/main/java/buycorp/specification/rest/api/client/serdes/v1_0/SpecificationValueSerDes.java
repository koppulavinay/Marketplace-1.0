package buycorp.specification.rest.api.client.serdes.v1_0;

import buycorp.specification.rest.api.client.dto.v1_0.SpecificationValue;
import buycorp.specification.rest.api.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
public class SpecificationValueSerDes {

	public static SpecificationValue toDTO(String json) {
		SpecificationValueJSONParser specificationValueJSONParser =
			new SpecificationValueJSONParser();

		return specificationValueJSONParser.parseToDTO(json);
	}

	public static SpecificationValue[] toDTOs(String json) {
		SpecificationValueJSONParser specificationValueJSONParser =
			new SpecificationValueJSONParser();

		return specificationValueJSONParser.parseToDTOs(json);
	}

	public static String toJSON(SpecificationValue specificationValue) {
		if (specificationValue == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (specificationValue.getSpecificationUOM() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationUOM\": ");

			sb.append("\"");

			sb.append(_escape(specificationValue.getSpecificationUOM()));

			sb.append("\"");
		}

		if (specificationValue.getSpecificationValueId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValueId\": ");

			sb.append(specificationValue.getSpecificationValueId());
		}

		if (specificationValue.getSpecificationValueLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValueLabel\": ");

			sb.append("\"");

			sb.append(_escape(specificationValue.getSpecificationValueLabel()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SpecificationValueJSONParser specificationValueJSONParser =
			new SpecificationValueJSONParser();

		return specificationValueJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		SpecificationValue specificationValue) {

		if (specificationValue == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (specificationValue.getSpecificationUOM() == null) {
			map.put("specificationUOM", null);
		}
		else {
			map.put(
				"specificationUOM",
				String.valueOf(specificationValue.getSpecificationUOM()));
		}

		if (specificationValue.getSpecificationValueId() == null) {
			map.put("specificationValueId", null);
		}
		else {
			map.put(
				"specificationValueId",
				String.valueOf(specificationValue.getSpecificationValueId()));
		}

		if (specificationValue.getSpecificationValueLabel() == null) {
			map.put("specificationValueLabel", null);
		}
		else {
			map.put(
				"specificationValueLabel",
				String.valueOf(
					specificationValue.getSpecificationValueLabel()));
		}

		return map;
	}

	public static class SpecificationValueJSONParser
		extends BaseJSONParser<SpecificationValue> {

		@Override
		protected SpecificationValue createDTO() {
			return new SpecificationValue();
		}

		@Override
		protected SpecificationValue[] createDTOArray(int size) {
			return new SpecificationValue[size];
		}

		@Override
		protected void setField(
			SpecificationValue specificationValue, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "specificationUOM")) {
				if (jsonParserFieldValue != null) {
					specificationValue.setSpecificationUOM(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationValueId")) {

				if (jsonParserFieldValue != null) {
					specificationValue.setSpecificationValueId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationValueLabel")) {

				if (jsonParserFieldValue != null) {
					specificationValue.setSpecificationValueLabel(
						(String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}