create index IX_2B59361D on marketplace_product_mediasku (draftProductId, productSKUId);
create index IX_4897E5E0 on marketplace_product_mediasku (productSKUId);
create index IX_5B4D2B37 on marketplace_product_mediasku (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F1C51379 on marketplace_product_mediasku (uuid_[$COLUMN_LENGTH:75$], groupId);