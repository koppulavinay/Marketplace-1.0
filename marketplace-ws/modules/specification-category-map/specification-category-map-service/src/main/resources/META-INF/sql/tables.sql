create table marketplace_speccategorymap (
	uuid_ VARCHAR(75) null,
	specCategoryMapId LONG not null primary key,
	specificationId LONG,
	categoryId LONG,
	isCategoryMandatory BOOLEAN,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG,
	ipAddress VARCHAR(75) null
);