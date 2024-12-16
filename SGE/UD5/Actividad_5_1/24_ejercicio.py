
import random  # Importamos la librería random para generar números aleatorios.

lista_numeros = []  # Inicializamos una lista vacía que se llenará con números aleatorios.

# Bucle 'while'.
# Iterará infinitamente hasta que el usuario decida salir del programa.
while True:
    # Mostramos el menú interactivo.
    print("\n----------------------- MENÚ INTERACTIVO -----------------------")
    print("a. Crear una lista nueva con números enteros aleatorios.")
    print("b. Imprimir la lista.")
    print("c. Mostrar el mayor número de la lista.")
    print("d. Mostrar el menor número de la lista.")
    print("e. Sumar los números de la lista.")
    print("f. Calcular el promedio de la lista.")
    print("g. Salir del programa.")
    print("----------------------------------------------------------------")
    opcion = input("Elija una opción: ")  # Solicitamos al usuario que elija una opción.

    # Estructura de control 'if'.
    # Dependiendo de la opción elegida, se ejecutará una acción específica.
    if opcion.lower() == "a":  # Opción para crear una nueva lista de números aleatorios.
        cantidad_numeros = int(input("Ingrese la cantidad de números a generar: "))  # Pedimos la cantidad de números.
        lista_numeros = random.sample(range(1, 101), cantidad_numeros)  # Generamos una lista de números aleatorios.
        print(f"> Números generados: {lista_numeros}")  # Mostramos la lista generada.

    elif opcion.lower() == "b":  # Opción para imprimir la lista.
        # Estructura de control 'if'.
        # Si la lista está vacía, mostramos un mensaje de aviso.
        if not lista_numeros:
            print("No hay ninguna lista creada...")
        else:
            print("La lista es:", lista_numeros)  # Mostramos los números de la lista.

    elif opcion.lower() == "c":  # Opción para mostrar el mayor número de la lista.
        # Estructura de control 'if'.
        # Si la lista está vacía, mostramos un mensaje de aviso.
        if not lista_numeros:
            print("No hay ninguna lista creada...")
        else:
            print("> El mayor número de la lista es:", max(lista_numeros))  # Calculamos y mostramos el mayor número.

    elif opcion.lower() == "d":  # Opción para mostrar el menor número de la lista.
        # Estructura de control 'if'.
        # Si la lista está vacía, mostramos un mensaje de aviso.
        if not lista_numeros:
            print("No hay ninguna lista creada...")
        else:
            print("> El menor número de la lista es:", min(lista_numeros))  # Calculamos y mostramos el menor número.

    elif opcion.lower() == "e":  # Opción para sumar los números de la lista.
        # Estructura de control 'if'.
        # Si la lista está vacía, mostramos un mensaje de aviso.
        if not lista_numeros:
            print("No hay ninguna lista creada...")
        else:
            print("> La suma de los números de la lista es:", sum(lista_numeros))  # Sumamos y mostramos el resultado.

    elif opcion.lower() == "f":  # Opción para calcular el promedio de la lista.
        # Estructura de control 'if'.
        # Si la lista está vacía, mostramos un mensaje de aviso.
        if not lista_numeros:
            print("No hay ninguna lista creada...")
        else:
            # Calculamos el promedio dividiendo la suma de los elementos entre la cantidad de elementos.
            print("> El promedio de la lista es:", sum(lista_numeros) / len(lista_numeros))

    elif opcion.lower() == "g":  # Opción para salir del programa.
        print("\nSaliendo del programa. ¡Hasta pronto!")  # Mensaje de despedida.
        break  # Finalizamos el bucle y salimos del programa.

    else:  # Estructura de control 'else'.
        # Si el usuario ingresa una opción inválida, mostramos un mensaje de advertencia.
        print("\nOpción no válida. Por favor, elija una opción del menú.")
