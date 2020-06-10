create databases User;

use User;

create table User(
 id int(64) primary key auto_increment,
 name varchar(24) not null,
 text varchar(200) not null,
 datenow datetime ,
 dateedit datetime );
 
 
insert into User values(1,"test","test",20000706112409,20000706112409);