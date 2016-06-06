create database db_frases;
use db_frases;

create table personajes(
	id int auto_increment,
    nombre varchar(30),
    primary key (id)
);

create table acciones(
	id int auto_increment,
    accion varchar(50),
    primary key(id)
);

create table lugares(
	id int auto_increment,
    lugar varchar(50),
    primary key(id)
);