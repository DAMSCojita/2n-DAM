
# Creamos la función de 'registrar_estudiante()' pasándole argumentos posicionales (*args) y argumentos clave-valor (**kwargs).
def registrar_estudiante(*args, **kwargs):
    # Verificamos si hay asignaturas en los argumentos posicionales (*args).
    # Si existen, las unimos en un string separados por comas y las imprimimos.
    # Si no hay, imprimimos un mensaje indicando que no está inscrito en ninguna asignatura.
    print(f"Asignaturas inscritas: {', '.join(args) if args else 'No inscrito en ninguna asignatura'}")

    print("Información personal:")
    # Estructrura de control 'if'.
    # Verificará si se ha pasado argumentos clave-valor (**kwargs).
    # En caso de que no haya ninguna información, lo especificará.
    if kwargs:
        # Bucle 'for'.
        # Imprimirá cada par clave-valor en una línea.
        for key, value in kwargs.items():
            print(f">  {key}: {value}")
    else:
        print("No hay información.") 
    print("--------------------")

# Llamamos varias veces a la función creada anteriormente con diferentes combinaciones de datos.
registrar_estudiante("Matemáticas", "Geografía y Historia", nombre = "Andrés Beredo", edad = 16, ciudad = "Washington")
registrar_estudiante(nombre = "Alejandra Bogavante", edad = 19, ciudad = "Barcelona")
registrar_estudiante("Física", "Química", "Biología")
registrar_estudiante() # Llamamos a la función aquí sin nada para iniciar el programa.
