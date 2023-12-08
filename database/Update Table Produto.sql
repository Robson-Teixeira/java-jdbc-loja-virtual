USE loja_virtual;

UPDATE produto
SET categoria_id = 1
WHERE id IN (1, 2, 3);

UPDATE produto
SET categoria_id = 3
WHERE id = 4;