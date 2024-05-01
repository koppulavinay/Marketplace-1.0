create index IX_3DA05316 on marketplace_variant_value (draftProductId, variantVal[$COLUMN_LENGTH:75$]);
create index IX_8683CE0E on marketplace_variant_value (productVariantId);
create index IX_B6296AFD on marketplace_variant_value (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8C1A8CBF on marketplace_variant_value (uuid_[$COLUMN_LENGTH:75$], groupId);