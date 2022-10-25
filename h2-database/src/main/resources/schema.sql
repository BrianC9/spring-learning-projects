DROP TABLE IF EXISTS book;
create table book(
  id int auto_increment,
  title varchar(255) NOT NULL ,
  pages int NOT NULL ,
  author varchar(255) NOT NULL
);

insert into book(title, pages, author) values ( 'Spring boot: Introduction',300,'Mark Benton' );