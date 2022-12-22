create index IX_4E266471 on SW_FileManager (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_69D3CAF6 on SW_FileManager (fileId, businessId);
create index IX_62796250 on SW_FileManager (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_68963CD2 on SW_FileManager (uuid_[$COLUMN_LENGTH:75$], groupId);