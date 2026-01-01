ALTER TABLE medicos ADD COLUMN telefone VARCHAR(20) NOT NULL DEFAULT '';

UPDATE medicos SET telefone = '11999999999' WHERE id = 1;

UPDATE medicos SET telefone = '11988888888' WHERE id = 3;