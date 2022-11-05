create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C1464008 on SW_Department (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_BA7A2E32 on SW_Department (name[$COLUMN_LENGTH:75$]);
create index IX_44594BE7 on SW_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_67C1A029 on SW_Department (uuid_[$COLUMN_LENGTH:75$], groupId);