DELETE FROM users;
DELETE FROM authorities;
DELETE FROM customer;


ALTER SEQUENCE customer_seq RESTART WITH 1;

INSERT INTO customer(first_name, last_name, email)
VALUES ('David', 'Adams', 'david@gmail.com'),
       ('John', 'Doe', 'john@gmail.com'),
       ('Ajay', 'Rao', 'ajay@gmail.com'),
       ('Mary', 'Public', 'mary@gmail.com'),
       ('Maxwell', 'Dixon', 'maxwell@gmail.com');

INSERT INTO users(username, password, enabled)
VALUES ('alex', '$2a$04$25UJru4hShOSrNQidh3gQuFXp7QverxO2KkqEBXMgqWSuBADFJgI2', 1),
       ('david', '$2a$04$25UJru4hShOSrNQidh3gQuFXp7QverxO2KkqEBXMgqWSuBADFJgI2', 1),
       ('mary', '$2a$04$25UJru4hShOSrNQidh3gQuFXp7QverxO2KkqEBXMgqWSuBADFJgI2', 1);

INSERT INTO authorities(username, authority)
VALUES ('alex', 'ROLE_ADMIN'),
       ('david', 'ROLE_ADMIN'),
       ('alex', 'ROLE_USER'),
       ('david', 'ROLE_USER'),
       ('mary', 'ROLE_USER');




