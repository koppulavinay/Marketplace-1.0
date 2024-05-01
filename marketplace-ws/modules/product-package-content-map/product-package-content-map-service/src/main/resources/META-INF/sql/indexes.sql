create index IX_528DFBD5 on marketplace_prod_pkg_content (draftProductId);
create index IX_32FDF2CC on marketplace_prod_pkg_content (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A8BCBC4E on marketplace_prod_pkg_content (uuid_[$COLUMN_LENGTH:75$], groupId);