CREATE DATABASE IF NOT EXISTS pokedex;
USE pokedex;

CREATE TABLE IF NOT EXISTS pokemon(
    ID SMALLINT(3) UNSIGNED PRIMARY KEY,
    nombre_Pokemon VARCHAR(15) NOT NULL,
    tipo_Pokemon VARCHAR(20) NOT NULL,
    habilidad_Pokemon VARCHAR(25) NOT NULL,
    habilidad_Oculta VARCHAR(25) DEFAULT NULL,
    fase_Evolutiva TINYINT(1) UNSIGNED DEFAULT NULL,
    imagen_Pokemon VARCHAR(7) NOT NULL
);

CREATE TABLE IF NOT EXISTS user(
	Nombre VARCHAR(20) NOT NULL,
    Pass VARCHAR(20) NOT NULL
);

DESC pokemon;
DELETE FROM pokemon;
select * from pokemon;

INSERT INTO user VALUES
("root", "root"),
("Jesus", "1234"),
("Emilio", "4567");
select * from user;
DELETE FROM USER WHERE Pass="hola";
SELECT COUNT(*) FROM USER WHERE NOMBRE="Jesus";