
contactos = {} # Creamos un diccionario vacío de contactos.

# Bucle 'while'.
# Iterará pidiendo un nombre y un teléfono (a no ser que más adelante el usuario salga).
while True:
    nombre = input("Escribe el nombre del contacto (o 'no' para terminar): ") # Pedimos al usuario que ingrese el nombre del contacto.
    
    # Estructura de control 'if'.
    # Si el usuario escribe 'no'. Saldremos del programa.
    if nombre.lower() == 'no':
        break
    
    # Estructura de control 'if'.
    # Si el nombre del usuario se encuentra en el diccionario, el programa informará de ello y volverá a pedir el nombre.
    if nombre in contactos:
        print("Ese nombre ya está en uso. Inténtelo de nuevo.")
        continue
    
    telefono = input("Ahora, escribe el teléfono del contacto: ") # Pedimos al usuario que introduzca el teléfono del contacto.
    contactos[nombre] = telefono; # Asignamos el número de teléfono al contacto con el nombre especificado.
    print("----------------------------------------")

# Mostramos el diccionario.
print("\nDiccionario de contactos: \n")
# Bucle 'for'.
# Iterará por cada nombre y teléfono del diccionario de contacto y mostrará los que hay.
for nombre, telefono in contactos.items():
    print(f"> Clave: {nombre}, Valor: {telefono}")
    print("----------------------------------------")


