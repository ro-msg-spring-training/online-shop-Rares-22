create schema if not exists shop;

create table if not exists `customer` (
     id int primary key auto_increment,
     first_name nvarchar(60) not null,
     last_name nvarchar(60) not null,
     username nvarchar(60) not null,
     password nvarchar(60) not null,
     email nvarchar(120) not null
);


create table if not exists `location`(
    id int primary key auto_increment,
    name varchar(50) not null ,
    address_country varchar(50) not null ,
    address_city varchar(50) not null ,
    address_county varchar(50) not null ,
    address_street_address varchar(50) not null
);

create  table if not exists `category`(
    id int primary key auto_increment,
    name varchar(50) not null,
    description varchar(50) not null
);

create table if not exists `supplier`(
    id int primary key auto_increment,
    name varchar(50) not null
);

create table if not exists `product`(
    id int primary key auto_increment,
    name varchar(50) not null ,
    description varchar(50) not null ,
    price numeric not null ,
    weight double not null,
    category int not null references category(id),
    supplier int not null references supplier(id),
    image_url varchar(50) not null
);

create table if not exists product_order(
    id int primary key auto_increment,
    shipped_from int not null references location(id),
    customer int not null references customer(id),
    created_at date not null ,
    address_country varchar(50) not null ,
    address_city varchar(50) not null ,
    address_county varchar(50) not null ,
    address_street_address varchar(50) not null
);

create table if not exists `stock`(
    product int not null references product(id),
    location int not null references location(id),
    quantity int not null
);

create table if not exists `revenue`(
    id int not null ,
    location int not null references location(id),
    data_revenue date not null ,
    sum numeric not null
);

create table if not exists `order_detail`(
    product_order int not null references product_order(id),
    product int not null references product(id),
    quantity int not null
);