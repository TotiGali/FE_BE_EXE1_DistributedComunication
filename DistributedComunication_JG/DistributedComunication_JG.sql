-- Crear la base de datos
CREATE DATABASE distributed_communication;

-- Usar la base de datos creada
USE distributed_communication;

-- Crear la tabla 'person'
CREATE TABLE person (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

select * from person;

commit;