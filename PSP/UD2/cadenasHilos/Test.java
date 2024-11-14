package cadenasHilos;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        @SuppressWarnings("resource") // Esto es solo para quitar el mensaje de aviso de que no hemos cerrado el escáner.
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena por teclado ('S' para suspender, 'R' para reanudar y '*' para detener):");
        MyHilo hilo = new MyHilo(); // Creamos una instancia para la clase 'myHilo'.
        hilo.start(); // Iniciamos el hilo.
        
        // Bucle 'while'.
        // Mientras la variable que controla el bucle en la clase de MyHilo sea true, iterará repetidamente.
        while (hilo.controla) {
            String cadena = sc.nextLine(); // Creamos una variable y guardamos la cadena del usuario.
            // Estructura 'if'.
            // Comprobamos la cadena introducida por el usuario y ejecutamos la acción correspondiente.
            if (cadena.equalsIgnoreCase("s")) {
                hilo.Suspende();
                System.out.println("> Hilo suspendido.");
            } else if (cadena.equalsIgnoreCase("r")) {
                hilo.Reanuda();
                System.out.println("> Hilo reanudado.");
            } else if (cadena.equalsIgnoreCase("*")) {
                hilo.controla = false; // Establecemos la variable que controla como false para detener el bucle.
                hilo.visualizaContador(); // Mostramos el recuento final del contador.
                System.out.println("> Hilo finalizado.");
            }
        }
    }
}
