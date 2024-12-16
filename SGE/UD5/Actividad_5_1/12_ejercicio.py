
lista_numeros = [] # Inicializamos una lista.

tamaño_lista = int(input("Escribe el tamaño que desees para la lista: ")) # Pedimos al usuario el tamaño de la lista

# Bucle 'while'.
# Iteramos sobre el tamaño de la lista para agregar los valores a la lista.
for i in range(tamaño_lista):
    # Pedimos al usuario un número
    numero = float(input(f"Introduce el número {i + 1}: "))  # Convertimos el input de string a float para poder operar con decimales. Lo guardamos en una nueva variable.
    # Agregamos el número a la lista
    lista_numeros.append(numero) # Agregamos el número a la lista.

promedio = sum(lista_numeros) / len(lista_numeros) # Calculamos el promedio y lo guardamos en una variable.

print(f"> El promedio de los valores ingresados es: {promedio}") # Mostramos el promedio.