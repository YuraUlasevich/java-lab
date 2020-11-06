createdb scooter;
create table users (id serial, name varchar(30), email varchar(20), login varchar(10) unique, password varchar(256), phone varchar(20) unique, role varchar(10));
ALTER TABLE users ADD PRIMARY KEY (ID);
create table scooters (id serial primary key, location jsonb, flag boolean, producer varchar(20), brand varchar(20), charge_level numeric);
create table orders(id serial primary key, user_id integer references users, scooter_id integer references scooters);
