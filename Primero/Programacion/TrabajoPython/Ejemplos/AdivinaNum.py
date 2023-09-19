import random

opcionMaquina = random.randint(1, 100)
vidas = 5
numero = 0

while (numero != opcionMaquina) and (vidas > 0):
    numero = int (input("Trata de adivinar el número en el que piensa la máquina: "))
    if numero > opcionMaquina:
        vidas -= 1
        print("El número de la máquina es más pequeño. Pierdes una vida, te quedan " + str(vidas) + ".")
    elif numero < opcionMaquina:
        vidas -= 1
        print("El número de la máquina es más grande. Pierdes una vida, te quedan " + str(vidas) + ".")
    else:
        print("Enhorabuena, has acertado! El número era el " + str(opcionMaquina) + ".")
    if vidas == 0:
        print("Has perdido porque te has quedado sin vidas. El número de la máquina era el " + str(opcionMaquina) + ".")