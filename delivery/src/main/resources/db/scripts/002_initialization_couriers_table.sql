INSERT INTO couriers(name, phone) VALUES
('Evgeniy', '88006008050'),
('Anna', '86009995522'),
('Oleg', '83005556070')
ON CONFLICT DO NOTHING;