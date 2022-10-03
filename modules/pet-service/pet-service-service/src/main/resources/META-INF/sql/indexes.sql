create index IX_2AA740C5 on SW_PetEntry (price);
create index IX_80FEBB68 on SW_PetEntry (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_124EFBEA on SW_PetEntry (uuid_[$COLUMN_LENGTH:75$], groupId);