
# Inicializamos el diccionario vacío de estudiantes y notas.
estudiantes_notas = {}

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentamos el menú principal.
    print("\n--------- GESTIÓN DE ESTUDIANTES Y ASIGNATURAS ----------")
    print("1. Agregar un estudiante con sus asignaturas y notas.")
    print("2. Consultar las asignaturas y notas de un estudiante.")
    print("3. Calcular el promedio de notas de un estudiante.")
    print("4. Salir.")
    print("---------------------------------------------------------")
    
    # Pedimos al usuario que elija una opción del menú.
    opcion = int(input("Elija una opción: "))

    # Opción para agregar un estudiante con sus asignaturas y notas.
    if opcion == 1:
        nombre = input("Ingrese el nombre del estudiante: ")  # Pedimos al usuario el nombre del estudiante.
        if nombre in estudiantes_notas:  # Verificamos si el estudiante ya existe en el diccionario.
            print("Error: Estudiante con el nombre ya existe.")  # Mostramos un mensaje de error si el estudiante ya existe.
            continue
        
        # Inicializamos el diccionario de notas para el estudiante.
        estudiantes_notas[nombre] = {}

        while True:
            materia = input("Ingrese el nombre de la asignatura (o 'fin' para terminar): ")  # Pedimos la asignatura.
            if materia.lower() == "fin":  # Finalizamos la entrada de asignaturas si se ingresa "fin".
                break

            # Controlamos entradas no válidas para las calificaciones.
            try:
                nota = float(input("Ingrese la nota para la asignatura: "))  # Pedimos la nota para la asignatura.
                while nota < 0 or nota > 100:  # Validamos que la nota esté en el rango permitido.
                    print("Error: La nota debe estar entre 0 y 100.")
                    nota = float(input("Ingrese la nota para la asignatura: "))
            except ValueError:
                print("Error: La nota debe ser un número válido.")
                continue

            # Agregamos la asignatura y la nota al diccionario del estudiante.
            estudiantes_notas[nombre][materia] = nota
            print(f"> Alumno y asignatura agregados.")

    # Opción para consultar las notas de un estudiante.
    elif opcion == 2:
        nombre = input("Ingrese el nombre del estudiante: ")  # Pedimos al usuario el nombre del estudiante.
        if nombre not in estudiantes_notas:  # Verificamos si el estudiante no existe en el diccionario.
            print("No existe ningún estudiante con ese nombre.")  # Mostramos un mensaje de error si el estudiante no existe.
            continue

        # Mostramos las asignaturas y notas del estudiante.
        print(f"\nNotas de '{nombre}':")
        for materia, nota in estudiantes_notas[nombre].items():
            print(f"> {materia}: {nota}")
        print("\n")

    # Opción para calcular el promedio de un estudiante.
    elif opcion == 3:
        nombre = input("Ingrese el nombre del estudiante: ")  # Pedimos al usuario el nombre del estudiante.
        if nombre not in estudiantes_notas:  # Verificamos si el estudiante no existe en el diccionario.
            print("No existe ningún estudiante con ese nombre.")  # Mostramos un mensaje de error si el estudiante no existe.
            continue

        # Calculamos el promedio de las notas del estudiante.
        total = sum(nota for _, nota in estudiantes_notas[nombre].items())
        promedio = total / len(estudiantes_notas[nombre])  # Dividimos la suma de las notas entre el número de asignaturas.
        print(f"\n> Promedio de notas de '{nombre}': {promedio:.2f}\n")

    # Opción para salir del programa.
    elif opcion == 4:
        print("Saliendo del programa...")
        break

    else:
        print("Introduzca una opción válida.")
