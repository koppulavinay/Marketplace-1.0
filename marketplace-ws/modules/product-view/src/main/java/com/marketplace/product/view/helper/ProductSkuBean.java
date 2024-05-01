package com.marketplace.product.view.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductSkuBean {

	private String skuName;
	private Long productSKUId;
	private Long draftProductId;
	private String skuId;
	private String sellerSkuId;
	private String defaultSku;
	private BigDecimal basePrice;
	private BigDecimal offerPrice;
	private BigDecimal cost;
	private BigDecimal margin;
	private long stock;
	private String uom;
	private Long minimumOrderQuantity;
	private Long maximumOrderQuantity;
	private Long lowStockThreshold;
	private String tax;
	private Date skuPublishingDate;
	private Date skuExpiryDate;
	private List productMediaSkuLst = new ArrayList<>();
	private List cpTaxCategoryLst = new ArrayList<>();
	private String skuCreationName;

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public List getProductMediaSkuLst() {
		return productMediaSkuLst;
	}

	public void setProductMediaSkuLst(List productMediaSkuLst) {
		this.productMediaSkuLst = productMediaSkuLst;
	}

	public Long getProductSKUId() {
		return productSKUId;
	}

	public void setProductSKUId(Long productSKUId) {
		this.productSKUId = productSKUId;
	}

	public Long getDraftProductId() {
		return draftProductId;
	}

	public void setDraftProductId(Long draftProductId) {
		this.draftProductId = draftProductId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getSellerSkuId() {
		return sellerSkuId;
	}

	public void setSellerSkuId(String sellerSkuId) {
		this.sellerSkuId = sellerSkuId;
	}

	public String getDefaultSku() {
		return defaultSku;
	}

	public void setDefaultSku(String defaultSku) {
		this.defaultSku = defaultSku;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(BigDecimal offerPrice) {
		this.offerPrice = offerPrice;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Long getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(Long minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	public Long getMaximumOrderQuantity() {
		return maximumOrderQuantity;
	}

	public void setMaximumOrderQuantity(Long maximumOrderQuantity) {
		this.maximumOrderQuantity = maximumOrderQuantity;
	}

	public Long getLowStockThreshold() {
		return lowStockThreshold;
	}

	public void setLowStockThreshold(Long lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Date getSkuPublishingDate() {
		return skuPublishingDate;
	}

	public void setSkuPublishingDate(Date skuPublishingDate) {
		this.skuPublishingDate = skuPublishingDate;
	}

	public Date getSkuExpiryDate() {
		return skuExpiryDate;
	}

	public void setSkuExpiryDate(Date skuExpiryDate) {
		this.skuExpiryDate = skuExpiryDate;
	}

	public List getCpTaxCategoryLst() {
		return cpTaxCategoryLst;
	}

	public void setCpTaxCategoryLst(List cpTaxCategoryLst) {
		this.cpTaxCategoryLst = cpTaxCategoryLst;
	}

	public String getSkuCreationName() {
		return skuCreationName;
	}

	public void setSkuCreationName(String skuCreationName) {
		this.skuCreationName = skuCreationName;
	}

	@Override
	public String toString() {
		return "ProductSkuBean [skuName=" + skuName + ", productSKUId=" + productSKUId + ", draftProductId="
				+ draftProductId + ", skuId=" + skuId + ", sellerSkuId=" + sellerSkuId + ", defaultSku=" + defaultSku
				+ ", basePrice=" + basePrice + ", offerPrice=" + offerPrice + ", cost=" + cost + ", margin=" + margin
				+ ", stock=" + stock + ", uom=" + uom + ", minimumOrderQuantity=" + minimumOrderQuantity
				+ ", maximumOrderQuantity=" + maximumOrderQuantity + ", lowStockThreshold=" + lowStockThreshold
				+ ", tax=" + tax + ", skuPublishingDate=" + skuPublishingDate + ", skuExpiryDate=" + skuExpiryDate
				+ ", productMediaSkuLst=" + productMediaSkuLst + ", cpTaxCategoryLst=" + cpTaxCategoryLst
				+ ", skuCreationName=" + skuCreationName + "]";
	}

}
