create table marketplace_product_spec_value (
	uuid_ VARCHAR(75) null,
	productSpecValueId LONG not null primary key,
	groupId LONG,
	productSpecificationId LONG,
	specificationValueLabelId LONG,
	specificationValueLabel VARCHAR(75) null,
	specificationValueUOM VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createdBy LONG,
	modifiedBy LONG,
	createDate DATE null,
	modifiedDate DATE null,
	ipAddress VARCHAR(75) null
);