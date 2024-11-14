package carreraAtleta;

import java.util.Scanner;

public class HiloAtleta extends Thread {
    @Override
    public void run() {

        // Declaramos el escáner.
        Scanner sc = new Scanner(System.in);

        // Pedimos al atleta su nombre y lo guardamos.
        System.out.println("> Ingrese el nombre del atleta:");
        String nombre = sc.nextLine();

        // Bucle 'for'.
        // Simulará la carrera del atleta. 
        for (int i = 1; i < 31; i++) {
            System.out.print(i + " km" + " ");
        }

        System.out.println("\nLlego a la meta " + nombre); // Mensaje que indica el final de la carrera del atleta.

        sc.close(); // Cerramos escáner.
    }
}
