/*1.Mostrar los empleados (código, nombre (del cliente)  y nombre del departamento) de la empresa que tienen el cargo de director y ordenados por el apellido.
Como verás, la información que debe aparecer está en dos Tablas: EMPLEADO y DEPARTAMENTO, las cuales deben combinarse (usando INNER) adecuadamente.*/
SELECT EMPLEADO.EMP_NO, EMPLEADO.NOMBRE, DEPARTAMENTO.DEPT_NO FROM EMPLEADO INNER JOIN DEPARTAMENTO
ON EMPLEADO.DEPT_NO = DEPARTAMENTO.DEPT_NO WHERE EMPLEADO.CARGO="DIRECTOR" ORDER BY NOMBRE ASC;

/*Mostrar el importe total que cada Departamento paga mensualmente en concepto de salario de los empleados (Total Nómina) y ordenado descendentemente
por el importe total de la nómina. La información que debe aparecer está en dos tablas, EMPLEADO y DEPARTAMENTO. Para esta Consulta, 
deberás agrupar y sumar convenientemente (GROUP BY). El resultado deberá parecerse a la imágen.*/
SELECT EMPLEADO.DEPT_NO AS "DEPT.", DEPARTAMENTO.DNOM AS "NOMBRE", SUM(EMPLEADO.SALARIO) AS "T.NÓMINA" FROM EMPLEADO RIGHT JOIN DEPARTAMENTO ON 
EMPLEADO.DEPT_NO = DEPARTAMENTO.DEPT_NO GROUP BY DEPARTAMENTO.DNOM ORDER BY SUM(EMPLEADO.SALARIO) DESC;

/*Mostrar un listado con los Códigos del Cliente, su Nombre, Fecha del Pedido y el Total del Pedido ordenado ascendentemente por Código de Cliente y fecha del Pedido
La información que debe aparecer está en dos tablas, PEDIDO y CLIENTE, las cuales se deben combinar adecuadamente. Los primeros registros debieran ser aproximadamente.... */
SELECT CLIENTE.CLIENTE_CODIGO, CLIENTE.NOMBRE, PEDIDO.PEDIDO_FECHA, PEDIDO.TOTAL FROM CLIENTE NATURAL JOIN PEDIDO ORDER BY CLIENTE.CLIENTE_CODIGO ASC, 
PEDIDO.PEDIDO_FECHA ASC;

/*Del Pedido 617 necesitamos obtener un listado con: Número del Pedido (PEDIDO_NUMERO), Número de Linea de detalle (DETALLE_NUMERO) , Nombre del Producto (DESCRIPCION), 
Precio de Venta (PRECIO_VENTA), Cantidad (CANTIDAD) e Importe (IMPORTE). Nota: Entre paréntesis los nombre de los aributos. Los nombres de las columnas serán los que 
aparecen en la imagen (Pedido, Linea, ..)*/
SELECT PEDIDO.PEDIDO_NUMERO AS "Número del Pedido", DETALLE.DETALLE_NUMERO AS "Número de Linea de detalle", PRODUCTO.DESCRIPCION AS "Nombre del Producto", 
DETALLE.PRECIO_VENTA AS "Precio de venta", DETALLE.CANTIDAD, DETALLE.IMPORTE FROM PEDIDO NATURAL JOIN DETALLE NATURAL JOIN PRODUCTO WHERE DETALLE.PEDIDO_NUMERO = 617;

/*Obtiene una lista con el nombre, cargo y salario de todos los empleados cuyo salario es MAYOR que la media del salario de todos los empleados.*/
SELECT NOMBRE, CARGO, SALARIO FROM EMPLEADO WHERE SALARIO>(SELECT AVG(SALARIO) FROM EMPLEADO);


/*  PARTE 2 */

/*(CONSULTA MULTITABLA) Obtener un Listado con el nombre y apellidos del cliente, nombre de la población, código postal y nombre
de la provincia de los clientes que habitan en Viveiro (POBLACION). Ordénalo por Nombre del Cliente*/
SELECT CLIENTES.NOMBRE, CLIENTES.APELLIDO, CLIENTES.APELLIDO2, POBLACIONES.POBLACION, CALLESPOBLACIONES.CODPOSTAL, PROVINCIAS.PROVINCIA 
FROM CLIENTES INNER JOIN CALLESPOBLACIONES ON CLIENTES.CALLE = CALLESPOBLACIONES.IDCALLE
INNER JOIN POBLACIONES ON CALLESPOBLACIONES.CODPOBLACION = POBLACIONES.CODIGOPOBLACION
INNER JOIN PROVINCIAS ON POBLACIONES.CODIGOPROVINCIA = PROVINCIAS.CODIGOPROVINCIA
WHERE POBLACIONES.POBLACION="VIVEIRO" ORDER BY CLIENTES.NOMBRE ASC;

/*(MULTITABLA Y AGREGACIÓN) ¿Cuál es el piso más grande (en metros)? Obtén la población y la provincia donde se encuentra.*/
SELECT POBLACIONES.POBLACION, PROVINCIAS.PROVINCIA, MAX(CLIENTES.METROS) AS "METROS" FROM PROVINCIAS 
INNER JOIN POBLACIONES ON PROVINCIAS.CODIGOPROVINCIA = POBLACIONES.CODIGOPROVINCIA
INNER JOIN CALLESPOBLACIONES ON POBLACIONES.CODIGOPOBLACION = CALLESPOBLACIONES.CODPOBLACION
INNER JOIN CLIENTES ON CALLESPOBLACIONES.IDCALLE = CLIENTES.CALLE;

/*(SUBCONSULTA) ¿Cuántos pisos están por encima de la media? (en metros cuadrados)*/
SELECT AVG(METROS) AS "MEDIA M2", COUNT(METROS) AS "Nº PISOS" FROM CLIENTES WHERE METROS>(SELECT AVG(METROS) FROM CLIENTES);

/*(MULTITABLA Y AGRUPACIÓN) ¿Cuántos habitantes tienen cada provincia? Lista la provincia, la suma de habitantes que tiene.*/
SELECT PROVINCIAS.PROVINCIA, SUM(POBLACIONES.HABITANTES) AS "HABITANTES" FROM PROVINCIAS NATURAL JOIN POBLACIONES GROUP BY PROVINCIA;

/*(AGRUPACIÓN) Cuáles son los TRES primeros apellidos (sólo primer apellido) predominantes entre los Cliente?
Cuando hablamos de predominantes nos refererimos a los que más se repiten.*/
SELECT APELLIDO, COUNT(APELLIDO) AS "NÚMERO" FROM CLIENTES GROUP BY APELLIDO ORDER BY COUNT(APELLIDO) DESC LIMIT 3;