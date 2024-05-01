package buycorp.specification.rest.api.client.serdes.v1_0;

import buycorp.specification.rest.api.client.dto.v1_0.Category;
import buycorp.specification.rest.api.client.dto.v1_0.SpecificationObject;
import buycorp.specification.rest.api.client.dto.v1_0.SpecificationValue;
import buycorp.specification.rest.api.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
public class SpecificationObjectSerDes {

	public static SpecificationObject toDTO(String json) {
		SpecificationObjectJSONParser specificationObjectJSONParser =
			new SpecificationObjectJSONParser();

		return specificationObjectJSONParser.parseToDTO(json);
	}

	public static SpecificationObject[] toDTOs(String json) {
		SpecificationObjectJSONParser specificationObjectJSONParser =
			new SpecificationObjectJSONParser();

		return specificationObjectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(SpecificationObject specificationObject) {
		if (specificationObject == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (specificationObject.getCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0; i < specificationObject.getCategories().length;
				 i++) {

				sb.append(
					String.valueOf(specificationObject.getCategories()[i]));

				if ((i + 1) < specificationObject.getCategories().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (specificationObject.getSpecificationDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationDescription\": ");

			sb.append("\"");

			sb.append(
				_escape(specificationObject.getSpecificationDescription()));

			sb.append("\"");
		}

		if (specificationObject.getSpecificationFieldDataType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldDataType\": ");

			sb.append(specificationObject.getSpecificationFieldDataType());
		}

		if (specificationObject.getSpecificationFieldType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldType\": ");

			sb.append(specificationObject.getSpecificationFieldType());
		}

		if (specificationObject.getSpecificationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationId\": ");

			sb.append(specificationObject.getSpecificationId());
		}

		if (specificationObject.getSpecificationLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationLabel\": ");

			sb.append("\"");

			sb.append(_escape(specificationObject.getSpecificationLabel()));

			sb.append("\"");
		}

		if (specificationObject.getSpecificationStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationStatus\": ");

			sb.append("\"");

			sb.append(_escape(specificationObject.getSpecificationStatus()));

			sb.append("\"");
		}

		if (specificationObject.getSpecificationValues() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValues\": ");

			sb.append("[");

			for (int i = 0;
				 i < specificationObject.getSpecificationValues().length; i++) {

				sb.append(
					String.valueOf(
						specificationObject.getSpecificationValues()[i]));

				if ((i + 1) <
						specificationObject.getSpecificationValues().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (specificationObject.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(specificationObject.getStatus()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SpecificationObjectJSONParser specificationObjectJSONParser =
			new SpecificationObjectJSONParser();

		return specificationObjectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		SpecificationObject specificationObject) {

		if (specificationObject == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (specificationObject.getCategories() == null) {
			map.put("categories", null);
		}
		else {
			map.put(
				"categories",
				String.valueOf(specificationObject.getCategories()));
		}

		if (specificationObject.getSpecificationDescription() == null) {
			map.put("specificationDescription", null);
		}
		else {
			map.put(
				"specificationDescription",
				String.valueOf(
					specificationObject.getSpecificationDescription()));
		}

		if (specificationObject.getSpecificationFieldDataType() == null) {
			map.put("specificationFieldDataType", null);
		}
		else {
			map.put(
				"specificationFieldDataType",
				String.valueOf(
					specificationObject.getSpecificationFieldDataType()));
		}

		if (specificationObject.getSpecificationFieldType() == null) {
			map.put("specificationFieldType", null);
		}
		else {
			map.put(
				"specificationFieldType",
				String.valueOf(
					specificationObject.getSpecificationFieldType()));
		}

		if (specificationObject.getSpecificationId() == null) {
			map.put("specificationId", null);
		}
		else {
			map.put(
				"specificationId",
				String.valueOf(specificationObject.getSpecificationId()));
		}

		if (specificationObject.getSpecificationLabel() == null) {
			map.put("specificationLabel", null);
		}
		else {
			map.put(
				"specificationLabel",
				String.valueOf(specificationObject.getSpecificationLabel()));
		}

		if (specificationObject.getSpecificationStatus() == null) {
			map.put("specificationStatus", null);
		}
		else {
			map.put(
				"specificationStatus",
				String.valueOf(specificationObject.getSpecificationStatus()));
		}

		if (specificationObject.getSpecificationValues() == null) {
			map.put("specificationValues", null);
		}
		else {
			map.put(
				"specificationValues",
				String.valueOf(specificationObject.getSpecificationValues()));
		}

		if (specificationObject.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(specificationObject.getStatus()));
		}

		return map;
	}

	public static class SpecificationObjectJSONParser
		extends BaseJSONParser<SpecificationObject> {

		@Override
		protected SpecificationObject createDTO() {
			return new SpecificationObject();
		}

		@Override
		protected SpecificationObject[] createDTOArray(int size) {
			return new SpecificationObject[size];
		}

		@Override
		protected void setField(
			SpecificationObject specificationObject, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "categories")) {
				if (jsonParserFieldValue != null) {
					specificationObject.setCategories(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CategorySerDes.toDTO((String)object)
						).toArray(
							size -> new Category[size]
						));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationDescription")) {

				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationFieldDataType")) {

				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationFieldDataType(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationFieldType")) {

				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationFieldType(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "specificationId")) {
				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationLabel")) {

				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationLabel(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationStatus")) {

				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationStatus(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationValues")) {

				if (jsonParserFieldValue != null) {
					specificationObject.setSpecificationValues(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> SpecificationValueSerDes.toDTO(
								(String)object)
						).toArray(
							size -> new SpecificationValue[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					specificationObject.setStatus((String)jsonParserFieldValue);
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