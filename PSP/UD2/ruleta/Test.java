package ruleta;

public class Test {
    public static void main(String[] args) {
        
        Banca banca = new Banca();

        Jugador[] jugadores = new Jugador[4];
        jugadores[0] = new Jugador(1, banca);
        jugadores[1] = new Jugador(2, banca);
        jugadores[2] = new Jugador(3, banca);
        jugadores[3] = new Jugador(4, banca);

        Thread[] hilos = new Thread[4];
        for (int i = 0; i < jugadores.length; i++) {
            hilos[i] = new Thread(jugadores[i], "Jugador " + (i + 1));
        }

        for (Thread hilo : hilos) {
            hilo.start();
        }

    }
}
