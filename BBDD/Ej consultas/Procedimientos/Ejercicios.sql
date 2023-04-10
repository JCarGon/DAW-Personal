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