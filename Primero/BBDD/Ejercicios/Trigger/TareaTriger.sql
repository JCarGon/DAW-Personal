Crea una  base de datos llamada test que contenga una tabla llamada alumnos con las siguientes columnas.
Tabla alumnos:

    id (entero sin signo)
    nombre (cadena de caracteres)
    apellido1 (cadena de caracteres)
    apellido2 (cadena de caracteres)
    nota (número real)

CREATE DATABASE test;
USE test;
CREATE TABLE IF NOT EXISTS alumnos(
    id INT(8) UNSIGNED PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL,
    apellido1 VARCHAR(15) NOT NULL,
    apellido2 VARCHAR(15) NOT NULL,
    nota REAL NOT NULL
);

Una vez creada la tabla escriba dos triggers con las siguientes características:

    Trigger 1: trigger_check_nota_before_insert
    Se ejecuta sobre la tabla alumnos.
    Se ejecuta  de una operación de inserción  .
    Si el nuevo valor de la nota que se quiere insertar es negativo, se guarda como 0.
    Si el nuevo valor de la nota que se quiere insertar es mayor que 10, se guarda como 10.

DROP TRIGGER IF EXISTS trigger_check_nota_before_insert;
DELIMITER $$
CREATE TRIGGER trigger_check_nota_before_insert
BEFORE INSERT
ON alumnos
FOR EACH ROW
BEGIN
    IF NEW.nota < 0 THEN SET NEW.nota = 0;
    ELSEIF NEW.nota > 10 THEN SET NEW.nota = 10;
    END IF;
END$$
DELIMITER ;

    Trigger2 : trigger_check_nota_before_update
    Se ejecuta sobre la tabla alumnos.
    Se ejecuta  de una operación de actualización .
    Si el nuevo valor de la nota que se quiere actualizar es negativo, se guarda como 0.
    Si el nuevo valor de la nota que se quiere actualizar es mayor que 10, se guarda como 10.

DROP TRIGGER IF EXISTS trigger_check_nota_before_update;
DELIMITER $$
CREATE TRIGGER trigger_check_nota_before_update
BEFORE UPDATE
ON alumnos
FOR EACH ROW
BEGIN
    IF NEW.nota < 0 THEN SET NEW.nota = 0;
    ELSEIF NEW.nota > 10 THEN SET NEW.nota = 10;
    END IF;
END$$
DELIMITER ;

Una vez creados los triggers escriba varias sentencias de inserción y actualización 
sobre la tabla alumnos y verifica que los triggers se están ejecutando correctamente.

INSERT INTO ALUMNOS VALUES 
(1, "Manolín", "García", "Pérez", -3.0),
(2, "Pepe", "Viyuela", "Muñoz", 14.0),
(3, "Juanito", "Becerra", "González", 7.5);
/* La nota de Manolín sería un 0, la de Pepe un 10 y la de Juanito un 7.5 */

UPDATE alumnos SET nota = -4.0 WHERE nombre="Juanito"; /* Le cambia la nota a Juanito, pasando de un 7.5 a 0 */
UPDATE alumnos SET nota = 11 WHERE nombre="Manolín"; /* Le cambia la nota a Manolín, pasando de un 0 a un 10 */
UPDATE alumnos SET nota = 6.8 WHERE nombre="Pepe"; /* Le cambia la nota a Pepe, pasando de un 10 a un 6.8 */