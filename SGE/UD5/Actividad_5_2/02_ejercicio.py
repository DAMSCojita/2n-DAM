
# Declaración de la lista de libros.
libros = []

# Declararamos un diccionario con los genéros válidos.
generos_validos = {"Ficción", "No ficción", "Fantasía", "Ciencia ficción", "Misterio", "Biografía", "Histórico", "Romance", "Comedia", "Drama"}

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentación del menú principal.
    print("\n--------------------- GESTIÓN DE BIBLIOTECA ---------------------")
    print("1. Registrar libro.")
    print("2. Consultar libro.")
    print("3. Mostrar libros por género.")
    print("4. Salir.")
    print("----------------------------------------------------------------")
    try:
        opcion = int(input("Elije una opción: "))  # Pedimos al usuario que elija una opción.

        # Opción para registrar un libro.
        if opcion == 1:
            try:
                id = int(input("Escribe el ID del libro: "))  # Pedimos el ID del libro.
                if any(libro['id'] == id for libro in libros):
                    print("Error: Ya existe un libro con este ID.")
                    continue
                titulo = input("Escribe el título del libro: ").strip()  # Pedimos el título.
                autor = input("Escribe el autor del libro: ").strip()  # Pedimos el autor.
                generos = input("Escribe los géneros del libro (separados por comas): ").strip().split(",")
                generos = [genero.strip() for genero in generos]  # Limpiamos los géneros.
                # Verificamos que todos los géneros sean válidos.
                if not all(genero in generos_validos for genero in generos):
                    print(f"Error: Uno o más géneros no son válidos. Los géneros válidos son: {', '.join(generos_validos)}")
                    continue
                libros.append({"id": id, "titulo": titulo, "autor": autor, "generos": generos}) # Agregamos el libro con sus datos a la lista de libros.
                print("> Libro registrado correctamente.")
            except ValueError:
                print("Error: El ID debe ser un número entero.")

        # Opción para consultar un libro.
        elif opcion == 2:
            try:
                id = int(input("Escribe el ID del libro: "))  # Pedimos el ID del libro.
                # Bucle 'for'.
                # Recorrerá la lista de libros.
                for libro in libros:
                    # Estructura de control 'if'.
                    # Comproará si el ID del libro coincide con el ID buscado.
                    if libro["id"] == id:
                        print(f"> ID: {libro['id']}, Título: {libro['titulo']}, Autor: {libro['autor']}, Géneros: {libro['generos']}")
                        break
                    else:
                        print("Error: No se encontró un libro con este ID.")
            except ValueError:
                print("Error: El ID debe ser un número entero.")

        # Opción para mostrar libros por género.
        elif opcion == 3:
            genero = input("Escribe el género del libro: ").strip()  # Pedimos el género.
            libros_genero = [libro for libro in libros if genero in libro["generos"]] # Creamos una lista de libros que contienen el género buscado.
            # Verificamos si la lista no está vacía.
            if not libros_genero:
                print("No hay libros en este género.")
            else:
                print(f"Libros en el género '{genero}':")
                # Bucle 'for'.
                # Mostrará los libros filtrados por el género al usuario.
                for libro in libros_genero:
                    print(f"> ID: {libro['id']}, Título: {libro['titulo']}, Autor: {libro['autor']}")

        # Opción para salir del programa.
        elif opcion == 4:
            print("Saliendo del programa...")
            break

        else:
            print("Opción no válida. Por favor, elija una opción del menú.")

    except ValueError:
        print("Error: Debe ingresar un número válido.")
