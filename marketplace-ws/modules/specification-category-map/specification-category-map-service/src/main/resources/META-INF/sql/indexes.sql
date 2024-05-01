create index IX_667D2A82 on marketplace_speccategorymap (categoryId);
create index IX_A90E4A26 on marketplace_speccategorymap (specificationId, categoryId);
create index IX_B36F81C9 on marketplace_speccategorymap (uuid_[$COLUMN_LENGTH:75$], companyId);