insert into authorities (authority)
values ('ROLE_USER') ON CONFLICT DO NOTHING;
insert into authorities (authority)
values ('ROLE_ADMIN') ON CONFLICT DO NOTHING;