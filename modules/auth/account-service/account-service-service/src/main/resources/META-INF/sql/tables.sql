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