create index IX_D6CD36BB on SW_AccountEntry (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E3859066 on SW_AccountEntry (email[$COLUMN_LENGTH:75$]);
create index IX_B559EA61 on SW_AccountEntry (phoneNumber[$COLUMN_LENGTH:75$]);
create index IX_5217FEE4 on SW_AccountEntry (username[$COLUMN_LENGTH:75$], password_[$COLUMN_LENGTH:75$]);
create index IX_A412089A on SW_AccountEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_73D7ED9C on SW_AccountEntry (uuid_[$COLUMN_LENGTH:75$], groupId);