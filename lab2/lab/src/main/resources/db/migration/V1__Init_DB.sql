create sequence hibernate_sequence start 1 increment 1;
create table orders (id int8 not null, scooter_id int4, user_id int4, primary key (id));
create table scooters (id int8 not null, brand varchar(255), charge_level int4, flag boolean, location varchar(255), producer varchar(255), primary key (id));
create table user_role (user_id int8 not null, role varchar(255));
create table usr (id int8 not null, activation_code varchar(255), active boolean not null, email varchar(255), name varchar(255), password varchar(255), phone varchar(255), username varchar(255), primary key (id));
alter table if exists user_role add constraint user_role foreign key (user_id) references usr;