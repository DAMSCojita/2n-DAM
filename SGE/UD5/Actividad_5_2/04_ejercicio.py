
# Inicialización del diccionario de estudiantes
estudiantes = {}

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentación del menú principal.
    print("\n--------------------- REGISTRO DE NOTAS POR ASIGNATURA ---------------------")
    print("1. Agregar un estudiante (con sus materias y calificaciones).")
    print("2. Calcular el promedio de un estudiante.")
    print("3. Encontrar al estudiante con el mejor promedio.")
    print("4. Salir.")
    print("----------------------------------------------------------------------------")
    try:
        opcion = int(input("Elija una opción: "))  # Pedimos al usuario que elija una opción y la convertimos a un número entero.
    except ValueError:  # Si el usuario ingresa algo que no es un número, capturamos el error.
        print("Opción no válida. Debe ingresar un número entre 1 y 4.")  # Mostramos un mensaje de error si la opción no es válida.
        continue  # Continuamos con la siguiente iteración del bucle para pedir una opción válida.

    # Opción para agregar un estudiante.
    if opcion == 1:
        nombre = input("Ingrese el nombre del estudiante: ")  # Pedimos al usuario el nombre del estudiante.
        materias = []  # Creamos una lista vacía llamada 'materias' para almacenar las materias y calificaciones del estudiante.

        # Bucle 'while'.
        # Iterará hasta que el usuario ingrese 'fin' para finalizar la entrada de materias.
        while True:  
            materia = input("Ingrese el nombre de la materia (o 'fin' para terminar): ")  # Pedimos al usuario el nombre de la materia.
            if materia == 'fin':  # Si el usuario escribe 'fin', terminamos el bucle.
                break  # Salimos del bucle si se ingresa 'fin'.
            # Control de excepciones para calificación inválida.
            try:
                calificacion = float(input("Ingrese la calificación de la materia: "))  # Pedimos la calificación para la materia.
                while calificacion < 0 or calificacion > 100:  # Verificamos si la calificación está fuera del rango permitido (0-100).
                    print("Calificación inválida. Ingrese una calificación entre 0 y 100.")  # Mostramos un mensaje de error si la calificación es inválida.
                    calificacion = float(input("Ingrese la calificación de la materia: "))  # Pedimos de nuevo la calificación.
            except ValueError:  # Si se ingresa algo que no puede convertirse a un número, capturamos el error.
                print("Error: La calificación debe ser un número válido.")  # Mostramos un mensaje de error si la calificación no es válida.
                continue  # Continuamos con la siguiente iteración del bucle.
            materias.append((materia, calificacion))  # Agregamos la materia y la calificación como una tupla a la lista de materias.
        estudiantes[nombre] = materias  # Guardamos el nombre del estudiante como clave y la lista de materias y calificaciones como valor en el diccionario.
        print(f"\n> Estudiante agregado con éxito.\n")  # Mostramos un mensaje indicando que el estudiante fue agregado con éxito.

    # Opción para calcular el promedio de un estudiante.
    elif opcion == 2:
        nombre = input("Ingrese el nombre del estudiante: ")  # Pedimos el nombre del estudiante.

        if nombre not in estudiantes:  # Verificamos si el estudiante no existe en el diccionario.
            print("No existe ningún estudiante.")  # Si el estudiante no existe, mostramos un mensaje de error.
            continue  # Terminamos esta iteración si el estudiante no existe.
        
        materias = estudiantes[nombre]  # Recuperamos la lista de materias del estudiante.
        total = sum(calificacion for _, calificacion in materias)  # Calculamos la suma de las calificaciones del estudiante.
        promedio = total / len(materias)  # Calculamos el promedio del estudiante.
        print(f"\n> El promedio de '{nombre}' es: {promedio:.2f}\n")  # Mostramos el promedio del estudiante con dos decimales.

    # Opción para encontrar al estudiante con el mejor promedio.
    elif opcion == 3:
        if not estudiantes:  # Verificamos si no hay estudiantes registrados en el diccionario.
            print("No hay estudiantes registrados.")  # Mostramos un mensaje de error si no hay estudiantes.
            continue  # Terminamos esta iteración si no hay estudiantes.

        mejor_promedio = None  # Inicializamos la variable 'mejor_promedio' para encontrar el mejor promedio.
        mejor_estudiante = None  # Inicializamos la variable 'mejor_estudiante' para almacenar el estudiante con el mejor promedio.

        for nombre, materias in estudiantes.items():  # Iteramos sobre cada estudiante y sus materias en el diccionario.
            total = sum(calificacion for _, calificacion in materias)  # Calculamos la suma de las calificaciones del estudiante.
            promedio = total / len(materias)  # Calculamos el promedio del estudiante.

            if mejor_promedio is None or promedio > mejor_promedio:  # Si es el primer estudiante o su promedio es mayor al mejor promedio encontrado.
                mejor_promedio = promedio  # Actualizamos el mejor promedio.
                mejor_estudiante = nombre  # Guardamos el nombre del estudiante con el mejor promedio.

        print(f"\n> El estudiante con el mejor promedio es: {mejor_estudiante}\n")  # Mostramos el nombre del estudiante con el mejor promedio.

    # Opción para salir del programa.
    elif opcion == 4:
        print("Saliendo del programa...")
        break

    else:
        print("Opción no válida. Elija una opción correcta.")  # Mostramos un mensaje de error si la opción es inválida.
