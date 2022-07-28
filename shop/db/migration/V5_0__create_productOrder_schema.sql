create table if not exists `productOrder`(
      id int primary key auto_increment,
      shippedFrom int not null references location(id),
      customer int not null references customer(id),
      createdAt date not null ,
      addressCountry varchar(50) not null ,
      addressCity varchar(50) not null ,
      addressCounty varchar(50) not null ,
      addressStreetAddress varchar(50) not null
);