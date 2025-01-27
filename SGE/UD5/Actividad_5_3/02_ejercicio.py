
# Creamos un decorador que contará el número de veces que se ha llamado a una función.
def contador_llamadas(funcion):
    # Creamos una función interna 'envoltorio()' pasando como parámetro el nombre y que envolverá la función original.
    def envoltorio(nombre): 
        envoltorio.contador += 1 # Incrementamos el contador asociado al envoltorio.
        print(f"La función decorada ha sido llamada {envoltorio.contador} veces.") # Mostramos la cantidad de veces que la función se llamó.
        return funcion(nombre) # Devolvemos la función original con el nombre.
    envoltorio.contador = 0 # Iniciamos un contador dentro del envoltorio.
    return envoltorio # Devolvemos la función.

# Usamos la función decorada para envolver la función de 'saludar()'.
@contador_llamadas
def saludar(nombre):
    print(f"> Saludos, {nombre}.")

# Llamamos a la función decorada varias veces con nombres diferentes.
saludar("Pere")
saludar("Carlos")
saludar("Eustaquio")