# Declaración de la lista de libros.
libros = []

# Declararamos un diccionario con los genéros válidos.
generos_validos = {"Ficción", "No ficción", "Fantasía", "Ciencia ficción", "Misterio", "Biografía", "Histórico", "Romance", "Comedia", "Drama"}

# Creamos una función para registrar un nuevo libro.
def registrar_libro():
    try:
        id = int(input("Escribe el ID del libro: ")) # Pedimos al usuario el ID del libro y lo guardamos en una variable.
        # Estructura de control 'if'.
        # Verificamos si el ID ya existe en la lista de libros para evitar duplicados.
        if any(libro['id'] == id for libro in libros):
            print("Error: Ya existe un libro con este ID.")
            return
        titulo = input("Escribe el título del libro: ").strip() # Pedimos al usuario el título del libro y lo guardamos en una variable.
        autor = input("Escribe el autor del libro: ").strip() # Pedimos al usuario el autor del libro y lo guardamos en una variable.
        generos = input("Escribe los géneros del libro (separados por comas): ").strip().split(",") # Pedimos al usuario los géneros del libro, separados por comas, y los convertimos en una lista.
        generos = [genero.strip() for genero in generos] # Limpiamos los espacios en blanco alrededor de cada género.
        # Validamos si todos los géneros introducidos son válidos.
        if not all(genero in generos_validos for genero in generos):
            print(f"Error: Uno o más géneros no son válidos. Los géneros válidos son: {', '.join(generos_validos)}")
            return
        # Creamos un diccionario con los datos del libro y lo añadimos a la lista de libros.
        libro = {"id": id, "titulo": titulo, "autor": autor, "generos": generos}
        libros.append(libro) # Agregamos el libro a la lista de libros.
        print("> Libro registrado correctamente.")
    except ValueError:
        print("Error: El ID debe ser un número entero.")

# Creamos una función para consultar un libro por su ID.
def consultar_libro():
    try:
        id = int(input("Escribe el ID del libro: ")) # Pedimos al usuario el ID del libro que desea consultar y lo guardamos en una variable.
        # Bucle 'for'.
        # Iteramos por la lista de libros buscando un libro con el ID especificado.
        for libro in libros:
            if libro["id"] == id:
                print(f"> ID: {libro['id']}, Título: {libro['titulo']}, Autor: {libro['autor']}, Géneros: {libro['generos']}")
                return
        print("Error: No se encontró un libro con este ID.")
    except ValueError:
        print("Error: El ID debe ser un número entero.")

# Creamos una función para mostrar todos los libros de un género específico.
def mostrar_libros_genero():
    genero = input("Escribe el género del libro: ").strip() # Pedimos al usuario el género que desea buscar y lo guardamos en una variable.
    # Usamos una comprensión de listas para filtrar los libros que contienen el género especificado.
    libros_genero = [libro for libro in libros if genero in libro["generos"]]
    # Estructura de control 'if'.
    # Si no se encontraron libros en el género especificado, mostramos un mensaje.
    if not libros_genero:
        print("No hay libros en este género.")
    else:
        print(f"Libros en el género '{genero}':")
        # Bucle 'for'.
        # Iteramos por la lista de libros del género y los mostramos al usuario.
        for libro in libros_genero:
            print(f"> ID: {libro['id']}, Título: {libro['titulo']}, Autor: {libro['autor']}")

# Creamos una función para mostrar el menú principal y gestionar las opciones del usuario.
def menu_principal():
    while True:
        # Presentación del menú principal.
        print("\n--------------------- GESTIÓN DE BIBLIOTECA ---------------------")
        print("1. Registrar libro.")
        print("2. Consultar libro.")
        print("3. Mostrar libros por género.")
        print("4. Salir.")
        print("----------------------------------------------------------------")
        try:
            opcion = int(input("Elije una opción: ")) # Pedimos al usuario que elija una opción y la guardamos en una variable.
            # Estructura de control 'if-elif-else'.
            # Según la opción elegida, llamamos a la función correspondiente o terminamos el programa.
            if opcion == 1:
                registrar_libro() # Llamamos a la función 'registrar_libro()' si el usuario elige la opción 1.
            elif opcion == 2:
                consultar_libro() # Llamamos a la función 'consultar_libro()' si el usuario elige la opción 2.
            elif opcion == 3:
                mostrar_libros_genero() # Llamamos a la función 'mostrar_libros_genero()' si el usuario elige la opción 3.
            elif opcion == 4:
                print("Saliendo del programa...") # Mostramos un mensaje de salida y terminamos el programa.
                break
            else:
                print("Opción no válida. Por favor, elija una opción del menú.") # Indicamos al usuario que la opción es inválida.
        except ValueError:
            print("Error: Debe ingresar un número válido.")
menu_principal() # Llamamos a la función 'menu_principal()' para iniciar el programa.
