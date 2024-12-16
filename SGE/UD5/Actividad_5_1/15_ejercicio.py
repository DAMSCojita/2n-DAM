
numero = int(input("Introduce un número entero: ")) # Pedimos al usuario un número entero.

tabla_multiplicar = [] # Creamos una lista.

# Bucle 'while'.
# Iterará desde el 1 hasta 11 (inclusive).
for i in range(1, 11):
    tabla_multiplicar.append(numero * i) # Calculamos la multiplicación del número por el índice y la agregamos a la lista.

print("> La tabla de multiplicar del número", numero, "es:", tabla_multiplicar) # Mostramos la lista.