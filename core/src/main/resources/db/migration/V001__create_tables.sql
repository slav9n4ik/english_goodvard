CREATE TABLE parent_user (
    id int primary key not null,
    name varchar(128) not null,
    surname varchar(128),
    middle_name varchar(128),
    email varchar(128),
    phone varchar(32) unique,
    description varchar(1000),
    status varchar(64),
    subscribe boolean,
    activation_code varchar(64),
    activated boolean,
    update_time timestamp
);

CREATE TABLE child_user (
    id int primary key not null,
    parent_id int,
    name varchar(128) not null,
    experience double precision,
    ages int,
    experience_in_current_school double precision,
    update_time timestamp,
    constraint parent_user_fk foreign key (parent_id) references parent_user (id) on delete cascade
);

CREATE TABLE video_order (
    id int primary key not null,
    name varchar(255) unique not null,
    url varchar(255) unique not null,
    price int not null,
    description varchar(1000)
);

CREATE TABLE orders_history (
    id int primary key not null,
    order_time timestamp not null,
    order_price int not null,
    parent_user_id int,
    order_id int,
    constraint parent_user_fk foreign key (parent_user_id) references parent_user (id) on delete cascade,
    constraint order_fk foreign key (order_id) references video_order (id) on delete cascade
);