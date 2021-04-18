CREATE TABLE restaurante_usuario_responsavel (
	restaurante_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
	PRIMARY KEY (restaurante_id, usuario_id)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

ALTER TABLE restaurante_usuario_responsavel ADD CONSTRAINT fk_rest_user_resp_restaurante
FOREIGN KEY (restaurante_id) REFERENCES restaurante(id);

ALTER TABLE restaurante_usuario_responsavel ADD CONSTRAINT fk_rest_user_resp_usuario
FOREIGN KEY (usuario_id) REFERENCES usuario(id);

