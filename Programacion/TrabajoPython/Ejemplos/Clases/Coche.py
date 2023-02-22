class coche:

    def __init__(self, marca, ruedas, velocidad, deposito):
        self.__marca = marca
        self.__ruedas = ruedas
        self.__velocidad = velocidad
        self.__deposito = deposito
        self.__depositoLleno = 0

    def getDepositoLleno(self):
        return str(self.__depositoLleno)

    def arrancar(self):
        print("El coche ha arrancado")

    def repostar(self, cantidad):
        if (self.__depositoLleno + cantidad) < self.__deposito:
            self.__depositoLleno += cantidad
        else:
            self.__depositoLleno = self.__deposito    