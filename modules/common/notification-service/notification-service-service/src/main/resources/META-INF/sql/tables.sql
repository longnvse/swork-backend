create table SW_Notification (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	editorId LONG,
	category VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	receiverId LONG,
	projectId LONG
);