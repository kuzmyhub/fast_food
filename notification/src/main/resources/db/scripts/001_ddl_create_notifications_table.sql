CREATE TABLE IF NOT EXISTS notifications(
id SERIAL PRIMARY KEY,
order_number INT,
status VARCHAR,
description VARCHAR,
created TIMESTAMP
);