CREATE DATABASE springsecuritydemo;

use springsecuritydemo;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(500) NOT NULL,
	enabled INT NOT NULL,
	PRIMARY KEY (id),
	INDEX (username)
);


CREATE TABLE authorities (
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);
