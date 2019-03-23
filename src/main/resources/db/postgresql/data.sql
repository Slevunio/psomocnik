INSERT INTO vets VALUES (DEFAULT, 'James', 'Carter') ON CONFLICT DO NOTHING;
INSERT INTO vets VALUES (DEFAULT, 'Helen', 'Leary') ON CONFLICT DO NOTHING;
INSERT INTO vets VALUES (DEFAULT, 'Linda', 'Douglas') ON CONFLICT DO NOTHING;
INSERT INTO vets VALUES (DEFAULT, 'Rafael', 'Ortega') ON CONFLICT DO NOTHING;
INSERT INTO vets VALUES (DEFAULT, 'Henry', 'Stevens') ON CONFLICT DO NOTHING;
INSERT INTO vets VALUES (DEFAULT, 'Sharon', 'Jenkins') ON CONFLICT DO NOTHING;

INSERT INTO specialties VALUES (DEFAULT, 'radiology') ON CONFLICT DO NOTHING;
INSERT INTO specialties VALUES (DEFAULT, 'surgery') ON CONFLICT DO NOTHING;
INSERT INTO specialties VALUES (DEFAULT, 'dentistry') ON CONFLICT DO NOTHING;

INSERT INTO vet_specialties VALUES (2, 1) ON CONFLICT DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 2) ON CONFLICT DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 3) ON CONFLICT DO NOTHING;
INSERT INTO vet_specialties VALUES (4, 2) ON CONFLICT DO NOTHING;
INSERT INTO vet_specialties VALUES (5, 1) ON CONFLICT DO NOTHING;

INSERT INTO types VALUES (DEFAULT, 'cat') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (DEFAULT, 'dog') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (DEFAULT, 'lizard') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (DEFAULT, 'snake') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (DEFAULT, 'bird') ON CONFLICT DO NOTHING;
INSERT INTO types VALUES (DEFAULT, 'hamster') ON CONFLICT DO NOTHING;

INSERT INTO owners VALUES (DEFAULT, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435') ON CONFLICT DO NOTHING;
INSERT INTO owners VALUES (DEFAULT, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487') ON CONFLICT DO NOTHING;

INSERT INTO pets VALUES (DEFAULT, 'Leo', '2000-09-07', 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Basil', '2002-08-06', 6, 2) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Rosy', '2001-04-17', 2, 3) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Jewel', '2000-03-07', 2, 3) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Iggy', '2000-11-30', 3, 4) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'George', '2000-01-20', 4, 5) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Samantha', '1995-09-04', 1, 6) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Max', '1995-09-04', 1, 6) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Lucky', '1999-08-06', 5, 7) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Mulligan', '1997-02-24', 2, 8) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Freddy', '2000-03-09', 5, 9) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Lucky', '2000-06-24', 2, 10) ON CONFLICT DO NOTHING;
INSERT INTO pets VALUES (DEFAULT, 'Sly', '2002-06-08', 1, 10) ON CONFLICT DO NOTHING;

INSERT INTO visits VALUES (DEFAULT, 7, '2010-03-04', 'rabies shot') ON CONFLICT DO NOTHING;
INSERT INTO visits VALUES (DEFAULT, 8, '2011-03-04', 'rabies shot') ON CONFLICT DO NOTHING;
INSERT INTO visits VALUES (DEFAULT, 8, '2009-06-04', 'neutered') ON CONFLICT DO NOTHING;
INSERT INTO visits VALUES (DEFAULT, 7, '2008-09-04', 'spayed') ON CONFLICT DO NOTHING;
