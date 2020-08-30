DELETE FROM customer;

ALTER SEQUENCE customer_seq RESTART WITH 1;

INSERT INTO customer(first_name, last_name, email)
VALUES ('David', 'Adams', 'david@gmail.com'),
       ('John', 'Doe', 'john@gmail.com'),
       ('Ajay', 'Rao', 'ajay@gmail.com'),
       ('Mary', 'Public', 'mary@gmail.com'),
       ('Maxwell', 'Dixon', 'maxwell@gmail.com');




