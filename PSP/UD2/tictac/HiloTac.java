package tictac;

public class HiloTac extends Thread {
    // Creamos el hilo Tac.
    // Imprimirá "TAC" cada medio segundo.
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

