
suma = 0 # Declaramos una variable que representa la suma de los números. La inicializamos a 0.

# Bucle 'while'.
# Comenzamos haciéndolo infinito siendo 'true'.
while True:
    # Solicitamos al usuario un número.
    numero = int(input("Ingrese un número (escriba 0 para dejar de introducir números): "))
    
    # Estructura de control 'if'.
    # Si el usuario ingresa 0, el bucle se detendrá y el programa imprimirá la suma.
    if numero == 0:
        break
    
    suma += numero # Vamos sumando los números.
print("> La suma de todos los números introducidos es: " + str(suma)) # Enseñamos el resultado de la suma al usuario.