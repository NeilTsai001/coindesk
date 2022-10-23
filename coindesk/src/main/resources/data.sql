CREATE TABLE CURRENCY (
	ID INT NOT NULL PRIMARY KEY auto_increment, 
	CHINESE_NAME VARCHAR(255), 
	CREATE_TIME  TIMESTAMP,
	NAME VARCHAR(255),
	RATE DECIMAL(9, 4),
	UPDATE_TIME  TIMESTAMP
	);