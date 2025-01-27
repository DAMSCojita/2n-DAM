
# Definimos la clase 'CuentaBancaria'.
class CuentaBancaria:
    # Declaración de constructor.
    # También inicializamos atributos.
    def __init__(self, titular):
        self.titular = titular
        self.saldo = 0

    # Creamos un método para depositar una cantidad en la cuenta bancaria.
    def depositar(self, cantidad):
        self.saldo += cantidad # Sumamos la cantidad depositada al saldo actual.
        print(f"> Se ha depositado {cantidad} en su cuenta. Saldo actual: {self.saldo}") # Mostramos un mensaje indicando la cantidad depositada y el saldo actual.

    # Creamos un método para retirar una cantidad de la cuenta bancaria.
    def retirar(self, cantidad):
        # Estructura de control 'if'.
        # Verificará si el saldo es suficiente para realizar el retiro.
        # En caso de que no lo sea, indicará un mensaje.
        if self.saldo >= cantidad:
            self.saldo -= cantidad # Restamos la cantidad retirada del saldo actual.
            print(f"> Se ha retirado {cantidad} de su cuenta. Saldo actual: {self.saldo}") # Mostramos un mensaje indicando la cantidad retirada y el saldo actual.
        else:
            print("No se puede realizar el retiro. Fondos insuficientes.")

    # Creamos un método para mostrar la información de la cuenta bancaria.
    def mostrar_informacion(self):
        print(f"> Titular: {self.titular}")
        print(f"> Saldo: {self.saldo}")
        print("--------------------")

cuenta_1 = CuentaBancaria("Pedro") # Creamos un objeto para representar una cuenta bancaria.
cuenta_2 = CuentaBancaria("Sandra") # Creamos un objeto para representar otra cuenta bancaria.

cuenta_1.mostrar_informacion() # Mostramos la información inicial de la primera cuenta llamando a la función para ello.
cuenta_1.depositar(1000) # Depositamos 1000 en la primera cuenta.
cuenta_1.retirar(500) # Retiramos 500 de la primera cuenta.
cuenta_1.mostrar_informacion()

cuenta_2.mostrar_informacion() # Mostramos la información inicial de la segunda cuenta llamando a la función para ello.
cuenta_2.depositar(2000) # Depositamos 2000 en la segunda cuenta.
cuenta_2.retirar(1500) # Retiramos 1500 de la primera cuenta.
cuenta_2.mostrar_informacion()
