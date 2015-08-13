
-- Criando estrutura do banco de dados para geriador de tarefas
DROP DATABASE IF EXISTS gerente_tarefas;
CREATE DATABASE IF NOT EXISTS gerente_tarefas /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE gerente_tarefas;


DROP TABLE IF EXISTS tb_tarefas;
CREATE TABLE tb_tarefas (
	id_tarefa bigint(20) NOT NULL AUTO_INCREMENT,
	nome varchar(80) NOT NULL,
	responsavel varchar(80) NOT NULL,
	prazo date NOT NULL,
	PRIMARY KEY (id_tarefa)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

