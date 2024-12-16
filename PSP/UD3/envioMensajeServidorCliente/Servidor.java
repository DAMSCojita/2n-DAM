package envioMensajeServidorCliente;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        
        try {
            ServerSocket servidor = new ServerSocket(1234); // Creamos un servidor y le pasamos por parámetro el puerto.
            System.out.println("Esperando cliente...");

            Socket cliente = servidor.accept(); // Aceptamos un cliente con 'accept()' y nos creamos un socket cliente para ello.
            System.out.println("Cliente conectado.");

            // Declaramos los flujos. 
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            String mensaje = "¡Hola mundo!"; // Creamos una variable para almacenar el mensaje.
            oos.writeObject(mensaje); // Escribimos el mensaje en el flujo.
            System.out.println("Mensaje enviado: " + mensaje);

            String respuesta = (String)ois.readObject(); // Creamos una variable de respuesta que obtendrá y leerá la respuesta del cliente (a través del flujo resumidamente).
            System.out.println("Respuesta del cliente: " + respuesta);

            // Cerramos los flujos y el socket.
            oos.close();
            ois.close();
            cliente.close();
            servidor.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
