package PracticaExamenTunel;

public class Main {
    public static void main(String[] args) {
        Tunel tunel = new Tunel(); // Crear el túnel

        // Crear dos vehículos que cruzan el túnel en direcciones opuestas
        Vehiculo vehiculo1 = new Vehiculo(tunel, "Norte a Sur");
        Vehiculo vehiculo2 = new Vehiculo(tunel, "Sur a Norte");

        // Iniciar los hilos
        vehiculo1.start();
        vehiculo2.start();

        try {
            vehiculo1.join(); // Espera a que el hilo 1 termine
            vehiculo2.join(); // Espera a que el hilo 2 termine
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los vehículos han cruzado el túnel.");
    }
}