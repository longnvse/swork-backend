create table SW_Project (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	projectId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedId LONG,
	name VARCHAR(75) null,
	code_ VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	budget LONG,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	progress INTEGER,
	actualTime DATE null,
	actualStart DATE null,
	progressType VARCHAR(75) null,
	businessId LONG
);

create table SW_ProjectMember (
	projectMemberId LONG not null primary key,
	projectId LONG,
	memberId LONG,
	memberType VARCHAR(75) null,
	type_ VARCHAR(75) null
);