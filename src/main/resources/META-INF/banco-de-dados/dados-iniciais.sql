insert into produto (nome, preco, data_criacao,  descricao) values ( 'Kindle', 499.0, date_sub(sysdate(), interval 1 day ) , 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into produto (nome, preco, data_criacao, descricao) values ( 'Kindle', 499.0, date_sub(sysdate(), interval 1 day ) ,'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');

insert into cliente (nome) values ('Fernando Medeiros');
insert into cliente (nome) values ('Marcos Mariano');

insert into pedido(cidade, estado, cliente_id) values ('JK','PP',1);

insert into  categoria(id, nome) values  (1, 'Eletrônicos');

insert into item_pedido(pedido_id, produto_id, preco_produto, quantidade) values (1,1,5.0,2);