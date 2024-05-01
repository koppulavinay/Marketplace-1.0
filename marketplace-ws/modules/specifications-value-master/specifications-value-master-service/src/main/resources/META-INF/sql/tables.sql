create table marketplace_specificationvalue (
	uuid_ VARCHAR(75) null,
	specificationValueId LONG not null primary key,
	groupId LONG,
	specificationId LONG,
	specificationValueLabel VARCHAR(75) null,
	specificationUOM VARCHAR(75) null,
	ipAddress VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG
);