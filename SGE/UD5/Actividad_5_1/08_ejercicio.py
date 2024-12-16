
import time # Importamos la librería de 'time'.

# Presentación del programa.
# Pedimos al usuario que ingrese el tiempo en segundos.
segundos = int(input("Ingrese el tiempo en segundos: "))

# Bucle 'while'.
# Mientras que el tiempo no haya llegado a 0.
while segundos > 0:
    # Mostramos el tiempo restante.
    print(f"Tiempo restante: {segundos} segundos")
    # Pausamos el programa durante un segundo.
    time.sleep(1)
    # Disminuimos el tiempo en 1 segundo.
    segundos -= 1
