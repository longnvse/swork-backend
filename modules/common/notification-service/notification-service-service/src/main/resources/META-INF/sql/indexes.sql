create index IX_62230261 on SW_Notification (companyId, externalReferenceCode[$COLUMN_LENGTH:75$]);
create index IX_8703103F on SW_Notification (receiverId, status[$COLUMN_LENGTH:75$], businessId);
create index IX_94920C8B on SW_Notification (subjectId);
create index IX_51CFE040 on SW_Notification (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D25376C2 on SW_Notification (uuid_[$COLUMN_LENGTH:75$], groupId);