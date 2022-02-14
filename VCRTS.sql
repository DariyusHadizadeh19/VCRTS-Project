create schema vcrts;
use vcrts;
-- create tables --
create table vehicles(VIN int(17), model varchar(10), company int(10), ownerName varchar(30), ownerID int(9), constraint VIN_pk primary key (VIN));

create table compResourcePool( VIN int (17), status varchar(5), constraint VIN_fk foreign key (VIN) references vehicles(VIN));

create table clients(firstName varchar(15), lastName varchar(15), clientID int(9), constraint clientID_pk primary key (clientID));

create table jobs( clientID int(9), JIN int(9), task varchar(20), place varchar(6), assignedVIN int (17), status varchar(8), duration int(3), constraint JIN_pk primary key (JIN), constraint assignedVIN_fk foreign key(assignedVIN) references vehicles(VIN), constraint clientID_fk foreign key(clientID) references clients(clientID));