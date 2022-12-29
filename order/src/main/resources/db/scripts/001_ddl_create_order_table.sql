CREATE TABLE orders(
id SERIAL PRIMARY KEY,
amount INT,
address VARCHAR(150),
customer_id INT REFERENCES customers(id) NOT NULL,
courier_id INT REFERENCES couriers(id),
status VARCHAR,
created TIMESTAMP NOT NULL
);