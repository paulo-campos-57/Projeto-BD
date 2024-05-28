CREATE TABLE USER (
    ID_USER INTEGER PRIMARY KEY AUTO_INCREMENT,
    USER_NAME VARCHAR(150) UNIQUE,
    SENHA VARCHAR(200) CHECK (LENGTH(SENHA) > 6),
    CONTATO1 VARCHAR(200),
    CONTATO2 VARCHAR(200),
    ESTADO VARCHAR(100),
    CIDADE VARCHAR(100),
    BAIRRO VARCHAR(100),
    RUA VARCHAR(100),
    NUMERO VARCHAR(10),
    COMPLEMENTO VARCHAR(100)
);

CREATE TABLE DENUNCIA(
    FK_ID_DENUNCIA INTEGER,
    FK_ID_DENUNCIADO INTEGER,
    COMENTARIO VARCHAR(1000),
    FOREIGN KEY (FK_ID_DENUNCIA) REFERENCES USER(ID_USER) ON DELETE CASCADE,
    FOREIGN KEY (FK_ID_DENUNCIADO) REFERENCES USER(ID_USER) ON DELETE CASCADE
);


CREATE TABLE MESTRE (
	FK_ID_USER INTEGER PRIMARY KEY,
	NPC VARCHAR(300),
	MONSTRO VARCHAR(300),
	FOREIGN KEY(FK_ID_USER) REFERENCES USER(ID_USER) on delete CASCADE
);

CREATE TABLE JOGADOR (
	FK_ID_USER INTEGER PRIMARY KEY,
	FOREIGN KEY(FK_ID_USER) REFERENCES USER(ID_USER) on delete CASCADE
);


CREATE TABLE PERSONAGEM (
    ID_PERSONAGEM INTEGER PRIMARY key AUTO_INCREMENT,
    NOME VARCHAR(100),
    CLASSE VARCHAR(50),
    NIVEL INTEGER,
    HABILIDADES VARCHAR(1000),
    BACKSTORY VARCHAR(3000),
    FK_ID_JOGADOR INTEGER,
    FOREIGN KEY (FK_ID_JOGADOR) REFERENCES JOGADOR(FK_ID_USER) ON DELETE CASCADE
);


CREATE TABLE HISTORIA (
    ID_HISTORIA INTEGER PRIMARY key AUTO_INCREMENT,
    NOME VARCHAR (100),
    PROLOGO VARCHAR (2000),
    QTD_JOGADORES INTEGER,
    DT_INICIO DATE,
    PRESENCIAL BOOL DEFAULT FALSE,
    FK_ID_MESTRE INTEGER,
    # Caso um mestre seja deletado, todas as suas histórias são deletadas também
    FOREIGN KEY (FK_ID_MESTRE) REFERENCES MESTRE (FK_ID_USER) ON DELETE CASCADE
);	

ALTER TABLE HISTORIA MODIFY QTD_JOGADORES INTEGER DEFAULT 0;

CREATE TABLE PARTICIPACAO (
    FK_ID_PERSONAGEM INTEGER,
    FK_ID_MESTRE INTEGER,
    FK_ID_HISTORIA INTEGER,
    PRIMARY KEY (FK_ID_PERSONAGEM, FK_ID_MESTRE, FK_ID_HISTORIA),
    FOREIGN KEY (FK_ID_PERSONAGEM) REFERENCES PERSONAGEM (ID_PERSONAGEM) on delete CASCADE,
    FOREIGN KEY (FK_ID_MESTRE) REFERENCES MESTRE (FK_ID_USER) ON DELETE CASCADE,
    FOREIGN KEY (FK_ID_HISTORIA) REFERENCES HISTORIA (ID_HISTORIA) ON DELETE CASCADE
);


CREATE TABLE PRODUTO (
	ID_PRODUTO INTEGER PRIMARY key AUTO_INCREMENT,
	NOME_PRODUTO VARCHAR(100),
	DESCRICAO VARCHAR(500),
	PRECO DOUBLE,
	FK_ID_USER INTEGER,
	FOREIGN KEY (FK_ID_USER) REFERENCES USER(ID_USER) ON DELETE CASCADE
);

CREATE TABLE DADO (
	ID_DADO INTEGER PRIMARY KEY,
	QTD_LADOS INTEGER,
	FOREIGN KEY (ID_DADO) REFERENCES PRODUTO (ID_PRODUTO)
);

ALTER TABLE DADO
RENAME COLUMN ID_DADO TO FK_ID_PRODUTO;

CREATE TABLE LIVRO (
	ID_LIVRO INTEGER PRIMARY KEY,
	QTD_PAGINAS INTEGER,
	ESTADO DOUBLE,
	FOREIGN KEY (ID_LIVRO) REFERENCES PRODUTO (ID_PRODUTO)
);

