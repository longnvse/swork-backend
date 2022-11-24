create table SW_Resource (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	resourceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	businessId LONG,
	modifiedId LONG,
	workId LONG,
	phaseId LONG,
	projectId LONG,
	resourceTypeId LONG,
	resourceTypeName VARCHAR(75) null,
	teamId LONG,
	teamName VARCHAR(75) null,
	quantity DOUBLE,
	unit VARCHAR(75) null,
	dateResource DATE null,
	totalAmount LONG
);

create table SW_ResourceType (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	resourceTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	businessId LONG,
	modifiedId LONG,
	name VARCHAR(75) null,
	unit VARCHAR(75) null,
	parentId LONG
);

create table SW_Team (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	teamId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	businessId LONG,
	modifiedId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	isActive BOOLEAN,
	phaseId LONG,
	projectId LONG,
	totalIncoming LONG,
	totalSpending LONG
);

create table SW_TeamMember (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	teamMemberId LONG not null primary key,
	companyId LONG,
	memberId LONG,
	memberName VARCHAR(75) null,
	isAdmin BOOLEAN,
	teamId LONG
);