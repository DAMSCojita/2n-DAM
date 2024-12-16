
# Declaración de la lista de empleados.
empleados = []

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentación del menú principal.
    print("\n--------------------- GESTIÓN DE EMPLEADOS ---------------------")
    print("1. Agregar empleado")
    print("2. Calcular promedio de salarios")
    print("3. Buscar empleados por posición")
    print("4. Salir")
    print("----------------------------------------------------------------")
    try:
        opcion = int(input("Elija una opción: "))  # Pedimos al usuario que elija una opción y la convertimos a un número entero.

        # Opción para agregar empleado.
        if opcion == 1:
            try:
                nombre = input("Escribe el nombre del empleado: ").strip()  # Pedimos al usuario el nombre del empleado y eliminamos espacios extra.
                if not nombre:  # Verificamos si el nombre está vacío.
                    print("Error: El nombre no puede estar vacío.")  # Si el nombre está vacío, mostramos un mensaje de error.
                    continue  # Volvemos al menú principal.

                posiciones = input("Escribe las posiciones del empleado (separadas por comas): ").strip().split(",")  # Pedimos las posiciones del empleado, separadas por comas.
                posiciones = tuple(posicion.strip() for posicion in posiciones if posicion.strip())  # Limpiamos espacios extra y convertimos a tupla, eliminando entradas vacías.
                if not posiciones:  # Verificamos si no se ingresaron posiciones.
                    print("Error: Debe ingresar al menos una posición.")  # Mostramos un mensaje de error si no se ha ingresado ninguna posición.
                    continue  # Volvemos al menú principal.

                salario = float(input("Escribe el salario del empleado: "))  # Pedimos el salario del empleado y lo convertimos a tipo float.
                if salario <= 0:  # Verificamos si el salario es negativo o igual a cero.
                    print("Error: El salario debe ser un número positivo.")  # Si el salario no es válido, mostramos un mensaje de error.
                    continue  # Volvemos al menú principal.

                empleado = {"nombre": nombre, "posiciones": posiciones, "salario": salario}  # Creamos un diccionario con la información del empleado.
                empleados.append(empleado)  # Añadimos el diccionario del empleado a la lista de empleados.
                print("> Empleado agregado correctamente.")  # Mostramos un mensaje de éxito al agregar el empleado.
            except ValueError:  # Capturamos cualquier error de tipo ValueError (por ejemplo, si el salario no es un número válido).
                print("Error: El salario debe ser un número válido.")  # Mostramos un mensaje de error si el salario no es válido.

        # Opción para calcular el promedio de salarios.
        elif opcion == 2:
            if not empleados:  # Verificamos si la lista de empleados está vacía.
                print("No hay empleados registrados para calcular el promedio de salarios.")  # Mostramos un mensaje si no hay empleados registrados.
                continue  # Volvemos al menú principal.
            promedio = sum(empleado["salario"] for empleado in empleados) / len(empleados)  # Calculamos el promedio de los salarios de todos los empleados.
            print(f"> El promedio de los salarios es: {promedio:.2f}")  # Mostramos el promedio de salarios con dos decimales.

        # Opción para buscar empleados por posición.
        elif opcion == 3:
            posicion_buscada = input("Escribe la posición a buscar: ").strip()  # Pedimos la posición que se desea buscar y eliminamos espacios extra.
            empleados_en_posicion = [empleado for empleado in empleados if posicion_buscada in empleado["posiciones"]]  # Filtramos los empleados que tienen la posición buscada.
            if not empleados_en_posicion:  # Verificamos que haya empleados con la posición buscada.
                print(f"Error: No se encontraron empleados con la posición '{posicion_buscada}'.")  # Mostramos un mensaje de error si no se encuentran empleados con esa posición.
            else:  # Si se encuentran empleados con la posición buscada.
                print(f"Empleados con la posición '{posicion_buscada}':")  # Mostramos un encabezado con la lista de empleados que tienen esa posición.
                for empleado in empleados_en_posicion:  # Iteramos sobre los empleados encontrados con esa posición.
                    print(f"> Nombre: {empleado['nombre']}, Salario: {empleado['salario']:.2f}")  # Mostramos el nombre y el salario de cada empleado.

        # Opción para salir del programa.
        elif opcion == 4:
            print("Saliendo del programa...")
            break

        else:
            print("Opción no válida. Por favor, elija una opción del menú.")  # Mostramos un mensaje de error si la opción no es válida.

    except ValueError:  # Capturamos cualquier error de tipo ValueError (por ejemplo, si la opción no es un número entero).
        print("Error: Debe ingresar un número válido.")
