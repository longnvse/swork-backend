create table FOO_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	taskId LONG,
	status BOOLEAN
);

create table SW_CHECKLIST_ChecklistEntry (
	uuid_ VARCHAR(75) null,
	checklistId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	taskId LONG,
	status BOOLEAN
);

create table SW_Checklist (
	uuid_ VARCHAR(75) null,
	checklistId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	taskId LONG,
	status BOOLEAN
);

create table SW_ChecklistHandler (
	uuid_ VARCHAR(75) null,
	checklistHandlerId LONG not null primary key,
	groupId LONG,
	checkListId LONG,
	accId LONG
);