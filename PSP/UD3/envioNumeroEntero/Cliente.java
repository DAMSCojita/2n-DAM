package envioNumeroEntero;

// Importación de librerías.
import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Declaramos un escáner.

        try {
            Socket cliente = new Socket("localhost", 1234); // Creamos un cliente y le asignamos el localhost y el puerto por parámetro.

            // Declaramos los flujos.
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            System.out.println("Introduce un número para calcular su cuadrado: ");
            int numero = sc.nextInt(); // Guardamos el número escogido por el cliente.
            oos.writeObject(numero); // Escribimos el número para enviarlo al servidor.
            System.out.println("> Número enviado al servidor: " + numero);

            int numCuadrado = (int)ois.readObject(); // Obtenemos y leemos el número recibido con el cuadrado por el servidor. 
            System.out.println("> Cuadrado del número devuelto por el servidor: " + numCuadrado);

            // Cerramos los flujos y el socket.
            sc.close();
            oos.close();
            ois.close();
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
