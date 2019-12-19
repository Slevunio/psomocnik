CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  user_name VARCHAR(30),
  email  VARCHAR(30),
  role_id INTEGER,
  password VARCHAR(100),
  created TIMESTAMPTZ,
  last_changed TIMESTAMPTZ
);

CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    role_name varchar(30)
);

ALTER TABLE users
    ADD CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE IF NOT EXISTS pets (
    id SERIAL PRIMARY KEY,
    pet_name VARCHAR(30),
    take_in_date timestamptz,
    last_changed timestamptz,
    species varchar(30),
    sex varchar(30),
    age integer,
    can_live_with_other_dogs varchar(30),
    can_live_with_other_cats varchar(30),
    can_live_with_kids varchar(30),
    activity integer,
    coat varchar(30),
    fur varchar(30),
    is_ill varchar(30),
    additional_notes varchar
);

CREATE TABLE IF NOT EXISTS photos (
    id SERIAL PRIMARY KEY,
    photo_name varchar(30),
    photo_type varchar(30),
    photo_data bytea,
    pet_id INTEGER NOT NULL 
);

ALTER TABLE
	photos ADD CONSTRAINT fk_photos_pet FOREIGN KEY (pet_id) REFERENCES pets (id);
