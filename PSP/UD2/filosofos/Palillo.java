package filosofos;

public class Palillo {

    boolean palilloDisponible[]; // Creamos una variable booleana de array que representa los palillos disponibles.

    // Declaración de constructor.
    public Palillo(int numPalillos) {
        // Crea un array de booleanos con un tamaño igual al número de palillos (`numPalillos`).
        // Cada elemento del array representará si un palillo está disponible (`true`) o no (`false`).
        palilloDisponible = new boolean[numPalillos]; 
        // Inicializamos todos los palillos como disponibles (`true`) a través de un bucle 'for'.
        for (int i = 0; i < numPalillos; i++) {
            palilloDisponible[i] = true;
        }
    }

    // Creamos un método para tomar palillos.
    public synchronized boolean tomarPalillos(int palillo_1, int palillo_2) {
        boolean palilloTomado = false; // Declaramos una variable booleana que indicará si el palillo ha sido tomado.
        // Estructura 'if'.
        // Si ambos palillos están disponibles, los toma y devuelve `true`.
        // Si no, los devuelve `false` y espera a que algún palillo esté disponible.
        // Usamos el 'notifyAll()' para asegurarnos que todos los hilos puedan continuar su ejecución.
        if ((palilloDisponible[palillo_1]) && (palilloDisponible[palillo_2])) {
            palilloDisponible[palillo_1] = false;
            palilloDisponible[palillo_2] = false;
            palilloTomado = true;
        }
        notifyAll(); // Notificación a todos los procesos.
        return palilloTomado; // Devolvemos el palillo tomado.
    }

    // Creamos un método para dejar los palillos.
    public synchronized void dejarPalillos(int palillo_1, int palillo_2) {
        palilloDisponible[palillo_1] = true;
        palilloDisponible[palillo_2] = true;
        notifyAll(); // Notificación a todos los procesos.
    }
}
