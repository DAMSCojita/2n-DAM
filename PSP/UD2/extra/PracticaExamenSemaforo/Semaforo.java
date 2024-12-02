package PracticaExamenSemaforo;

public class Semaforo {
    private boolean vehiculosPuedenCruzar = true; // Indica si los vehículos tienen luz verde

    // Método sincronizado para que un vehículo cruce
    public synchronized void cruzarVehiculo(int id) throws InterruptedException {
        while (!vehiculosPuedenCruzar) { // Si no es luz verde para vehículos, espera
            System.out.println("Vehículo " + id + " espera en el semáforo.");
            wait();
        }
        System.out.println("Vehículo " + id + " está cruzando.");
        Thread.sleep((int) (Math.random() * 2000)); // Simula el cruce
        System.out.println("Vehículo " + id + " ha cruzado.");
    }

    // Método sincronizado para que un peatón cruce
    public synchronized void cruzarPeaton(int id) throws InterruptedException {
        while (vehiculosPuedenCruzar) { // Si no es luz verde para peatones, espera
            System.out.println("Peatón " + id + " espera en el semáforo.");
            wait();
        }
        System.out.println("Peatón " + id + " está cruzando.");
        Thread.sleep((int) (Math.random() * 2000)); // Simula el cruce
        System.out.println("Peatón " + id + " ha cruzado.");
    }

    // Método sincronizado para cambiar el estado del semáforo
    public synchronized void cambiarEstado() {
        vehiculosPuedenCruzar = !vehiculosPuedenCruzar; // Alterna el semáforo
        System.out.println("\n*** Semáforo cambiado. Ahora " + 
            (vehiculosPuedenCruzar ? "vehículos" : "peatones") + " pueden cruzar. ***\n");
        notifyAll(); // Notifica a todos los hilos en espera
    }
}