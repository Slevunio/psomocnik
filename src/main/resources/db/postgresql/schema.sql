
CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  user_name VARCHAR(30),
  email  VARCHAR(30),
  role_id INTEGER REFERENCES roles(id),
  password VARCHAR(60),
  created TIMESTAMPTZ,
  last_changed TIMESTAMPTZ,
);
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    role_name varchar(30)
);
#ALTER TABLE users ADD CONSTRAINT fk_key_users_roles FOREIGN KEY (role_id) REFERENCES roles (id);

CREATE TABLE IF NOT EXISTS pets (
    id SERIAL PRIMARY KEY,
    pet_name VARCHAR(30),
    take_in_date TIMESTAMPTZ,
    last_changed TIMESTAMPTZ,
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

CREATE TABLE IF NOT EXISTS photos (
    id SERIAL PRIMARY KEY,
    photo_name varchar(30),
    photo_type varchar(30),
    photo_data bytea,
    pet_id INTEGER NOT NULL REFERENCES pets(id)
);

#ALTER TABLE photos ADD CONSTRAINT fk_photos_pet FOREIGN KEY (pet_id) REFERENCES pets (id);
