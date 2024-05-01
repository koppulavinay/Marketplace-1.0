create table marketplace_brand (
	uuid_ VARCHAR(75) null,
	brandId LONG not null primary key,
	groupId LONG,
	assetCategoryId LONG,
	brandCode VARCHAR(75) null,
	brandName VARCHAR(75) null,
	brandDescription VARCHAR(75) null,
	brandOwner VARCHAR(75) null,
	brandReviewer LONG,
	brandType VARCHAR(75) null,
	externalReferenceId VARCHAR(75) null,
	brandApprovalStatus VARCHAR(75) null,
	reviewerRemarks VARCHAR(75) null,
	brandInactive BOOLEAN,
	brandImageUpload LONG,
	brandImageURL VARCHAR(75) null,
	managerRemarks VARCHAR(75) null,
	customAtr1 VARCHAR(75) null,
	customAtr2 VARCHAR(75) null,
	customAtr3 VARCHAR(75) null,
	customAtr4 VARCHAR(75) null,
	customAtr5 VARCHAR(75) null,
	customAtr6 VARCHAR(75) null,
	customAtr7 VARCHAR(75) null,
	customAtr8 VARCHAR(75) null,
	customAtr9 VARCHAR(75) null,
	customAtr10 VARCHAR(75) null,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	createdBy LONG,
	modifiedBy LONG,
	ipAddress VARCHAR(75) null,
	isActive BOOLEAN,
	downForSeller BOOLEAN,
	downForBuyer BOOLEAN,
	downForMaintenance BOOLEAN,
	userId LONG,
	userName VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);