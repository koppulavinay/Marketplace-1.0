package buycorp.specification.rest.api.client.serdes.v1_0;

import buycorp.specification.rest.api.client.dto.v1_0.Category;
import buycorp.specification.rest.api.client.dto.v1_0.SpecificationUpdateObject;
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
public class SpecificationUpdateObjectSerDes {

	public static SpecificationUpdateObject toDTO(String json) {
		SpecificationUpdateObjectJSONParser
			specificationUpdateObjectJSONParser =
				new SpecificationUpdateObjectJSONParser();

		return specificationUpdateObjectJSONParser.parseToDTO(json);
	}

	public static SpecificationUpdateObject[] toDTOs(String json) {
		SpecificationUpdateObjectJSONParser
			specificationUpdateObjectJSONParser =
				new SpecificationUpdateObjectJSONParser();

		return specificationUpdateObjectJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		SpecificationUpdateObject specificationUpdateObject) {

		if (specificationUpdateObject == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (specificationUpdateObject.getCategories() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0;
				 i < specificationUpdateObject.getCategories().length; i++) {

				sb.append(
					String.valueOf(
						specificationUpdateObject.getCategories()[i]));

				if ((i + 1) <
						specificationUpdateObject.getCategories().length) {

					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (specificationUpdateObject.getModifiedBy() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"modifiedBy\": ");

			sb.append(specificationUpdateObject.getModifiedBy());
		}

		if (specificationUpdateObject.getSpecificationDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationDescription\": ");

			sb.append("\"");

			sb.append(
				_escape(
					specificationUpdateObject.getSpecificationDescription()));

			sb.append("\"");
		}

		if (specificationUpdateObject.getSpecificationFieldDataType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldDataType\": ");

			sb.append(
				specificationUpdateObject.getSpecificationFieldDataType());
		}

		if (specificationUpdateObject.getSpecificationFieldType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldType\": ");

			sb.append(specificationUpdateObject.getSpecificationFieldType());
		}

		if (specificationUpdateObject.getSpecificationId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationId\": ");

			sb.append(specificationUpdateObject.getSpecificationId());
		}

		if (specificationUpdateObject.getSpecificationLabel() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationLabel\": ");

			sb.append("\"");

			sb.append(
				_escape(specificationUpdateObject.getSpecificationLabel()));

			sb.append("\"");
		}

		if (specificationUpdateObject.getSpecificationValues() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValues\": ");

			sb.append("[");

			for (int i = 0;
				 i < specificationUpdateObject.getSpecificationValues().length;
				 i++) {

				sb.append(
					String.valueOf(
						specificationUpdateObject.getSpecificationValues()[i]));

				if ((i + 1) <
						specificationUpdateObject.
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
		SpecificationUpdateObjectJSONParser
			specificationUpdateObjectJSONParser =
				new SpecificationUpdateObjectJSONParser();

		return specificationUpdateObjectJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		SpecificationUpdateObject specificationUpdateObject) {

		if (specificationUpdateObject == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (specificationUpdateObject.getCategories() == null) {
			map.put("categories", null);
		}
		else {
			map.put(
				"categories",
				String.valueOf(specificationUpdateObject.getCategories()));
		}

		if (specificationUpdateObject.getModifiedBy() == null) {
			map.put("modifiedBy", null);
		}
		else {
			map.put(
				"modifiedBy",
				String.valueOf(specificationUpdateObject.getModifiedBy()));
		}

		if (specificationUpdateObject.getSpecificationDescription() == null) {
			map.put("specificationDescription", null);
		}
		else {
			map.put(
				"specificationDescription",
				String.valueOf(
					specificationUpdateObject.getSpecificationDescription()));
		}

		if (specificationUpdateObject.getSpecificationFieldDataType() == null) {
			map.put("specificationFieldDataType", null);
		}
		else {
			map.put(
				"specificationFieldDataType",
				String.valueOf(
					specificationUpdateObject.getSpecificationFieldDataType()));
		}

		if (specificationUpdateObject.getSpecificationFieldType() == null) {
			map.put("specificationFieldType", null);
		}
		else {
			map.put(
				"specificationFieldType",
				String.valueOf(
					specificationUpdateObject.getSpecificationFieldType()));
		}

		if (specificationUpdateObject.getSpecificationId() == null) {
			map.put("specificationId", null);
		}
		else {
			map.put(
				"specificationId",
				String.valueOf(specificationUpdateObject.getSpecificationId()));
		}

		if (specificationUpdateObject.getSpecificationLabel() == null) {
			map.put("specificationLabel", null);
		}
		else {
			map.put(
				"specificationLabel",
				String.valueOf(
					specificationUpdateObject.getSpecificationLabel()));
		}

		if (specificationUpdateObject.getSpecificationValues() == null) {
			map.put("specificationValues", null);
		}
		else {
			map.put(
				"specificationValues",
				String.valueOf(
					specificationUpdateObject.getSpecificationValues()));
		}

		return map;
	}

	public static class SpecificationUpdateObjectJSONParser
		extends BaseJSONParser<SpecificationUpdateObject> {

		@Override
		protected SpecificationUpdateObject createDTO() {
			return new SpecificationUpdateObject();
		}

		@Override
		protected SpecificationUpdateObject[] createDTOArray(int size) {
			return new SpecificationUpdateObject[size];
		}

		@Override
		protected void setField(
			SpecificationUpdateObject specificationUpdateObject,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "categories")) {
				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setCategories(
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
					specificationUpdateObject.setModifiedBy(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationDescription")) {

				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setSpecificationDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationFieldDataType")) {

				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setSpecificationFieldDataType(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationFieldType")) {

				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setSpecificationFieldType(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "specificationId")) {
				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setSpecificationId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationLabel")) {

				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setSpecificationLabel(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "specificationValues")) {

				if (jsonParserFieldValue != null) {
					specificationUpdateObject.setSpecificationValues(
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