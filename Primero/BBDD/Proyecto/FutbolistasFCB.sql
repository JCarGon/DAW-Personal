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
/* Smallint de extensión 4 ya que son los dígitos que va a tener el año.
Nacionalidad extensión 10 porque la más extensa que he encontrado es de 9 y tener algún margen */

CREATE TABLE Equipo(
    CodigoEquipo SMALLINT(4) PRIMARY KEY,
    NombreOficial VARCHAR(15),
    AnoCreacion SMALLINT(4) UNSIGNED NOT NULL,
    NombreEstadio VARCHAR(30) NOT NULL,
    UNIQUE (NombreOficial)
);
/* AnoCreacion smallint porque tiene un máximo de 32767 y solo voy a necesitar hasta 4 dígitos */

CREATE TABLE Juega(
    Temporada SMALLINT(4),
    NIF VARCHAR(9),
    CodigoEquipo SMALLINT(4),
    PRIMARY KEY(Temporada, NIF, CodigoEquipo),
    CONSTRAINT fk_Juega_Futoblista FOREIGN KEY(NIF) REFERENCES Futbolista(NIF),
    CONSTRAINT fk_Juega_Equipo FOREIGN KEY(CodigoEquipo) REFERENCES Equipo(CodigoEquipo)
);

/*Apartado C:
1. Añade un atributo en el que se recoja si la jugadora llegó de los escalafones
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

/*Apartado D:
1. PROCEDIMIENTO ALMACENADO que agregue una JUGADORA. Deberá recibir todos los
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

/*3. PROCEDIMIENTO ALMACENADO que modifique año de nacimiento de una JUGADORA. Recibirá como parámetro de entrada 
la clave de la jugadora y el nuevo valor del año de nacimiento. */
DELIMITER $$
DROP PROCEDURE IF EXISTS ModificarJugadora;
CREATE PROCEDURE ModificarJugadora(IN NIFIntroducido VARCHAR(9), IN NuevoAnoNac SMALLINT(4))
BEGIN
    UPDATE FUTBOLISTA SET ANONACIMIENTO = NuevoAnoNac WHERE NIF = NIFIntroducido;
END $$
DELIMITER ;

call ModificarJugadora("12342543L", 2000);

/* 4. PROCEDIMIENTO ALMACENADO que obtiene la lista de JUGADORAS jugaron en una determinada temporada 
en un determinado equipo. Como parámetros de entrada, el procedimiento recibirá un identificador de equipo 
y la temporada para la que deseamos sacar el listado. La salida contendrá el título de la temporada, 
el nombre del equipo, y el nombre/apellidos de las jugadores*/
DELIMITER $$
DROP PROCEDURE IF EXISTS JugadorasPorTemporada;
CREATE PROCEDURE JugadorasPorTemporada(IN CodigoEquipoEntrada SMALLINT(4), IN TemporadaEntrada SMALLINT(4))
BEGIN
    SELECT JUEGA.TEMPORADA, EQUIPO.NOMBREOFICIAL, CONCAT(FUTBOLISTA.NOMBRE, " ",FUTBOLISTA.APELLIDO) AS "Nombre/Apellido" FROM 
    FUTBOLISTA NATURAL JOIN JUEGA NATURAL JOIN EQUIPO WHERE EQUIPO.CODIGOEQUIPO=CodigoEquipoEntrada AND JUEGA.TEMPORADA=TemporadaEntrada;
END $$
DELIMITER ;

call JugadorasPorTemporada(0008, 2019);

/* VALORES PARA LA TEMPORADA 2022 */
INSERT INTO Futbolista VALUES
("11111111A", "Cata", "Coll", 2001, "España"),
("22222222B", "Ana-Maria", "Crnogorčević", 1990, "Suiza"),
("33333333C", "Irene", "Paredes", 1991, "España"),
("44444444D", "Laia", "Codina", 2000, "España"),
("55555555E", "Nuria", "Rábano", 1999, "España"),
("66666666F", "Alexia", "Putella", 1994, "España"),
("77777777G", "Ingrid", "Engen", 1998, "Noruega"),
("88888888H", "Vicky", "López", 2006, "España"),
("99999999I", "Geyse", "", 1998, "Brasil"),
("12131415J", "Fridolina", "Rolfö", 1993, "Noruega"),
("24252327K", "Asisat", "Oshoala", 1994, "Nigeria");

INSERT INTO Equipo VALUES(0008, "FC Barcelona", 1899, "Spotify Camp Nou");

