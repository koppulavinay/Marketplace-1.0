create index IX_CA3D2240 on marketplace_brand (assetCategoryId);
create index IX_3955E0B3 on marketplace_brand (brandApprovalStatus[$COLUMN_LENGTH:75$]);
create index IX_772BFCF9 on marketplace_brand (brandOwner[$COLUMN_LENGTH:75$]);
create index IX_98D37FA3 on marketplace_brand (brandReviewer);
create index IX_3F787016 on marketplace_brand (createdBy);
create index IX_5D346D4D on marketplace_brand (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F7A1E30F on marketplace_brand (uuid_[$COLUMN_LENGTH:75$], groupId);