package tictacRunnable;

public class Test {
    
    public static void main(String[] args) {
        
        // Creamos los hilos Tic y Tac.
        Tic tic = new Tic();
        Tac tac = new Tac();
        
        // Iniciamos los hilos con Runnable.
        Thread hiloTic = new Thread(tic);
        Thread hiloTac = new Thread(tac);

        // Arrancamos los hilos.
        hiloTic.start();
        hiloTac.start();
        
        // Esperamos a que terminen los hilos.
        try {
            hiloTic.join(); // Esperamos a que termine el hilo Tic
            hiloTac.join(); // Esperamos a que termine el hilo Tac
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Todos los hilos han terminado.");

    }
}
