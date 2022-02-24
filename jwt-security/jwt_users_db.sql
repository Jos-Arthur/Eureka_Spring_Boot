DROP DATABASE demo_db;
DROP USER eceme_user1;
CREATE USER eceme_user1 with password 'password';
CREATE DATABASE demo_db with template=template0 owner=eceme_user1;
\connect demo_db;
alter default privileges grant all on tables to eceme_user1;
alter default privileges grant all on sequences to eceme_user1;

create table et_users(
user_id integer primary key not null,
first_name varchar(250) not null,
last_name varchar(250) not null,
email varchar(250) not null,
password varchar(250) not null
);

create table et_categories(
category_id integer primary key not null,
user_id integer not null,
title varchar(250) not null,
description varchar(250) not null
);
alter table et_categories add constraint cat_users_fk foreign key (user_id) references et_users(user_id);

create table et_transactions(
transaction_id integer primary key not null,
category_id integer not null,
user_id integer not null,
amount numeric(10,2) not null,
note varchar(250) not null,
transaction_date bigint not null
);
alter table et_transactions add constraint transactions_cat_fk foreign key (category_id) references et_categories(category_id);
alter table et_transactions add constraint transactions_users_fk foreign key (user_id) references et_users(user_id);

create sequence et_users_seq increment 1 start 1;
create sequence et_categories_seq increment 1 start 1;
create sequence et_transactions_seq increment 1 start 1000;