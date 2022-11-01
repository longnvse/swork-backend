create table SW_AcccountPermision (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	companyId LONG,
	permisionId LONG,
	accountId LONG
);

create table SW_AccountEntry (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	accountId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	creatorId LONG,
	username VARCHAR(75) null,
	password_ VARCHAR(75) null,
	fullName VARCHAR(75) null,
	phoneNumber INTEGER,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	departmentId LONG,
	businessId LONG
);

create table SW_AccountPermission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	companyId LONG,
	permissionId LONG,
	accountId LONG
);

create table SW_Permision (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	companyId LONG,
	name VARCHAR(75) null
);

create table SW_PermisionDetail (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	companyId LONG,
	permisionId LONG,
	actionCode VARCHAR(75) null
);

create table SW_Permission (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	companyId LONG,
	name VARCHAR(75) null
);

create table SW_PermissionDetail (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	id_ LONG not null primary key,
	companyId LONG,
	permissionId LONG,
	actionCode VARCHAR(75) null
);