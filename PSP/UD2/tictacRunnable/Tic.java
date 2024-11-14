package tictacRunnable;

public class Tic implements Runnable {
    // Implementamos el método run del interfaz Runnable para el proceso tic.
    public void run() {
        while (true) {
            System.out.println("TIC");
            try {
                Thread.sleep(500); // Dormimos el proceso por medio segundo.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
