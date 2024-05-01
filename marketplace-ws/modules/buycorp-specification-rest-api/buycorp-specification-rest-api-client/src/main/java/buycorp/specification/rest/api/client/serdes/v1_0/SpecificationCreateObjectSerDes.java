package buycorp.specification.rest.api.client.serdes.v1_0;

import buycorp.specification.rest.api.client.dto.v1_0.Category;
import buycorp.specification.rest.api.client.dto.v1_0.SpecificationCreateObject;
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
public class SpecificationCreateObjectSerDes {

	public static SpecificationCreateObject toDTO(String json) {
		SpecificationCreateObjectJSONParser
			specificationCreateObjectJSONParser =
				new SpecificationCreateObjectJSONParser();

		return specificationCreateObjectJSONParser.parseToDTO(json);
	}

	public static SpecificationCreateObject[] toDTOs(String json) {
		SpecificationCreateObjectJSONParser
			specificationCreateObjectJSONParser =
				new SpecificationCreateObjectJSONParser();

		return specificationCreateObjectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		SpecificationCreateObject specificationCreateObject) {

		if (specificationCreateObject == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (specificationCreateObject.getCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0;
				 i < specificationCreateObject.getCategories().length; i++) {

				sb.append(
					String.valueOf(
						specificationCreateObject.getCategories()[i]));

				if ((i + 1) <
						specificationCreateObject.getCategories().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (specificationCreateObject.getModifiedBy() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedBy\": ");

			sb.append(specificationCreateObject.getModifiedBy());
		}

		if (specificationCreateObject.getSpecificationDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationDescription\": ");

			sb.append("\"");

			sb.append(
				_escape(
					specificationCreateObject.getSpecificationDescription()));

			sb.append("\"");
		}

		if (specificationCreateObject.getSpecificationFieldDataType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldDataType\": ");

			sb.append(
				specificationCreateObject.getSpecificationFieldDataType());
		}

		if (specificationCreateObject.getSpecificationFieldType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldType\": ");

			sb.append(specificationCreateObject.getSpecificationFieldType());
		}

		if (specificationCreateObject.getSpecificationLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationLabel\": ");

			sb.append("\"");

			sb.append(
				_escape(specificationCreateObject.getSpecificationLabel()));

			sb.append("\"");
		}

		if (specificationCreateObject.getSpecificationValues() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValues\": ");

			sb.append("[");

			for (int i = 0;
				 i < specificationCreateObject.getSpecificationValues().length;
				 i++) {

				sb.append(
					String.valueOf(
						specificationCreateObject.getSpecificationValues()[i]));

				if ((i + 1) <
						specificationCreateObject.
							getSpecificationValues().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		SpecificationCreateObjectJSONParser
			specificationCreateObjectJSONParser =
				new SpecificationCreateObjectJSONParser();

		return specificationCreateObjectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		SpecificationCreateObject specificationCreateObject) {

		if (specificationCreateObject == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (specificationCreateObject.getCategories() == null) {
			map.put("categories", null);
		}
		else {
			map.put(
				"categories",
				String.valueOf(specificationCreateObject.getCategories()));
		}

		if (specificationCreateObject.getModifiedBy() == null) {
			map.put("modifiedBy", null);
		}
		else {
			map.put(
				"modifiedBy",
				String.valueOf(specificationCreateObject.getModifiedBy()));
		}

		if (specificationCreateObject.getSpecificationDescription() == null) {
			map.put("specificationDescription", null);
		}
		else {
			map.put(
				"specificationDescription",
				String.valueOf(
					specificationCreateObject.getSpecificationDescription()));
		}

		if (specificationCreateObject.getSpecificationFieldDataType() == null) {
			map.put("specificationFieldDataType", null);
		}
		else {
			map.put(
				"specificationFieldDataType",
				String.valueOf(
					specificationCreateObject.getSpecificationFieldDataType()));
		}

		if (specificationCreateObject.getSpecificationFieldType() == null) {
			map.put("specificationFieldType", null);
		}
		else {
			map.put(
				"specificationFieldType",
				String.valueOf(
					specificationCreateObject.getSpecificationFieldType()));
		}

		if (specificationCreateObject.getSpecificationLabel() == null) {
			map.put("specificationLabel", null);
		}
		else {
			map.put(
				"specificationLabel",
				String.valueOf(
					specificationCreateObject.getSpecificationLabel()));
		}

		if (specificationCreateObject.getSpecificationValues() == null) {
			map.put("specificationValues", null);
		}
		else {
			map.put(
				"specificationValues",
				String.valueOf(
					specificationCreateObject.getSpecificationValues()));
		}

		return map;
	}

	public static class SpecificationCreateObjectJSONParser
		extends BaseJSONParser<SpecificationCreateObject> {

		@Override
		protected SpecificationCreateObject createDTO() {
			return new SpecificationCreateObject();
		}

		@Override
		protected SpecificationCreateObject[] createDTOArray(int size) {
			return new SpecificationCreateObject[size];
		}

		@Override
		protected void setField(
			SpecificationCreateObject specificationCreateObject,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "categories")) {
				if (jsonParserFieldValue != null) {
					specificationCreateObject.setCategories(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> CategorySerDes.toDTO((String)object)
						).toArray(
							size -> new Category[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "modifiedBy")) {
				if (jsonParserFieldValue != null) {
					specificationCreateObject.setModifiedBy(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationDescription")) {

				if (jsonParserFieldValue != null) {
					specificationCreateObject.setSpecificationDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationFieldDataType")) {

				if (jsonParserFieldValue != null) {
					specificationCreateObject.setSpecificationFieldDataType(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationFieldType")) {

				if (jsonParserFieldValue != null) {
					specificationCreateObject.setSpecificationFieldType(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationLabel")) {

				if (jsonParserFieldValue != null) {
					specificationCreateObject.setSpecificationLabel(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationValues")) {

				if (jsonParserFieldValue != null) {
					specificationCreateObject.setSpecificationValues(
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