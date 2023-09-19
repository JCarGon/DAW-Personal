###Archivo para la teoría de la POO
----

-Clases
-Importación de una clase en un main
-Conceptos de herencia o semejante

### Para inicializar una clase con su constructor:

    class coche:

    def __init__(self, marca, ruedas, velocidad, deposito):
        self.marca = marca
        self.ruedas = ruedas
        self.velocidad = velocidad
        self.deposito = deposito

### Para crear métodos para nuestra clase:

    def getDepositoLleno(self):
        return str(self.__depositoLleno)

    def arrancar(self):
        print("El coche ha arrancado")

    def repostar(self, cantidad):
        if (self.__depositoLleno + cantidad) < self.__deposito:
            self.__depositoLleno += cantidad
        else:
            self.__depositoLleno = self.__deposito   

### Para llamar a la clase, crear un nuevo objeto y usar sus métodos:

    from Clases.Coche import coche

    chevrolet = coche("Chevrolet", 8, 180, 400)
    chevrolet.arrancar()

""" POO - Herencia (creaciones de clases coche(superclase) y cochevolador(subclase))
class Coche:
    
    ruedas = 4
    
    def __init__(self, deposito, km):
        self.deposito = deposito
        self._km = km # para hacer un atributo privado
        
    def repostar(self, cantidad):
        self.deposito += cantidad
        
--------------------------
-En la subclase hay que importar primero la clase padre

from Coche import Coche
class CocheVolador(Coche):
    
    ruedas = 6
    
    def __init__(self, deposito, km, esta_volando=False):
        super().__init__(deposito, km)
        self.esta_volando = esta_volando
        
    def vuela(self):
        if self.esta_volando:
            print("El coche ya está volando.")
        else:
            self.esta_volando=True
            print("El coche empieza a volar.")
            
    def aterrizar(self):
        if self.esta_volando:
            self.esta_volando=False
            print("El coche aterriza.")
        else:
            print("El coche ya está en tierra firme.")
"""
from Coche import Coche
from CocheVolador import CocheVolador

coche1 = Coche(100, 50000)
print(coche1.deposito)

cocheVolador1 = CocheVolador(150, 2000)
cocheVolador1.vuela()
cocheVolador1.vuela()
cocheVolador1.aterrizar()
cocheVolador1.aterrizar()
cocheVolador1.repostar(20)
print(cocheVolador1.deposito)
cocheVolador1.repostar(50)
print(cocheVolador1.deposito)

print(isinstance(coche1, Coche))
print(isinstance(cocheVolador1, Coche))
print(issubclass(Coche, CocheVolador))
print(issubclass(CocheVolador, Coche))

# isinstance te dice con un bool si el primer parámetro es un objeto de la clase del segundo parámetro o alguna de sus clases hijas
# issubclass te dice con un bool si el primer parámetro es una subclase del segundo parámetro

"""             POLIMORFISMO
(clase padre Animal, las demás heredan de ella)

class Perro:
    def sonido(self):
        print('Guauuuuu!!!')
        
class Gato:
    def sonido(self):
        print('Miaaauuuu!!!')
        
class Vaca:
    def sonido(self):
        print('Múuuuuuuu!!!')
       
- MAIN - 
def a_cantar(animales):
    for animal in animales:
        animal.sonido()

Va a imprimir el método correspondiente a cada clase
"""