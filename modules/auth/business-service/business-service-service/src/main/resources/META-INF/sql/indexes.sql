create index IX_EF65B836 on SW_Business (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_5CB897CB on SW_Business (email[$COLUMN_LENGTH:75$]);
create index IX_53C61760 on SW_Business (name[$COLUMN_LENGTH:100$]);
create index IX_66C11206 on SW_Business (phoneNumber[$COLUMN_LENGTH:75$]);
create index IX_619AE015 on SW_Business (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_71667D7 on SW_Business (uuid_[$COLUMN_LENGTH:75$], groupId);