
import csv # Importamos la libreria 'csv'.

opcion = '' # Declaramos una variable opcion vacía para poder hacer el bucle.

while opcion != 5: # Mientras opción sea diferente a 5.

    # Presentación del programa.
    print("-------------------------------- GESTIÓN DE FICHEROS SECUENCIALES --------------------------------")
    print("1. Crear o sobreescribir un fichero secuencial.")
    print("2. Leer fichero y buscar a un cliente a través de un DNI.")
    print("3. Añadir nuevos clientes.")
    print("4. Listar todos los clientes.")
    print("5. Salir.")
    print("--------------------------------------------------------------------------------------------------")
    opcion = input("Elija una opción: ") # Recibimos la opción por el usuario.

    # Manejo de opciones.
    # Crear o sobreescribir el fichero.
    if opcion == '1':
        with open('activitat_secuencial_inicial\clientes_secuencial.txt', 'w', newline='') as file: # Creamos un fichero y escribimos
            writer = csv.writer(file) # Creamos una variable que escribirá los datos.
            # Escribimos en cada línea los datos correspondientes:
            writer.writerow([12345678 , "Joan", "Gonzalez", 654321789])
            writer.writerow([87654321 , "Ana", "Martinez", 987654321])
            writer.writerow([13579246, "Lluís", "Rodriguez", 564738291])
            writer.writerow([24681357, "Maria", "Perez", 987654765])
        file.close() # Cerramos el fichero.
    # Lectura de fichero y búsqueda de cliente por DNI.
    elif opcion == '2':
        with open('activitat_secuencial_inicial\clientes_secuencial.txt', 'r') as file: # Abrimos un fichero y leemos.
            entrada = input(" > Introduce un DNI para buscarlo en el archivo: \n") # Creamos una variable y un input preguntando el DNI.
            for line in file: # Creamos un bucle que recorra cada línea del fichero.
                datos = line.strip().split(',') # Creamos una variable donde están los datos y los dividimos con comas y espacios eliminados.
                if entrada in line: # Si la entrada del usuario coincide con la línea, se ejecutará el bloque de abajo.
                    print("Cliente encontrado: " + datos[1], datos[2], "," + " Teléfono: " + datos[3]) # Se escriben los datos.
        file.close() # Cerramos el fichero.
    # Añadir un cliente.
    elif opcion == '3':
        with open('activitat_secuencial_inicial\clientes_secuencial.txt', 'a', newline='') as file:
            # Pedimos los datos. Cada uno siendo una variable diferente.
            dni = input("> Escribe el DNI: ")
            nombre = input("> Escribe el nombre: ")
            apellido = input("> Escribe el apellido: ")
            telefono = input("> Escribe el teléfono: ")
            writer = csv.writer(file) # Creamos una variable que escribirá los datos.
            writer.writerow([dni, nombre, apellido, telefono]) # Escribimos cada dato (siendo una variable) separados por comas).
        file.close() # Cerramos el fichero.
    # Listar todos los clientes.
    elif opcion == '4':
        with open('activitat_secuencial_inicial\clientes_secuencial.txt', 'r') as file:
            print(file.read()) # Leemos todo el fichero y se muestra por consola.
        file.close() # Cerramos el fichero.
    elif opcion == '5':
        print("> Saliendo del programa...")
        exit()
    else: # 'else' final en caso de que el usuario no introduzca una opción correcta.
        print("Error. Escriba una opción correcta y vuelva a intentarlo.") # Indicamos al usuario que escriba una opción correcta.

    