ALTER TABLE LIVRO
RENAME COLUMN ID_LIVRO TO FK_ID_PRODUTO;

CREATE TABLE VENDA (
    ID_VENDA INTEGER PRIMARY KEY AUTO_INCREMENT,
    FK_ID_PRODUTO INTEGER,
    FK_ID_USER INTEGER,
    DATA_VENDA DATE,
    FOREIGN KEY (FK_ID_PRODUTO) REFERENCES PRODUTO(ID_PRODUTO),
    FOREIGN KEY (FK_ID_USER) REFERENCES USER(ID_USER)
);

CREATE TABLE COMPRA (
    ID_COMPRA INTEGER PRIMARY KEY AUTO_INCREMENT,
    FK_ID_PRODUTO INTEGER,
    FK_ID_USER INTEGER,
    DATA_COMPRA DATE,
    FOREIGN KEY (FK_ID_PRODUTO) REFERENCES PRODUTO(ID_PRODUTO),
    FOREIGN KEY (FK_ID_USER) REFERENCES USER(ID_USER)
);

DELIMITER //

CREATE TRIGGER update_qtd_jogadores
AFTER INSERT ON PARTICIPACAO
FOR EACH ROW
BEGIN
    DECLARE qtd_jogadores_atual INTEGER;
    SET qtd_jogadores_atual = (SELECT QTD_JOGADORES FROM HISTORIA WHERE ID_HISTORIA = NEW.FK_ID_HISTORIA);
    
    IF qtd_jogadores_atual IS NULL THEN
        SET qtd_jogadores_atual = 1;
    ELSE
        SET qtd_jogadores_atual = qtd_jogadores_atual + 1;
    END IF;
    
    UPDATE HISTORIA SET QTD_JOGADORES = qtd_jogadores_atual WHERE ID_HISTORIA = NEW.FK_ID_HISTORIA;
END;
//

DELIMITER ;

INSERT INTO USER (USER_NAME, SENHA, CONTATO1, CONTATO2, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, COMPLEMENTO) VALUES
('João Silva', 'senha12345', '81987654321', '81912345678', 'Pernambuco', 'Recife', 'Boa Viagem', 'Av. Boa Viagem', '123', 'Apto 101'),
('Carlos Aroldo', 'senha54321', '81912348765', '81987651234', 'Pernambuco', 'Olinda', 'Casa Caiada', 'Rua das Flores', '456', 'Casa 1'),
('Ana Rodolfa', 'senha67890', '81987650987', '81912347654', 'Paraíba', 'João Pessoa', 'Manaíra', 'Rua', '514', 'Apto 401'),
('Maria Souza', 'senha98765', '81911223344', '81955667788', 'Pernambuco', 'Recife', 'Casa Forte', 'Av. 17 de Agosto', '789', 'Casa 2'),
('José Lima', 'senha11223', '81999887766', '81933445566', 'Pernambuco', 'Jaboatão', 'Piedade', 'Rua X', '321', 'Apto 203'),
('Luciana Borges', 'senha44556', '81966778899', '81922334455', 'Pernambuco', 'Caruaru', 'Centro', 'Rua Y', '654', 'Casa 3'),
('Fernando Alves', 'senha55667', '81988990011', '81911221122', 'Pernambuco', 'Paulista', 'Jardim Paulista', 'Av. Z', '987', 'Apto 305'),
('Paula Melo', 'senha33445', '81999887755', '81966778822', 'Pernambuco', 'Garanhuns', 'Heliópolis', 'Rua A', '147', 'Casa 4'),
('Ricardo Neves', 'senha77889', '81922334466', '81999887744', 'Paraíba', 'Campina Grande', 'Catolé', 'Rua B', '258', 'Apto 502'),
('Carla Farias', 'senha99000', '81955667733', '81988990022', 'Paraíba', 'Patos', 'Centro', 'Rua C', '369', 'Casa 5'),
('Bruno Dias', 'senha12300', '81966778811', '81933445577', 'Paraíba', 'Cabedelo', 'Praia Formosa', 'Av. D', '741', 'Apto 601'),
('Fernanda Costa', 'senha44500', '81999887722', '81922334499', 'Pernambuco', 'Olinda', 'Carmo', 'Rua E', '852', 'Casa 6'),
('Rodrigo Silva', 'senha55600', '81911221144', '81966778833', 'Pernambuco', 'Igarassu', 'Centro', 'Av. F', '963', 'Apto 104');

INSERT INTO MESTRE (FK_ID_USER, NPC, MONSTRO) VALUES
(1, 'Gandalf', 'Smaug'),
(4, 'Merlin', 'Dragon'),
(7, 'Berend Gemviper', 'Tarrasque'),
(9, 'Orion', 'Gigante de gelo');

