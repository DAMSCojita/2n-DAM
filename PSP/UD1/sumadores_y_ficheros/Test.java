package sumadores_y_ficheros;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
    
        // Creamos un objeto 'File' que representa el directorio donde se encuentra LeerNombre.
        File directorio = new File("src\\sumadores_y_ficheros");

        // Creamos un objeto 'File' que representa el fichero donde se almacenará el resultado.
        File ficheroResultado = new File("src\\sumadores_y_ficheros\\resultado.txt");

        // Creamos un ProcessBuilder y empleamos los comandos necesarios.
        ProcessBuilder pb = new ProcessBuilder("java", "Sumador.java", "5", "5");

        pb.redirectOutput(ficheroResultado); // Redigimos la salida del programa a un fichero llamado'resultado.txt'.

        pb.directory(directorio); // Establecemos el directorio de trabajo para el proceso que se ejecutará.

        Process p = pb.start(); // Iniciamos el proceso y lo guardamos en una variable.

        try {
            p.waitFor(); // Con el 'waitFor()' esperamos a que el proceso finalice.
            // Bloque 'try-catch'.
            // Creamos un objeto 'BufferedReader' para leer el contenido del ficheroResultado.
            try (BufferedReader br = new BufferedReader(new FileReader(ficheroResultado))) {
                int c; // Creaamos una variable para almacenar el carácter leído.
                // Leemos el contenido del fichero línea por línea y lo imprimimos por consola.	
                while ((c = br.read())!= -1) {
                    System.out.print((char) c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                   
    }
}
