DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS customer;

DROP SEQUENCE IF EXISTS customer_seq;

CREATE SEQUENCE customer_seq START WITH 1;

CREATE TABLE customer (
                          id INTEGER PRIMARY KEY DEFAULT nextval('customer_seq'),
                          first_name VARCHAR(45),
                          last_name VARCHAR(45),
                          email VARCHAR(45)
);

CREATE TABLE users (
    username VARCHAR(35) PRIMARY KEY NOT NULL,
    password VARCHAR(68) NOT NULL,
    enabled SMALLINT NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(35) NOT NULL,
    authority VARCHAR(35) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);