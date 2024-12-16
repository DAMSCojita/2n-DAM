
# Declaración de diccionarios.
productos = {}
proveedores = {}

# Creamos una función para registrar un producto.
def registrar_producto():
    nombre_producto = input("Escribe el nombre del producto: ") # Pedimos el nombre del producto al usuario y lo guardamos en una variable.
    precio = float(input("Ahora, introduce el precio: ")) # Pedimos el precio del producto al usuario y lo guardamos en una variable.
    cantidad_stock = int(input("Finalmente, establece la cantidad en stock: ")) # Pedimos la cantidad de stock al usuario y lo guardamos en una variable.
    productos[nombre_producto] = {"precio": precio, "stock": cantidad_stock} # Creamos una nueva entrada en el diccionario 'productos' con el nombre del producto como clave y un diccionario que contiene el precio y la cantidad de stock como valor.
    print("> Producto registrado correctamente.") 
    return

# Creamos una función para registrar un proveedor.
def registrar_proveedor():
    nombre_proveedor = input("Escribe el nombre del proveedor: ") # Pedimos el nombre del proveedor al usuario y lo guardamos en una variable.
    telefono = input("Ahora, introduce el teléfono: ") # Pedimos el teléfono del proveedor al usuario y lo guardamos en una variable.
    productos_suministrados = [] # Creamos una lista de productos suministrados.
    # Bucle 'while'.
    # Iterará infinitamente, cuando el usuario introduzca 'fin' el bucle terminará.
    while True:
        producto = input("Introduce un producto suministrado por el proveedor ('fin' para terminar): ") # Pedimos un producto al usuario y lo guardamos en una variable.
        # Estructura de control 'if'.
        # Si el usuario introduce 'fin', saldremos del bucle.
        # Si no, si el producto que ha introducido se encuentra en el diccionario de productos, los irá añadiendo a la lista que acabamos de declarar antes.
        if producto == 'fin':
            break
        elif producto in productos:
            productos_suministrados.append(producto) # Añadimos el producto a la lista.
        else:
            print("El producto no existe, por favor regístrelo primero.") # En caso de que el usuario no haya escrito bien el producto o no exista el programa lo indica.
    proveedores[nombre_proveedor] = {"telefono": telefono, "productos_suministrados": productos_suministrados} # Creamos una nueva entrada en el diccionario 'proveedores' con el teléfono como clave y un diccionario que contiene la lista de productos suministrados como valor. 
    print("> Proveedor registrado correctamente.")
    return

# Creamos una función para mostrar los productos.
def mostrar_productos():
    print("Productos:")
    # Bucle 'for'.
    # Iterará por cada nombre y teléfono del diccionario de productos y mostrará los que hay.
    for nombre_producto, info_producto in productos.items():
        print(f"> {nombre_producto}: Precio: {info_producto['precio']}, Stock: {info_producto['stock']}")
    return

# Creamos una función para mostrar los proveedores.
def mostrar_proveedores():
    print("Proveedores:")
    # Bucle 'for'.
    # Iterará por cada nombre y teléfono del diccionario de proveedores y mostrará los que hay.
    for nombre_proveedor, info_proveedor in proveedores.items():
        productos_suministrados = ", ".join(info_proveedor["productos_suministrados"])
        print(f"> {nombre_proveedor}: Teléfono: {info_proveedor['telefono']}, Productos suministrados: {productos_suministrados}")
    return

# Creamos una función principal que tendrá la parte principal del programa. Desde el menú hasta la gestión de opciones.
def menu_principal():
    # Bucle 'while'.
    # Iterará infinitamente hasta que el usuario decida salir del programa.
    while True:
        # Presentación del programa.
        print("\n--------------------- GESTIÓN DE PRODUCTOS ---------------------")
        print("1. Registrar un nuevo producto.")
        print("2. Registrar un nuevo proveedor.")
        print("3. Mostrar todos los productos.")
        print("4. Mostrar todos los proveedores.")
        print("5. Salir.")
        print("----------------------------------------------------------------")
        opcion = int(input("Elije una opción: ")) # Pedimos al usuario que introduzca una opción y la guardamos en una nueva variable.
        if opcion == 1:
            registrar_producto() # En el caso de la opción 1, llamaremos al método 'registrar_producto()'.
        elif opcion == 2:
            registrar_proveedor() # En el caso de la opción 2, llamaremos al método 'registrar_proveedor()'.
        elif opcion == 3:
            mostrar_productos() # En el caso de la opción 3, llamaremos al método 'mostrar_productos()'.
        elif opcion == 4:
            mostrar_proveedores() # En el caso de la opción 4, llamaremos al método 'mostrar_proveedores()'.
        elif opcion == 5:
            print("Saliendo del programa...") # En caso de la opción 5, saldremos del programa.
            break
menu_principal() # Llamamos a la función 'menu_principal()' para ejecutar el programa.



