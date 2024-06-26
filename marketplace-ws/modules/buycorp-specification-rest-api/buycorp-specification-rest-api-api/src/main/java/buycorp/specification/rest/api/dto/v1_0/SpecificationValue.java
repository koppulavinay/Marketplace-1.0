package buycorp.specification.rest.api.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
@GraphQLName("SpecificationValue")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "SpecificationValue")
public class SpecificationValue implements Serializable {

	public static SpecificationValue toDTO(String json) {
		return ObjectMapperUtil.readValue(SpecificationValue.class, json);
	}

	public static SpecificationValue unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(SpecificationValue.class, json);
	}

	@Schema
	public String getSpecificationUOM() {
		return specificationUOM;
	}

	public void setSpecificationUOM(String specificationUOM) {
		this.specificationUOM = specificationUOM;
	}

	@JsonIgnore
	public void setSpecificationUOM(
		UnsafeSupplier<String, Exception> specificationUOMUnsafeSupplier) {

		try {
			specificationUOM = specificationUOMUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String specificationUOM;

	@Schema
	public Long getSpecificationValueId() {
		return specificationValueId;
	}

	public void setSpecificationValueId(Long specificationValueId) {
		this.specificationValueId = specificationValueId;
	}

	@JsonIgnore
	public void setSpecificationValueId(
		UnsafeSupplier<Long, Exception> specificationValueIdUnsafeSupplier) {

		try {
			specificationValueId = specificationValueIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long specificationValueId;

	@Schema
	public String getSpecificationValueLabel() {
		return specificationValueLabel;
	}

	public void setSpecificationValueLabel(String specificationValueLabel) {
		this.specificationValueLabel = specificationValueLabel;
	}

	@JsonIgnore
	public void setSpecificationValueLabel(
		UnsafeSupplier<String, Exception>
			specificationValueLabelUnsafeSupplier) {

		try {
			specificationValueLabel =
				specificationValueLabelUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String specificationValueLabel;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecificationValue)) {
			return false;
		}

		SpecificationValue specificationValue = (SpecificationValue)object;

		return Objects.equals(toString(), specificationValue.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (specificationUOM != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationUOM\": ");

			sb.append("\"");

			sb.append(_escape(specificationUOM));

			sb.append("\"");
		}

		if (specificationValueId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValueId\": ");

			sb.append(specificationValueId);
		}

		if (specificationValueLabel != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValueLabel\": ");

			sb.append("\"");

			sb.append(_escape(specificationValueLabel));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "buycorp.specification.rest.api.dto.v1_0.SpecificationValue",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}