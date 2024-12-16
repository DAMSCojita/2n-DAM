package admitirMaquinaYIPbasico;

// Importación de librerías.
import java.util.*;
import java.net.*;

public class Test {
    public static void main(String[] args) {
        
        // Declaración de variables.
        InetAddress dir = null;
        String nombreMaquina = "";

        Scanner sc = new Scanner(System.in); // Declaramos un escáner.
        
        // Pedimos al usuario que introduzca el nombre de la máquina.
        System.out.println("Escribe el nombre de la máquina: ");
        nombreMaquina = sc.nextLine(); // Guardamos el nombre de la máquina en una variable.
        
        // Estructura 'try-catch'.
        // Intentará llamar al método para obtener la información y en caso de que no lo consiga capturará la excepción y lo avisará.
        try {
            dir = InetAddress.getByName(nombreMaquina); // Obtenemos la dirección IP de la máquina.
            pruebaMetodo(dir); // Llamamos al método 'pruebaMetodo()' pasando el nombre.
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close(); // Cerramos escáner.

    }

    // Método de la teoría para obtener la información.
    public static void pruebaMetodo(InetAddress dir) {
        System.out.println("\tMetodo getByName():  " + dir);
		InetAddress dir2;
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMetodo getLocalHost(): " + dir2);
		} catch (UnknownHostException e) {e.printStackTrace();}	

		// USAMOS METODOS DE LA CLASE
		System.out.println("\tMetodo getHostName(): "+ dir.getHostName());
		System.out.println("\tMetodo getHostAddress(): "+  dir.getHostAddress());
		System.out.println("\tMetodo toString(): " + dir.toString());
		System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());		
	}	
}

