package extra.repaso_TCP;

// Importación de librerías.
import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); // Creamos un escáner.
        
        // Estructura 'try-catch'.
        // Intentará iniciar el cliente y enviar las operaciones pertinentes (también leerá la respuesta del servidor), en caso de que
        // se produzca alguna excepción el programa la capturará.
        try {
            Socket cliente = new Socket("localhost", 8080); // Declaramos el socket de cliente.

            // Creamos los flujos de entrada y salida.
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            // Bucle infinito 'while'.
            // Recibirá y procesará las operaciones del cliente.
            while (true) {
                System.out.println("Introduce la operación (formato operación número1 número2) ['salir' para terminar]:");
                String operacion = sc.nextLine(); // Leemos la operación introducida por el cliente.

                // Estructura de control 'if'.
                // Si el usuario introduce "salir", la conexión del servidor terminará.
                if (operacion.equals("salir")) {
                    System.out.println("Terminando conexión con el servidor...");
                    break;
                }

                oos.writeObject(operacion); // Escribimos el objeto de la operación.
                oos.flush(); // Limpiamos el ObjectOutputStream.

                String respuesta = (String)ois.readObject(); // Declaramos una variable que representa la respuesta del servidor y leemos el objeto recibido.
                System.out.println("> Respuesta del servidor: " + respuesta);
            }
            // Cerramos los flujos, el cliente y el escáner.
            oos.close();
            ois.close();
            cliente.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado: "+ e.getMessage());
        }
    }
}
