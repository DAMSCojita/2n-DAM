
# Declaración de la lista de empleados.
empleados = []

# Creamos una función para agregar un nuevo empleado.
def agregar_empleado():
    try:
        nombre = input("Escribe el nombre del empleado: ").strip()  # Pedimos al usuario el nombre del empleado y eliminamos espacios extra.
        if not nombre:  # Verificamos si el nombre está vacío.
            print("Error: El nombre no puede estar vacío.")  # Si el nombre está vacío, mostramos un mensaje de error.
            return  # Terminamos la función si no se ingresó un nombre válido.

        posiciones = input("Escribe las posiciones del empleado (separadas por comas): ").strip().split(",")  # Pedimos las posiciones del empleado, separadas por comas.
        posiciones = tuple(posicion.strip() for posicion in posiciones if posicion.strip())  # Limpiamos espacios extra y convertimos a tupla, eliminando entradas vacías.
        # Estructura de control 'if'.
        # Verificará si no se ingresaron posiciones.
        if not posiciones:  
            print("Error: Debe ingresar al menos una posición.")  # Mostramos un mensaje de error si no se ha ingresado ninguna posición.
            return  # Terminamos la función si no hay posiciones válidas.

        salario = float(input("Escribe el salario del empleado: "))  # Pedimos el salario del empleado y lo convertimos a tipo float.
        # Estructura de control 'if'.
          # Verificará si el salario es negativo o igual a cero.
        if salario <= 0:
            print("Error: El salario debe ser un número positivo.")  # Si el salario no es válido, mostramos un mensaje de error.
            return  # Terminamos la función si el salario no es válido.
        empleado = {"nombre": nombre, "posiciones": posiciones, "salario": salario}  # Creamos un diccionario con la información del empleado.
        empleados.append(empleado)  # Añadimos el diccionario del empleado a la lista de empleados.
        print("> Empleado agregado correctamente.")  # Mostramos un mensaje de éxito al agregar el empleado.
    except ValueError:  # Capturamos cualquier error de tipo ValueError (por ejemplo, si el salario no es un número válido).
        print("Error: El salario debe ser un número válido.")  # Mostramos un mensaje de error si el salario no es válido.

# Creamos una función para calcular el promedio de los salarios.
def calcular_promedio_salarios():
    # Estructura de control 'if'.
    # Verificará si la lista de empleados está vacía.
    if not empleados:  
        print("No hay empleados registrados para calcular el promedio de salarios.")  # Mostramos un mensaje si no hay empleados registrados.
        return  # Terminamos la función si no hay empleados.
    promedio = sum(empleado["salario"] for empleado in empleados) / len(empleados)  # Calculamos el promedio de los salarios de todos los empleados.
    print(f"> El promedio de los salarios es: {promedio:.2f}")  # Mostramos el promedio de salarios con dos decimales.

# Creamos una función para buscar empleados por una posición específica.
def buscar_empleados_por_posicion():
    posicion_buscada = input("Escribe la posición a buscar: ").strip()  # Pedimos la posición que se desea buscar y eliminamos espacios extra.
    empleados_en_posicion = [empleado for empleado in empleados if posicion_buscada in empleado["posiciones"]]  # Filtramos los empleados que tienen la posición buscada.
    # Estructura de control 'if'.
    # Verificará que haya empleados.
    if not empleados_en_posicion:  
        print(f"Error: No se encontraron empleados con la posición '{posicion_buscada}'.")  # Mostramos un mensaje de error si no se encuentran empleados con esa posición.
    else:  # Si se encuentran empleados con la posición buscada.
        print(f"Empleados con la posición '{posicion_buscada}':")  # Mostramos un encabezado con la lista de empleados que tienen esa posición.
        for empleado in empleados_en_posicion:  # Iteramos sobre los empleados encontrados con esa posición.
            print(f"> Nombre: {empleado['nombre']}, Salario: {empleado['salario']:.2f}")  # Mostramos el nombre y el salario de cada empleado.

# Creamos una función para mostrar el menú principal y gestionar las opciones del usuario.
def menu_principal():
    while True:  # Bucle infinito que mantendrá el menú activo hasta que el usuario elija salir.
        # Presentación del menú principal.
        print("\n--------------------- GESTIÓN DE EMPLEADOS ---------------------")
        print("1. Agregar empleado")
        print("2. Calcular promedio de salarios")
        print("3. Buscar empleados por posición") 
        print("4. Salir")  
        print("----------------------------------------------------------------")
        try:
            opcion = int(input("Elija una opción: "))  # Pedimos al usuario que elija una opción y la convertimos a un número entero.
            if opcion == 1:  
                agregar_empleado() # Si elige la opción 1, ejecutamos la función para agregar un empleado.
            elif opcion == 2:  
                calcular_promedio_salarios() # Si elige la opción 2, ejecutamos la función para calcular el promedio de salarios.
            elif opcion == 3:  
                buscar_empleados_por_posicion() # Si elige la opción 3, ejecutamos la función para buscar empleados por posición.
            elif opcion == 4:  
                print("Saliendo del programa...") # Si elige la opción 4, salimos del programa.
                break
            else:
                print("Opción no válida. Por favor, elija una opción del menú.")  # Mostramos un mensaje de error.
        except ValueError:
            print("Error: Debe ingresar un número válido.")  # Mostramos un mensaje de error si la opción no es válida.
menu_principal() # Llamamos a la función 'menu_principal()' para iniciar el programa.
