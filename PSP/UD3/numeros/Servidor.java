package numeros;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        
        int puerto = 12345; // Declaramos una única variable que representa el puerto.

        // Bloque 'try-resources'.
        // Intentará crear y iniciar el socket del servidor, en caso de que no sea posible debido a una excepción, el programa la capturará.
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando cliente...");

            // Bucle infinito.
            // Creará otro socket que será el del cliente y lo aceptará con el del servidor. En caso de que haya alguna excepción, se capturará igual.
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    // Declaración de Streams.
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                    System.out.println("Cliente conectado.");

                    // Bucle infinito.
                    // Leerá los objetos y los mostrará por consola a no ser que el número que obtenga sea 0 o menor.
                    while (true) {
                        Numeros numeros = (Numeros)ois.readObject(); // Declaramos y leemos el objeto de números.

                        // Estructura de control 'if'.
                        // Como se ha explicado, en caso de que el número sea 0 o menor. El programa saldrá del bucle significando el cierre.
                        if (numeros.getNumero() <= 0) {
                            System.out.println("El cliente ha terminado la conexión.");
                            break;
                        }

                        int numero = numeros.getNumero(); // Declaramos una variable que tendra el número.
                        // Establecemos en el objeto de números un cálculo por cada operación.
                        numeros.setCuadrado((long)numero * numero);
                        numeros.setCubo((long)numero * numero * numero);

                        oos.writeObject(numeros); // Escribimos el objeto.
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error al intentar conectarse: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }

    }
}
