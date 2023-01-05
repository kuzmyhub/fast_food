INSERT INTO couriers(name, number, dismissed) VALUES
('Evgeniy', '88006008050', false),
('Anna', '86009995522', false),
('Oleg', '83005556070', false)
ON CONFLICT DO NOTHING;