CREATE TABLE order_dishes(
id SERIAL PRIMARY KEY,
order_id INT REFERENCES orders(id),
dish_id INT REFERENCES dishes(id)
);