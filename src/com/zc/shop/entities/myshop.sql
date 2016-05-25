drop database if exists myshop;

create database myshop default character set utf8;

use myshop;

drop table if exists SORDER;

drop table if exists PRODUCT;
drop table if exists CATEGORY;
drop table if exists ACCOUNT;

drop table if exists FORDER;

drop table if exists STATUS;
drop table if exists address;
drop table if exists customer;

create table customer (
	id integer not null auto_increment,
	name varchar(50),
	password varchar(20),
	sex varchar(2),
	phone varchar(12),
	email varchar(50),
	primary key(id)
);
create table FORDER (
/*
 * 
CREATE TABLE `forder` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  `TOTALAMOUNT` decimal(10,2) DEFAULT NULL,
  `POST` varchar(6) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `MESSAGE` varchar(255) DEFAULT NULL,
  `DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CUSTOMER` int(11) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_250wne83saja8couy26nqwvqv` (`CUSTOMER`),
  KEY `FK_lnc49aulrgv29rr5tpjaxoyk` (`STATUS`),
  CONSTRAINT `FK_lnc49aulrgv29rr5tpjaxoyk` FOREIGN KEY (`STATUS`) REFERENCES `st
atus` (`ID`),
  CONSTRAINT `FK_250wne83saja8couy26nqwvqv` FOREIGN KEY (`CUSTOMER`) REFERENCES
`customer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

 */
	id integer not null auto_increment,
	name varchar(50),
	phone varchar(12),
	message varchar(255),
	date timestamp default current_timestamp,
	totalAmount decimal(10,2),
	post varchar(6),
	address varchar(255),
	customer integer,
	primary key(id),
	foreign key(sorder) REFRENCES CUSTOMER(id)
);
create table ACCOUNT (
	id integer not null auto_increment,
	aname varchar(50),
	password varchar(20),
	primary key(id)
);

create table CATEGORY (
	id integer not null auto_increment,
	cname varchar(50),
	hot boolean,
	account int,
	primary key(id),
	foreign key(account) REFRENCES ACCOUNT(id)
);
create table PRODUCT (
	id integer not null auto_increment,
	name varchar(255),
	amount bigint,
	price decimal(10,2),
	picture varchar(255),
	date timestamp default current_timestamp,
	remark longtext,
	dremark longtext,
	commend boolean,
	category int,
	primary key(id),
	foreign key(category) REFRENCES CATEGORY(id)
);

create table SORDER (
	id integer not null auto_increment,
	name varchar(255),
	price decimal(8,2),
	amount integer,
	product integer,
	primary key(id),
	foreign key(product) REFRENCES PRODUCT(id)
);
create table STATUS (
	id integer not null auto_increment,
	status varchar(255),
	primary key(id),
);

select * FROM ACCOUNT;
select * FROM CATEGORY;
select * FROM PRODUCT;
select * FROM customer;
select * FROM forder;
select * FROM address;
select * FROM sorder;
select * FROM status;

insert into status values(null,'未处理');

/*
 * :::::::::::::::::customer::::::::::::::::::::::::
 */
insert into customer values(null,'user1','123','male','13541112333','user1@qq.com');

/*
 * :::::::::::::::::product::::::::::::::::::::::::
 */
insert into product values(null,'yanchao shan',999,0.01,'df','bastard','insane',null,true,4);
insert into product values(null,'yanchao shan',999,0.01,'df','bastard','insane',null,true,4);
insert into product values(null,'yanchao shan',999,0.01,'df','bastard','insane',null,true,4);


/*
 *:::::::::::修改字段类型:::::::::::::::::
 */
alter table forder change totalamount totalamount decimal(10,2);
/*
 * ::::::::::删除字段：::::::::::::
 */
alter table sorder drop column forder_id ; 

