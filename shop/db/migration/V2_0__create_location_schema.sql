create table if not exists `location`(
    id int primary key auto_increment,
    name varchar(50) not null ,
    addressCountry varchar(50) not null ,
    addressCity varchar(50) not null ,
    addressCounty varchar(50) not null ,
    addressStreetAddress varchar(50) not null
);