
# Pedimos al usuario que ingrese una frase
frase = input("Escribe una frase: ")

print("> Frase original:", frase) # Mostramos la frase original.
print("> Longitud de la frase:", len(frase)) # Mostramos la longitud de la frase.
# Convertimos la frase a mayúsculas y luego a minúsculas con los métodos 'upper()' y 'lower()'.
print("> Frase en mayúsculas:", frase.upper())
print("> Frase en minúsculas:", frase.lower())
print("> La palabra 'Python' aparece", frase.count("Python"), "veces.") # Contamos cuántas veces aparece la palabra "Python" en la frase.

frase_reemplazada = frase.replace("a", "@") # Reemplazamos todas las "a" por "@"
print("> Frase reemplazada con 'a' por '@':", frase_reemplazada)

frase_limpia = frase.strip() # Eliminamos los espacios en blanco al principio y al final de la frase.
print("> Frase limpia:", frase_limpia)

primeras_cinco_letras = frase_limpia[:5] # Extraemos las primeras 5 letras de la frase.
print("> Primeras 5 letras:", primeras_cinco_letras)

# Estructura de control 'if'.
# Verificará si la palabra "programación" está en la frase. Si lo está, lo indicará.
# En caso contrario dirá que no se encuentra.
if frase == frase_limpia.startswith("programación") or frase_limpia.endswith("programación"):
    print("> La palabra 'programación' está en la frase.")
else:
    print("> La palabra 'programación' no está en la frase.")

frase_invertida = frase_limpia[::-1] # Invertimos la frase.
print("> Frase invertida:", frase_invertida)

frase_capitalizada = " ".join(palabra.capitalize() for palabra in frase_limpia.split()) # Imprimimos la frase con la primera letra de cada palabra en mayúscula
print("> Frase capitalizada:", frase_capitalizada)