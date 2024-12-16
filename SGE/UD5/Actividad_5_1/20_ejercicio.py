
# Declaramos un diccionario para los estudiantes.
diccionario_estudiantes = [
    {"nombre": "Juan", "edad": 18, "calificaciones": (9, 8, 10)},
    {"nombre": "Maria", "edad": 19, "calificaciones": (7, 9, 8)},
    {"nombre": "Pedro", "edad": 20, "calificaciones": (9, 10, 9)},
    {"nombre": "Luis", "edad": 17, "calificaciones": (8, 7, 9)}
]   

# Bucle 'for'.
# Recorrerá el diccionario de estudiantes.
for estudiante in diccionario_estudiantes:
    # Imprimimos la información de cada estudiante.
    print(f"> Nombre: {estudiante['nombre']}")
    print(f"> Edad: {estudiante['edad']}")
    print(f"> Calificaciones: {estudiante['calificaciones']}")

    promedio = sum(estudiante['calificaciones']) / len(estudiante['calificaciones']) # Calculamos el promedio de las calificaciones del estudiante.
    print(f"> Promedio de calificaciones: {promedio}") # Enseñamos el promedio de las calificaciones del estudiante.
    print("------------------------")

