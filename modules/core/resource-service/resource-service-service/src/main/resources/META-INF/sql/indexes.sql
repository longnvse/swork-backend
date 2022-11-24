create index IX_2567AC08 on SW_Resource (businessId, phaseId);
create index IX_972D56A6 on SW_Resource (businessId, projectId);
create index IX_22AE3F2A on SW_Resource (businessId, teamId);
create index IX_4C57063C on SW_Resource (businessId, workId, phaseId, projectId);
create index IX_845D2D84 on SW_Resource (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_8292B163 on SW_Resource (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_36CE34A5 on SW_Resource (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9EF44E77 on SW_ResourceType (businessId, name[$COLUMN_LENGTH:75$]);
create index IX_BFA747D1 on SW_ResourceType (businessId, parentId);
create index IX_A33A4F5E on SW_ResourceType (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_192C73D on SW_ResourceType (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2EADF8FF on SW_ResourceType (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D895F43A on SW_Team (businessId, name[$COLUMN_LENGTH:75$], phaseId);
create index IX_37EA5A58 on SW_Team (businessId, name[$COLUMN_LENGTH:75$], projectId);
create index IX_11904F59 on SW_Team (businessId, phaseId);
create index IX_1BBA69B7 on SW_Team (businessId, projectId);
create index IX_47C235D3 on SW_Team (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_A15837B2 on SW_Team (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_428F02B4 on SW_Team (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6EB8DD8D on SW_TeamMember (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_E6927171 on SW_TeamMember (teamId, isAdmin);
create index IX_2CF9936C on SW_TeamMember (uuid_[$COLUMN_LENGTH:75$], companyId);