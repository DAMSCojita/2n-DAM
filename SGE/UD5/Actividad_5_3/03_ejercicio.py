
import time  # Importamos la librería 'time' necesaria para medir tiempos de ejecución.

# Creamos un decorador que medirá el tiempo de ejecución de una función.
def tiempo(funcion):
    # Creamos una función interna 'envoltorio' que encapsulará la función original para añadir funcionalidad adicional.
    def envoltorio(*args, **kwargs):
        tiempo_Comienzo = time.time() # Guardamos el tiempo de inicio en una variable antes de ejecutar la función.    
        resultado = funcion(*args, **kwargs) # Llamamos a la función original con los argumentos proporcionados y almacenamos su resultado.
        tiempoFinal = time.time() # Guardamos el tiempo al finalizar la ejecución de la función.
        tiempoEjecucion = tiempoFinal - tiempo_Comienzo # Calculamos la diferencia entre el tiempo de inicio y el final para obtener el tiempo de ejecución.
        print(f"> La función {funcion.__name__} tardó {tiempoEjecucion:.2f} segundos en ejecutarse.") # Calculamos la diferencia entre el tiempo de inicio y el final para obtener el tiempo de ejecución.
        return resultado # Retornamos el resultado de la función original.
    # Retornamos la función interna para que actúe como decorador.
    return envoltorio

# Decoramos la función 'suma_numeros' con el decorador.
@tiempo
def suma_numeros():
    return sum(range(1, 1000001)) # Calculamos la suma de los números del 1 al 1,000,000 y devolvemos el resultado.

# Decoramos la función 'cuenta_pares' con el decorador.
@tiempo
def cuenta_pares():
    return sum(num % 2 == 0 for num in range(1, 1000001)) # Contamos cuántos números pares hay entre 1 y 1,000,000 y devolvemos el resultado.

# Llamamos a la función 'suma_numeros' para ejecutar y medir el tiempo de su ejecución.
suma_numeros()

# Llamamos a la función 'cuenta_pares' para ejecutar y medir el tiempo de su ejecución.
cuenta_pares()
