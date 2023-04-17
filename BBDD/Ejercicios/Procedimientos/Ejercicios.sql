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

/* "Crea una FUNCION que reciba el NIF de una persona con letra incluida y compruebe si es correcto. 
En caso de que no coincida número y letra, deberá devolver el valor booleano falso, en caso contrario 
la función devolverá el valor true. La Función tendrá dos parámeros de entrada: número del DNI y letra, 
y uno de salida: FALSE si no coincida LETRA GENERADA y LETRA PASADA como SEGUNDO PARÁMETRO" */
DROP FUNCTION IF EXISTS ValidarDNI;
DELIMITER //
CREATE FUNCTION ValidarDNI(dni INT, letra CHAR)
    RETURNS BOOLEAN
    BEGIN
        DECLARE resultado BOOLEAN;
        DECLARE resto INT;
        DECLARE abecedario CHAR(23);
        DECLARE letra1 CHAR(1);
        SET abecedario = 'TRWAGMYFPDXBNJZSQVHLCKE';
    
        SET resto = dni%23;
        SET letra1 = SUBSTR(abecedario, resto+1, 1);

        IF letra1 = letra THEN SET resultado = TRUE;
        ELSE SET resultado = FALSE;
        END IF;
    
    RETURN resultado;
END //

DELIMITER ;

SELECT letraDNI(30266219, 'J'); --> Devuelve 1 (true) o 0 (false)

/* Calcular letra de  NIE. Se pasa una letra X(0), Y(1), Z(2) y el número compuesto de 7 cifras. Se pone al comienzo.
Se divide el número entre 23, nos quedamos con la parte entera y se multiplica por 23.
Se resta el número inicial menos el resultado de la multiplicación. El resultado es la posición de la letra en la cadena. */
DROP FUNCTION IF EXISTS calcularNIE;
DELIMITER //
CREATE FUNCTION calcularNIE(letra CHAR, nie INT(7))
    RETURNS CHAR(1)
    BEGIN
        DECLARE resto INT;
        DECLARE nieNuevo INT(8);
        DECLARE abecedario CHAR(23);
        DECLARE letraFinal CHAR(1);
        SET abecedario = 'TRWAGMYFPDXBNJZSQVHLCKE';

        IF letra = 'X' THEN SET nieNuevo = CONCAT(0, nie);
        ELSEIF letra = 'Y' THEN SET nieNuevo = CONCAT(1, nie);
        ELSE SET nieNuevo = CONCAT(2, nie);
        END IF;

        SET resto = nieNuevo%23;
        SET letraFinal = SUBSTR(abecedario, resto+1, 1);

    RETURN letraFinal;
END //
DELIMITER ;

/* Con CASE */
DROP FUNCTION IF EXISTS calcularNIE;
DELIMITER //
CREATE FUNCTION calcularNIE(letra CHAR, nie INT(7))
    RETURNS CHAR(1)
    BEGIN
        DECLARE resto INT;
        DECLARE nieNuevo INT(8);
        DECLARE abecedario CHAR(23);
        DECLARE letraFinal CHAR(1);
        SET abecedario = 'TRWAGMYFPDXBNJZSQVHLCKE';

        CASE letra
            WHEN 'X' THEN SET nieNuevo = CONCAT(0, nie);
            WHEN 'Y' THEN SET nieNuevo = CONCAT(1, nie);
            WHEN 'Z' THEN SET nieNuevo = CONCAT(2, nie);
        END CASE;

        SET resto = nieNuevo%23;
        SET letraFinal = SUBSTR(abecedario, resto+1, 1);

    RETURN letraFinal;
END //
DELIMITER ;

SELECT calcularNIE('Y', 9408905); --> X
SELECT calcularNIE('Y', 4527393); --> H

/* Confeccionar un PROCEDIMIENO que nos retorne dos valores aleatorios distintos comprendidos entre 0 y 10.
Los dos valores deben ser enteros. Usa el REPEAT */
DROP PROCEDURE IF EXISTS numerosRandom;
DELIMITER //
CREATE PROCEDURE numerosRandom()
BEGIN
    DECLARE valor1 INT;
    DECLARE valor2 INT;
    
    REPEAT
        SET valor1 = RAND() * 10;
        SET valor2 = RAND() * 10;
    UNTIL valor1 != valor2 
    END REPEAT;

    SELECT valor1, valor2;
END //
DELIMITER ;

call numerosRandom;

/* Crea una FUNCION  que devuelva el factorial de un número pasado por parámetro. Debes usar WHILE */
DROP PROCEDURE IF EXISTS factorial;
DELIMITER //
CREATE FUNCTION factorial(num INT)
    RETURNS INT
    BEGIN
        DECLARE numFactorial INT;
        DECLARE contador INT;
        SET numFactorial = 1;
        SET contador = 2;

        WHILE contador <= num DO
            SET numFactorial = numFactorial*contador;
            SET contador = contador+1;
        END WHILE;
    RETURN numFactorial;
    END //
DELIMITER ;

SELECT factorial(5);