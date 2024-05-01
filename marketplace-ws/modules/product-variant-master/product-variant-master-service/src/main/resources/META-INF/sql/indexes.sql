create index IX_378B399C on marketplace_product_variant (draftProductId, variantName[$COLUMN_LENGTH:75$]);
create index IX_4F3344FB on marketplace_product_variant (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_192ECE3D on marketplace_product_variant (uuid_[$COLUMN_LENGTH:75$], groupId);