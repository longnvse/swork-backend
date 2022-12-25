create index IX_D26CEB07 on SW_Phase (businessId, projectId, phaseName[$COLUMN_LENGTH:100$]);
create index IX_F2189A1B on SW_Phase (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_10D9557E on SW_Phase (projectId);
create index IX_82502BFA on SW_Phase (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A00768FC on SW_Phase (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8113123B on SW_PhaseManage (phaseId);