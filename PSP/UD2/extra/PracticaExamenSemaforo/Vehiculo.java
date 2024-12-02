package PracticaExamenSemaforo;

public class Vehiculo extends Thread {
    private final Semaforo semaforo;
    private final int id;

    public Vehiculo(Semaforo semaforo, int id) {
        this.semaforo = semaforo;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaforo.cruzarVehiculo(id); // Intenta cruzar cuando tenga luz verde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
