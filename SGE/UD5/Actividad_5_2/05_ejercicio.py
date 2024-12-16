
# Inicializamos el inventario como un diccionario.
inventario = {}

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentación del menú principal.
    print("\n--------------------- GESTIÓN DE INVENTARIO DE UNA TIENDA ---------------------")
    print("1. Agregar producto al inventario.")
    print("2. Actualizar stock de un producto usando su id.")
    print("3. Mostrar productos con menos de 5 unidades en stock.")
    print("4. Salir.")
    print("-------------------------------------------------------------------------------")

    # Estructura de control 'try-except'.
    # Capturaremos cualquier error de tipo 'ValueError' si el usuario no ingresa un número válido.
    try:
        opcion = int(input("Elija una opción: "))  # Solicitamos al usuario que elija una opción del menú.

        # Opción para agregar un producto al inventario.
        if opcion == 1: 
            try:
                id = int(input("Ingrese el ID del producto: "))  # Pedimos el ID del producto al usuario.
                nombre = input("Ingrese el nombre del producto: ").strip()  # Pedimos el nombre del producto y eliminamos espacios extra.
                precio = float(input("Ingrese el precio del producto: "))  # Pedimos el precio del producto y lo convertimos a tipo float.
                stock = int(input("Ingrese el stock del producto: "))  # Pedimos el stock del producto y lo convertimos a tipo entero.

                # Estructura de control 'if'.
                # Verificará si el ID ya existe en el inventario.
                if id in inventario:
                    print(f"Error: Ya existe un producto con el ID {id}.")  # Mostramos un mensaje de error si el ID ya está registrado.
                else:
                    inventario[id] = {"nombre": nombre, "detalle": (precio, stock)}  # Agregamos el producto al inventario.
                    print(f"> Producto agregado con éxito.")  # Mostramos un mensaje de éxito.
            except ValueError:
                print("Error: Introduzca el valor correcto especificado y vuelva a intentarlo.")  # Mostramos un mensaje de error si la entrada no es válida.

        # Opción para actualizar el stock de un producto.
        elif opcion == 2:
            try:
                id = int(input("Ingrese el ID del producto: "))  # Pedimos el ID del producto al usuario.

                # Estructura de control 'if'.
                # Verificará si el ID no existe en el inventario.
                if id not in inventario:
                    print(f"Error: No existe un producto con el ID {id}.")  # Mostramos un mensaje de error si el ID no está registrado.
                else:
                    stock = int(input("Ingrese el nuevo stock del producto: "))  # Pedimos el nuevo stock del producto.
                    producto = inventario[id]  # Recuperamos el producto del inventario.
                    producto["detalle"] = (producto["detalle"][0], stock)  # Actualizamos el stock del producto.
                    print(f"> Stock actualizado para el producto '{producto['nombre']}' (ID {id}).")  # Mostramos un mensaje de éxito.
            except ValueError:
                print("Error: Entrada inválida. Asegúrese de ingresar valores correctos.")  # Mostramos un mensaje de error si la entrada no es válida.

        # Opción para mostrar productos con menos de 5 unidades en stock.
        elif opcion == 3:
            productos_bajo = {id: prod for id, prod in inventario.items() if prod["detalle"][1] < 5}  # Filtramos los productos con stock menor a 5.

            # Estructura de control 'if-else'.
            # Verificará si los productos cumplen la condición de las unidades.
            if not productos_bajo:
                print("No hay productos con menos de 5 unidades en stock.")  # Mostramos un mensaje si no hay productos con stock bajo.
            else:
                print("Productos con menos de 5 unidades en stock:")  # Mostramos un encabezado para la lista de productos.
                for id, prod in productos_bajo.items():  # Iteramos sobre los productos con stock bajo.
                    print(f"> ID: {id}, Nombre: {prod['nombre']}, Precio: {prod['detalle'][0]}, Stock: {prod['detalle'][1]}")  # Mostramos los detalles de cada producto.

        # Opción para salir del programa.
        elif opcion == 4:
            print("Saliendo del programa...") 
            break  # Salimos del bucle principal y terminamos el programa.

        else:
            print("Seleccione una opción válida del menú y vuelva a intentarlo.")  # Mostramos un mensaje de error si la opción no es válida.

    except ValueError:
        print("Ingrese un número válido.")  # Mostramos un mensaje de error si la entrada no es un número válido.
