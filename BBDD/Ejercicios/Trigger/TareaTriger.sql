/*Estructura de un trigger donde:

    nombre_trigger: es el nombre que se le da al trigger.
    BEFORE/AFTER: indica si el trigger se dispara antes o después de la operación que lo activa (insertar, actualizar o eliminar).
    INSERT/UPDATE/DELETE: indica la acción que dispara el trigger.
    nombre_tabla: es el nombre de la tabla sobre la cual se aplica el trigger.
    FOR EACH ROW: indica que el trigger se ejecuta para cada fila afectada por la operación que lo activa.
    BEGIN: marca el inicio del código del trigger.
    END: marca el final del código del trigger.

Dentro del cuerpo del trigger se puede incluir cualquier código SQL válido, como por ejemplo, consultas, operaciones de inserción, actualización o eliminación, entre otras.*/

CREATE TRIGGER nombre_trigger
{BEFORE | AFTER} {INSERT | UPDATE | DELETE}
ON nombre_tabla
FOR EACH ROW
BEGIN
   -- Código del trigger
END;

