
from faker import Faker # Importamos la libería 'Faker' para poder añadir datos aleatorios.

opcion = '' # Creamos y inicializamos la variable 'opcion' que representa la decisión que tome el usuario al principio.

while opcion != '5': # El programa se seguirá ejecutando mientras la opción sea diferente a 5 (que es para salir).

    # Presentación del programa.
    print("---------- ALMACENAMIENTO Y MANIPULACIÓN DE DATOS DE FICHEROS -----")
    print("1. Crear o sobreescribir fichero con clientes.")
    print("2. Leer fichero y mostrar los clientes.")
    print("3. Modificar clientes.")
    print("4. Añadir nuevos empleados.")
    print("5. Salir.")
    print("-------------------------------------------------------------------")
    opcion = input("Elija una opción: ") # Pedimos al usuario que elija una opción.

    # Creamos una función para crear o sobreescribir el fichero.
    def crearOSobreescribirFichero():
        fake = Faker() # Llamamos a 'Faker()' y lo introducimos en una variable para generar los datos.
        # Abrimos para escribir el fichero.
        with open('activitat_1_5\\formato.txt', 'w', newline='') as file:
            # Bucle que añade 5 empleados predeterminadamente.
            for _ in range (5):
                nombre = fake.first_name()
                apellido = fake.last_name()
                cargo = fake.job()
                salario = fake.random_int(min=2000, max=5000)
                file.write(f"{nombre},{apellido},{cargo},{salario}\n")
            print("Fichero creado o sobreescrito con éxito.")
        file.close() # Cerramos fichero.
    
    # Creamos una función para leer el fichero.
    def leerFichero():
        # Abrimos el fichero para leerlo.
        with open('activitat_1_5\\formato.txt', 'r') as file:
            empleados = file.readlines() # Leemos cada línea.
            for empleado in empleados:
                nombre, apellido, cargo, salario = empleado.strip().split(',', 3) # Metemos los datos en las líneas eliminando los espacios en blanco y dividiendo las líneas en comas. Ponemos '3' al final para que se hagan como máximo 3 divisiones (que si no lo ponemos dará error).
                print(f"Nombre: {nombre} {apellido}")
                print(f"Cargo: {cargo}")
                print(f"Salario: {salario}")
                print("-" * 20)
        file.close() # Cerramos fichero.

    # Creamos una función para modificar el salario de un cliente en el fichero.
    def modificarSalarioClientesEnFichero():

        # Abrimos el fichero y lo leemos.
        with open('activitat_1_5\\formato.txt', 'r') as file:
            empleados = file.readlines() # Lectura de cada línea.
        
        # Pedimos al usuario el nombre del empleado que quiere y el nuevo salario a modificar. Guardamos los el nombre y el salario en variables.
        nombre_empleado = input("> Escribe el nombre del empleado/a que quieras modificar: ")
        nuevo_salario = input("> Ahora, añade el nuevo salario para el empleado/a: ")
        encontrado = False # Nos creamos una variable auxiliar booleana para saber si se ha encontrado el empleado.

        # Abrimos el fichero para escribir los cambios.
        with open('activitat_1_5\\formato.txt', 'w') as file:
            # Bucle que recorre cada línea del fichero buscando los empleados que coincidan con el nombre introducido.
            for empleado in empleados:
                nombre, apellido, cargo, salario = empleado.strip().split(',', 3) # Metemos los datos en las líneas eliminando los espacios en blanco y dividiendo las líneas en comas. Ponemos '3' al final para que se hagan como máximo 3 divisiones (que si no lo ponemos dará error).
                # Si el nombre del empleado coincide con el nombre introducido, escribimos el nuevo salario en el fichero (lo convertimos también en minúscula por si acaso).
                if nombre.lower() == nombre_empleado.lower():
                    file.write(f"{nombre},{apellido},{cargo},{nuevo_salario}\n") # Escribimos la línea modificada en el fichero.
                    encontrado = True # Si se ha encontrado el empleado, cambiamos la variable booleana a True.
                else:
                    file.write(f"{empleado.strip()}\n") # Escribimos la línea sin cambios en el fichero en caso de que no se encuentre.
            # Si el empleado se ha encontrado, imprimimos un mensaje de éxito.
            # En caso contrario, indicamos un mensaje de error.
            if encontrado:
                print(f"Salario del cliente {nombre_empleado} ha sido modificado con éxito.")
            else:
                print(f"No se ha encontrado el empleado {nombre_empleado}, vuelva a intentarlo de nuevo o asegúrese de que está en el fichero.")
        file.close() # Cerramos fichero.

    # Creamos una función para añadir empleados aleatorios al fichero.
    def añadirEmpleados():
        fake = Faker() # Llamamos a 'Faker()' y lo introducimos en una variable para generar los datos.

        numEmpleados = input("¿Cuántos empleados deseas añadir al fichero? ") # Preguntamos al usuario cuántos empleados quiere añadir y lo guardamos en una variable.

        numEmpleados = int(numEmpleados) # Convertimos la variable de entrada a entero.

        # Abrimos el fichero para añadir los nuevos empleados. Usamos 'a' para añadirlo al fichero (si ponemos 'w' se borraría todo).
        with open('activitat_1_5\\formato.txt', 'a') as file:
            # Bucle que añade el número de empleados introducido por el usuario.
            for _ in range (numEmpleados):
                # Generamos datos aleatorios para cada empleado.
                nombre = fake.first_name() 
                apellido = fake.last_name()
                cargo = fake.job()
                salario = fake.random_int(min=2000, max=5000)
                file.write(f"{nombre}, {apellido}, {cargo}, {salario}\n") # Escribimos la línea con los datos en el fichero.
                print(f"-Empleado {nombre} {apellido} añadido con éxito.") # Imprimimos un mensaje de éxito para cada empleado añadido.
        file.close()
    
    # Ejecución del programa según la opción elegida por el usuario.
    if opcion == '1':
        crearOSobreescribirFichero()
    elif opcion == '2':
        leerFichero()
    elif opcion == '3':
        modificarSalarioClientesEnFichero()
    elif opcion == '4':
        añadirEmpleados()
    elif opcion == '5':
        print("Saliendo del programa...")
        exit()
    else:
        print("Por favor, introduzca una opción correcta y vuelva a intentarlo.")

