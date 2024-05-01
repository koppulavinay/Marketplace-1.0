create index IX_C3FA6616 on marketplace_consigneedetails (parentCartId, orderItemId);
create index IX_BEBBF071 on marketplace_consigneedetails (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C6B7DF33 on marketplace_consigneedetails (uuid_[$COLUMN_LENGTH:75$], groupId);