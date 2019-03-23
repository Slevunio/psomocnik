CREATE TABLE IF NOT EXISTS vets (
  id SERIAL PRIMARY KEY,
  first_name varchar(30),
  last_name varchar(30)
);
CREATE INDEX IF NOT EXISTS idx_vets_last_name ON vets (last_name);

CREATE TABLE IF NOT EXISTS specialties (
  id SERIAL PRIMARY KEY,
  name varchar(80)
);
CREATE INDEX IF NOT EXISTS idx_specialties_name ON specialties (name);

CREATE TABLE IF NOT EXISTS vet_specialties (
  vet_id integer NOT NULL,
  specialty_id integer NOT NULL,
  FOREIGN KEY (vet_id) REFERENCES vets(id),
  FOREIGN KEY (specialty_id) REFERENCES specialties(id),
  CONSTRAINT unique_ids UNIQUE (vet_id,specialty_id)
);
CREATE TABLE IF NOT EXISTS types (
  id SERIAL PRIMARY KEY,
  name varchar(80)
);
CREATE INDEX IF NOT EXISTS idx_types_name ON types (name);

CREATE TABLE IF NOT EXISTS owners (
  id SERIAL PRIMARY KEY,
  first_name varchar(30),
  last_name varchar(30),
  address varchar(255),
  city varchar(80),
  telephone varchar(20)
);
CREATE INDEX IF NOT EXISTS idx_owners_last_name ON owners (last_name);

CREATE TABLE IF NOT EXISTS pets (
  id SERIAL PRIMARY KEY,
  name varchar(30),
  birth_date DATE,
  type_id integer,
  owner_id integer,
  FOREIGN KEY (owner_id) REFERENCES owners(id),
  FOREIGN KEY (type_id) REFERENCES types(id)
);
CREATE INDEX IF NOT EXISTS idx_pets_name ON pets (name);

CREATE TABLE IF NOT EXISTS visits (
  id SERIAL PRIMARY KEY,
  pet_id integer,
  visit_date DATE,
  description varchar(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id)
);
