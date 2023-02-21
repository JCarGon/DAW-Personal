palabras = ["esternocleidomastoideo", "papaya", "loquete"]
palabranueva = ""

for i in range(len(palabras)):
    palabranueva += "*"
    for a in range(len(palabras[i])):
        palabranueva += "*"
    palabranueva += "*\n*"+palabras[i]+"*\n*"
    for a in range(len(palabras[i])):
        palabranueva += "*"
    palabranueva += "*\n"

print(palabranueva)

def getCubo(numero):
    cubo = ""
    principioLineaSuperior = "/\\"
    linea1 = "/\\_\\"
    finalLineaSuperior = "_\\"
    principioLineaInferior = "\\/"
    linea2 = "\\/_/"
    finalLineaInferior = "_/"

    for i in range(numero):
        # range(posición donde empieza, posición anterior a la que llega, progresión)
        for j in range(i+1, numero, +1):
            cubo += " "
        for j in range(numero-i, numero, +1):
            cubo += principioLineaSuperior
        cubo += linea1
        for j in range(numero-1):
            cubo += finalLineaSuperior
        cubo += "\n"

    for i in range(numero):
        for j in range(numero-i, numero, +1):
            cubo += " "
        for j in range(i+1, numero, +1):
            cubo += principioLineaInferior
        cubo += linea2
        for j in range(numero-1):
            cubo += finalLineaInferior
        if i < (numero-1):
            cubo += "\n"          
    return cubo