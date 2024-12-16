
numeros_positivos = [] # Inicializamos una lista vacía para almacenar los números positivos.

# Bucle 'while'.
# Empezará iterando infinitamente.
while True:
    numero = int(input("Ingrese un número entero (pon un número mayor a 100 para terminar): ")) # Pedimos al usuario que ingrese un número.
    # Estructuras de control 'if'.
    # Si el número es negativo, el programa lo ignorará y continuará pidiendo números.
    # En caso de que el número que introduza sea mayor a 100, saldrá del bucle.
    if numero < 0:
        continue
    if numero > 100:
        break
    numeros_positivos.append(numero) # Añadimos los numeros puestos por el usuario a la lista.
print("> Números positivos introducidos hasta ese momento:", numeros_positivos) # Enseñamos los números positivos al usuario.