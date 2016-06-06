create database db_frases;
use db_frases;

create table personajes(
	id int auto_increment,
    personaje varchar(30),
    primary key (id)
);

create table accion(
	id int auto_increment,
    accion varchar(50),
    primary key(id)
);

create table lugar(
	id int auto_increment,
    lugar varchar(50),
    primary key(id)
);

create table frases(
	id int auto_increment,
    idPersonaje int,
    idAccion int,
    idLugar int,
    frase text,
    foreign key(idPersonaje) references personajes(id),
    foreign key(idAccion) references accion(id),
    foreign key(idLugar) references lugar(id),
    primary key(id)
);
