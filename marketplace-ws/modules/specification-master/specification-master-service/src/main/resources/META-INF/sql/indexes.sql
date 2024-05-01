create index IX_55180A9 on marketplace_Specification (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_87641D6B on marketplace_Specification (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A0EE44D0 on marketplace_specification (specificationStatus[$COLUMN_LENGTH:75$]);
create index IX_C04900C9 on marketplace_specification (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_247D258B on marketplace_specification (uuid_[$COLUMN_LENGTH:75$], groupId);