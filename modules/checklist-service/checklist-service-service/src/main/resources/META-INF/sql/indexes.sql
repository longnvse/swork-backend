create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1AA102E5 on SW_CHECKLIST_ChecklistEntry (name[$COLUMN_LENGTH:75$]);
create index IX_E27FAC1A on SW_CHECKLIST_ChecklistEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D058711C on SW_CHECKLIST_ChecklistEntry (uuid_[$COLUMN_LENGTH:75$], groupId);