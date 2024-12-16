package envioNumeroEntero;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        
        try {
            ServerSocket servidor = new ServerSocket(1234); // Declaramos un servidor pasándole el puerto por parámetro.

            Socket cliente = servidor.accept(); // Aceptamos un cliente con 'accept()' y nos creamos un socket cliente para ello.
            System.out.println("Cliente conectado...");

            // Declaramos los flujos.
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            int numeroCliente = (int)ois.readObject(); // Leemos el número introducido por el cliente.
            System.out.println("Número recibido por el cliente: " + numeroCliente);

            int numeroCuadrado = numeroCliente * numeroCliente; // Nos creamos una nueva variable y calculamos el cuadrado del número proporcionado por el cliente.

            oos.writeObject(numeroCuadrado); // Escribimos el cuadrado en el flujo.
            System.out.println("> Cuadrado enviado al cliente: " + numeroCuadrado);

            // Cerramos los flujos, el cliente y el servidor.
            ois.close();
            oos.close();
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
