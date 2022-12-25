create index IX_A0D52AB9 on SW_Work (businessId, parentId, name[$COLUMN_LENGTH:100$]);
create index IX_D060C3FC on SW_Work (businessId, parentReferenceCode[$COLUMN_LENGTH:75$], name[$COLUMN_LENGTH:100$]);
create index IX_9F32C025 on SW_Work (businessId, phaseId);
create index IX_6E713902 on SW_Work (businessId, projectId, name[$COLUMN_LENGTH:100$]);
create index IX_6DF7702 on SW_Work (businessId, projectId, phaseId, name[$COLUMN_LENGTH:100$]);
create index IX_76527087 on SW_Work (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_7C330B0A on SW_Work (parentId, name[$COLUMN_LENGTH:100$]);
create index IX_8CC370B on SW_Work (parentReferenceCode[$COLUMN_LENGTH:75$], name[$COLUMN_LENGTH:100$]);
create index IX_19A6ED0D on SW_Work (phaseId, parentId);
create index IX_FECF62D1 on SW_Work (projectId, name[$COLUMN_LENGTH:100$]);
create index IX_D8CC9F2B on SW_Work (projectId, parentId);
create index IX_1567B16D on SW_Work (projectId, phaseId, parentId);
create index IX_50FC5A66 on SW_Work (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1A844268 on SW_Work (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_79B7B241 on SW_WorkMember (workId, memberType[$COLUMN_LENGTH:75$], type_[$COLUMN_LENGTH:75$]);
create index IX_D0554BA9 on SW_WorkMember (workId, type_[$COLUMN_LENGTH:75$]);