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

/* create table frases(
	id int auto_increment,
    idPersonaje int,
    idAccion int,
    idLugar int,
    frase text,
    foreign key(idPersonaje) references personajes(id),
    foreign key(idAccion) references accion(id),
    foreign key(idLugar) references lugar(id),
    primary key(id)
); */


insert into personajes values (null,'Emilio');
insert into personajes values (null,'José');

insert into acciones values (null,'está comiendo');
insert into acciones values (null,'está durmiendo');

insert into lugares values (null,'en la Playa');
insert into lugares values (null,'en el Cerro');