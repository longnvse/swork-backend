create index IX_89E385FA on SW_Comment (classPkId, classPKName[$COLUMN_LENGTH:75$]);
create index IX_C3F86C3 on SW_Comment (parentId);
create index IX_DC1F599E on SW_Comment (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_724DAFA0 on SW_Comment (uuid_[$COLUMN_LENGTH:75$], groupId);