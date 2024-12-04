INSERT INTO portaslot (tipo) VALUES ('PINCHER');
INSERT INTO portaslot (tipo) VALUES ('USB');
INSERT INTO portaslot (tipo) VALUES ('HDMI');

INSERT INTO sensor (tipo) VALUES ('luz');
INSERT INTO sensor (tipo) VALUES ('movimento');
INSERT INTO sensor (tipo) VALUES ('ifravermelho');

INSERT INTO processador (marca, modelo) VALUES ('INTEL', 'CORE');
INSERT INTO processador (marca, modelo) VALUES ('nvidea', 'gtx');
INSERT INTO processador (marca, modelo) VALUES ('Verstappen', 'f1');
INSERT INTO processador (marca, modelo) VALUES ('Max', 'f5');
INSERT INTO processador (marca, modelo) VALUES ('Amr', 'razer');
INSERT INTO processador (marca, modelo) VALUES ('Kilan', 'octar');
INSERT INTO processador (marca, modelo) VALUES ('Speed', 'racer');
INSERT INTO processador (marca, modelo) VALUES ('Mclarem', 'nascar');
INSERT INTO processador (marca, modelo) VALUES ('RedBull', 'Asas');
INSERT INTO processador (marca, modelo) VALUES ('Acer', 'nitro');

INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha A', '2020-01-01');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha B', '2018-05-15');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha C', '2019-11-30');

INSERT INTO Camera (resolucao, frontal) VALUES (12.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (16.0, false);
INSERT INTO Camera (resolucao, frontal) VALUES (8.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (9.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (15.0, false);
INSERT INTO Camera (resolucao, frontal) VALUES (21.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (3.0, false);
INSERT INTO Camera (resolucao, frontal) VALUES (14.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (6.0, true);
INSERT INTO Camera (resolucao, frontal) VALUES (7.0, false);
INSERT INTO Camera (resolucao, frontal) VALUES (8.5, true);

INSERT INTO Tela (tamanho, resolucao) VALUES (5.5, 1920);
INSERT INTO Tela (tamanho, resolucao) VALUES (6.1, 2560);
INSERT INTO Tela (tamanho, resolucao) VALUES (6.5, 2400);
INSERT INTO Tela (tamanho, resolucao) VALUES (6.0, 2910);
INSERT INTO Tela (tamanho, resolucao) VALUES (2.8, 3040);
INSERT INTO Tela (tamanho, resolucao) VALUES (10.9, 500);
INSERT INTO Tela (tamanho, resolucao) VALUES (18.8, 560);
INSERT INTO Tela (tamanho, resolucao) VALUES (19.3, 5070);
INSERT INTO Tela (tamanho, resolucao) VALUES (27.9, 1950);
INSERT INTO Tela (tamanho, resolucao) VALUES (24.1, 2750);
INSERT INTO Tela (tamanho, resolucao) VALUES (17.3, 1860);

INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série X', '2021-03-20', 1);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Y', '2019-09-10', 2);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Z', '2020-11-25', 3);

INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(0, 'Samsung', 'peperone', '2020-11-02', 128, 8, 999.99, '01412e6e-2e20-4b90-b855-ece8f21dc05e.jpg', 1, 1, 1);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(10, 'Apple', 'iPhone 12', '2020-10-23', 256, 6, 1099.99, '60ad000a-8d48-4665-9851-68dee7c81a13.jpeg', 2, 2, 2);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(20, 'OnePlus', 'OnePlus 9 Pro', '2021-03-23', 256, 12, 969.99, '60ad000a-8d48-4665-9851-68dee7c81a13.jpeg', 3, 3, 3);

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