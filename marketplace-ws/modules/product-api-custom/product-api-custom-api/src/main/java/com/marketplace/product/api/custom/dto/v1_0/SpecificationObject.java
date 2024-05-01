package com.marketplace.product.api.custom.dto.v1_0;

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
 * @author ashishinani
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
	public PackageContent[] getPackageContent() {
		return packageContent;
	}

	public void setPackageContent(PackageContent[] packageContent) {
		this.packageContent = packageContent;
	}

	@JsonIgnore
	public void setPackageContent(
		UnsafeSupplier<PackageContent[], Exception>
			packageContentUnsafeSupplier) {

		try {
			packageContent = packageContentUnsafeSupplier.get();
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
	protected PackageContent[] packageContent;

	@Schema
	@Valid
	public Specification[] getSpecification() {
		return specification;
	}

	public void setSpecification(Specification[] specification) {
		this.specification = specification;
	}

	@JsonIgnore
	public void setSpecification(
		UnsafeSupplier<Specification[], Exception>
			specificationUnsafeSupplier) {

		try {
			specification = specificationUnsafeSupplier.get();
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
	protected Specification[] specification;

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

		if (packageContent != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"packageContent\": ");

			sb.append("[");

			for (int i = 0; i < packageContent.length; i++) {
				sb.append(String.valueOf(packageContent[i]));

				if ((i + 1) < packageContent.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (specification != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"specification\": ");

			sb.append("[");

			for (int i = 0; i < specification.length; i++) {
				sb.append(String.valueOf(specification[i]));

				if ((i + 1) < specification.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.marketplace.product.api.custom.dto.v1_0.SpecificationObject",
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