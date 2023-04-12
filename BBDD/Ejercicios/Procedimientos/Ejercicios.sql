/* Ejercicio 1: Procedimiento que muestre enfermos que nacieron entre 2 fechas pasándoselas por parámetros*/
DROP PROCEDURE IF EXISTS ejemplo1;
DELIMITER $$
CREATE PROCEDURE ejemplo1(IN fecha1 date, IN fecha2 date)
BEGIN
    SELECT ENFERMO.* FROM ENFERMO WHERE FECHA_NAC>=fecha1 AND FECHA_NAC<=fecha2;
END $$
DELIMITER ;

/* Para llamar al procedimiento */
call ejemplo1("1940-01-01", "1960-01-01");

/* Ejercicio 2: Crea un procedimiento que muestre el nombre de un enfermo dado su codigo (pasado por parámetro). */
DROP PROCEDURE IF EXISTS ejemplo2;
DELIMITER $$
CREATE PROCEDURE ejemplo2(IN codigo INTEGER(5))
BEGIN
    SELECT ENFERMO.NOMBRE FROM ENFERMO WHERE ENFERMO.INSCRIPCION=codigo;
END $$
DELIMITER ;

/* Para llamar al procedimiento */
call ejemplo2(10995);

/* Crea una FUNCION que devuelva la letra del dni. Como parámetro de entrada le pasaremos a la Función el número del DNI */
DROP FUNCTION IF EXISTS letraDNI;
DELIMITER $$
CREATE FUNCTION letraDNI(dni INT)
RETURNS CHAR(1)
BEGIN
    DECLARE resto INT;
    DECLARE abecedario CHAR(23);
    DECLARE letra CHAR(1);
    SET abecedario = 'TRWAGMYFPDXBNJZSQVHLCKE';

    SET resto = dni%23;
    SET letra = SUBSTR(abecedario, resto+1, 1);

    RETURN letra;
END $$
DELIMITER ;

SELECT letraDNI(30266219);

/* Crea una FUNCION que muestre el nombre de un enfermo dado su codigo de inscripción o INSCRIPCION (pasado por parámetro). */
DROP FUNCTION IF EXISTS nombreEnfermo;
DELIMITER $$
CREATE FUNCTION nombreEnfermo(inscripcion INT)
RETURNS CHAR(20)
BEGIN
    DECLARE nombre CHAR(20);
    SET nombre = (SELECT ENFERMO.NOMBRE FROM ENFERMO WHERE ENFERMO.INSCRIPCION = inscripcion);
    RETURN nombre;
END $$
DELIMITER ;

SELECT nombreEnfermo(10995);

/* Escribe una función que devuelva el valor de la hipotenusa de un triángulo a partir de los valores de sus lados. */
DROP FUNCTION IF EXISTS hipotenusa;
DELIMITER $$
CREATE FUNCTION hipotenusa(lado1 INT, lado2 INT)
RETURNS REAL
BEGIN
    DECLARE hipotenusa REAL;
    SET hipotenusa = SQRT(POWER(lado1, 2)+POWER(lado2, 2));
    RETURN hipotenusa;
END $$
DELIMITER ;

SELECT hipotenusa(5, 4);