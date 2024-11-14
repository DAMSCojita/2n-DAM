package tictac;

public class Test {
    public static void main(String[] args) {
        
        // Creamos los hilos Tic y Tac.
        HiloTic tic = new HiloTic();
        HiloTac tac = new HiloTac();
        
        // Iniciamos los hilos.
        tic.start();
        tac.start();

    }
}
