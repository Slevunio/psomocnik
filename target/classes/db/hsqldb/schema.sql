DROP TABLE roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE pets IF EXISTS;
DROP TABLE diseases IF EXISTS;
DROP TABLE pet_diseases IF EXISTS;
DROP TABLE photos IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  user_name VARCHAR(30),
  email  VARCHAR(30),
  role_id INTEGER,
  password VARCHAR(60),
  created TIMESTAMP,
  last_changed TIMESTAMP,
);
CREATE TABLE roles (
    id INTEGER IDENTITY PRIMARY KEY,
    role_name varchar(30)
);
ALTER TABLE users ADD CONSTRAINT fk_key_users_roles FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE pets (
    id INTEGER IDENTITY PRIMARY KEY,
    pet_name VARCHAR(30),
    take_in_date TIMESTAMP,
    last_changed TIMESTAMP,
    species VARCHAR(30),
    sex VARCHAR(30),
    age INTEGER,
    can_live_with_other_dogs VARCHAR(30),
    can_live_with_other_cats VARCHAR(30),
    can_live_with_kids VARCHAR(30),
    activity INTEGER,
    coat varchar(30),
    fur varchar(30),
    is_ill varchar(30),
    additional_notes longvarchar
);

CREATE TABLE diseases (
    id INTEGER IDENTITY PRIMARY KEY,
    disease_name varchar(30)

);

CREATE TABLE pet_diseases (
    pet_id INTEGER NOT NULL,
    disease_id INTEGER NOT NULL
);

ALTER TABLE pet_diseases ADD CONSTRAINT fk_pet_diseases_pet FOREIGN KEY (pet_id) REFERENCES pets (id);
ALTER TABLE pet_diseases ADD CONSTRAINT fk_pet_diseases_diseases FOREIGN KEY (disease_id) REFERENCES diseases (id);

CREATE TABLE photos (
    id INTEGER IDENTITY PRIMARY KEY,
    photo_name varchar(30),
    photo_type varchar(30),
    photo_data BLOB,
    pet_id INTEGER NOT NULL
);

ALTER TABLE photos ADD CONSTRAINT fk_photos_pet FOREIGN KEY (pet_id) REFERENCES pets (id);