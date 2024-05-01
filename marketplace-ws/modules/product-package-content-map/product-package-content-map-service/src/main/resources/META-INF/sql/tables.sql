create table marketplace_prod_pkg_content (
	uuid_ VARCHAR(75) null,
	packageContentId LONG not null primary key,
	groupId LONG,
	itemName VARCHAR(75) null,
	itemQuantity VARCHAR(75) null,
	draftProductId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createdBy LONG,
	modifiedBy LONG,
	createDate DATE null,
	modifiedDate DATE null,
	ipAddress VARCHAR(75) null
);