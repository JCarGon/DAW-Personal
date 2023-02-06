#comentario de una línea
'''comentario de más
de una línea'''
"""comentario de
más de una línea"""

#imprimir por pantalla
print("Hola mundo")

nombre = "Jay"
print(type(nombre)) #para sacar el tipo de la variable
apellido = "CJ"
nombreCompleto = nombre + " " + apellido # suma o concatena strings

edad = 21
edad += 1 # suma 1 a la edad actual
print("Tu edad es: "+str(edad)) # str() para convertir a String lo del interior del paréntesis

peso = 70.15 #float
humano = True #Para declarar una variable de tipo booleana es "bool" || los valores de los booleanos se ponen en mayúscula la primera "True"/"False"

nombre1, edad1, humano1 = "Clay", 25, True
print(nombre1+str(edad1)+str(humano1))
# no se puede concatenar como en java variables que no sean string con el "+"; hay que convertirlo todo a String
# print(nombre1+edad+humano1) sin castear a str da error en el valor entero y bool

edadP1 = edadP2 = edadP3 = 30 #asignación múltiple de valor a variables, todas tendrían el valor 30
'''
        ALGUNOS MÉTODOS DE LOS STR (STRINGS)
    print(len(nombre1)) #saca la extensión del string
    print(nombre.find("a")) #saca la posición del carácter buscado
    print(nombre1.upper()) #pone en mayúsculas el string
    print(nombre1.lower()) #pone en minúsculas el string
    print(nombre1.count("l")) #cuenta cuántas veces aparece el carácter en el string
    print(nombre1.replace("a","o")) #cambia el carácter "a" por el carácter "o"
    print(nombre*3) #imprime algo 3 veces
'''

#conversión de variables de un tipo a otro
x = 1 #int
y = 2.0 #float
z = "3" #str

'''
        INFO SOBRE CASTEAR VARIABLES
    -Si se hace el cast en una asignación:
    x = 3 (entero)
    x = str(x)
    x será una varibale de tipo string

    -Si el cast se hace en el print:
    print(str(x))
    x será un string solo en la salida por pantalla para poder concatenar con más variables, pero seguirá siendo un entero
'''

#ENTRADA POR PANTALLA CON INPUT
name = input("Dime tu nombre: ") #captura lo que entra por consola del usuario y lo asigna a una variable