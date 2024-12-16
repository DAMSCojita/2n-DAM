
print("Bienvenido al programa básico para calcular el número mayor (solamente dos).") # Presentación básica del programa.
x = input("> Escribe un número: ") # Pedimos al usuario que introduzca un número y lo guardamos en una variable.
y = input("> Ahora, escribe otro número: ") # Hacemos lo mismo que la anterior línea de código pero para el otro número.

# Estructura de control 'if'.
# Si 'x' es mayor a 'y' (es decir, si el primer número que introdució el usuario es mayor al segundo) el programa lo escribirá por consola. Y en caso contrario lo mismo pero al revés.
if x > y:
    print(f"El número mayor es el {x}.") # Imprimimos 'x' que en este caso es el mayor.
elif x < y:
    print(f"El número mayor es el {y}.") # Imprimimos 'y' que en este caso es el mayor.