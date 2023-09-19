set @var1 = 6;
set @var2 = 17.5;
set @var3 = @var1 + @var2;

select @var1, @var2, @var3;

set @fecha = current_date();
set @fnac="2023/01/01";
set @dias = datediff(@fecha, @fnac); -> fecha mayor, fecha menor
select @dias; -> muestra 78 días que son los que han pasado de este año

select @fmin := min(fechahora), @fmax := max(fechahora) from mediciones limit 1;

/* CREAR PROCEDIMIENTO */
DELIMITER $$
DROP PROCEDURE IF EXISTS listar_productos$$
CREATE PROCEDURE listar_productos(IN gama VARCHAR(50))
BEGIN
    SELECT *
    FROM producto
    WHERE producto.gama = gama;
END
$$
DELIMITER ;


/* EJEMPLO DE CREAR PROCEDIMIENTO CON VARIAS VARIABLES USANDO INTO */
DROP PROCEDURE IF EXISTS lista_cliente;

DELIMITER $$

CREATE PROCEDURE lista_cliente()
BEGIN
    DECLARE nombre VARCHAR(100);
    DECLARE apellido1 VARCHAR(100);
    DECLARE apellido2 VARCHAR(100);

    SELECT clientes.nombre, clientes.apellido1, clientes.apellido2
    INTO nombre, apellido1, apellido2
    FROM clientes WHERE clientes.codigo = 1;

    SELECT nombre, apellido1, apellido2;
END $$

DELIMITER ;