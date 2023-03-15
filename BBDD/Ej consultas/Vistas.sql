Escriba una vista que se llame listado_pagos_clientes que muestre un listado donde aparezcan todos los clientes y los pagos 
que ha realizado cada uno de ellos. La vista deberá tener las siguientes columnas: nombre y apellidos del cliente concatenados, 
teléfono, ciudad, pais, fecha_pago, total del pago, id de la transacción:
CREATE VIEW listado_pagos_clientes AS SELECT CONCAT(CLIENTE.NOMBRE_CONTACTO, " ", CLIENTE.APELLIDO_CONTACTO) AS NOMBRE_COMPLETO, 
CLIENTE.TELEFONO, CLIENTE.CIUDAD, CLIENTE.PAIS, PAGO.FECHA_PAGO AS FECHA_DEL_PAGO, PAGO.TOTAL, PAGO.ID_TRANSACCION FROM CLIENTE NATURAL JOIN PAGO;

/*Todos incluyendo los que no hacen pedido*/
CREATE VIEW listado_pagos_clientes AS SELECT CONCAT(CLIENTE.NOMBRE_CONTACTO, " ", CLIENTE.APELLIDO_CONTACTO) AS NOMBRE_COMPLETO, 
CLIENTE.TELEFONO, CLIENTE.CIUDAD, CLIENTE.PAIS, PAGO.FECHA_PAGO AS FECHA_DEL_PAGO, PAGO.TOTAL, PAGO.ID_TRANSACCION FROM CLIENTE LEFT JOIN PAGO 
ON CLIENTE.CODIGO_CLIENTE = PAGO.CODIGO_CLIENTE GROUP BY CLIENTE.NOMBRE_CLIENTE ORDER BY CLIENTE.NOMBRE_CONTACTO ASC;

Escriba una vista que se llame listado_pedidos_clientes que muestre un listado donde aparezcan todos los clientes y los pedidos 
que ha realizado cada uno de ellos. La vista deber tener las siguientes columnas: nombre y apellidos del cliente concatendados, 
teléfono, ciudad, pais, código del pedido, fecha del pedido, fecha esperada, fecha de entrega y la cantidad total del pedido, que 
será la suma del producto de todas las cantidades por el precio de cada unidad, que aparecen en cada línea de pedido:
CREATE VIEW listado_pedidos_clientes AS SELECT CONCAT(CLIENTE.NOMBRE_CONTACTO, " ", CLIENTE.APELLIDO_CONTACTO) AS NOMBRE_COMPLETO, 
CLIENTE.TELEFONO, CLIENTE.CIUDAD, CLIENTE.PAIS, PEDIDO.CODIGO_PEDIDO AS CODIGO_DEL_PEDIDO, PEDIDO.FECHA_PEDIDO AS FECHA_DEL_PEDIDO, 
PEDIDO.FECHA_ESPERADA AS FECHA_ESPERADA, PEDIDO.FECHA_ENTREGA AS FECHA_DE_ENTREGA, SUM(CANTIDAD*DETALLE_PEDIDO.PRECIO_UNIDAD) AS PRECIO_TOTAL FROM CLIENTE 
NATURAL JOIN PEDIDO NATURAL JOIN DETALLE_PEDIDO GROUP BY PEDIDO.CODIGO_PEDIDO;

Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes de la ciudad de Madrid que han realizado pagos.
Escribe la sentencia SELECT.
SELECT * FROM listado_pagos_clientes WHERE CIUDAD="MADRID";
/*para lista con null*/
select * from listado_pagos_clientes where ciudad="madrid" and total is not null;

Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes que todavía no han recibido su pedido.
Escribe la sentencia SELECT.
SELECT * FROM listado_pedidos_clientes WHERE PEDIDO.FECHA_ENTREGA IS NULL;

Utilice las vistas que ha creado en los pasos anteriores para calcular el número de pedidos que ha realizado cada uno de los clientes.
Escribe la sentencia SELECT.
SELECT NOMBRE_COMPLETO, COUNT(CODIGO_DEL_PEDIDO) AS NUMERO_PEDIDOS FROM LISTADO_PEDIDOS_CLIENTES GROUP BY NOMBRE_COMPLETO;

Utilice las vistas que ha creado en los pasos anteriores para calcular el valor del pedido máximo y mínimo que ha realizado cada cliente.
Escribe la sentencia SELECT.
SELECT NOMBRE_COMPLETO, MIN(PRECIO_TOTAL), MAX(PRECIO_TOTAL) FROM LISTADO_PEDIDOS_CLIENTES GROUP BY NOMBRE_COMPLETO;

Modifique el nombre de las vista listado_pagos_clientes y asígnele el nombre listado_de_pagos. Una vez que haya modificado el nombre de la vista 
ejecute una consulta utilizando el nuevo nombre de la vista para comprobar que sigue funcionando correctamente.


Antes de continuar, haga una captura de pantalla donde aparezca las Tablas y Vistas que has creado. La captura puede ser de la consola 
(utilizando el comando show tables), o del la pantalla del phpMyAdmin. DESPUES elimine las vistas que ha creado en los pasos anteriores.
Adjunta la Captura a la Tarea