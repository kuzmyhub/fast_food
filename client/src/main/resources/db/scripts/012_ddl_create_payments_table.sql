CREATE TABLE IF NOT EXISTS payments(
id SERIAL PRIMARY KEY,
order_id INT REFERENCES orders(id),
created TIMESTAMP
);