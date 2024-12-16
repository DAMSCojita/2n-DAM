package atenderVariosClientesVariante;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 1234; // Declaramos una variable que contendrá el puerto.

            ServerSocket servidor = new ServerSocket(puerto); // Declaramos un servidor y le pasamos el puerto por parámetro.
            System.out.println("Servidor iniciado.");

            Socket socketCliente = servidor.accept(); // Aceptamos una conexión entrante desde un cliente en el servidor utilizando el método 'accept()'.
            ObjectInputStream ois = new ObjectInputStream(socketCliente.getInputStream()); // Creamos un ObjectInputStream para leer objetos enviados por el cliente a través del socket.
            int MAX_CLIENTES = (int) ois.readObject(); // Leemos el objeto enviado por el cliente. En este caso, esperamos recibir un número entero.
            System.out.println("Se aceptarán " + MAX_CLIENTES + " clientes."); // Imprimimos el número de clientes que el servidor aceptará, que se ha recibido del cliente.

            int clienteActual = 1; // Creamos una variable para representar el cliente actual.
            
            // Bucle 'while'.
            // Iterará mientras el número de clientes actuales sea igual o inferior al máximo que hemos definido previamente.
            while (clienteActual <= MAX_CLIENTES) {
                Socket cliente = servidor.accept(); // Aceptamos un cliente con 'accept()' y nos creamos un socket cliente para ello.
                System.out.println("Cliente " + clienteActual + " conectado.");

                // Creamos un flujo.
                ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
                oos.writeObject("Hola, cliente número " + clienteActual); // Escribimos en el flujo la indicación del cliente con su número.

                clienteActual++; // Incrementamos el contador de clientes actuales.

                // Cerramos el flujo y el cliente.
                oos.close();
                cliente.close();
            }

            // Cuando nos salgamos del bucle (es decir, cuando alcance el máximo de clientes), mostramos un mensaje indicándolo y además cerramos el servidor.
            System.out.println("Se alcanzaron el máximo número de clientes permitidos. Cerrando servidor...");
            servidor.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
