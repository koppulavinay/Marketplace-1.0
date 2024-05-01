create index IX_4FA8EEEC on marketplace_product_sku (draftProductId, defaultSku[$COLUMN_LENGTH:75$]);
create index IX_10E1B79C on marketplace_product_sku (draftProductId, skuName[$COLUMN_LENGTH:75$]);
create index IX_ED2FFF89 on marketplace_product_sku (skuId[$COLUMN_LENGTH:75$]);
create index IX_6C757393 on marketplace_product_sku (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_ADDBC2D5 on marketplace_product_sku (uuid_[$COLUMN_LENGTH:75$], groupId);