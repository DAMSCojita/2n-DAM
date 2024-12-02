package PracticaExamenSemaforo;

public class Peaton extends Thread {
    private final Semaforo semaforo;
    private final int id;

    public Peaton(Semaforo semaforo, int id) {
        this.semaforo = semaforo;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            semaforo.cruzarPeaton(id); // Intenta cruzar cuando tenga luz verde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
	