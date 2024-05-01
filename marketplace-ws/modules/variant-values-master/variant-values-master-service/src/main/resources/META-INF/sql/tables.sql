create table marketplace_variant_value (
	uuid_ VARCHAR(75) null,
	variantValueId LONG not null primary key,
	groupId LONG,
	productVariantId LONG,
	variantVal VARCHAR(75) null,
	draftProductId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG,
	ipAddress VARCHAR(75) null
);