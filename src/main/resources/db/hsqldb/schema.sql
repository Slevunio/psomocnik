DROP TABLE users IF EXISTS;
DROP TABLE pets IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  user_name VARCHAR(30),
  email  VARCHAR(30),
  user_type VARCHAR(30),
  created TIMESTAMP,
  last_changed TIMESTAMP
);

CREATE TABLE pets (
    id INTEGER IDENTITY PRIMARY KEY,
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
