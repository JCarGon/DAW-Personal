# Inicializaciñon de una lista
cajon = ["calcetin", "chaleco", "camiseta", "pantalones"]
# La lista admite diferentes tipos, pero puede dar problema a la hora de utilizar métodos, como por ejemplo sort()

# Impresión de la lista completa

print(cajon)

# Impresión valor por valor

for i in cajon:
    print(i)

# Para reemplazar una de las posiciones

cajon[0] = "calzoncillos"

# Métodos de las listas:

# Append: añadir un valor al final de la lista

cajon.append("calcetin")

# Remove: elimina el valor de la lista buscando su posición

cajon.remove("calzoncillos")

# Del: elimina la posición dada. Si no le damos posición, borra la lista completa

del cajon[0]

# Extemds: combina varias listas

cajon2 = ["sujetador", "tacones"]
cajon.extend(cajon2)

# Sería lo mismo que hacer:

cajon += cajon2

# Pop: elimina el último elemento de la lista

cajon.pop() # Podemos imprimir el valor eliminado metiendolo en un print

# Insert: añade un valor en la posición dada, desplazando el resto de valores hacia la derecha

cajon.insert(0, "chicles")

# Sort: ordena la lista de manera ascendente

cajon.sort()

# Clear: limpia la lista de valores

cajon.clear()

# Para crear listas bidimensionales

cajon3 = ["pañuelo", "trapo", "gormiti"]

armario = [cajon, cajon2, cajon3]


# Indexar

nombre = "Los pythonisos"

if(nombre[4].islower()):
    nombre = nombre[0:4] + nombre[4].upper() + nombre[5:]
print(nombre)