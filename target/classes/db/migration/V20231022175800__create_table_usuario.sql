create sequence usuario_seq start 1 increment 1;

create table usuario (
    id int8 not null,
    name varchar(255),
    birth_date date,
    cpf varchar(14),
    email varchar(255),
    password varchar(45) not null,
    PRIMARY KEY (id)
);