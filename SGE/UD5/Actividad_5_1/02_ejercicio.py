
print("Bienvenido al programa básico para determinar números primos.") # Presentación básica del programa.
x = int(input("> Escribe un número entero (mayor que 2 y positivo): ")) # Pedimos al usuario que escriba un número entero con unas condiciones y lo guardamos en una variable. La pasamos como entero.

# Estructura de control 'if'.
# Verificará varias condiciones:
# - Que el número sea entero.
# - Que el número sea positivo.
# - Que el número sea mayor a 2.
# En caso de que no se cumplan las condiciones el programa lo avisará.
# Dentro de la estructura de control determinará si el número es o no primo.
if x >= 0:
    if x > 2:
        # Bucle 'for'.
        # Este bucle verifica si el número x es divisible por cualquiera de los valores del rango de 2 a x-1.
        # Si encuentra un divisor, entonces el número no es primo.
        # Si no encuentra ningún divisor, entonces el número es primo.
        for i in range (2, x):
            if (x % i) == 0:
                print(f"{x} no es un número primo.")
                break
            else:
                print(f"{x} es un número primo.")
                break
    else:
        print("El número debe ser mayor que 2.")
else:
    print("El número ingresado no es entero.")