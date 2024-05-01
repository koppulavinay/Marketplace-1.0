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
@GraphQLName("Sku")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Sku")
public class Sku implements Serializable {

	public static Sku toDTO(String json) {
		return ObjectMapperUtil.readValue(Sku.class, json);
	}

	public static Sku unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Sku.class, json);
	}

	@Schema
	public String getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	@JsonIgnore
	public void setBasePrice(
		UnsafeSupplier<String, Exception> basePriceUnsafeSupplier) {

		try {
			basePrice = basePriceUnsafeSupplier.get();
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
	protected String basePrice;

	@Schema
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@JsonIgnore
	public void setCost(UnsafeSupplier<String, Exception> costUnsafeSupplier) {
		try {
			cost = costUnsafeSupplier.get();
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
	protected String cost;

	@Schema
	public String getDefaultSku() {
		return defaultSku;
	}

	public void setDefaultSku(String defaultSku) {
		this.defaultSku = defaultSku;
	}

	@JsonIgnore
	public void setDefaultSku(
		UnsafeSupplier<String, Exception> defaultSkuUnsafeSupplier) {

		try {
			defaultSku = defaultSkuUnsafeSupplier.get();
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
	protected String defaultSku;

	@Schema
	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@JsonIgnore
	public void setExpiryDate(
		UnsafeSupplier<String, Exception> expiryDateUnsafeSupplier) {

		try {
			expiryDate = expiryDateUnsafeSupplier.get();
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
	protected String expiryDate;

	@Schema
	@Valid
	public Image[] getImages() {
		return images;
	}

	public void setImages(Image[] images) {
		this.images = images;
	}

	@JsonIgnore
	public void setImages(
		UnsafeSupplier<Image[], Exception> imagesUnsafeSupplier) {

		try {
			images = imagesUnsafeSupplier.get();
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
	protected Image[] images;

	@Schema
	public Long getLowStockThreshold() {
		return lowStockThreshold;
	}

	public void setLowStockThreshold(Long lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}

	@JsonIgnore
	public void setLowStockThreshold(
		UnsafeSupplier<Long, Exception> lowStockThresholdUnsafeSupplier) {

		try {
			lowStockThreshold = lowStockThresholdUnsafeSupplier.get();
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
	protected Long lowStockThreshold;

	@Schema
	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	@JsonIgnore
	public void setMargin(
		UnsafeSupplier<String, Exception> marginUnsafeSupplier) {

		try {
			margin = marginUnsafeSupplier.get();
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
	protected String margin;

	@Schema
	public Long getMaximumOrderQuantity() {
		return maximumOrderQuantity;
	}

	public void setMaximumOrderQuantity(Long maximumOrderQuantity) {
		this.maximumOrderQuantity = maximumOrderQuantity;
	}

	@JsonIgnore
	public void setMaximumOrderQuantity(
		UnsafeSupplier<Long, Exception> maximumOrderQuantityUnsafeSupplier) {

		try {
			maximumOrderQuantity = maximumOrderQuantityUnsafeSupplier.get();
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
	protected Long maximumOrderQuantity;

	@Schema
	public Long getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(Long minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	@JsonIgnore
	public void setMinimumOrderQuantity(
		UnsafeSupplier<Long, Exception> minimumOrderQuantityUnsafeSupplier) {

		try {
			minimumOrderQuantity = minimumOrderQuantityUnsafeSupplier.get();
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
	protected Long minimumOrderQuantity;

	@Schema
	public String getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}

	@JsonIgnore
	public void setOfferPrice(
		UnsafeSupplier<String, Exception> offerPriceUnsafeSupplier) {

		try {
			offerPrice = offerPriceUnsafeSupplier.get();
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
	protected String offerPrice;

	@Schema
	public Long getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(Long productSkuId) {
		this.productSkuId = productSkuId;
	}

	@JsonIgnore
	public void setProductSkuId(
		UnsafeSupplier<Long, Exception> productSkuIdUnsafeSupplier) {

		try {
			productSkuId = productSkuIdUnsafeSupplier.get();
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
	protected Long productSkuId;

	@Schema
	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	@JsonIgnore
	public void setPublishingDate(
		UnsafeSupplier<String, Exception> publishingDateUnsafeSupplier) {

		try {
			publishingDate = publishingDateUnsafeSupplier.get();
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
	protected String publishingDate;

	@Schema
	public String getSellerSkuId() {
		return sellerSkuId;
	}

	public void setSellerSkuId(String sellerSkuId) {
		this.sellerSkuId = sellerSkuId;
	}

	@JsonIgnore
	public void setSellerSkuId(
		UnsafeSupplier<String, Exception> sellerSkuIdUnsafeSupplier) {

		try {
			sellerSkuId = sellerSkuIdUnsafeSupplier.get();
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
	protected String sellerSkuId;

	@Schema
	public String getSkuCreationName() {
		return skuCreationName;
	}

	public void setSkuCreationName(String skuCreationName) {
		this.skuCreationName = skuCreationName;
	}

	@JsonIgnore
	public void setSkuCreationName(
		UnsafeSupplier<String, Exception> skuCreationNameUnsafeSupplier) {

		try {
			skuCreationName = skuCreationNameUnsafeSupplier.get();
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
	protected String skuCreationName;

	@Schema
	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	@JsonIgnore
	public void setSkuId(
		UnsafeSupplier<String, Exception> skuIdUnsafeSupplier) {

		try {
			skuId = skuIdUnsafeSupplier.get();
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
	protected String skuId;

	@Schema
	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@JsonIgnore
	public void setStock(UnsafeSupplier<Long, Exception> stockUnsafeSupplier) {
		try {
			stock = stockUnsafeSupplier.get();
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
	protected Long stock;

	@Schema
	@Valid
	public Variant[] getVariants() {
		return variants;
	}

	public void setVariants(Variant[] variants) {
		this.variants = variants;
	}

	@JsonIgnore
	public void setVariants(
		UnsafeSupplier<Variant[], Exception> variantsUnsafeSupplier) {

		try {
			variants = variantsUnsafeSupplier.get();
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
	protected Variant[] variants;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Sku)) {
			return false;
		}

		Sku sku = (Sku)object;

		return Objects.equals(toString(), sku.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (basePrice != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"basePrice\": ");

			sb.append("\"");

			sb.append(_escape(basePrice));

			sb.append("\"");
		}

		if (cost != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"cost\": ");

			sb.append("\"");

			sb.append(_escape(cost));

			sb.append("\"");
		}

		if (defaultSku != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"defaultSku\": ");

			sb.append("\"");

			sb.append(_escape(defaultSku));

			sb.append("\"");
		}

		if (expiryDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"expiryDate\": ");

			sb.append("\"");

			sb.append(_escape(expiryDate));

			sb.append("\"");
		}

		if (images != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"images\": ");

			sb.append("[");

			for (int i = 0; i < images.length; i++) {
				sb.append(String.valueOf(images[i]));

				if ((i + 1) < images.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (lowStockThreshold != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lowStockThreshold\": ");

			sb.append(lowStockThreshold);
		}

		if (margin != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"margin\": ");

			sb.append("\"");

			sb.append(_escape(margin));

			sb.append("\"");
		}

		if (maximumOrderQuantity != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"maximumOrderQuantity\": ");

			sb.append(maximumOrderQuantity);
		}

		if (minimumOrderQuantity != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"minimumOrderQuantity\": ");

			sb.append(minimumOrderQuantity);
		}

		if (offerPrice != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"offerPrice\": ");

			sb.append("\"");

			sb.append(_escape(offerPrice));

			sb.append("\"");
		}

		if (productSkuId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productSkuId\": ");

			sb.append(productSkuId);
		}

		if (publishingDate != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"publishingDate\": ");

			sb.append("\"");

			sb.append(_escape(publishingDate));

			sb.append("\"");
		}

		if (sellerSkuId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"sellerSkuId\": ");

			sb.append("\"");

			sb.append(_escape(sellerSkuId));

			sb.append("\"");
		}

		if (skuCreationName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"skuCreationName\": ");

			sb.append("\"");

			sb.append(_escape(skuCreationName));

			sb.append("\"");
		}

		if (skuId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"skuId\": ");

			sb.append("\"");

			sb.append(_escape(skuId));

			sb.append("\"");
		}

		if (stock != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stock\": ");

			sb.append(stock);
		}

		if (variants != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"variants\": ");

			sb.append("[");

			for (int i = 0; i < variants.length; i++) {
				sb.append(String.valueOf(variants[i]));

				if ((i + 1) < variants.length) {
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
		defaultValue = "com.marketplace.product.api.custom.dto.v1_0.Sku",
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