create user hr with password 'hr';
create database xe;

psql -U someuser -h 127.0.0.1 database

grant all privileges on database xe to hr;
grant all privileges on board to hr;

create table board (
	seq	integer,
	title varchar(100),
	writer varchar(100),
	content varchar(999),
	regDate date,
	cnt integer,
	PRIMARY KEY(seq)
);
