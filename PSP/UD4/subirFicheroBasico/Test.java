package subirFicheroBasico;

// Importación de librerías.
import java.io.*;
import org.apache.commons.net.ftp.*;

public class Test {
    public static void main(String[] args) {

        FTPClient cliente = new FTPClient(); // Definimos el cliente. (No añadimos el 'S' en el FTP ya que lo hemos configurado en el servidor).

        // Declaración de variables.
        String servidor = "localhost";
        String user = "usuario1";
        String pwd = "123456";

        // Estructura 'try-catch'.
        // Intentará establecer la conexión al servidor.
        // En caso de que se produzca una excepción el programa la capturaría.
        try {
            System.out.println("Conectándose a " + servidor + "...");
            cliente.connect(servidor); // Nos conectamos al servidor.
            boolean login = cliente.login(user, pwd); // Declaramos una variable booleana que representa el login y dentro con el cliente usamos como parámetro el usuario y la contraseña.

            cliente.setFileType(FTP.BINARY_FILE_TYPE); // Configura la transferencia en modo binario para evitar modificaciones en el archivo.
            cliente.enterLocalPassiveMode(); // Activamos el modo pasivo para la transferencia de archivos.
            
            // Estructura de control 'if'.
            // Comprobará si el login ha sido correcto.
            if (login) {
                System.out.println("> Login correcto.");

                System.out.println("\n- Directorio actual: " + cliente.printWorkingDirectory()); // Mostramos por consola el directorio actual usando el método 'printWorkingDirectory()'.

                String archivo = "C:\\test\\prueba.txt"; // Declaramos una variable que representará el archivo con su respectiva ruta.
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivo)); // Declaramos un BufferedInputStream con el archivo.

                // Estructura de control 'if',
                // Intentará subir el archivo usando el método 'storeFile()'. En caso de que no pueda lo indicará con un mensaje.
                if (cliente.storeFile("prueba.txt", bis)) {
                    System.out.println("> Fichero subido correctamente.");
                } else {
                    System.out.println("No se ha podido subir el fichero.");
                }

                FTPFile[] archivos = cliente.listFiles(cliente.printWorkingDirectory()); // Declaramos un array de archivos que dentro tendrá un listado de ficheros del cliente y el directorio.
                System.out.println("\n> Ficheros en el directorio actual: ");

                // Bucle 'for'.
                // Recorrerá el array de archivos buscando los ficheros y los irá mostrando por consola.
                for (int i = 0; i < archivos.length; i++) {
                    System.out.println("    - " + archivos[i].getName());
                }

                // Cerramos el BufferedInputStream y desconectamos el cliente.
                bis.close();
                cliente.logout();
                cliente.disconnect();
            }
        } catch (IOException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }
}
