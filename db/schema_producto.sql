CREATE DATABASE inventario;

USE inventario;

CREATE TABLE producto (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(50) NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id),
    UNIQUE KEY codigo (codigo)
)