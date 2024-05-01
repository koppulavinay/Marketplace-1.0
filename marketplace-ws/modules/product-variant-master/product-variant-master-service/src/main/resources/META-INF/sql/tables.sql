create table marketplace_product_variant (
	uuid_ VARCHAR(75) null,
	productVariantId LONG not null primary key,
	groupId LONG,
	draftProductId LONG,
	variantName VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG,
	ipAddress VARCHAR(75) null
);