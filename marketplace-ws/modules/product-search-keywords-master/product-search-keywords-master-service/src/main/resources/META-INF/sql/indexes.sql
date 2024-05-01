create index IX_B0B065B1 on marketplace_product_keywords (draftProductId);
create index IX_922D55A8 on marketplace_product_keywords (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6DF262A on marketplace_product_keywords (uuid_[$COLUMN_LENGTH:75$], groupId);