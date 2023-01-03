CREATE TABLE dishes(
id SERIAL PRIMARY KEY,
name VARCHAR UNIQUE NOT NULL,
description VARCHAR NOT NULL,
cost INT NOT NULL,
photo BYTEA,
available BOOLEAN
);

comment on table dishes is 'Данные блюд предосталяемых рестораном';
comment on column dishes.name is 'Наименование блюда';
comment on column dishes.description is 'Описание блюда';
comment on column dishes.cost is 'Стоимость блюда';
comment on column dishes.photo is 'Фотография блюда';
comment on column dishes.available is 'Доступность блюда для клиентов';