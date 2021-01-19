create database negozioabbigliamento;

use negozioabbigliamento;
create table articoli (
	id int primary key auto_increment,
    nome varchar(200),
    codicearticolo varchar(500),
    categoria varchar(200),
    prezzo double,
    colore varchar(200),
    taglia varchar(20),
    quantita int
);

select * from articoli;

create table utenti (
	id int primary key auto_increment,
    username varchar(50),
    password varchar(50),
    nome varchar(50),
    cognome varchar(50),
    indirizzo varchar(200)
);

select * from utenti;

create table acquisti(
	id int primary key auto_increment,
	idutente int,
    idarticolo int,
    importototale double,
    foreign key(idutente) references utenti(id),
    foreign key(idarticolo) references articoli(id)
);
