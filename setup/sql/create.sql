-- Project Name : MessageBoard
-- Date/Time    : 2015/08/26 16:40:58
-- Author       : vagrant
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- 
drop table if exists account cascade;

create table account (
  id integer not null
  , name character varying not null
  , constraint account_PKC primary key (id)
) ;

-- 
drop table if exists message cascade;

create table message (
  id integer not null
  , message character varying not null
  , fk_account integer not null
  , begin_datetime timestamp not null
  , end_datetime timestamp not null
  , constraint message_PKC primary key (id)
) ;

alter table message
  add constraint message_FK1 foreign key (fk_account) references account(id);



