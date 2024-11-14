package filosofos;

public class Palillo {

    boolean palilloDisponible[];

    public Palillo(int numPalillos) {
        palilloDisponible = new boolean[numPalillos];
        for (int i = 0; i < numPalillos; i++) {
            palilloDisponible[i] = true;
        }
    }

    public synchronized boolean tomarPalillos(int palillo_1, int palillo_2) {
        boolean palilloTomado = false;
        if ((palilloDisponible[palillo_1]) && (palilloDisponible[palillo_2])) {
            palilloDisponible[palillo_1] = false;
            palilloDisponible[palillo_2] = false;
            palilloTomado = true;
        }
        notifyAll();
        return palilloTomado;
    }

    public synchronized void dejarPalillos(int palillo_1, int palillo_2) {
        palilloDisponible[palillo_1] = true;
        palilloDisponible[palillo_2] = true;
        notifyAll();
    }
}
