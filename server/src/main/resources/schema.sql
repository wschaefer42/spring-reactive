-- We have to create the Table by hand, because R2DBC to not generate it
DROP TABLE IF EXISTS guest;
CREATE TABLE guest
(
    id int auto_increment primary key ,
    name varchar(100) not null,
    town varchar(100) not null,
    message text
);
