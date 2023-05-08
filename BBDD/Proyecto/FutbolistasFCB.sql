/*Apartado B: Creación de tablas: */
CREATE DATABASE FutbolistasFCB;

USE FutbolistasFCB;

CREATE TABLE Futbolista(
    NIF VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR (20),
    Apellido VARCHAR(20),
    AnoNacimiento SMALLINT(4) UNSIGNED NOT NULL,
    Nacionalidad VARCHAR(10) NOT NULL
);
/*Formato DATE: "YYYY-MM-DD"
Nacionalidad extensión 10 porque la más extensa que he encontrado es de 9 y tener algún margen*/

CREATE TABLE Equipo(
    NombreOficial VARCHAR(15) PRIMARY KEY,
    AnoCreacion SMALLINT(4) UNSIGNED NOT NULL,
    NombreEstadio VARCHAR(30) NOT NULL
);
/*AnoCreacion smallint porque tiene un máximo de 32767 y solo voy a necesitar hasta 4 dígitos*/

CREATE TABLE Juega(
    Temporada SMALLINT(4),
    NIF VARCHAR(9),
    NombreOficial VARCHAR(15),
    PRIMARY KEY(NIF, NombreOficial),
    CONSTRAINT fk_Juega_Futoblista FOREIGN KEY(NIF) REFERENCES Futbolista(NIF),
    CONSTRAINT fk_Juega_Equipo FOREIGN KEY(NombreOficial) REFERENCES Equipo(NombreOficial)
);

/*Apartado C: */
/*1. Añade un atributo en el que se recoja si la jugadora llegó de los escalafones
inferiores del FCB. Este atributo solo puede tomar los valores “S” ó “N”.*/
ALTER TABLE Futbolista ADD COLUMN EscalafonesInferiores CHAR(1) NOT NULL CHECK(EscalafonesInferiores IN ('S', 'N'));

/*2. Añade otro atributo que contenga el e-mail de la jugadora. El valor de este
atributo debe ser único para cada jugadora y se debe comprobar que contiene la
arroba (@) como parte de su validez.*/
ALTER TABLE Futbolista ADD COLUMN Email VARCHAR(30) CHECK(Email LIKE '%@%');

/*3. Escribe la sentencia que eliminaría el atributo nacionalidad de la jugadora.*/
ALTER TABLE Futbolista DROP COLUMN Nacionalidad;

/*4. Escribe la sentencia que añadiría un atributo que contenga la capacidad de
espectadores que tiene el estadio. Debe ser un número positivo no nulo y menor de
99.999, y por supuesto mayor de cero.*/
ALTER TABLE Equipo ADD COLUMN Capacidad INT(5) UNSIGNED NOT NULL CHECK(Capacidad > 0 AND Capacidad < 99999);

/*5. Escribe la sentencia que cree un índice con el campo nombre y apellidos de las jugadoras.*/
CREATE INDEX IndiceNombreApellido ON Futbolista (Nombre, Apellido);

/*6. Escribe la sentencia que cree un índice con el campo año de creación del equipo.*/
CREATE INDEX IndiceFechaIngreso ON Equipo (AnoCreacion);

/*7. Si por ejemplo has llamado a la tabla contiene a las jugadoras como
“FUTBOLISTAS”, escribe la sentencia que renombraría esa tabla a “JUGADORAS”.*/
ALTER TABLE Futbolista RENAME TO Jugadora;

/*8. Escribe la sentencia que eliminaría esta última tabla.*/
DROP TABLE Jugadora;

/*Apartado D: */
/*1. PROCEDIMIENTO ALMACENADO que agregue una JUGADORA. Deberá recibir todos los
atributos de la jugadora, que se pasarán como parámetros de entrada.*/
DELIMITER $$
DROP PROCEDURE IF EXISTS AddJugadora;
CREATE PROCEDURE AddJugadora(IN NIF VARCHAR(9), IN Nombre VARCHAR (20), IN Apellido VARCHAR(20), IN AnoNacimiento DATE, IN Nacionalidad VARCHAR(10))
BEGIN
    INSERT INTO Futbolista VALUES(NIF, Nombre, Apellido, AnoNacimiento, Nacionalidad);
END $$
DELIMITER ;

call AddJugadora("12324253I", "Laura", "Pausini", "1980-04-28", "Italiana");

/*2. PROCEDIMIENTO ALMACENADO que agregue un EQUIPO. Deberá recibir todos los
atributos del equipo, que se pasarán como parámetros de entrada.*/
DELIMITER $$
DROP PROCEDURE IF EXISTS AddEquipo;
CREATE PROCEDURE AddEquipo(IN NombreOficial VARCHAR(15), IN AnoCreacion SMALLINT(4), IN NombreEstadio VARCHAR(20))
BEGIN
    INSERT INTO Equipo VALUES(NombreOficial, AnoCreacion, NombreEstadio);
END $$
DELIMITER ;

call AddEquipo("Sevilla FC", 1905, "Ramón Sánchez Pizjuán");

/*3. PROCEDIMIENTO ALMACENADO que modifique datos almacenados de una JUGADORA introduciendo su NIF.*/
DELIMITER $$
DROP PROCEDURE IF EXISTS ModificarJugadora;
CREATE PROCEDURE ModificarJugadora(IN NIF VARCHAR(9))
BEGIN
    IF 
    END IF;
END $$
DELIMITER ;