INSERT INTO JOGADOR (FK_ID_USER) VALUES
(2),
(3),
(5),
(6),
(7),
(8),
(10),
(11),
(12),
(13);


INSERT INTO PERSONAGEM (NOME, CLASSE, NIVEL, HABILIDADES, BACKSTORY, FK_ID_JOGADOR) VALUES
('Aragorn', 'Guerreiro', 10, 'Espada Longa, Defesa', 'Filho do rei exilado, busca retomar seu trono.', 2),
('Legolas', 'Arqueiro', 9, 'Arco e Flecha, Agilidade', 'Elfo habilidoso com arco, membro da Sociedade do Anel.', 3),
('Frodo', 'Hobbit', 5, 'Furtividade, Coragem', 'Portador do anel, em uma missão para destruí-lo.', 5),
('Gimli', 'Anão', 8, 'Machado Duplo, Força', 'Guerreiro anão com grande força e bravura.', 6),
('Gandalf', 'Mago', 15, 'Magia, Sabedoria', 'Mago poderoso que guia a Sociedade do Anel.', 7),
('Boromir', 'Guerreiro', 9, 'Espada, Liderança', 'Homem valente de Gondor, membro da Sociedade do Anel.', 8),
('Sam', 'Hobbit', 5, 'Fidelidade, Jardinagem', 'Leal companheiro de Frodo, sempre ao seu lado.', 10),
('Merry', 'Hobbit', 5, 'Esperteza, Coragem', 'Amigo de Frodo, embarca na missão para destruir o anel.', 11),
('Pippin', 'Hobbit', 5, 'Curiosidade, Alegria', 'Outro amigo de Frodo, aventureiro e curioso.', 12),
('Éowyn', 'Guerreira', 8, 'Espada, Determinação', 'Nobre de Rohan, determinada a proteger seu reino.', 13);

INSERT INTO HISTORIA (NOME, PROLOGO, DT_INICIO, PRESENCIAL, FK_ID_MESTRE) VALUES
('A Jornada do Anel', 'A Sociedade do Anel deve levar o Anel para ser destruído em Mordor.', '2024-05-01', TRUE, 1),
('A Guerra dos Magos', 'Uma batalha épica entre magos pelo controle do reino.', '2024-06-01', FALSE, 4),
('A Caça ao Tarrasque', 'Os heróis devem enfrentar a perigosa criatura Tarrasque.', '2024-07-01', TRUE, 7),
('A Defesa do Norte', 'Uma batalha para proteger o reino dos gigantes de gelo.', '2024-08-01', FALSE, 9);

INSERT INTO PARTICIPACAO (FK_ID_PERSONAGEM, FK_ID_MESTRE, FK_ID_HISTORIA) VALUES
(1, 1, 1),  -- Aragorn na história "A Jornada do Anel" com Gandalf
(2, 1, 1),  -- Legolas na história "A Jornada do Anel" com Gandalf
(3, 1, 1),  -- Frodo na história "A Jornada do Anel" com Gandalf
(4, 1, 1),  -- Gimli na história "A Jornada do Anel" com Gandalf
(5, 4, 2),  -- Gandalf na história "A Guerra dos Magos" com Merlin
(6, 1, 1),  -- Boromir na história "A Jornada do Anel" com Gandalf
(7, 1, 1),  -- Sam na história "A Jornada do Anel" com Gandalf
(8, 1, 1),  -- Merry na história "A Jornada do Anel" com Gandalf
(9, 1, 1),  -- Pippin na história "A Jornada do Anel" com Gandalf
(10, 9, 4); -- Éowyn na história "A Defesa do Norte" com Orion

INSERT INTO PRODUTO (NOME_PRODUTO, DESCRICAO, PRECO, FK_ID_USER) VALUES
('Livro do Mestre', 'Livro do mestre, 5° edição', 130.00, 1),
('Livro do Jogador', 'Livro do jogador, 5° edição', 100.00, 1),
('Camisa temática', 'Camisa do Berserk', 45.00, 12),
('D20', 'Dado de 20 lados, azul', 15.00, 3),
('D4', 'Dado de 4 lados, branco', 7.50, 3),
('Pôster', 'Põster de O Senhor dos Aneis, autografado pelo elenco', 1500.00, 5),
('Action Figure', 'Batman', 400.00, 6);

INSERT INTO DADO (FK_ID_PRODUTO, QTD_LADOS) VALUES
(4, 20),
(5, 4);

INSERT INTO LIVRO (FK_ID_PRODUTO, QTD_PAGINAS , ESTADO) VALUES
(1, 346, 4),
(2, 289, 3);
