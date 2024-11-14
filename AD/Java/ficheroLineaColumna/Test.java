package ficheroLineaColumna;

// Importación de liberías.
import java.util.*;
import java.io.*;


public class Test {
    public static void main(String[] args) {
        
        // Declaración de variables.
        String contenido = "";
        String palabra = "";

        Scanner sc = new Scanner(System.in); // Declaramos el escáner.

        // Estructura 'try-catch'.
        // Leerá el fichero a través de un BufferedReader.
        // En caso de que no lo encuentre o se produzca cualquier error, pillará la excepción y la indicará por consola.
        // Declarando el BufferedReader dentro del paréntesis en el 'try' en resumen nos permite leer el fichero sin necesidad de cerrarlo al final. 
        try (BufferedReader br = new BufferedReader(new FileReader("src\\ficheroLineaColumna\\fichero.txt"))) {
            System.out.println("> Escriba la palabra que quiera buscar en el fichero: ");
            palabra = sc.nextLine(); // Guardamos la palabra que el usuario eligió para buscar.
            int linea = 1; // Declaramos una variable para representar la línea.
            // Bucle 'while'.
            // Leerá línea a línea el fichero.
            // Si una palabra coincide con la que buscamos, mostrará la línea y columna.
            while ((contenido = br.readLine())!= null) {
                String[] lineaSplit = contenido.split(" "); // Creamos un array que almacenará las palabras de la línea de texto 'contenido'. También, resumimos en partes el contenido separándolos por espacios en blanco usando el método 'split()'.
                // Bucle 'for'.
                // Comparamos cada palabra de la línea con la palabra que buscamos.
                // Si coinciden, mostramos la línea y columna.
                // 'i + 1' es para que la columna empiece en 1, no en 0, como se esperaba.
                // 'i + 1' es la columna en la que se encuentra la palabra.
                for (int i = 0; i < lineaSplit.length; i++) {
                    if (lineaSplit[i].equalsIgnoreCase(palabra)) {
                        System.out.println("La palabra '" + palabra + "' se encuentra en la línea " + linea + ", columna " + (i + 1));
                    }
                }
                linea++; // Incrementamos la línea cada vez que leemos.
            }
        } catch (Exception e) {
            System.out.println("Se ha producido un error al leer el fichero: " + e.getMessage());
        }
        sc.close(); // Cerramos escáner.
    }
}
