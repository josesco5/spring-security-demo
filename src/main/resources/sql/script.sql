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

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(45) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    role VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (email),
    INDEX (email)
);

INSERT INTO customer(email, pwd, role) VALUES ('johndoe@example.com', '54321', 'admin');
