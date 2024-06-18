-- drop schema if exists urecadb;
-- create schema if not exists urecadb
-- character set utf8mb4	collate utf8mb4_0900_as_cs;



use urecadb;

drop table if exists book;


create table if not exists book(
	num varchar(10) primary key,
    title varchar(20) not null,
    price int default 0
);

insert into book values("101","자바",1000);
insert into book values("102","알고",2000);
insert into book values("103","자료",3000);
commit; 

select * from book;