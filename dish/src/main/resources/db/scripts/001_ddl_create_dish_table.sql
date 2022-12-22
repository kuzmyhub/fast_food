CREATE TABLE dishes(
id SERIAL PRIMARY KEY,
name VARCHAR UNIQUE NOT NULL,
cost INT NOT NULL
);

comment on table dishes is 'Данные блюд предосталяемых рестораном';
comment on column dishes.name is 'Наименование блюда';
comment on column dishes.cost is 'Стоимость блюда';