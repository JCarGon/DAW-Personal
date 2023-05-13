CREATE DATABASE IF NOT EXISTS pokedex;
USE pokedex;

CREATE TABLE IF NOT EXISTS pokemon(
    PokemonID SMALLINT(3) UNSIGNED PRIMARY KEY,
    nombre_Pokemon VARCHAR(15) NOT NULL,
    tipo_Pokemon VARCHAR(20) NOT NULL,
    habilidad_Pokemon VARCHAR(25) NOT NULL,
    habilidad_Oculta VARCHAR(25) DEFAULT NULL,
    fase_Evolutiva TINYINT(1) UNSIGNED DEFAULT NULL,
    imagen_Pokemon VARCHAR(7) NOT NULL
);

CREATE TABLE IF NOT EXISTS user(
	UserID SMALLINT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Nombre VARCHAR(20) NOT NULL,
    Pass VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS tiene(
	UserID SMALLINT(3) UNSIGNED AUTO_INCREMENT,
    PokemonID SMALLINT(3) UNSIGNED,
    PRIMARY KEY(UserID, ID),
    CONSTRAINT fk_tiene_pokemon FOREIGN KEY(PokemonID) REFERENCES Pokemon(PokemonID),
    CONSTRAINT fk_tiene_user FOREIGN KEY(UserID) REFERENCES user(UserID)
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