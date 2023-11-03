create table clientes (
    id Bigint not null auto_increment,
    nome varchar(30) not null,
    sobrenome varchar(30) not null,
    cpf varchar(11) not null unique,
    email varchar(150) not null unique,
    data varchar(30) not null,
    cep varchar(11),
    rua varchar(100) not null,
    numero varchar(20) not null,
    bairro varchar(40) not null,
    cidade varchar(40) not null,
    uf varchar(2),
    primary key(id)
);
