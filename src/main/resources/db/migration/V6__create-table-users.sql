CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    login varchar(100) NOT NULL,
    senha varchar(255) NOT NULL
);