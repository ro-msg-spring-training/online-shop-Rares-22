create table if not exists `product`(
    id int primary key auto_increment,
    name varchar(50) not null ,
    description varchar(50) not null ,
    price numeric not null ,
    weight double not null,
    category int not null references category(id),
    supplier int not null references supplier(id),
    imageUrl varchar(50) not null
);