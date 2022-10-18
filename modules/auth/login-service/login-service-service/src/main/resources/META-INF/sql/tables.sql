create table SW_TokenEntry (
	uuid_ VARCHAR(75) null,
	tokenId LONG not null primary key,
	accountId LONG,
	businessId LONG,
	userName VARCHAR(75) null,
	refreshToken VARCHAR(75) null,
	expiryDate DATE null,
	issuedDate DATE null,
	refreshedDate DATE null,
	userAgent VARCHAR(200) null,
	clientIp VARCHAR(75) null,
	firstLoginDate DATE null,
	sessionId VARCHAR(75) null,
	remember BOOLEAN
);