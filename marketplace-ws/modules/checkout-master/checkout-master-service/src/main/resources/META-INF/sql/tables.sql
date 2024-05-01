create table marketplace_checkout (
	checkoutCustomId LONG not null primary key,
	commerceOrderId LONG,
	requestJson VARCHAR(75) null,
	responseJson VARCHAR(75) null,
	module VARCHAR(75) null,
	createDate DATE null
);