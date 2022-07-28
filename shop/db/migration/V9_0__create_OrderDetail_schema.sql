create table if not exists `OrderDetail`(
      productOrder int not null references productOrder(id),
      product int not null references product(id),
      quantity int not null
);