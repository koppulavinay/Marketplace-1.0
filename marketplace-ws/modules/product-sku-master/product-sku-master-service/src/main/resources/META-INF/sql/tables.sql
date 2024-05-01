create table marketplace_product_sku (
	uuid_ VARCHAR(75) null,
	productSKUId LONG not null primary key,
	groupId LONG,
	draftProductId LONG,
	skuId VARCHAR(75) null,
	sellerSkuId VARCHAR(75) null,
	skuName VARCHAR(75) null,
	skuCreationName STRING null,
	defaultSku VARCHAR(75) null,
	basePrice DECIMAL(30, 16) null,
	offerPrice DECIMAL(30, 16) null,
	cost DECIMAL(30, 16) null,
	margin DECIMAL(30, 16) null,
	stock LONG,
	uom VARCHAR(75) null,
	minimumOrderQuantity LONG,
	maximumOrderQuantity LONG,
	lowStockThreshold LONG,
	tax VARCHAR(75) null,
	skuPublishingDate DATE null,
	skuExpiryDate DATE null,
	images VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG,
	ipAddress VARCHAR(75) null
);