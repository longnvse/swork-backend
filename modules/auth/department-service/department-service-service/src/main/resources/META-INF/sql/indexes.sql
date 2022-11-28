create index IX_C1464008 on SW_Department (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_BA7A2E32 on SW_Department (name[$COLUMN_LENGTH:100$]);
create index IX_44594BE7 on SW_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_67C1A029 on SW_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B88B6F9B on SW_DepartmentAccount (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E0988D47 on SW_DepartmentAccount (departmentId);
create index IX_D81E017A on SW_DepartmentAccount (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_724C9E7C on SW_DepartmentAccount (uuid_[$COLUMN_LENGTH:75$], groupId);