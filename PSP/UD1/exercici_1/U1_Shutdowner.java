package exercici_1;

// Importación de librerías.
import java.io.*;
import java.util.*;

public class U1_Shutdowner {
    public static void main(String[] args) {

        // Declaración y inicialización de variables.
        int opcion = 0;
        int temp = 0;
        String comando = "";

        Scanner sc = new Scanner(System.in); // Escáner.

        // Presentación del programa.
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("                                          SHUTDOWNER");
        System.out.println("Bienvenido al programa Shutdowner. Podrás gestionar el apagado de tu sistema manualmente.");
        System.out.println("Elige una opción:");
        System.out.println("1. Apagar.");
        System.out.println("2. Reiniciar.");
        System.out.println("3. Suspender (aquí no hay tiempo de espera).");
        System.out.println("----------------------------------------------------------------------------------------------");
        try {
            opcion = sc.nextInt(); // Leer la opción del usuario.
            // Switch entre las opciones disponibles.
            switch (opcion) {
                case 1:
                    System.out.println("> Ahora, elige el tiempo de espera (o pon 0 si no quieres).");
                    temp = sc.nextInt(); // Guardamos el tiempo de espera.
                    System.out.println(" > Apagando equipo...");
                    comando = "shutdown /s /t " + temp;
                    break;
                case 2:
                    System.out.println("> Ahora, elige el tiempo de espera (o pon 0 si no quieres).");
                    temp = sc.nextInt(); // Guardamos el tiempo de espera.
                    System.out.println(" > Reiniciando equipo...");
                    comando = "shutdown /r /t " + temp;
                    break;
                case 3:
                    System.out.println(" > Suspendiendo equipo...");
                    comando = "shutdown /h";
                    break;
                default:
                    break;
            }
            try {
                @SuppressWarnings("unused") // Este código no hace nada en si, sirve solo para en el IDE de VS Code eliminar las advertencias.
                Process p = new ProcessBuilder("CMD", "/C", comando).start(); // Ejecutamos comando (VS Code me obliga a usar un try-catch aquí).
            } catch (IOException e) {
                e.printStackTrace();
            }
        // Manejo de excepciones en caso de entradas incorrectas.
        } catch (InputMismatchException me) {
            System.out.println("Error al leer los datos: " + me.getMessage());
        } catch (Exception e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }

        sc.close(); // Cerramos escáner.
    }
}
