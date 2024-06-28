-- Aplicativos
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (1, 'App 1', 200.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (2, 'App 2', 150.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (3, 'App 3', 50.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (4, 'App 4', 2.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (5, 'App 5', 37.00);

-- Clientes
INSERT INTO clientes (id, nome, email) VALUES (1, 'Cliente 1', 'cliente1@email.com');
INSERT INTO clientes (id, nome, email) VALUES (2, 'Cliente 2', 'cliente2@email.com');
INSERT INTO clientes (id, nome, email) VALUES (3, 'Cliente 3', 'cliente3@email.com');
INSERT INTO clientes (id, nome, email) VALUES (4, 'Cliente 4', 'cliente4@email.com');
INSERT INTO clientes (id, nome, email) VALUES (5, 'Cliente 5', 'cliente5@email.com');
INSERT INTO clientes (id, nome, email) VALUES (6, 'Cliente 6', 'cliente6@email.com');
INSERT INTO clientes (id, nome, email) VALUES (7, 'Cliente 7', 'cliente7@email.com');
INSERT INTO clientes (id, nome, email) VALUES (8, 'Cliente 8', 'cliente8@email.com');
INSERT INTO clientes (id, nome, email) VALUES (9, 'Cliente 9', 'cliente9@email.com');
INSERT INTO clientes (id, nome, email) VALUES (10, 'Cliente 10', 'cliente10@email.com');

-- Assinaturas Ativas
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (1, 1, 1, '2024-01-01', '2024-12-01');
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (3, 2, 2, '2024-01-01', '2024-12-01');
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (4, 3, 3, '2024-01-01', '2024-12-01');
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (5, 4, 4, '2024-01-01', '2024-12-01');
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (6, 5, 6, '2024-01-01', '2024-12-01');
-- Assinatura Inativa
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (2, 1, 1, '2024-01-01', '2024-02-01');

-- Usuarios
INSERT INTO usuarios(id, usuario, senha) VALUES (1, 'teste', '12345');
INSERT INTO usuarios(id, usuario, senha) VALUES (2, 'teste11', '12345');