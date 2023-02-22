# Para inicializar una funcion

def primerafuncion(nombre, apellido, edad):
    print("Hola " + nombre + " " + apellido)
    print("Tienes " + edad + " años")

primerafuncion("Los", "Pythonisos", "25")

# No es necesario especificar el tipo del return

# Para crear un numero aleatorio

import random

numeroentero = random.randint(1,10)
numerorandom = random.random()

# Seleccionar una opcion aleatoria de una lista

opciones = ["piedra",  "papel", "tijeras"]
opcionelegida = random.choice(opciones)

# Para ordenar una lista de manera aleatoria

baraja = [1,2,3,4,5,6,7,8,9,"J", "Q", "K"]
random.shuffle(baraja)

# Para importar funciones desde archivos externos

import externo
# Asi ponemos un alias
import externo as libreria
# Asi importamos unicamente la funcion especificada
from externo import suma