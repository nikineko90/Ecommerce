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
