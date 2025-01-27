
# Declaración de variables junto con las operaciones lambda correspondientes.
suma = lambda x, y: x + y
resta = lambda x, y: x - y
multiplicacion = lambda x, y: x * y
division = lambda x, y: x / y

# Bucle principal para la ejecución de la calculadora.
while True:
    # Presentación del programa.
    print("\n--------------- CALCULADORA BÁSICA CON LAMBDA ----------------")
    print("1. Sumar.")
    print("2. Restar.")
    print("3. Multiplicar.")
    print("4. Dividir.")
    print("5. Salir.")
    print("--------------------------------------------------------------")

    try:
        opcion = int(input("Elija una opción: "))

        # Estructura de control 'if'.
        # Validamos que la opción esté dentro del rango permitido.
        if opcion < 1 or opcion > 5:
            raise ValueError("Error. ") # Generamos un error si la opción no es válida.
    except ValueError:
        # Mensaje de error para opciones no válidas.
        print("Por favor, elija una opción correcta (del 1 al 5).")
        continue
    
    # Verificamos si el usuario desea salir del programa.
    # Introducimos esta porción de código aquí y no al final porqué si no nos volverá a pedir ambos números.
    if opcion == 5:
        print("Saliendo del programa...")
        break

    try:
        # Solicitamos los dos números al usuario.
        x = float(input("Ingrese el primer número: "))
        y = float(input("Ingrese el segundo número: "))
    except ValueError:
        # Mensaje de error si los valores ingresados no son numéricos.
        print("Error: Los valores deben ser numéricos.")
        continue

    # Manejo de las opciones del programa.
    # Por cada opción, se enseñará el resultado en el mismo print llamando a la operación lambda que toque.

    # Operación de suma.
    if opcion == 1:
        print(f"> El resultado de la suma es: {suma(x, y)}")
    # Operación de resta.
    elif opcion == 2:
        print(f"> El resultado de la resta es: {resta(x, y)}")
    # Operación de multiplicación.
    elif opcion == 3:
        print(f"> El resultado de la multiplicación es: {multiplicacion(x, y)}")
    # Operación de división.
    elif opcion == 4:
        # Estructura de control 'if'.
        # Evitará la división por 0.
        if x == 0 or y == 0:
            # Mensaje de error si el segundo número es 0.
            print("No se puede dividir por 0.")
        else:
            # Ejecutamos la operación de división y mostramos el resultado.
            print(f"> El resultado de la división es: {division(x, y)}")
