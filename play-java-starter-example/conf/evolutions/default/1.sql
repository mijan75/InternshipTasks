# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table student (
  id                            varchar(255) not null,
  name                          varchar(255),
  address                       varchar(255),
  phone                         varchar(255),
  email                         varchar(255),
  constraint pk_student primary key (id)
);


# --- !Downs

drop table if exists student;

