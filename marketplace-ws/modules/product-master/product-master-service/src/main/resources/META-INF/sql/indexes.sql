create index IX_31F0E390 on marketplace_product (cpDefinitionId);
create index IX_CB7A97B5 on marketplace_product (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B6BF8777 on marketplace_product (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_D205814A on marketplace_product (vendorId[$COLUMN_LENGTH:75$], categoryId, organizationId[$COLUMN_LENGTH:75$], productStatus[$COLUMN_LENGTH:75$]);