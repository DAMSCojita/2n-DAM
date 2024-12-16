
# Estructura 'try'.
# Intentará ejecutar el bloque de abajo. En caso de que encuentre algún error (por ejemplo que el usuario no haya ingresado un número correcto) lo avisará.
try:
    print("Bienvenido a la calculadora básica.") 
    # Pedimos al usuario que ingrese dos números y una operación.
    primer_numero = float(input("Escribe un número: "))
    segundo_numero = float(input("Ahora, escribe otro número: "))
    tipoOperacion = input("Ingresa el tipo de operación que quieras realizar (+, -, *, /): ")
except:
    print("Error. Introduzca valores numéricos válidos.") # Ponemos un mensaje de error en caso de que el usuario no introduzca un número correcto.
# Estructura 'try'.
# Intentará ejecutar el bloque de abajo. En caso de que encuentre algún error (por ejemplo que el usuario no haya una operación correcta) lo avisará.
try:
    # Estructura 'if'.
    # Realizará la operación seleccionada y mostrará el resultado.
    if tipoOperacion == '+':
        resultado = primer_numero + segundo_numero # Sumamos los valores en caso de '+'.
    elif tipoOperacion == '-':
        resultado = primer_numero - segundo_numero # Sumamos los valores en caso de '-'.
    elif tipoOperacion == '*':
        resultado = primer_numero * segundo_numero # Sumamos los valores en caso de '*'.
    elif tipoOperacion == '/':
        resultado = primer_numero / segundo_numero # Sumamos los valores en caso de '/'.
        # Otra estructura 'if'
        # Se ejecutará en caso de que el primero el segundo número sea igual a 0 y avisará al usuario de que no se puede dividir por 0.
        if primer_numero or segundo_numero == 0:
            print("Error: No se puede dividir por 0.")
            exit() # Terminamos el programa con la función 'exit()'.
    print("> El resultado es: " + resultado) # Escribimos el resultado por consola.
except:
    print("Error. Introduzca una operación correcta y vuelva a intentarlo.") # Ponemos un mensaje de error en caso de que el usuario no introduzca una operación correcta.
