create index IX_E5EE4C01 on marketplace_category (assetCategoryId);
create index IX_D06227ED on marketplace_category (assignManager, parentCategoryId);
create index IX_961FB377 on marketplace_category (assignReviewer, parentCategoryId);
create index IX_7593671F on marketplace_category (categoryApprovalStatus[$COLUMN_LENGTH:75$]);
create index IX_3061020E on marketplace_category (createdBy, parentCategoryId);
create index IX_8E500F56 on marketplace_category (parentCategoryId, categoryApprovalStatus[$COLUMN_LENGTH:75$]);
create index IX_B7A87BAC on marketplace_category (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AE33FD2E on marketplace_category (uuid_[$COLUMN_LENGTH:75$], groupId);