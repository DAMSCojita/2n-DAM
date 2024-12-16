package servidorTCPbasico;

// Importación de librerías.
import java.io.*;
import java.net.*;

public class Servidor {
	public static void main(String[] args) throws IOException {
        
		// Declaración de variables.
        int puerto = 6000; // Declaramos una variable para representar el puerto.
		ServerSocket Servidor = new ServerSocket(puerto); // Declaramos el servidor y le pasamos por parámetro el puerto.
		
		System.out.println("Escuchando en " + Servidor.getLocalPort());	// Obtenemos el puerto actual y indicamos que es por el que estamos escuchando.
		
		Socket cliente = Servidor.accept(); // Aceptamos un cliente con 'accept()' y nos creamos un socket cliente para ello.

		// Mostramos información del primer cliente.
		System.out.println("- Cliente 1:");
		System.out.println("> " + cliente.getLocalPort());
		System.out.println("> " + cliente.getPort());
		
		Socket cliente2 = Servidor.accept(); // Aceptamos el segundo cliente con 'accept()' y nos creamos un socket cliente para ello.
		
		System.out.println(); // Salto de línea.

		// Mostramos información del segundo cliente.
		System.out.println("- Cliente 2:");
		System.out.println("> " + cliente2.getLocalPort());
		System.out.println("> " + cliente2.getPort());
		
		Servidor.close(); // Cerramos el servidor.
    }
}
