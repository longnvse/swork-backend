create index IX_81705AC0 on SW_AcccountPermision (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_4BFD69F on SW_AcccountPermision (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_D6CD36BB on SW_AccountEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E3859066 on SW_AccountEntry (email[$COLUMN_LENGTH:75$]);
create index IX_5217FEE4 on SW_AccountEntry (username[$COLUMN_LENGTH:75$], password_[$COLUMN_LENGTH:75$]);
create index IX_A412089A on SW_AccountEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_73D7ED9C on SW_AccountEntry (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F13F1151 on SW_AccountPermission (accountId);
create index IX_65B74C7C on SW_AccountPermission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_2339C05B on SW_AccountPermission (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_F888AE4E on SW_Permision (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_67DD062D on SW_Permision (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_AF010BFF on SW_PermisionDetail (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_680E5DE on SW_PermisionDetail (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_2B70805 on SW_Permission (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_94CBADE4 on SW_Permission (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_B9DD0076 on SW_PermissionDetail (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_6090D59F on SW_PermissionDetail (permissionId);
create index IX_4A2AA855 on SW_PermissionDetail (uuid_[$COLUMN_LENGTH:75$], companyId);