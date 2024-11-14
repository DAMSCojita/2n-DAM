package exercici_1_5;

import java.io.*;

/*
 * Este código está copiado del ejercicio 1.4 y se ha modificado para que dé el error si o si del enunciado del 1.5 y lo envíe a otro fichero llamado 'error.txt'.
 */

public class TestFicheroError {
    
    public static void main(String[] args) throws IOException {
        
        // Creamos un objeto 'File' que representa el directorio donde se encuentra LeerNombre.
        File directorio = new File("src\\exercici_1_4");

        // Creamos un ProcessBuilder y empleamos los comandos necesarios.
        ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre", "Stefan");

        pb.directory(directorio); // Establecemos el directorio de trabajo para el proceso que se ejecutará.

        // Redigimos el error a un fichero llamado 'error.txt'.
        File ficheroErrado = new File("src\\exercici_1_5\\error.txt");
        pb.redirectError(ficheroErrado);

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
