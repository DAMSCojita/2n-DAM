package servidorTCPbasico;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        // Declaración de variables.
        String Host = "localhost";  // Declaramos una variable para representar el host.
        int Puerto = 6000; // Declaramos una variable para representar el puerto.
            
        Socket Cliente = new Socket(Host, Puerto); // Creamos un socket para el cliente asignándole el host y el puerto.

        InetAddress i = Cliente.getInetAddress(); // Obtenemos la dirección IP del cliente que se conecta al servidor.
        
        // Mostramos información sobre el cliente.
        System.out.println ("Puerto local: " + Cliente.getLocalPort());
        System.out.println ("Puerto Remoto: " + Cliente.getPort());
        System.out.println ("Nombre Host/IP: " + Cliente.getInetAddress());
        System.out.println ("Host Remoto: " + i.getHostName().toString());
        System.out.println ("IP Host Remoto: " + i.getHostAddress().toString());
        
        Cliente.close(); // Cerramos el socket de cliente.
    }
}
