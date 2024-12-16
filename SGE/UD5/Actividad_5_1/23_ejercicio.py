
agenda = {}  # Definimos un diccionario para almacenar los contactos.

# Bucle 'while'.
# Iterará infinitamente hasta que el usuario decida salir.
while True:
    # Presentación del programa.
    print("\n--------- AGENDA DE CONTACTOS ----------")
    print("a. Mostrar Agenda")
    print("b. Añadir Contacto")
    print("c. Borrar Contacto")
    print("d. Modificar Contacto")
    print("e. Salir")
    print("----------------------------------------")
    opcion = input("Elija una opción: ")  # Pedimos al usuario que elija una opción.

    # Estructuras de control 'if'.
    # Irá controlando cada opción, y dependiendo de cuál realizará la acción deseada.
    if opcion.lower() == 'a':  # Mostrar contactos.
        # Estructura de control 'if'.
        # Si la agenda está vacía, muestra un mensaje y vuelve al menú.
        if not agenda:  
            print("\nNo hay contactos en la agenda.\n")
        else:
            print("\nContactos:")
            # Bucle 'for'.
            # Iterará por cada contacto en la agenda y mostrará sus detalles.
            for nombre, detalles in agenda.items():
                # Mostramos los contactos con sus respectivos datos.
                print(f"> Nombre: {nombre}")
                print(f"> Teléfono: {detalles['telefono']}")
                print(f"> Email: {detalles['email']}\n")
        continue

    elif opcion.lower() == 'b':  # Añadir un contacto.
        # Pedimos al usuario los datos del nuevo contacto.
        nombre = input("Escribe el nombre del contacto: ")
        # Estructura de control 'if'.
        # Si el contacto ya existe, mostramos un mensaje de advertencia.
        if nombre in agenda:
            print("\nEl contacto ya existe. Use la opción 'Modificar Contacto' para actualizarlo.\n")
        else:
            telefono = input("Escribe el teléfono del contacto: ")
            email = input("Escribe el email del contacto: ")
            # Añadimos el contacto al diccionario.
            agenda[nombre] = {'telefono': telefono, 'email': email}
            print("\nContacto agregado correctamente.\n")
        continue

    elif opcion.lower() == 'c':  # Borrar un contacto.
        nombre = input("Indica el contacto a borrar (escribe el nombre): ")  # Pedimos el nombre del contacto.
        # Estructura de control 'if'.
        # Si el contacto existe en la agenda, lo eliminamos.
        if nombre in agenda:
            del agenda[nombre]  # Eliminamos el contacto del diccionario.
            print("\nContacto borrado correctamente.\n")
        else:
            print("\nContacto no encontrado.\n")
        continue

    elif opcion.lower() == 'd':  # Modificar un contacto.
        nombre = input("Indica el contacto a modificar (escribe el nombre): ")  # Pedimos el nombre del contacto.
        # Estructura de control 'if'.
        # Si el contacto existe en la agenda, mostramos sus datos y permitimos modificarlos.
        if nombre in agenda:
            print("\nDetalles actuales del contacto:")
            print(f"Teléfono: {agenda[nombre]['telefono']}")
            print(f"Email: {agenda[nombre]['email']}")
            print("----------------------------------------")
            opcion_mod = input("¿Qué desea modificar? 1. Teléfono  - 2. Email: ")  # Pedimos al usuario que elija.
            # Estructura de control 'if'.
            # Dependiendo de la elección, modificamos el teléfono o el email.
            if opcion_mod == '1':
                nuevo_telefono = input("Ingrese el nuevo teléfono: ")
                agenda[nombre]['telefono'] = nuevo_telefono  # Actualizamos el teléfono.
                print("\nTeléfono modificado correctamente.\n")
            elif opcion_mod == '2':
                nuevo_email = input("Ingrese el nuevo email: ")
                agenda[nombre]['email'] = nuevo_email  # Actualizamos el email.
                print("\nEmail modificado correctamente.\n")
            else:
                print("\nOpción no válida.\n")
        else:
            print("\nContacto no encontrado.\n")
        continue

    elif opcion.lower() == 'e':  # Salir del programa.
        break  # Terminamos el bucle y salimos del programa.

    else:  # Opción no válida.
        print("\nOpción no válida. Por favor, elija una opción del menú.\n")
