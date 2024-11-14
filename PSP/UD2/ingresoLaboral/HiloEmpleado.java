package ingresoLaboral;

import java.util.*;

public class HiloEmpleado extends Thread {
    // Implemantamos el método run del hilo.
    @Override
    public void run() {

        Scanner sc = new Scanner(System.in); // Declaramos un scanner para leer de la consola.

        // Pedimos al usuario que ingrese los datos del empleado.
        System.out.println("> Ingrese el nombre del empleado:");
        String nombre = sc.nextLine();
        System.out.println("> Ingrese el día de ingreso:");
        String diaIngreso = sc.nextLine();
        System.out.println("> Ingrese la hora de ingreso:");
        String horaIngreso = sc.nextLine();
        
        // Pasamos la hora de ingreso a un formato numérico.
        double horaIngresoConvertido = Double.parseDouble(horaIngreso);

        double horaOficial = 8.0; // Definimos una variable para la hora oficial.

        // Estructura 'if'.
        // Evaluará si el empleado llego temprano o tarde.
        if (horaIngresoConvertido < horaOficial) {
            System.out.println(nombre + " llego temprano " + " el dia " + diaIngreso);
        } else {
            System.out.println(nombre + " llego tarde " + " el dia " + diaIngreso);
        }

        sc.close(); // Cerramos el scanner.
    }

}
