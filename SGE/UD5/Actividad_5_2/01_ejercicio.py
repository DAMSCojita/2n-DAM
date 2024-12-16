
# Declaración de diccionarios.
productos = {}
proveedores = {}

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentación del programa.
    print("\n--------------------- GESTIÓN DE PRODUCTOS ---------------------")
    print("1. Registrar un nuevo producto.")
    print("2. Registrar un nuevo proveedor.")
    print("3. Mostrar todos los productos.")
    print("4. Mostrar todos los proveedores.")
    print("5. Salir.")
    print("----------------------------------------------------------------")
    opcion = int(input("Elije una opción: "))  # Pedimos al usuario que introduzca una opción.

    # Opción para registrar un nuevo producto.
    if opcion == 1:
        nombre_producto = input("Escribe el nombre del producto: ")  # Pedimos el nombre del producto.
        precio = float(input("Ahora, introduce el precio: "))  # Pedimos el precio del producto.
        cantidad_stock = int(input("Finalmente, establece la cantidad en stock: "))  # Pedimos la cantidad en stock.
        productos[nombre_producto] = {"precio": precio, "stock": cantidad_stock}  # Guardamos los datos en el diccionario.
        print("> Producto registrado correctamente.")

    # Opción para registrar un nuevo proveedor.
    elif opcion == 2:
        nombre_proveedor = input("Escribe el nombre del proveedor: ")  # Pedimos el nombre del proveedor.
        telefono = input("Ahora, introduce el teléfono: ")  # Pedimos el teléfono del proveedor.
        productos_suministrados = []  # Creamos una lista para los productos suministrados.
        while True:
            producto = input("Introduce un producto suministrado por el proveedor ('fin' para terminar): ")  # Pedimos un producto.
            if producto == 'fin':
                break  # Salimos del bucle si el usuario introduce 'fin'.
            elif producto in productos:
                productos_suministrados.append(producto)  # Añadimos el producto a la lista si existe.
            else:
                print("El producto no existe, por favor regístrelo primero.")  # Indicamos si el producto no existe.
        proveedores[nombre_proveedor] = {"telefono": telefono, "productos_suministrados": productos_suministrados}  # Guardamos los datos en el diccionario.
        print("> Proveedor registrado correctamente.")

    # Opción para mostrar todos los productos.
    elif opcion == 3:
        print("Productos:")
        for nombre_producto, info_producto in productos.items():
            print(f"> {nombre_producto}: Precio: {info_producto['precio']}, Stock: {info_producto['stock']}")

    # Opción para mostrar todos los proveedores.
    elif opcion == 4:
        print("Proveedores:")
        for nombre_proveedor, info_proveedor in proveedores.items():
            productos_suministrados = ", ".join(info_proveedor["productos_suministrados"])
            print(f"> {nombre_proveedor}: Teléfono: {info_proveedor['telefono']}, Productos suministrados: {productos_suministrados}")

    # Opción para salir del programa.
    elif opcion == 5:
        print("Saliendo del programa...")
        break
    else:
        print("Opción no válida, por favor intenta de nuevo.")
