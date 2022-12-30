CREATE TABLE payments(
id SERIAL PRIMARY KEY,
order_id INT REFERENCES orders(id),
created TIMESTAMP
);