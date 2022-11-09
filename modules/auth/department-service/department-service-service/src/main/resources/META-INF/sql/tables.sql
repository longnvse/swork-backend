create table SW_Department (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	departmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedId LONG,
	modifiedDate DATE null,
	businessId LONG,
	name VARCHAR(75) null
);

create table SW_DepartmentAccount (
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	departmentAccountId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	departmentId LONG,
	accountId LONG
);