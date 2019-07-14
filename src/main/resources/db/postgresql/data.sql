INSERT INTO users VALUES (1, 'Slevunio', 'slevunio@gmail.com', 'password', 'admin', '2019-05-01 00:00:00-07', '2019-05-01') ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (1, 'Fafik', '2019-05-11 00:00:00', 'Pies', 'M', '3', 'Tak', 'Nie', 'Tak', '8', 'Brak') ON CONFLICT DO NOTHING;
