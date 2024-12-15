INSERT INTO portaslot (tipo) VALUES ('PINCHER');
INSERT INTO portaslot (tipo) VALUES ('USB');
INSERT INTO portaslot (tipo) VALUES ('HDMI');
INSERT INTO portaslot (tipo) VALUES ('Ethernet');
INSERT INTO portaslot (tipo) VALUES ('MicroUSB');
INSERT INTO portaslot (tipo) VALUES ('Type-C');
INSERT INTO portaslot (tipo) VALUES ('Thunderbolt');
INSERT INTO portaslot (tipo) VALUES ('VGA');
INSERT INTO portaslot (tipo) VALUES ('DisplayPort');
INSERT INTO portaslot (tipo) VALUES ('AudioJack');

INSERT INTO sensor (tipo) VALUES ('luz');
INSERT INTO sensor (tipo) VALUES ('movimento');
INSERT INTO sensor (tipo) VALUES ('infravermelho');
INSERT INTO sensor (tipo) VALUES ('temperatura');
INSERT INTO sensor (tipo) VALUES ('umidade');
INSERT INTO sensor (tipo) VALUES ('proximidade');
INSERT INTO sensor (tipo) VALUES ('pressão');
INSERT INTO sensor (tipo) VALUES ('aceleração');
INSERT INTO sensor (tipo) VALUES ('giroscópio');
INSERT INTO sensor (tipo) VALUES ('magnetômetro');

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
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha D', '2021-07-10');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha E', '2017-03-25');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha F', '2016-08-18');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha G', '2022-12-05');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha H', '2015-05-22');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha I', '2013-04-13');
INSERT INTO Linha (nome, anoLancamento) VALUES ('Linha J', '2014-09-09');

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

INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série X', '2021-03-20', 1);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Y', '2019-09-10', 2);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Z', '2020-11-25', 3);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série W', '2018-02-14', 4);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série V', '2017-06-19', 5);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série U', '2022-01-01', 6);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série T', '2023-04-11', 7);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série S', '2015-08-08', 8);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série R', '2014-03-03', 9);
INSERT INTO Serie (nome, anoLancamento, linha_id) VALUES ('Série Q', '2013-12-12', 10);

INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(0, 'Samsung', 'peperone', '2020-11-02', 128, 8, 999.99, '01412e6e-2e20-4b90-b855-ece8f21dc05e.jpg', 1, 1, 1);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(10, 'Apple', 'iPhone 12', '2020-10-23', 256, 6, 1099.99, '60ad000a-8d48-4665-9851-68dee7c81a13.jpeg', 2, 2, 2);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(20, 'OnePlus', 'OnePlus 9 Pro', '2021-03-23', 256, 12, 969.99, '60ad000a-8d48-4665-9851-68dee7c81a13.jpeg', 3, 3, 3);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(15, 'Xiaomi', 'Mi 11', '2021-01-01', 128, 8, 749.99, 'mi11.jpg', 4, 4, 4);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(5, 'Google', 'Pixel 5', '2020-10-15', 128, 8, 699.99, 'pixel5.jpg', 5, 5, 5);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(8, 'Huawei', 'P40 Pro', '2020-03-26', 256, 8, 899.99, 'p40pro.jpg', 6, 6, 6);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(12, 'Sony', 'Xperia 1 II', '2020-05-22', 256, 8, 1199.99, 'xperia1ii.jpg', 7, 7, 7);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(7, 'LG', 'Velvet', '2020-05-07', 128, 6, 599.99, 'velvet.jpg', 8, 8, 8);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(9, 'Motorola', 'Edge+', '2020-04-22', 256, 12, 999.99, 'edgeplus.jpg', 9, 9, 9);
INSERT INTO Celular (estoque, marca, nome, anoLancamento, armazenamento, ram, preco, nomeimagem, id_tela, id_processador, id_serie) VALUES
(11, 'Nokia', '8.3 5G', '2020-09-15', 128, 8, 649.99, 'nokia83.jpg', 10, 10, 10);

INSERT INTO celular_camera (celular_id, camera_id) VALUES (1, 1);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (1, 2);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (2, 3);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (4, 4);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (5, 5);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (6, 6);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (7, 7);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (8, 8);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (9, 9);
INSERT INTO celular_camera (celular_id, camera_id) VALUES (10, 10);

INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (1, 1);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (2, 2);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (3, 3);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (4, 4);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (5, 5);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (6, 6);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (7, 7);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (8, 8);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (9, 9);
INSERT INTO celular_portaslot (celular_id, portaslot_id) VALUES (10, 10);

INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (1, 1);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (2, 2);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (3, 3);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (4, 4);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (5, 5);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (6, 6);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (7, 7);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (8, 8);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (9, 9);
INSERT INTO celular_sensor (celular_id, sensor_id) VALUES (10, 10);

-- Senhas utilizadas para cada usuário:
-- Julio: 12345
-- Lukas90: lukas789
-- Maria: maria456
-- Ana: ana012
-- Fernanda: fernanda234

-- Paulo: paulo789
-- Carlos: carlos345
-- Marcia: marcia901
-- Renato: renato567
-- Claudia: claudia890

-- Inserindo usuários na tabela usuario
INSERT INTO usuario (login, senha) VALUES ('julio', 'jDG4bVLVolzg4JgBQgelxVcOMW5vNB3Gpo0SX+IFhn3IWtRBeKpoL7yIE/cjHWU=');
INSERT INTO usuario (login, senha) VALUES ('lukas90', 'b4TItKEVTPlcMF4AqtFScrDicypQ/+4LUF/QilxV5kK5tk1c8acYIc4H5p7uHHU=');
INSERT INTO usuario (login, senha) VALUES ('maria', 'K+Vy3Qf3uiv1t3iq6x5QWEVb8Xhg/17FtZqNPD0xplQLNtTP1H1d8KKyji+VBh4=');
INSERT INTO usuario (login, senha) VALUES ('ana', 'EaUR4lMGQdE0/U+c5dSfJAwpDPzRlHiM4sMnCb/bpAPwE1LY8Kza0jlZ591XBNo=');
INSERT INTO usuario (login, senha) VALUES ('fernanda', 'kpwNCaYiCM7dlumTtsbRfWUoM4OEIT8ZF2ViohD1bTkSBX+oWKLfRpwGCK1nI24=');

INSERT INTO usuario (login, senha) VALUES ('paulo', 'T9XIxz+KGizH/qs6H5oAzGQbULWN4fwSWWD4InWdO9xIFVtH+CnVOOC2MQEEta8=');
INSERT INTO usuario (login, senha) VALUES ('carlos', 'PpTF46XnYNwFjyqk6XEjdAC/wDFgbmjtq5ZJdy8GtubA9Jx4N0/Tu4ArVCLrbIE=');
INSERT INTO usuario (login, senha) VALUES ('marcia', '0AihkKj2BhN84T4vo8MXVATLu90zpTbuz9i6Y8bXYAxg1lPyqfq3azkBnigXMQQ=');
INSERT INTO usuario (login, senha) VALUES ('renato', 'Zd8DgsRmHUbqOdUGnLLztUAqsU7iMUXn6xSTqFK5TsVd+5anjbZVrMBxHijiIDw=');
INSERT INTO usuario (login, senha) VALUES ('claudia', 'claudia890');

INSERT INTO usuario (login, senha) VALUES ('ricardo', 'i/rX8LnqIdA+RAS+LeqaMv/iYbbmDCf2lNwHztFby9VgRWvm1myBQxadulJM2o8=');

-- -- Funcionários
-- ('joao.silva', '" + getHashSenha("senha123Joao") + "'), -- Cargo: Gerente de Vendas

-- -- Clientes
-- ('lucas.pereira', '" + getHashSenha("SenhaLucas1234") + "'), -- Compra Recente: Xiaomi Redmi Note 13

-- Inserindo clientes na tabela cliente
INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('julio', 12345678, '123.456.789-01', 1);
INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('lukas90', 33445566, '456.789.012-34', 2);
INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('maria', 87654321, '987.654.321-00', 3);
INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('ana', 11223344, '345.678.901-23', 4);
INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('fernanda', 55667788, '567.890.123-45', 5);
-- INSERT INTO cliente (nome, cep, cpf, id_usuario) VALUES ('julio', 123, 123, 1);

-- Inserindo funcionários na tabela funcionario
INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('paulo', 22334455, '123.987.654-32', '12.345.678/0001-99', 4);
INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('carlos', 66778899, '987.123.456-78', '23.456.789/0002-88', 6);
INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('marcia', 88997766, '345.678.912-12', '34.567.890/0003-77', 8);
INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('renato', 55443322, '456.789.123-67', '45.678.901/0004-66', 9);
INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('claudia', 99887766, '567.890.234-89', '56.789.012/0005-55', 10);
-- INSERT INTO funcionario (nome, cep, cpf, cnpj, id_usuario) VALUES ('ricardo', 123, 123, 222, 11);
