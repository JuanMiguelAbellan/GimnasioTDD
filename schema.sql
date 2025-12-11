drop database if exists gimnasio;
create database gimnasio;

use gimnasio;

create table jugador (
	id int auto_increment,
	dni varchar(10),
    nombre varchar(50),
    apellidos varchar(100),
    fecha_nacimiento date,
    resistencia int,
    velocidad int,
    recuperacion int,
    primary key (id, dni)
);

create table ejercicio(
	id int auto_increment primary key,
    titulo varchar(50),
    descripcion varchar(150),
    duracion double
);

create table entrenamiento(
	id int auto_increment primary key,
    fecha date
);