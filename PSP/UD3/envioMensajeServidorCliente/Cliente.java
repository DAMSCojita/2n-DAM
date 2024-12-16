package envioMensajeServidorCliente;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost", 1234); // Creamos un cliente y le asignamos el localhost y el puerto por parámetro.

            // Declaramos los flujos. 
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            String mensajeServidor = (String)ois.readObject(); // Declaramos una variable que obtendrá y leerá el mensaje del servidor.
            System.out.println("Mensaje recibido del servidor: " + mensajeServidor);

            String respuesta = mensajeServidor.toLowerCase(); // Convertimos el mensaje del servidor en minúscula.

            oos.writeObject(respuesta); // Escribimos el mensaje en minúscula.

            // Cerramos los flujos y el socket.
            ois.close();
            oos.close();
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
