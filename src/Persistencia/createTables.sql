/**
 * Author:  Pedro e Daniel
 */

CREATE TABLE IF NOT EXISTS cliente(
    idCliente INTEGER AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf INTEGER(11),
    endereco VARCHAR(255) NOT NULL,
    numero INTEGER NOT NULL,
    nomeMae VARCHAR(255)
    PRIMARY KEY(idCliente)
);

CREATE TABLE IF NOT EXISTS venda(
    idVenda INTEGER AUTO_INCREMENT,
    nomeMercadoria VARCHAR(255) NOT NULL,
    valorMercadoria DOUBLE NOT NULL,
    numParcelas INTEGER NOT NULL,
    valorParcelas DOUBLE NOT NULL,
    dataVenda DATE NOT NULL,
    idCliente INTEGER NOT NULl,
    PRIMARY KEY(idVenda),
    FOREIGN KEY(idCliente) REFERENCES cliente (idCliente)
    
);    

CREATE TABLE IF NOT EXISTS vendedor(
    nome VARCHAR(255) NOT NULL,
    cpf INTEGER NOT NULL,
    senha VARCHAR(255) NOT NULL
);


    

