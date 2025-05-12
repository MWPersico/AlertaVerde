INSERT INTO tb_usuario (nome, email, senha_hash, telefone) VALUES ('Paulo Engenheiro', 'paulo@email.com', '123', '11999999999');
INSERT INTO tb_usuario (nome, email, senha_hash, telefone) VALUES ('Helena Ativista', 'helena@email.com', '123', '11988888888');
INSERT INTO tb_usuario (nome, email, senha_hash, telefone) VALUES ('Jessica Veterinária', 'jessica@email.com', '123', '11977777777');

INSERT INTO tb_denuncia (titulo, descricao, categoria, latitude, longitude, anonima, id_usuario, status, data_denuncia, codigo_rastreamento) VALUES ('Queimada em área urbana', 'Foi detectada fumaça forte próxima a uma área de mata.', 1, -23.5505, -46.6333, false, 1, 0, CURRENT_TIMESTAMP, 'ABC123');

INSERT INTO tb_denuncia (titulo, descricao, categoria, latitude, longitude, anonima, id_usuario, status, data_denuncia, codigo_rastreamento) VALUES ('Desmatamento em sítio', 'Estão derrubando árvores perto do rio sem autorização.', 0, -22.9035, -43.2096, false, 2, 1, CURRENT_TIMESTAMP, 'XYZ789');

INSERT INTO tb_denuncia (titulo, descricao, categoria, latitude, longitude, anonima, id_usuario, status, data_denuncia, codigo_rastreamento) VALUES ('Animais silvestres à venda', 'Vendedor ambulante oferecendo animais em extinção.', 2, -15.7797, -47.9297, true, 3, 0, CURRENT_TIMESTAMP, 'ANM456');

INSERT INTO tb_midia_denuncia (id_denuncia, tipo, url_arquivo) VALUES (1, 0, 'https://static.nationalgeographicbrasil.com/files/styles/image_3200/public/nationalgeographic_2724573.jpg?w=1900&h=1267&p=bottom');
INSERT INTO tb_midia_denuncia (id_denuncia, tipo, url_arquivo) VALUES (2, 0, 'https://static.nationalgeographicbrasil.com/files/styles/image_3200/public/01-deforestation-disease.jpg?w=1900&h=1267');
INSERT INTO tb_midia_denuncia (id_denuncia, tipo, url_arquivo) VALUES (3, 0, 'https://static.nationalgeographicbrasil.com/files/styles/image_3200/public/gettyimages-1032117208.jpg?w=1900&h=1269');