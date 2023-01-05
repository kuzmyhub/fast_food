insert into customers(username, phone, password, enabled, authority_id)
values ('admin', 86005956644, '$2a$10$2iedlpNKGh056b5MGpn2JuJIceIawrCnzYP849TbC7qyd637L0bje', true, 2)
ON CONFLICT DO NOTHING;