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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kashyap.mishra
 * @generated
 */
@Generated("")
@GraphQLName("SpecificationObject")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "SpecificationObject")
public class SpecificationObject implements Serializable {

	public static SpecificationObject toDTO(String json) {
		return ObjectMapperUtil.readValue(SpecificationObject.class, json);
	}

	public static SpecificationObject unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			SpecificationObject.class, json);
	}

	@Schema
	@Valid
	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	@JsonIgnore
	public void setCategories(
		UnsafeSupplier<Category[], Exception> categoriesUnsafeSupplier) {

		try {
			categories = categoriesUnsafeSupplier.get();
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
	protected Category[] categories;

	@Schema
	public String getSpecificationDescription() {
		return specificationDescription;
	}

	public void setSpecificationDescription(String specificationDescription) {
		this.specificationDescription = specificationDescription;
	}

	@JsonIgnore
	public void setSpecificationDescription(
		UnsafeSupplier<String, Exception>
			specificationDescriptionUnsafeSupplier) {

		try {
			specificationDescription =
				specificationDescriptionUnsafeSupplier.get();
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
	protected String specificationDescription;

	@Schema
	public Long getSpecificationFieldDataType() {
		return specificationFieldDataType;
	}

	public void setSpecificationFieldDataType(Long specificationFieldDataType) {
		this.specificationFieldDataType = specificationFieldDataType;
	}

	@JsonIgnore
	public void setSpecificationFieldDataType(
		UnsafeSupplier<Long, Exception>
			specificationFieldDataTypeUnsafeSupplier) {

		try {
			specificationFieldDataType =
				specificationFieldDataTypeUnsafeSupplier.get();
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
	protected Long specificationFieldDataType;

	@Schema
	public Long getSpecificationFieldType() {
		return specificationFieldType;
	}

	public void setSpecificationFieldType(Long specificationFieldType) {
		this.specificationFieldType = specificationFieldType;
	}

	@JsonIgnore
	public void setSpecificationFieldType(
		UnsafeSupplier<Long, Exception> specificationFieldTypeUnsafeSupplier) {

		try {
			specificationFieldType = specificationFieldTypeUnsafeSupplier.get();
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
	protected Long specificationFieldType;

	@Schema
	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
	}

	@JsonIgnore
	public void setSpecificationId(
		UnsafeSupplier<Long, Exception> specificationIdUnsafeSupplier) {

		try {
			specificationId = specificationIdUnsafeSupplier.get();
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
	protected Long specificationId;

	@Schema
	public String getSpecificationLabel() {
		return specificationLabel;
	}

	public void setSpecificationLabel(String specificationLabel) {
		this.specificationLabel = specificationLabel;
	}

	@JsonIgnore
	public void setSpecificationLabel(
		UnsafeSupplier<String, Exception> specificationLabelUnsafeSupplier) {

		try {
			specificationLabel = specificationLabelUnsafeSupplier.get();
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
	protected String specificationLabel;

	@Schema
	public String getSpecificationStatus() {
		return specificationStatus;
	}

	public void setSpecificationStatus(String specificationStatus) {
		this.specificationStatus = specificationStatus;
	}

	@JsonIgnore
	public void setSpecificationStatus(
		UnsafeSupplier<String, Exception> specificationStatusUnsafeSupplier) {

		try {
			specificationStatus = specificationStatusUnsafeSupplier.get();
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
	protected String specificationStatus;

	@Schema
	@Valid
	public SpecificationValue[] getSpecificationValues() {
		return specificationValues;
	}

	public void setSpecificationValues(
		SpecificationValue[] specificationValues) {

		this.specificationValues = specificationValues;
	}

	@JsonIgnore
	public void setSpecificationValues(
		UnsafeSupplier<SpecificationValue[], Exception>
			specificationValuesUnsafeSupplier) {

		try {
			specificationValues = specificationValuesUnsafeSupplier.get();
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
	protected SpecificationValue[] specificationValues;

	@Schema
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
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
	protected String status;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecificationObject)) {
			return false;
		}

		SpecificationObject specificationObject = (SpecificationObject)object;

		return Objects.equals(toString(), specificationObject.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (categories != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categories\": ");

			sb.append("[");

			for (int i = 0; i < categories.length; i++) {
				sb.append(String.valueOf(categories[i]));

				if ((i + 1) < categories.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (specificationDescription != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationDescription\": ");

			sb.append("\"");

			sb.append(_escape(specificationDescription));

			sb.append("\"");
		}

		if (specificationFieldDataType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldDataType\": ");

			sb.append(specificationFieldDataType);
		}

		if (specificationFieldType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationFieldType\": ");

			sb.append(specificationFieldType);
		}

		if (specificationId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationId\": ");

			sb.append(specificationId);
		}

		if (specificationLabel != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationLabel\": ");

			sb.append("\"");

			sb.append(_escape(specificationLabel));

			sb.append("\"");
		}

		if (specificationStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationStatus\": ");

			sb.append("\"");

			sb.append(_escape(specificationStatus));

			sb.append("\"");
		}

		if (specificationValues != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specificationValues\": ");

			sb.append("[");

			for (int i = 0; i < specificationValues.length; i++) {
				sb.append(String.valueOf(specificationValues[i]));

				if ((i + 1) < specificationValues.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(status));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "buycorp.specification.rest.api.dto.v1_0.SpecificationObject",
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