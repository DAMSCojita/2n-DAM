package numeros;

// Importación de librerías.
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        
        // Declaración de variables.
        String host = "localhost";
        int puerto = 12345;

        // Bloque 'try-resources'.
        // Intentará crear el socket, en caso de que se produzca una excepción (por ejemplo que se inicie mientras el servidor no lo está), la capturará.
        try (Socket socket = new Socket(host, puerto)) {
            // Declaración de Streams.
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in); // Creamos un escáner.
            int numero; // Declaramos una variable que representa el número introducido por el usuario.

            // Estructura de control 'do-while'.
            // Mientras el número que introduzca el usuario sea mayor a 0, el bucle se repetirá.
            do {
                System.out.println("Introduce un número (<= 0 para salir): ");
                numero = sc.nextInt(); // Leemos el número introducido por el usuario.

                Numeros numeros = new Numeros(); // Creamos un objeto de la clase 'Numeros'.
                numeros.setNumero(numero); // Usamos el setter y establecemos el número en el objeto.
                oos.writeObject(numeros); // Escribimos el objeto de numeros en el Stream.

                // Estructura de control 'if'.
                // Si el número introducido por el usuario es menor o igual a 0, salimos del bucle.
                // En caso contrario, leemos el objeto de numeros devolviendolo desde el Stream y mostramos sus propiedades.
                if (numero <= 0) {
                    break;
                }

                numeros = (Numeros)ois.readObject(); // Leemos el objeto de numeros del Stream.
                // Mostramos el resultado de los cálculos.
                System.out.println("> Cuadrado: " + numeros.getCuadrado()); 
                System.out.println("> Cubo: " + numeros.getCubo());
            } while (numero > 0);
            sc.close(); // Cerramos escáner.
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
        
    }
}
