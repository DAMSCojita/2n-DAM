
# Importación de librerías.
import random
import string

# Definimos los diferentes conjuntos de caracteres para generar la contraseña
letras_mayusculas = string.ascii_uppercase  # Letras mayúsculas del alfabeto inglés (A-Z)
letras_minusculas = string.ascii_lowercase  # Letras minúsculas del alfabeto inglés (a-z)
numeros = string.digits  # Dígitos numéricos (0-9)
caracteres_especiales = string.punctuation  # Caracteres especiales (!, @, #, etc.)

contraseña = [] # Declaramos una lista para construir la contraseña de forma dinámica.

# Bucles 'for'.
# Irán añadiendo letras y números.

# Añadimos 2 letras mayúsculas seleccionadas aleatoriamente
for _ in range(2):
    contraseña.append(random.choice(letras_mayusculas))

# Añadimos 2 letras minúsculas seleccionadas aleatoriamente
for _ in range(2):
    contraseña.append(random.choice(letras_minusculas))

# Añadimos 2 números seleccionados aleatoriamente
for _ in range(2):
    contraseña.append(random.choice(numeros))

# Añadimos 2 caracteres especiales seleccionados aleatoriamente
for _ in range(2):
    contraseña.append(random.choice(caracteres_especiales))

# Añadimos 4 caracteres aleatorios que pueden ser letras (mayúsculas o minúsculas) o números
for _ in range(4):
    contraseña.append(random.choice(letras_mayusculas + letras_minusculas + numeros))

# Añadimos 4 caracteres aleatorios que pueden ser letras (mayúsculas o minúsculas) o caracteres especiales
for _ in range(4):
    contraseña.append(random.choice(letras_mayusculas + letras_minusculas + caracteres_especiales))

random.shuffle(contraseña) # Barajamos el contenido de la lista para asegurar un orden aleatorio de los caracteres

contraseña = ''.join(contraseña) # Convertimos la lista de caracteres en una cadena

print("Contraseña generada:", contraseña) # Imprimimos la contraseña generada

