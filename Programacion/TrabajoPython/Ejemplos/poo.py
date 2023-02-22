from Clases.Coche import coche

chevrolet = coche("Chevrolet", 8, 180, 400)

chevrolet.arrancar()
chevrolet.repostar(350)

print(chevrolet.getDepositoLleno())