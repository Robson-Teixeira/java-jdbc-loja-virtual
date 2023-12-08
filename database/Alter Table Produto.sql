USE loja_virtual;

ALTER TABLE produto
ADD COLUMN categoria_id INT; 

ALTER TABLE produto
ADD FOREIGN KEY (categoria_id) references categoria (id);