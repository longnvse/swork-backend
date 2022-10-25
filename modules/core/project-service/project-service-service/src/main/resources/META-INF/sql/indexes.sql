create index IX_B5AD37CF on SW_Project (businessId, code_[$COLUMN_LENGTH:75$]);
create index IX_B4C79C92 on SW_Project (businessId, name[$COLUMN_LENGTH:75$]);
create index IX_F69C0779 on SW_Project (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_17661558 on SW_Project (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_29A411DA on SW_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_C74C5FE6 on SW_ProjectMember (projectId);