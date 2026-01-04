ALTER TABLE consultas
    RENAME COLUMN status_consulta TO ativa;

ALTER TABLE consultas
ALTER COLUMN ativa TYPE BOOLEAN
    USING (
          CASE
              WHEN ativa = 'ATIVA' THEN TRUE
              WHEN ativa = 'CANCELADA' THEN FALSE
              ELSE NULL
    END
);