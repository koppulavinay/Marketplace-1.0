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

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ashishinani
 * @generated
 */
@Generated("")
@GraphQLName("Variant")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Variant")
public class Variant implements Serializable {

	public static Variant toDTO(String json) {
		return ObjectMapperUtil.readValue(Variant.class, json);
	}

	public static Variant unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Variant.class, json);
	}

	@Schema
	public Long getProductVariantId() {
		return productVariantId;
	}

	public void setProductVariantId(Long productVariantId) {
		this.productVariantId = productVariantId;
	}

	@JsonIgnore
	public void setProductVariantId(
		UnsafeSupplier<Long, Exception> productVariantIdUnsafeSupplier) {

		try {
			productVariantId = productVariantIdUnsafeSupplier.get();
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
	protected Long productVariantId;

	@Schema
	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	@JsonIgnore
	public void setVariantName(
		UnsafeSupplier<String, Exception> variantNameUnsafeSupplier) {

		try {
			variantName = variantNameUnsafeSupplier.get();
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
	protected String variantName;

	@Schema
	public String getVariantValue() {
		return variantValue;
	}

	public void setVariantValue(String variantValue) {
		this.variantValue = variantValue;
	}

	@JsonIgnore
	public void setVariantValue(
		UnsafeSupplier<String, Exception> variantValueUnsafeSupplier) {

		try {
			variantValue = variantValueUnsafeSupplier.get();
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
	protected String variantValue;

	@Schema
	public Long getVariantValueId() {
		return variantValueId;
	}

	public void setVariantValueId(Long variantValueId) {
		this.variantValueId = variantValueId;
	}

	@JsonIgnore
	public void setVariantValueId(
		UnsafeSupplier<Long, Exception> variantValueIdUnsafeSupplier) {

		try {
			variantValueId = variantValueIdUnsafeSupplier.get();
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
	protected Long variantValueId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Variant)) {
			return false;
		}

		Variant variant = (Variant)object;

		return Objects.equals(toString(), variant.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (productVariantId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productVariantId\": ");

			sb.append(productVariantId);
		}

		if (variantName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"variantName\": ");

			sb.append("\"");

			sb.append(_escape(variantName));

			sb.append("\"");
		}

		if (variantValue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"variantValue\": ");

			sb.append("\"");

			sb.append(_escape(variantValue));

			sb.append("\"");
		}

		if (variantValueId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"variantValueId\": ");

			sb.append(variantValueId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.marketplace.product.api.custom.dto.v1_0.Variant",
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