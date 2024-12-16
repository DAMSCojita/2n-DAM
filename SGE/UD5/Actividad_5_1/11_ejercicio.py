
edad = int(input("¿Cuántos años tienes? ")) # Pedimos la edad al usuario y la guardamos en una variable

# Estructuras de control 'if'.
# Controlará una situación dependiendo de la edad.
if edad < 4:
    precio = 0 # Al ser la edad menor a 4, la entrada cuesta 0€. Es decir. Es gratis.
elif edad <= 18:
    precio = 5 # Al ser menor de 18, la entrada costará 5€
else:
    precio = 10 # Al ser mayor a partir de 18 años, costará 10€.

print(f"> El precio de la entrada es {precio}.") # Mostramos el precio de la entrada.
