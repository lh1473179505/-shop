create database shop;
use shop;

create table member(
	id int not null primary key auto_increment,
	userName varchar(20),
	trueName varchar(20),
	password varchar(20),
	city varchar(20),
	address varchar(100),
	postcode varchar(6),
	cardNO varchar(24),
	cardType varchar(20),
	grade int,
	Amount decimal(15,2),
	tel varchar(20),
	email varchar(100),
	freeze int
	
);

create table superType(
	id int not null primary key,
	TypeName varchar(50) not null
);

create table goods(
	id bigint not null primary key,
	typeID int not null,
	goodsName varchar(200) not null,
	introduce text,
	price decimal(15,2) not null,
	nowPrice decimal(15,2),
	picture varchar(100),
	INTime datetime,
	newGoods int not null default 0,
	sale int default 0,
	hit int default 0
);
create table cart0(
	id int not null primary key,
	
	number int not null default 0,
	picture varchar(100),
	goodsName varchar(200) not null,
	price decimal(15,2)
);

insert into goods values(1,1,"xiaodao","haibucuo",500,500,"11.jpg",now(),1,0,0);
insert into goods values(2,2,"xiaodao2","haibucuo",500,500,"12.jpg",now(),1,0,0);
insert into goods values(3,3,"xiaodao3","haibucuo",500,500,"13.jpg",now(),1,0,0);
insert into goods values(4,4,"xiaodao4","haibucuo",500,500,"14.jpg",now(),1,0,0);
insert into goods values(5,5,"xiaodao5","haibucuo",500,500,"15.jpg",now(),1,0,0);
insert into goods values(6,6,"xiaodao6","haibucuo",500,500,"16.jpg",now(),1,0,0);
insert into goods values(7,7,"xiaodao2","haibucuo",500,500,"17.jpg",now(),1,0,0);
insert into goods values(8,8,"xiaodao3","haibucuo",500,500,"18.jpg",now(),1,0,0);
insert into goods values(9,9,"xiaodao4","haibucuo",500,500,"19.jpg",now(),1,0,0);
insert into goods values(10,10,"xiaodao5","haibucuo",500,500,"25.jpg",now(),1,0,0);
insert into goods values(11,11,"xiaodao","haibucuo",500,500,"21.jpg",now(),1,0,0);
insert into goods values(12,12,"xiaodao2","haibucuo",500,500,"22.jpg",now(),1,0,0);
insert into goods values(13,13,"xiaodao3","haibucuo",500,500,"23.jpg",now(),1,0,0);
insert into goods values(14,14,"xiaodao4","haibucuo",500,500,"24.jpg",now(),1,0,0);
insert into goods values(15,15,"xiaodao5","haibucuo",500,500,"35.jpg",now(),1,0,0);

insert into goods values(31,31,"xiaodao","haibucuo",500,500,"11.jpg",now(),0,1,0);
insert into goods values(32,32,"xiaodao2","haibucuo",500,500,"12.jpg",now(),0,1,0);
insert into goods values(33,33,"xiaodao3","haibucuo",500,500,"13.jpg",now(),0,1,0);
insert into goods values(34,34,"xiaodao4","haibucuo",500,500,"14.jpg",now(),0,1,0);
insert into goods values(35,35,"xiaodao5","haibucuo",500,500,"15.jpg",now(),0,1,0);
insert into goods values(36,36,"xiaodao6","haibucuo",500,500,"16.jpg",now(),0,1,0);
insert into goods values(37,37,"xiaodao2","haibucuo",500,500,"17.jpg",now(),0,1,0);
insert into goods values(38,38,"xiaodao3","haibucuo",500,500,"18.jpg",now(),0,1,0);
insert into goods values(39,39,"xiaodao4","haibucuo",500,500,"19.jpg",now(),0,1,0);
insert into goods values(40,40,"xiaodao5","haibucuo",500,500,"25.jpg",now(),0,1,0);
insert into goods values(41,41,"xiaodao","haibucuo",500,500,"21.jpg",now(),0,1,0);
insert into goods values(42,42,"xiaodao2","haibucuo",500,500,"22.jpg",now(),0,1,0);
insert into goods values(53,53,"xiaodao3","haibucuo",500,500,"23.jpg",now(),0,1,0);
insert into goods values(54,54,"xiaodao4","haibucuo",500,500,"24.jpg",now(),0,1,0);
insert into goods values(55,55,"xiaodao5","haibucuo",500,500,"35.jpg",now(),0,1,0);

insert into goods values(141,141,"xiaodao11","haibucuo",500,500,"21.jpg",now(),1,0,2);
insert into goods values(142,142,"xiaodao21","haibucuo",500,500,"22.jpg",now(),1,1,5);
insert into goods values(153,153,"xiaodao31","haibucuo",500,500,"23.jpg",now(),0,1,7);
insert into goods values(154,154,"xiaodao41","haibucuo",500,500,"24.jpg",now(),1,1,1);
insert into goods values(155,155,"xiaodao51","haibucuo",500,500,"35.jpg",now(),0,1,9);


create table orders(
	orderID bigint not null primary key,
	bnumber smallint,
	username varchar(15),
	receiveName varchar(15),
	address varchar(100),
	tel varchar(20),
	OrderDate datetime,
	bz varchar(200)
);

create table order_detial(
	id bigint not null primary key,
	orderID bigint not null,
	goodsID bigint not null ,
	price decimal(15,2) not null,
	number int not null,
	constraint foreign key(orderID) references orders(orderID)
	
);

create table manager(
	id int not null primary key,
	manager varchar(30) not null,
	pwd varchar(30) not null
);



