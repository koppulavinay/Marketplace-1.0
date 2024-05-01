create index IX_A3DB5D7 on marketplace_product_spec_value (productSpecificationId, specificationValueLabelId);
create index IX_64F3496B on marketplace_product_spec_value (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4B052EAD on marketplace_product_spec_value (uuid_[$COLUMN_LENGTH:75$], groupId);