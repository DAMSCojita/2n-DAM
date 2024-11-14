package exercici_1_4;

public class LeerNombre {
    public static void main(String[] args) {
        
        // Declaración y inicialización de la variable 'nombre'.
        String nombre = args[0]; // Pasamos el args[0] a la variable.

        // Si el nombre es válido lo mostrará por consola y el programa se cerrará enviando un 1.
        // En caso contrario, nos indica que introduzcamos un nombre correcto y devuelve un -1. 
        if (esNombreValido(nombre)) {
            System.out.println("El nombre que has puesto es: " + nombre);
            System.exit(1);
        } else {
            System.out.println("Por favor, introduzca un nombre correcto.");
            System.exit(-1);
        }

    }

    // Función para validar el nombre.
    public static boolean esNombreValido(String nombre) {

        // Comprobamos si el nombre está vacío o tiene menos de 2 carácteres.
        if (nombre == null || nombre.trim().isEmpty() || nombre.length() < 2) {
            return false;
        }

        // Comprobamos que el nombre sea una letra y si tiene espacios.
        for (char c : nombre.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }

        return true;
    }
}
