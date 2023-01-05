CREATE TABLE IF NOT EXISTS customers (
  id serial primary key,
  username VARCHAR(50) NOT NULL unique,
  phone VARCHAR(11) NOT NULL unique,
  password VARCHAR(100) NOT NULL,
  enabled boolean DEFAULT true,
  authority_id int NOT NULL REFERENCES authorities(id)
);

