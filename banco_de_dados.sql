CREATE DATABASE tarefasdb CHARSET="utf8mb4" COLLATE="utf8mb4_general_ci";

USE tarefasdb;

CREATE TABLE atividade(
idtarefa int auto_increment primary key,
titulo varchar(100) not null,
descricao text not null,
datainicio date  not null,
datatermino date not null,
estado enum("Aberta", "Finalizada")
);