
# Pedimos al usuario el nombre.
nombre = input("Introduce tu nombre: ")

# Pedimos al usuario el número de veces que quiere repetir el nombre.
numero = int(input("Ahora escribe cuántas veces deseas repetir tu nombre: "))

# Imprimimos el número de letras que tiene el nombre del usuario.
# Usamos 'len' para agarrar la longitud del nombre sin necesidad de hacer bucles para recorrer una cadena.
print(f"> El nombre '{nombre}' tiene {len(nombre)} letras.")
print("----------------------------------------")  # Separador.

# Bucle 'for'.
# Imprimirá el nombre del usuario tantas veces como el número introducido.
for i in range(numero):
    print(nombre)


    