INSERT INTO Juega VALUES 
(2022, "11111111A", 0008),
(2022, "22222222B", 0008),
(2022, "33333333C", 0008),
(2022, "44444444D", 0008),
(2022, "55555555E", 0008),
(2022, "66666666F", 0008),
(2022, "77777777G", 0008),
(2022, "88888888H", 0008),
(2022, "99999999I", 0008),
(2022, "12131415J", 0008),
(2022, "24252327K", 0008);


/* VALORES PARA LA TEMPORADA 2019 */
INSERT INTO Futbolista VALUES
("19181716P", "Gemma", "Font", 1999, "España"),
("38373534O", "María", "León", 1995, "España"),
("51535657T", "Stefanie", "van der Gragt", 1992, "Países Bajos"),
("71782774V", "Kheira", "Hamraoui", 1990, "Francia"),
("91929394S", "Caroline", "Graham Hansen", 1995, "Noruega"),
("73654738L", "Lieke", "Martens", 1992, "Países Bajos");

INSERT INTO Juega VALUES 
(2019, "22222222B", 0008),
(2019, "44444444D", 0008),
(2019, "66666666F", 0008),
(2019, "88888888H", 0008),
(2019, "24252327K", 0008),
(2019, "19181716P", 0008),
(2019, "38373534O", 0008),
(2019, "51535657T", 0008),
(2019, "71782774V", 0008),
(2019, "91929394S", 0008),
(2019, "73654738L", 0008);

/* 5. PROCEDIMIENTO ALMACENADO que lista los equipos en los que ha militado una
jugadora. El identificador de la jugadora será el que se le pasa al PROCEDIMIENTO
como parámetro. */
DELIMITER $$
DROP PROCEDURE IF EXISTS EquiposDeJugadora;
CREATE PROCEDURE EquiposDeJugadora(IN NIFIntroducido VARCHAR(9))
BEGIN
    SELECT DISTINCT EQUIPO.NOMBREOFICIAL AS "Nombre-Equipo" FROM EQUIPO NATURAL JOIN JUEGA NATURAL JOIN FUTBOLISTA WHERE FUTBOLISTA.NIF=NIFIntroducido;
END $$
DELIMITER ;

call EquiposDeJugadora("66666666F");

INSERT INTO Equipo VALUES (0005, "Sevilla FC", 1905, "Ramón Sánchez Pizjuán");
INSERT INTO Juega VALUES (2023, "66666666F", 0005);

/* 6. FUNCION ESCALAR que recibe como parámetro el identificador de la jugadora y
devuelva el número (cantidad) de equipos en los que ha militado. */
DROP FUNCTION IF EXISTS Escalar;
DELIMITER $$
CREATE FUNCTION Escalar(NIFIntroducido VARCHAR(9))
    RETURNS INT
    BEGIN
        DECLARE numeroEquipos INT;
        SELECT COUNT(DISTINCT EQUIPO.NOMBREOFICIAL) INTO numeroEquipos FROM EQUIPO NATURAL JOIN JUEGA NATURAL JOIN FUTBOLISTA WHERE FUTBOLISTA.NIF="66666666F";
    RETURN numeroEquipos;
END $$
DELIMITER ;

SELECT Escalar("66666666F");

/* 7. Vista (VIEW) que liste temporada, nombre de equipo y nombre/apellido de jugadora.
Deberá estar ordenado por temporada-equipo-jugadora. */
CREATE OR REPLACE VIEW listarTemporadaEquipoJugadora AS SELECT JUEGA.TEMPORADA, EQUIPO.NOMBREOFICIAL, CONCAT(FUTBOLISTA.NOMBRE, " ", FUTBOLISTA.APELLIDO) 
FROM FUTBOLISTA NATURAL JOIN JUEGA NATURAL JOIN EQUIPO ORDER BY JUEGA.TEMPORADA, EQUIPO.NOMBREOFICIAL, FUTBOLISTA.NOMBRE;

/* 8. Vista (VIEW) que lista todos las jugadoras y equipos en los que ha militado. */
CREATE OR REPLACE VIEW ListarJugadoraEquipo AS SELECT DISTINCT EQUIPO.NOMBREOFICIAL, CONCAT(FUTBOLISTA.NOMBRE, " ", FUTBOLISTA.APELLIDO) 
FROM FUTBOLISTA NATURAL JOIN JUEGA NATURAL JOIN EQUIPO ORDER BY FUTBOLISTA.NOMBRE;