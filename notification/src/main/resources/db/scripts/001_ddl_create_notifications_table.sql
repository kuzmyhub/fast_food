CREATE TABLE notifications(
id SERIAL PRIMARY KEY,
order_number INT,
status VARCHAR,
description VARCHAR,
created TIMESTAMP
);