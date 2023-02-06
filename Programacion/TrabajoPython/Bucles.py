## While

# - Ejemplo While:
num = 0
nombre = ""

while num < 3:
	print("Tu numero es " + str(num))
	num = num + 1

# - While más práctico:

while len(nombre) == 0:
	nombre = input("Dime tu nombre: ")

print("Hola " + nombre)


## For

# - Ejemplo For:
for i in range(10):

	print(i)

# Para inicializar la "i" en el valor que queramos:

for i in range(50,100):
	print(i)

# De esta forma hacemos que "i" valga 50 en la primera ejecución y 99 en la última.

# Podemos añadir un 3er argumento a nuestros bucles for, que servirá como "step".

for i in range(50,100,2):
	print(i)

# Esto imprimirá "i" desde 50 hasta 100, sumando 2 a "i" en cada ejecución.

# Este bucle iguala "i" a cada caracter del string impuesto como condición.
for i in "Los Pythonisos":
	print(i)

# - Ejemplo más práctico:
import time

for segundos in range(12,0,-1):
	print(segundos)
	time.sleep(1)

print("¡Feliz año nuevo!")
'''
Este bucle empieza con "i" = 12, y reduce hasta 0 con una interrupción de 1s en cada ejecución del bucle, simulando unas campanadas.
Cuando el bucle termina, se felicita el nuevo año.
'''

##Bucles Anidados
# - Ejemplo 
filas = int(input("Cuantas filas quieres?: "))
columnas = int(input("Cuantas columnas quieres?: "))
simbolo = input("Introduce el símbolo a usar: ")

for i in range(filas):
	for j in range(columnas):
		print(simbolo, end=" ")
	print()

'''
Este programa pide como entrada al usuario el numero de filas y columnas, y el caracter a imprimir en todas esas filas y columnas.
Dentro del primer print, end=" " establece que al final de cada ejecución, en vez de dar un salto de línea, pondrá un espacio en blanco,
y el próximo print continuará tras este. El último print() funciona como salto de línea cada vez que una de las filas termina.
'''