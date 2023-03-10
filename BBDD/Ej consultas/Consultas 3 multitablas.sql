select clientes.nombre from clientes inner join callespoblaciones on clientes.calle = callespoblaciones.idcalle
    inner join poblaciones on callespoblaciones.codpoblacion = poblaciones.codigopoblacion
    inner join provincias on poblaciones.codigoprovincia = provincias.codigoProvincia
    where provincias.codigoprovincia=32;

/*
COUNT(*) -> CUENTA
AVG(ATRIBUTO) -> MEDIA
MAX(ATRIBUTO) -> MÁXIMO
MIN(ATRIBUTO) -> MÍNIMO
SUM(ATRIBUTO) -> SUMA
*/

/* LAS SUBCONSULTAS DEBEN DEVOLVER SOLO 1 VALOR */
SELECT * FROM CLIENTES WHERE CLIENTES.CODIGOPROVINCIA = (SELECT CODIGOPROVINCIA FROM PROVINCIAS WHERE PROVINCIA = "ORENSE");

SELECT COUNT(*) FROM CLIENTES; /* DEVUELVE EL NÚMERO DE CLIENTES QUE HAY EN ESA TABLA CLIENTES */

SELECT AVG(METROS) FROM CLIENTES; /* MEDIA DE CLIENTES */

/* SACA LOS CLIENTES QUE TIENEN UN PISO CON MENOS METROS QUE LA MEDIA */
SELECT * FROM CLIENTES WHERE METROS <= (SELECT AVG(METROS) FROM CLIENTES);

/* SACA EL NÚMERO DE CLIENTES QUE TIENEN UNO DE ESOS 4 CÓDIGOS DE PROVINCIAS */
SELECT COUNT(*) FROM CLIENTES WHERE CODIGOPROVINCIA IN (SELECT CODIGOPROVINCIA FROM PROVINCIAS WHERE PROVINCIA IN ("LUGO", "CORUÑA, LA", "ORENSE", "PONTEVEDRA"));
SELECT COUNT(*) FROM CLIENTES WHERE CODIGOPROVINCIA IN (SELECT CODIGOPROVINCIA FROM PROVINCIAS WHERE PROVINCIA = "LUGO" OR PROVINCIA = "CORUÑA, LA" OR PROVINCIA = "ORENSE" OR PROVINCIA = "PONTEVEDRA");

/* SACA NOMBRE Y APELLIDO DE CLIENTES CUYA POBLACIÓN SEA %FERRO% */
SELECT CLIENTES.NOMBRE, CLIENTES.APELLIDO FROM CLIENTES WHERE CLIENTES.CODIGOPOBLACION = (SELECT POBLACIONES.CODIGOPOBLACION FROM POBLACIONES WHERE POBLACIONES.POBLACION LIKE "%FERRO%");

/* POBLACION Y HABITANTES DE POBLACIONES CUYOS HABITANTES > MEDIA */
SELECT POBLACION, HABITANTES FROM POBLACIONES WHERE HABITANTES >= (SELECT AVG(HABITANTES) FROM POBLACIONES);