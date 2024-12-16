
import random # Importamos la librería de 'random' para poder generar valores aleatorios.

nombre = input("Introduce tu nombre: ") # Pedimos el nombre al usuario.
numero_secreto = random.randint(1, 20) # Generamos un número aleatorio entre 1 y 20 con 'random.randint()' y lo guardamos en una variable.
intentos = 0 # Declaramos una variable para representar el máximo de intentos.
MAX_INTENTOS = 6 # Declaramos una constante para representar el máximo de intentos.

# Bucle 'while'.
# Iterará mientras los intentos del usuario sean menores de 6.
while intentos < MAX_INTENTOS:
    intentos += 1 # Sumamos un intento a la variable.
    numero_usuario = int(input(f"Intento {intentos}/{MAX_INTENTOS}: Adivina el número (entre 1 y 20): ")) # Pedimos al usuario que intente adivinar el número secreto. Además, le proporcionamos un recuento de intentos que lleve y el máximo.
    
    # Estructuras de control 'if'.
    # Si el número introducido por el usuario es igual al número secreto, muestra un mensaje de felicitación y termina el programa.
    if numero_usuario == numero_secreto:
        print(f"\n¡Felicidades, {nombre}! Adivinaste el número {numero_secreto} en {intentos} intentos.")
        exit() # Cuando se cumple la condición de que el usuario ha adivinado el número, se sale del bucle con 'exit()' para finalizar el programa.
    elif numero_usuario > numero_secreto:
        print("El número es más bajo.") # En caso de que el número introducido sea mayor, muestra un mensaje de que el número es más bajo.
    else:
        print("El número es más alto.") # En caso de que el número introducido sea menor, muestra un mensaje de que el número es más alto.

print(f"\n¡Has perdido, {nombre}! El número secreto era {numero_secreto}.") # Al final, mostramos un mensaje de que ha perdido y el número secreto en caso de que no lo haya conseguido.