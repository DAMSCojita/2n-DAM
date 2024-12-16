
# Declaramos el diccionario con los precios de las frutas.
precios_frutas = {
    "manzana": 1.5,
    "pera": 2.0,
    "uva": 3.0
}

# Bucle 'while'.
# Iterará infinitamente para realizar consultas.
while True:
    
    nombre_fruta = input("Introduce el nombre de la fruta: ") # Pedimos al usuario el nombre de la fruta.
    
    # Estructura de control 'try-except' 
    # Intentará ejecutar el bloque para preguntar la cantidad y realizar los cálculos y en caso de que encuentre alguna excepción, lo indicará.
    try:
        cantidad_vendida = int(input("Introduce la cantidad vendida de la fruta: ")) # Pedimos la cantidad vendida de la fruta.
        precio_final = precios_frutas[nombre_fruta] * cantidad_vendida # Calculamos el precio final multiplicando el precio de la fruta por la cantidad vendida y lo guardamos en una variable.
        print(f"> El precio final de la {nombre_fruta} es: {precio_final}") # Mostramos el precio final de la fruta.
    except:
        print(f"La fruta '{nombre_fruta}' no está en el diccionario o ocurrió algún error inesperado.") # En caso de que no se encuentre la fruta en el diccionario o ocurra algún error, se mostrará este mensaje.
    print("----------------------------------------")  # Separador.
    
    opcion = input("¿Desea realizar otra consulta? ('s' para indicar que si) \n") # Preguntamos al usuario si desea realizar otra consulta.
    
    # Estructura de control 'if'.
    # Si la respuesta es distinta de's' (o 'S'), se terminará el bucle. En caso contrario, se volverá a realizar otra consulta.
    if opcion.lower()!= "s":
        break



