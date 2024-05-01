create table marketplace_product_keywords (
	uuid_ VARCHAR(75) null,
	searchKeywordId LONG not null primary key,
	groupId LONG,
	searchKeyword VARCHAR(75) null,
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