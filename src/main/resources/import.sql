INSERT INTO portaslot (tipo) VALUES ('PINCHER');
INSERT INTO portaslot (tipo) VALUES ('USB');
INSERT INTO portaslot (tipo) VALUES ('HDMI');

INSERT INTO sensor (tipo) VALUES ('luz');
INSERT INTO sensor (tipo) VALUES ('movimento');
INSERT INTO sensor (tipo) VALUES ('ifravermelho');

INSERT INTO processador (marca, modelo) VALUES ('INTEL', 'CORE');
INSERT INTO processador (marca, modelo) VALUES ('nvidea', 'gtx');
INSERT INTO processador (marca, modelo) VALUES ('verttapen', 'f1');

INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha A', '2020-01-01');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha B', '2018-05-15');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha C', '2019-11-30');

INSERT INTO Camera (resolucao, frontal) VALUES (12.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (16.0, false);
INSERT INTO Camera (resolucao, frontal) VALUES (8.0, true);

INSERT INTO Tela (tamanho, resolucao) VALUES (5.5, 1920);
INSERT INTO Tela (tamanho, resolucao) VALUES (6.1, 2560);
INSERT INTO Tela (tamanho, resolucao) VALUES (6.5, 2400);

INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série X', '2021-03-20', 1);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Y', '2019-09-10', 2);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Z', '2020-11-25', 3);

INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(0, 'Samsung', 'peperone', '2020-11-02', 128, 8, 999.99, '01412e6e-2e20-4b90-b855-ece8f21dc05e.jpeg', 1, 1, 1);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, id_tela, id_processador, id_serie) VALUES
(10, 'Apple', 'iPhone 12', '2020-10-23', 256, 6, 1099.99, 2, 2, 2);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, id_tela, id_processador, id_serie) VALUES
(20, 'OnePlus', 'OnePlus 9 Pro', '2021-03-23', 256, 12, 969.99, 3, 3, 3);

INSERT INTO celular_camera (celular_id, camera_id) VALUES (1, 1);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (1, 2);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (2, 3);

INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (1, 1);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (2, 2);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (3, 3);

INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (1, 1);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (2, 2);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (3, 3);

INSERT INTO usuario (login, senha) VALUES ('julio', 'jDG4bVLVolzg4JgBQgelxVcOMW5vNB3Gpo0SX+IFhn3IWtRBeKpoL7yIE/cjHWU=');
INSERT INTO usuario (login, senha) VALUES ('ricardo', 'i/rX8LnqIdA+RAS+LeqaMv/iYbbmDCf2lNwHztFby9VgRWvm1myBQxadulJM2o8=');

INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('julio', 123, 123, 1);

INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('ricardo', 123, 123, 222, 2);