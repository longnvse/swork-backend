create table SW_Phase (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	phaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	creatorId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	businessId LONG,
	modifiedId LONG,
	phaseName VARCHAR(100) null,
	startDate DATE null,
	endDate DATE null,
	status VARCHAR(75) null,
	description VARCHAR(500) null,
	progress LONG,
	projectId LONG
);

create table SW_PhaseManage (
	phaseManageId LONG not null primary key,
	phaseId LONG,
	accountId LONG
);