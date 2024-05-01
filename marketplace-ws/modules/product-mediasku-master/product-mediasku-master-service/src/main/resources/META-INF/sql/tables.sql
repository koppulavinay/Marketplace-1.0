create table marketplace_product_mediasku (
	uuid_ VARCHAR(75) null,
	ProductMediaSKUId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	createdBy LONG,
	modifiedDate DATE null,
	modifiedBy LONG,
	ipAddress VARCHAR(75) null,
	draftProductId LONG,
	productSKUId LONG,
	imageUrl VARCHAR(255) null,
	fileEntryId LONG
);