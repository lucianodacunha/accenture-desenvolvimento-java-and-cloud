create table customer (
	id integer auto_increment primary key,
	nome varchar(50) not null,
	email varchar(50) not null unique
);


select * from customer;

insert into customer (nome, email) values ('Client1', 'client1@email.com');
insert into customer (nome, email) values ('Client2', 'client2@email.com');
insert into customer (nome, email) values ('Client3', 'client3@email.com');

commit;