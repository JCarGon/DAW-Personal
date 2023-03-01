INSERT INTO DEPARTAMENTOS (DEPT_NO, NOMBRE, LOCALIDAD) 
VALUES (10, "FACTURACION", "TARRAGONA"),
(20, "VENTAS", "TARRAGONA"),
(30, "INFORMATICA", "VALENCIA"),
(40, "INVESTIGACION", "VALENCIA"),
(50, "FACTURACION", "BARCELONA"),
(100, "DIRECCION", "BACELONA"),
(200, "AGRICULTURA", "BARCELONA");

/*Siguiendo el mismo procedimiento anterior, haz lo mismo por la tabla EMPLEADOS 
(no se deben especificar las columnas en la sentencia INSERT).*/
INSERT INTO EMPLEADOS
VALUES (4800, "PEPE", "COMERCIAL", 20, 14000, "1990/11/10"),
(5350, "JAIME", "ANALISTA", 30, 20000, "1999/10/04"),
(5400, "RAMON", "PROGRAMAD", 30, 16500, "1998/12/03"),
(6200, "PEDRO", "DIRECTOR", 100, 24000, "1997/04/02"),
(7500, "RAUL", "ANALISTA", 10, 8000, "1996/12/01"),
(7876, "ANTONIO", "OPERARIO", 10, 12000, "1990/12/01");

/* Efectúa las inserciones en la tabla EMPLEADOS_ANTIGUOS, introduciendo los valores en la cláusula VALUES en 
el siguiente orden: nombre, salario y código del empleado. A continuación se muestra la Tabla: */
INSERT INTO EMPLEADOS_ANTIGUOS (NOMBRE, SALARIO, EMP_NO)
VALUES ("MARGARITA", 24600, 7200),
("PETUNIA", 98000, 7300),
("LIRIO", 45000, 7400);

/* Siguiendo el mismo procedimiento, haz lo mismo para la tabla EMPLEADOS_NUEVOS, 
especificando las columnas en el siguiente orden: NOMBRE, SALARIO y EMP_NO. */
INSERT INTO EMPLEADOS_NUEVOS (NOMBRE, SALARIO, EMP_NO)
VALUES ("ROSA", 15500, 8200),
("ENRIQUE", 45000, 8300);

/* La empresa ha contratado a un nuevo empleado de nombre ‘Carmen’ con código 3311 
que trabajará en el departamento de informática y cobrará 21000 euros. Actualizar la 
base de datos para reflejar esta situación, teniendo en cuenta que a partir de ahora, por 
política de empresa, los nuevos empleados contratados son considerados nuevos empleados, 
y se añadirán a la tabla EMPLEADOS_NUEVOS. */
INSERT INTO EMPLEADOS_NUEVOS VALUES (3311, "CARMEN", 2100);

/* La Empresa ha decidido ahora que todos los empleados nuevos (de la tabla EMPLEADOS_NUEVOS) 
deberán incluirse también en la tabla EMPLEADOS, es decir, hay que añadir a la tabla EMPLEADOS 
todos los empleados de la tabla EMPLEADOS_NUEVO que todavía no formen parte de ella (por ejemplo, 
la empleada Carmen insertada en el anterior ejercicio, ya forma parte). Como estos nuevos empleados 
todavía no tienen asignado de forma definitiva un departamento de trabajo, cree previamente un nuevo 
departamento de nombre TEMPORAL y código 0, y asigne a los empleados nuevos en este departamento, 
con la fecha de alta del día actual. */
INSERT INTO DEPARTAMENTOS (DEPT_NO, NOMBRE)
VALUES (0, "TEMPORAL");

INSERT INTO EMPLEADOS (EMP_NO, NOMBRE, SALARIO)
SELECT * FROM EMPLEADOS_NUEVOS;

UPDATE EMPLEADOS SET ALTA = NOW() WHERE DEPT_NO = 0;

/* Hay un empleado que se ha trasladado de otra fábrica, y debe ser dado de alta inmediatamente 
en la tabla EMPLEADOS de la base de datos. La información que se dispone de este empleado es que 
se llama 'David', que tiene el código de empleado 1579, y que trabajará en el departamento 10, 
con el mismo oficio que PEPE. */
INSERT INTO EMPLEADOS (EMP_NO, NOMBRE, DEPT_NO)
VALUES (1579, "DAVID", 10);
UPDATE EMPLEADOS SET OFICIO = (SELECT OFICIO FROM EMPLEADOS WHERE NOMBRE = "PEPE") WHERE EMP_NO=1579;