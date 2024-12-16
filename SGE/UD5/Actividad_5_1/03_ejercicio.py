
# Pedimos al usuario que introduzca sus datos.
nombre = input("Introduce tu nombre: ")
apellido_1 = input("Introduce tu primer apellido: ")
apellido_2 = input("Introduce tu segundo apellido: ")

# Eliminamos espacios en blanco y pasamos a minúsculas
nombre = nombre.strip().lower()
apellido_1 = apellido_1.strip().lower()
apellido_2 = apellido_2.strip().lower()

# Construimos la cuenta de correo
cuenta_correo = nombre + "." + apellido_1 + "." + apellido_2 + "@iesjoanramis.org"

print("> Tu cuenta de correo es:", cuenta_correo) # Indicamos la cuenta de correo.