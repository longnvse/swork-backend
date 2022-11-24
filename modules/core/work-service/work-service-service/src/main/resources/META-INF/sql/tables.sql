create table SW_Work (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	workId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedId LONG,
	businessId LONG,
	projectId LONG,
	phaseId LONG,
	parentId LONG,
	parentReferenceCode VARCHAR(75) null,
	progress LONG,
	name VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	actualStartDate DATE null,
	actualEndDate DATE null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	percentage DOUBLE,
	progressType VARCHAR(75) null,
	unit VARCHAR(75) null,
	incompleteTask DOUBLE,
	complete DOUBLE
);

create table SW_WorkMember (
	workMemberId LONG not null primary key,
	workId LONG,
	memberId LONG,
	memberType VARCHAR(75) null,
	memberReferenceCode VARCHAR(75) null,
	type_ VARCHAR(75) null
);