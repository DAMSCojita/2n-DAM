package listadodirectorio;

// Importación de librerías.
import java.io.*;

public class ListadoDirectorio {
    public static void main(String[] args) {
        String ruta = "src\\listadodirectorio\\";
        if (args.length >= 1) ruta = args[0];

        File fich = new File(ruta);

        if (!fich.exists()) {
            System.out.println("No existe el fichero o directorio (" + ruta + ").");
        } else {
            if (fich.isFile()) {
                System.out.println(ruta + " es un fichero.");
            } else {
                System.out.println(ruta + " es un directorio. Contenidos: ");
                File[] ficheros =  fich.listFiles();
                for (File f : ficheros) {
                    String textoDescr = f.isDirectory() ? "/" : 
                    f.isFile() ? "_" : "?";
                    System.out.println("(" + textoDescr + ") " + f.getName());
                    // Añadimos una variable para representar el tamaño.
                    long tamaño = f.length(); // Con la función de 'f.length()' podremos obtener el tamaño del directorio o fichero.
                    System.out.println("> Tamaño: " + tamaño); // Enseñamos el tamaño por consola.
                    // Añadimos una variable para representar la fecha.
                    long ultimaFecha = f.lastModified(); // Con la función de 'f.lastModified()' podremos obtener la última fecha de modificación del directorio o fichero. 
                    System.out.println("> Última modificación: " + new java.util.Date(ultimaFecha)); // Enseñamos la última fecha de modificación.

                    // Especificamos los permisos de un fichero o directorio con los métodos de Java. Usamos ternarios para determinarlo.
                    System.out.println(f.canRead() ? "r" : "");
                    System.out.println(f.canWrite() ? "w" : "");
                    System.out.println(f.canExecute() ? "x" : "");
                    
                    System.out.println(verTamañoDirectorio(f)); // Llamamos al método 'verTamañoCarpeta()' para mostrar el tamaño del directorio. Como no hay nada, mostrará '0'.
                }
            }
        }
    }

    // Método para obtener el tamaño de un directorio.
    public static long verTamañoDirectorio(File directorio) {

        // Declaramos una variable 'longitud' que representará la longitud total de la directorio.
        long longitud = 0; 

        // Obtenemos un array de ficheros que contiene la directorio.
        File[] ficheros = directorio.listFiles(); 

        // Comprobamos si el array de ficheros no es nulo.
        if (ficheros != null) {
            // Recorremos cada fichero del array.
            for (File file : ficheros) {
                // Si el fichero es un fichero regular (no es un directorio), sumamos su tamaño a la variable 'longitud'.
                if (file.isFile()) {
                    longitud += file.length();
                } else {
                    // Si el fichero es un directorio, llamamos recursivamente al método 'verTamañoDirectorio()' para calcular su tamaño y sumamos el resultado a la variable 'longitud'.
                    longitud += verTamañoDirectorio(file);
                }
            }
        }

        // Devolvemos el tamaño total del directorio.
        return longitud;
    }

}
