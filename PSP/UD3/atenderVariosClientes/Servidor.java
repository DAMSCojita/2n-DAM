package atenderVariosClientes;

// Importación de librerías.
import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            int puerto = 1234; // Declaramos una variable que contendrá el puerto.

            Scanner sc = new Scanner(System.in); // Declaramos un escáner.

            ServerSocket servidor = new ServerSocket(puerto); // Declaramos un servidor y le pasamos el puerto por parámetro.
            System.out.println("Servidor iniciado.");

            System.out.println("Bienvenido al programa servidor. Escribe el número de clientes que quieras gestionar: ");
            int MAX_CLIENTES = sc.nextInt(); // Guardamos la cantidad de clientes que manejará el servidor.

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

            // Cuando nos salgamos del bucle (es decir, cuando alcance el máximo de clientes), mostramos un mensaje indicándolo y además cerramos el servidor y el escáner.
            System.out.println("Se alcanzaron el máximo número de clientes permitidos. Cerrando servidor...");
            servidor.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
