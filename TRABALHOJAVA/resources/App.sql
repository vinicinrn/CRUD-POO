-- Criação do banco de dados
CREATE DATABASE pessoas;
USE pessoas;

-- Criação da tabela pessoas
CREATE TABLE pessoas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);
