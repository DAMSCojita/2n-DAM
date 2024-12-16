
lista_numeros = [] # Declaramos en una lista.

# Bucle 'while'.
# Iterará infinitamente para pedir números al usuario (y saldrá cuando elija 0).
while True:

    numero = int(input("Escribe un número (pon 0 para salir): ")) # Pedimos un número al usuario y que introduzca un '0' cuando quiera dejar de añadir números.
    
    # Estructura de control 'if'.
    # Si el número es 0, salimos del bucle.
    if numero == 0:
        break
    
    lista_numeros.append(numero) # Añadimos el número al final de la lista.

lista_numeros.sort() # Ordenamos la lista de menor a mayor.

print("------------------------------------------------------------") # Añadimos un separador.
print("> Números ordenados de menor a mayor:")
# Bucle 'while'.
# Mostrará los números ordenados de menor a mayor.
for numero in lista_numeros:
    print(numero)

lista_numeros.sort(reverse=True) # Invertimos la lista para hacer lo contrario (es decir, ordenarlos de mayor a menor).

print("------------------------------------------------------------") # Añadimos un separador.
print("> Números ordenados de mayor a menor:")
# Bucle 'while'.
# Mostrará los números ordenados de mayor a menor.
for numero in lista_numeros:
    print(numero)
