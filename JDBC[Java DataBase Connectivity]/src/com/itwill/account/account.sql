drop table account;
create table account(
		no number(10) primary key,
		owner varchar2(100) not null,
		balance number(10),
		iyul number(10,2));


insert into account values(1111,'KIM',34000,3.4);
insert into account values(2222,'KIM',34000,3.4);
insert into account values(3333,'KIM',34000,3.4);
insert into account values(4444,'LEE',12000,2.4);
insert into account values(5555,'PARK',77000,1.3);
insert into account values(6666,'CHOI',99000,2.9);
insert into account values(7777,'SIM',61000,1.8);
insert into account values(8888,'HONG',81000,4.8);
insert into account values(9999,'JAMES',38000,3.3);


commit;

select * from account where no=7777;
select * from account where owner='KIM';
select * from account;
delete account where no=1111;
update account set owner='JAVA',balance=9999,iyul=9.9 where no=2222; 




