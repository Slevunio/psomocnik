CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  user_name varchar(30),
  email varchar(30),
  user_type varchar(30),
  created TIMESTAMPTZ,
  last_changed TIMESTAMPTZ
);
