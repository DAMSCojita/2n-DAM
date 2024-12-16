
meses = ("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre") # Creamos una tupla con los meses del año.

# Bucle 'while'.
# Iterará infinitamente por el 'True'.
while True:
    numero = int(input("Escribe un número (0 para salir): ")) # Pedimos un número al usuario hasta que introduzca un cero.

    # Estructura de control 'if'.
    # En caso de que el número sea 0, el programa terminará.
    if numero == 0:
        exit()
    else:
        # En caso contrario, comprobaremos si el número está entre 1 y la longitud de la tupla.
        if numero > 0 and numero <= len(meses):
            print(meses[numero - 1]) # Imprimimos el contenido de esa posición.
        else:
            print("Error. Introduzca un número de mes válido (del 1 al 12).") # Mostramos un mensaje de error.
        