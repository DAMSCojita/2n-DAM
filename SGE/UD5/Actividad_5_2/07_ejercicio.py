
# Inicializamos el diccionario vacío de contactos con sus números y correos electrónicos.
agenda_contactos = {}

# Bucle principal del programa.
# Mantendrá el programa activo hasta que el usuario decida salir.
while True:
    # Presentamos el menú principal.
    print("\n------------------- AGENDA CON NÚMEROS Y CORREOS --------------------")
    print("1. Agregar un contacto.")
    print("2. Modificar los números o correos electrónicos de un contacto.")
    print("3. Buscar contactos por tipo de número.")
    print("4. Salir.")
    print("---------------------------------------------------------------------")
    
    # Pedimos al usuario que elija una opción del menú.
    try:
        opcion = int(input("Elija una opción: "))  # Intentamos convertir la opción a entero.
    except ValueError:
        print("Ingrese una opción válida.")
        continue

    # Opción para agregar un contacto.
    if opcion == 1:
        nombre = input("Ingrese el nombre del contacto: ")  # Pedimos al usuario el nombre del contacto.
        if nombre in agenda_contactos:  # Verificamos si el contacto ya existe en la agenda.
            print("Error: El contacto ya existe.")  # Mostramos un mensaje de error si el contacto ya existe.
            continue
        
        # Inicializamos las listas de números y correos para el nuevo contacto.
        agenda_contactos[nombre] = {"telefonos": [], "correos": []}

        # Bucle 'while' que irá pidiendo los datos.
        while True:
            tipo_telefono = input("Ingrese el tipo de teléfono (móvil, trabajo, etc.): ")  # Pedimos el tipo de teléfono.
            numero_telefono = input("Ingrese el número de teléfono: ")  # Pedimos el número de teléfono.
            agenda_contactos[nombre]["telefonos"].append((numero_telefono, tipo_telefono))  # Agregamos el teléfono y su tipo al contacto.
            
            otra_entrada = input("¿Desea agregar otro número de teléfono? (sí/no): ").lower()  # Preguntamos si desea agregar otro teléfono.
            if otra_entrada != "sí":  # Si no desea agregar más, salimos del bucle.
                break
        
        # Bucle 'while' que irá pidiendo los datos.
        while True:
            correo = input("Ingrese un correo electrónico: ")  # Pedimos el correo electrónico.
            agenda_contactos[nombre]["correos"].append(correo)  # Agregamos el correo a la lista de correos del contacto.

            otra_entrada = input("¿Desea agregar otro correo electrónico? (sí/no): ").lower()  # Preguntamos si desea agregar otro correo.
            if otra_entrada != "sí":  # Si no desea agregar más, salimos del bucle.
                break

        print(f"> Contacto '{nombre}' agregado con éxito.")  # Confirmamos que el contacto ha sido agregado.
    
    # Opción para modificar los números o correos electrónicos de un contacto.
    elif opcion == 2:
        nombre = input("Ingrese el nombre del contacto que desea modificar: ")  # Pedimos el nombre del contacto.
        if nombre not in agenda_contactos:  # Verificamos si el contacto no existe en la agenda.
            print("No existe ningún contacto con ese nombre.")  # Mostramos un mensaje de error si el contacto no existe.
            continue
        
        # Bucle 'while' que irá pidiendo los datos.
        while True:
            print(f"Telefonos actuales de '{nombre}':")
            for idx, (numero, tipo) in enumerate(agenda_contactos[nombre]["telefonos"]):
                print(f"{idx+1}. {numero} ({tipo})")  # Mostramos los números y tipos de teléfono.
            
            opcion_telefono = input("Ingrese el número de teléfono a modificar (o 'fin' para terminar): ")
            if opcion_telefono.lower() == 'fin':  # Si se ingresa 'fin', salimos del bucle.
                break
            try:
                # Intentamos convertir la opción en índice de lista.
                indice = int(opcion_telefono) - 1  
                if 0 <= indice < len(agenda_contactos[nombre]["telefonos"]):  # Verificamos si el índice es válido.
                    nuevo_numero = input("Ingrese el nuevo número de teléfono: ")
                    nuevo_tipo = input("Ingrese el nuevo tipo de teléfono: ")
                    agenda_contactos[nombre]["telefonos"][indice] = (nuevo_numero, nuevo_tipo)
                    print(f"> Teléfono modificado correctamente.")
                else:
                    print("Opción no válida. El número ingresado no existe.")  # Si el índice es incorrecto, mostramos un mensaje de error.
            except ValueError:
                print("Ingresa una opción válida.")  # Si la entrada no es válida, mostramos un mensaje de error.
        
        while True:
            print(f"Correos actuales de '{nombre}':")
            for idx, correo in enumerate(agenda_contactos[nombre]["correos"]):
                print(f"> {idx+1}. {correo}")  # Mostramos los correos electrónicos.

            opcion_correo = input("Ingrese el correo a modificar (o 'fin' para terminar): ")
            if opcion_correo.lower() == 'fin':  # Si se ingresa 'fin', salimos del bucle.
                break
            try:
                # Intentamos convertir la opción en índice de lista.
                indice = int(opcion_correo) - 1  
                if 0 <= indice < len(agenda_contactos[nombre]["correos"]):  # Verificamos si el índice es válido.
                    nuevo_correo = input("Ingrese el nuevo correo electrónico: ")
                    agenda_contactos[nombre]["correos"][indice] = nuevo_correo
                    print(f"> Correo modificado correctamente.")
                else:
                    print("Opción no válida. El correo ingresado no existe.")  # Si el índice es incorrecto, mostramos un mensaje de error.
            except ValueError:
                print("Debe ingresar un número válido.")  # Si la entrada no es válida, mostramos un mensaje de error.

    # Opción para buscar contactos por tipo de número.
    elif opcion == 3:
        tipo_busqueda = input("Ingrese el tipo de número (móvil, trabajo, etc.): ")  # Pedimos el tipo de número.
        encontrados = []  # Lista para almacenar contactos encontrados.
        for nombre, datos in agenda_contactos.items():
            for numero, tipo in datos["telefonos"]:
                if tipo == tipo_busqueda:
                    encontrados.append(nombre)  # Añadimos el contacto a la lista si el tipo de número coincide.

        if encontrados:
            print(f"Contactos con tipo de número '{tipo_busqueda}':")
            for nombre in encontrados:
                print(f"> {nombre}")
        else:
            print(f"No se encontraron contactos con el tipo de número '{tipo_busqueda}'.")  # Si no se encontraron, mostramos un mensaje.

    # Opción para salir del programa.
    elif opcion == 4:
        print("Saliendo del programa...")
        break

    else:
        print("Introduzca una opción válida.")  # Si la opción no es válida, mostramos un mensaje de error.
