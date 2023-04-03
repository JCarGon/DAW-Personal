/*
Primero, se debe establecer una conexión con la base de datos y luego crear un objeto Statement que permita ejecutar la consulta. 
Una vez ejecutada la consulta, se puede obtener el resultado como un objeto ResultSet. A continuación, se puede iterar a través 
del resultado utilizando el método next() y acceder a cada columna del resultado utilizando los métodos get adecuados, como getInt(), 
getString(), getDouble(), etc.

Por ejemplo, si se desea guardar el resultado de una consulta que devuelve un solo valor entero en una variable llamada "resultado", 
se podría hacer lo siguiente:

try {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_bd", "usuario", "contraseña");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM tabla");
    if (rs.next()) {
        int resultado = rs.getInt(1);
        System.out.println("El resultado es: " + resultado);
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}

En este ejemplo, se ejecuta una consulta que cuenta el número de registros en una tabla y se guarda el resultado en la 
variable "resultado". Si la consulta no devuelve ningún resultado, el método next() devolverá false y el cuerpo del if 
no se ejecutará. Si hay un resultado, el valor de la primera columna se obtiene utilizando el método getInt(1).

Es importante tener en cuenta que el objeto ResultSet es un objeto que está vinculado a la conexión a la base de datos 
y que se debe cerrar correctamente después de utilizarlo para evitar problemas de memoria.

*/