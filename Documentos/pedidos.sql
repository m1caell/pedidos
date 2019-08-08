create table Cliente (
id int(11) auto_increment,
nome varchar(50),
saldo decimal(18,2),
constraint pk_cliente primary key(id)
);

create table Endereco(
id int(11) auto_increment
,idCliente int
,Endereco varchar(100)
,Numero int
,Cidade varchar(100)
,UF varchar(2),
constraint pk_endereco primary key(id),
constraint fk_endereco_cliente foreign key(idCliente) references Cliente(id)
);

create table Produto (
id int(11) auto_increment
,Nome varchar(50)
,ValorUni decimal(18,2)
,Saldo decimal(12,2)
,DataFabricacao datetime
,DataValidade datetime
,Descricao varchar(500),
constraint pk_produto primary key(id)
);

create table Pedido(
id int(11) auto_increment
,idCliente int(11)
,idEndereco int(11)
,ValorTotal decimal(18,2)
,Data datetime,
constraint pk_pedido primary key(id),
constraint fk_pedido_cliente FOREIGN KEY (idCliente) REFERENCES Cliente (id),
constraint fk_pedido_endereco FOREIGN KEY (idEndereco) REFERENCES Endereco(id)
);

create table ItemPedido(
id int(11) auto_increment
,idPedido int(11)
,idProduto int(11)
,Qtde int(11)
,valorUni decimal(12,2),
constraint pk_item_pedido primary key(id),
constraint fk_item_pedido_pedido foreign key(idPedido) references Pedido(id),
constraint fk_item_pedido_produto foreign key(idProduto) references Produto(id)
);