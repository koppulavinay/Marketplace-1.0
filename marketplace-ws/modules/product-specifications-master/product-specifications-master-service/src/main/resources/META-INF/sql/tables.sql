create table marketplace_productspecs (
	uuid_ VARCHAR(75) null,
	productSpecificationId LONG not null primary key,
	groupId LONG,
	specificationId LONG,
	specificationLabel VARCHAR(75) null,
	specificationFieldType VARCHAR(75) null,
	draftProductId LONG,
	isMandatory BOOLEAN,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createdBy LONG,
	modifiedBy LONG,
	createDate DATE null,
	modifiedDate DATE null,
	ipAddress VARCHAR(75) null
);