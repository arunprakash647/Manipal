create database uniformm;


use uniformm;

create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 

create table product(
productname varchar(50) not null,
metatagtitle varchar(50),
model varchar(50),
price varchar(50),
quantity varchar(50),
category varchar(50));

insert into product values("Socks", "White Socks","SCK-014","200","20","15"); 
