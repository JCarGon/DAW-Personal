'''
        CONDICIONALES
Para los if - elif- else, no se utilizan corchetes para agrupar el bloque que pertenece a cada if/elif/else.
Se hace mediante las tabulaciones, por lo que el código que se encuentre anidado dentro de cada uno será lo que se ejecute.
'''
edad = int(input("¿Cuántos años tienes? "))

if edad>=100:
    print("Tienes más años que un bosque.")
elif edad>=18:
    print("Eres mayor de edad.")
elif edad<0:
    print("No puedes tener edad negativa porque no habrías nacido aún.")
else:
    print("Eres un niño pequeño.")

'''
        OPERADORES LÓGICOS (and, or, not)
Para not -> if not(temp >= 0.0 and temp<=30.0):
Not niega la condición para cambiar su valor bool de true a flase o viceversa

'''
temp = float(input("¿Cuántos grados hace?: "))

if temp >= 0.0 and temp<=30.0:
    print("la temperatura es buena hoy")
    print("Sal fuera.")
elif temp < 0 or temp > 30:
    print("la temperatura es mala hoy.")
    print("Quédate en casa.")