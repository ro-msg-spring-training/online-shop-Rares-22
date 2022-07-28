create table if not exists `revenue`(
    id int not null ,
    location int not null references location(id),
    dataRevenue date not null ,
    sum numeric not null
)