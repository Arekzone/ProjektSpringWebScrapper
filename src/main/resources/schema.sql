create table Customers(
                          cid serial primary key,
                          c_fullname varchar(255),
                          city varchar(255),
                          sid int references Salesman(sid)

);
create table Salesman(
                         sid serial primary key,
                         s_fullname varchar(255),
                         city varchar(255)
);

create table Orders(
                       oid serial primary key,
                       amount_purchase decimal,
                       cid int references Customers(cid),
                       sid int references Salesman(sid),
                       s_fullname varchar(255),
                       c_fullname varchar(255)
);
insert into salesman values(1,'John','New York');
insert into salesman values(2,'Jane','New York');
insert into salesman values(3,'Jack','New York');
insert into salesman values(4,'Jill','New York');
insert into salesman values(5,'Joe','New York');

insert into customers values(1,'John','New York',1);
insert into customers values(2,'Jane','New York',2);
insert into customers values(3,'Jack','New York',3);
insert into customers values(4,'Jill','New York',4);
insert into customers values(5,'Joe','New York',5);

insert into orders values(1,100,1,1,'John','John');
insert into orders values(2,200,2,2,'Jane','Jane');
insert into orders values(3,300,3,3,'Jack','Jack');
insert into orders values(4,400,4,4,'Jill','Jill');
insert into orders values(5,500,5,5,'Joe','Joe');