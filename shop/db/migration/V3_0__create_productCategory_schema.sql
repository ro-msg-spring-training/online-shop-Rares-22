create  table if not exists `category`(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) not null,
    description varchar(50) not null
);