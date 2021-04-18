CREATE TABLE estado (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO estado (nome) SELECT DISTINCT nome_estado FROM cidade;

ALTER TABLE cidade 
    ADD COLUMN estado_id bigint NOT NULL;

UPDATE cidade c 
SET c.estado_id = (SELECT e.id
                   FROM estado e
                   WHERE e.nome = c.nome_estado);

ALTER TABLE cidade 
    ADD constraint fk_cidade_estado
        FOREIGN KEY (estado_id) REFERENCES estado (id);

ALTER TABLE cidade
    DROP column nome_estado;

ALTER TABLE cidade 
    CHANGE nome_cidade nome VARCHAR(80) NOT NULL;
