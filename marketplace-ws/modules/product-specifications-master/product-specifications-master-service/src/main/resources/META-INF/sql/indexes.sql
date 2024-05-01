create index IX_52376980 on marketplace_productspecs (draftProductId);
create index IX_EE02A1B7 on marketplace_productspecs (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A86629F9 on marketplace_productspecs (uuid_[$COLUMN_LENGTH:75$], groupId);