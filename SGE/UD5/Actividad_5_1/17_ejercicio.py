
frutas = ["manzana", "pera", "uva", "mango"] # Creamos una lista con las frutas.

print(f"Lista de frutas: {frutas}") # Mostramos la lista de frutas inicial.

print() # Añadimos un salto de línea.
print("Eliminando el último elemento de la lista...") # Añadimos un mensaje informando de que estamos eliminando el último elemento de la lista.
frutas.pop() # Eliminamos el último elemento. Que en este caso será 'mango'.

print(f"> Lista actualizada: {frutas}") # Enseñamos la lista actualizada.
