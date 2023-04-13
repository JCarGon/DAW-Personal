CREATE DATABASE IF NOT EXISTS pokedex;

USE pokedex;

CREATE TABLE IF NOT EXISTS pokemon(
    ID SMALLINT(3) UNSIGNED PRIMARY KEY,
    nombre_Pokemon VARCHAR(15) NOT NULL,
    tipo_Pokemon VARCHAR(20) NOT NULL,
    habilidad_Pokemon VARCHAR(20) NOT NULL,
    habilidad_Oculta VARCHAR(20) DEFAULT NULL,
    fase_Evolutiva TINYINT(1) UNSIGNED DEFAULT NULL,
    imagen_Pokemon VARCHAR(7) NOT NULL
);

SHOW TABLES;

INSERT INTO pokemon VALUES(1, 'Bulbasaur', 'Planta/Veneno', 'Espesura', 'Clorofila', 1, '001.jpg');
DELETE FROM pokemon WHERE ID = 1;
SELECT * FROM POKEMON;