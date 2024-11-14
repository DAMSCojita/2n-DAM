package tictac;

public class HiloTic extends Thread {
    public void run() {
        // Creamos el hilo Tic.
        // Imprimirá "TIC" cada medio segundo.
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



