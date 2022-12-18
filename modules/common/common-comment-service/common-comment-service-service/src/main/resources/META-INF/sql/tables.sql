create table SW_Comment (
	uuid_ VARCHAR(75) null,
	commentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	accountId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	businessId LONG,
	content VARCHAR(75) null,
	parentId LONG,
	classPkId LONG,
	classPKName VARCHAR(75) null
);