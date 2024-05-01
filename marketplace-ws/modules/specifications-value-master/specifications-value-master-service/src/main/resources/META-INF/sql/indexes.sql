create index IX_ABBA2426 on marketplace_SpecificationValue (specificationId);
create index IX_FD6FFBFC on marketplace_SpecificationValue (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_997F517E on marketplace_SpecificationValue (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_A0E67026 on marketplace_specificationvalue (specificationId);
create index IX_ADCD2FFC on marketplace_specificationvalue (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_6799857E on marketplace_specificationvalue (uuid_[$COLUMN_LENGTH:75$], groupId);