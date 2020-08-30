DROP TABLE IF EXISTS customer;

DROP SEQUENCE IF EXISTS customer_seq;

CREATE SEQUENCE customer_seq START WITH 1;

CREATE TABLE customer (
                          id INTEGER PRIMARY KEY DEFAULT nextval('customer_seq'),
                          first_name VARCHAR(45),
                          last_name VARCHAR(45),
                          email VARCHAR(45)
);