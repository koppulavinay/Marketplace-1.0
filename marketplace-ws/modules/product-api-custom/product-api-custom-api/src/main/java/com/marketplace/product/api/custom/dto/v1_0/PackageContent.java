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
@GraphQLName("PackageContent")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "PackageContent")
public class PackageContent implements Serializable {

	public static PackageContent toDTO(String json) {
		return ObjectMapperUtil.readValue(PackageContent.class, json);
	}

	public static PackageContent unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(PackageContent.class, json);
	}

	@Schema
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@JsonIgnore
	public void setItemName(
		UnsafeSupplier<String, Exception> itemNameUnsafeSupplier) {

		try {
			itemName = itemNameUnsafeSupplier.get();
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
	protected String itemName;

	@Schema
	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@JsonIgnore
	public void setItemQuantity(
		UnsafeSupplier<String, Exception> itemQuantityUnsafeSupplier) {

		try {
			itemQuantity = itemQuantityUnsafeSupplier.get();
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
	protected String itemQuantity;

	@Schema
	public Long getPackageContentId() {
		return packageContentId;
	}

	public void setPackageContentId(Long packageContentId) {
		this.packageContentId = packageContentId;
	}

	@JsonIgnore
	public void setPackageContentId(
		UnsafeSupplier<Long, Exception> packageContentIdUnsafeSupplier) {

		try {
			packageContentId = packageContentIdUnsafeSupplier.get();
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
	protected Long packageContentId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PackageContent)) {
			return false;
		}

		PackageContent packageContent = (PackageContent)object;

		return Objects.equals(toString(), packageContent.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (itemName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"itemName\": ");

			sb.append("\"");

			sb.append(_escape(itemName));

			sb.append("\"");
		}

		if (itemQuantity != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"itemQuantity\": ");

			sb.append("\"");

			sb.append(_escape(itemQuantity));

			sb.append("\"");
		}

		if (packageContentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"packageContentId\": ");

			sb.append(packageContentId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.marketplace.product.api.custom.dto.v1_0.PackageContent",
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