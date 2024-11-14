package tictacRunnable;

public class Tac implements Runnable {
    // Implementamos el método run del interfaz Runnable para el proceso tac.
    public void run() {
        while (true) {
            System.out.println("TAC");
            try {
                Thread.sleep(500); // Dormimos el proceso por medio segundo.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
