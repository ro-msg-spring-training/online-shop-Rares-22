create table if not exists `stock`(
    product int not null references product(id),
    location int not null references location(id),
    quantity int not null
);