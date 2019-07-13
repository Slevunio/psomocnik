CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  user_name varchar(30),
  email varchar(30),
  password varchar(30),
  user_role varchar(30),
  created TIMESTAMPTZ,
  last_changed TIMESTAMPTZ
);

CREATE TABLE IF NOT EXISTS pets (
    id SERIAL PRIMARY KEY,
    pet_name VARCHAR(30),
    take_in_date TIMESTAMP,
    species VARCHAR(30),
    sex VARCHAR(30),
    age INTEGER,
    can_live_with_other_dogs VARCHAR(30),
    can_live_with_other_cats VARCHAR(30),
    can_live_with_kids VARCHAR(30),
    activity INTEGER,
    diseases VARCHAR(150)
);
