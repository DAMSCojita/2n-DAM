package exercici_1_4;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        
        // Creamos un objeto 'File' que representa el directorio donde se encuentra LeerNombre.
        File directorio = new File("src\\exercici_1_4");

        // Creamos un ProcessBuilder y empleamos los comandos necesarios.
        ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre.java", "Stefan");

        pb.directory(directorio); // Establecemos el directorio de trabajo para el proceso que se ejecutará.

        Process p = pb.start(); // Iniciamos el proceso y lo guardamos en una variable.

        // Bloque 'try-catch'.
        // Controlamos cualquier excepción genérica que pueda producirse excluyendo la "IOException" (por si acaso, y el IDE lo demanda).
        try {
            int salida = p.waitFor(); // Con el 'waitFor()' esperamos a que el proceso finalice y guardamos la salida en una variable.

            // Obtenemos el flujo de entrada del programa con 'InputStream'
            InputStream is = p.getInputStream();
            int c;

            // Leemos el flujo del programa byte por byte y lo imprimimos como carácteres.
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println(salida); // Mostramos la salida del programa.
            is.close(); // Cerramos el 'InputStream'.
        } catch (Exception e) {
            e.printStackTrace();
        }
               
    }
}
