import random
vidasusuario = 3
vidasordenador = 3
opciones = ["piedra", "papel", "tijeras"]
jugador = ""

while vidasordenador > 0 and vidasusuario > 0:
    ordenador = random.choice(opciones)
    
    jugador = input("Elige: ¿piedra, papel o tijeras?: ")

    while jugador not in opciones:
        print("Ha introducido una opcion incorrecta.")
        jugador = input("Elige: ¿piedra, papel o tijeras?: ")

    if jugador == ordenador:
        print("Habeis sacado lo mismo. Siguiente ronda:")
    elif jugador == "piedra":
        if ordenador == "papel":
            print("El jugador ha sacado " + jugador + ". El ordenador ha sacado " + ordenador + ". El jugador pierde vida.")
            vidasusuario -= 1
        elif ordenador == "tijeras":
            print("El jugador ha sacado " + jugador + ". El ordenador ha sacado " + ordenador + ". El ordenador pierde vida.")
            vidasordenador -= 1
    elif jugador == "papel":
        if ordenador == "piedra":
            print("El jugador ha sacado " + jugador + ". El ordenador ha sacado " + ordenador + ". El ordenador pierde vida.")
            vidasordenador -= 1
        elif ordenador == "tijeras":
            print("El jugador ha sacado " + jugador + ". El ordenador ha sacado " + ordenador + ". El usuario pierde vida.")
            vidasusuario -= 1
    elif jugador == "tijeras":
        if ordenador == "papel":
            print("El jugador ha sacado " + jugador + ". El ordenador ha sacado " + ordenador + ". El ordenador pierde vida.")
            vidasordenador -= 1
        elif ordenador == "piedra":
            print("El jugador ha sacado " + jugador + ". El ordenador ha sacado " + ordenador + ". El usuario pierde vida.")
            vidasusuario -= 1

    print("Vidas usuario: " + str(vidasusuario))
    print("Vidas ordenador: " + str(vidasordenador))