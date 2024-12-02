package PracticaExamenSemaforo;

public class Main {
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();

        // Crear hilos de vehículos y peatones
        for (int i = 1; i <= 5; i++) {
            new Vehiculo(semaforo, i).start();
            new Peaton(semaforo, i).start();
        }

        // Cambiar el estado del semáforo periódicamente
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Cambia el semáforo cada 5 segundos
                    semaforo.cambiarEstado();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
