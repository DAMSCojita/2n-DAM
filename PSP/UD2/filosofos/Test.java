package filosofos;

public class Test {
    public static void main(String[] args) {

        Palillo palillo; // Declaramos una variable de objeto 'Palillo'.
        palillo = new Palillo(5); // Asignamos 5 palillos a la variable.

        Filosofo filosofos[] = new Filosofo[5]; // Creamos un array de filósofos y añadimos 5.

        Thread hilos[] = new Thread[5]; // Creamos un array de hilos y añadimos 5.

        // Bucle 'for'.
        // Creamos y iniciamos los hilos de filósofos, cada uno con una unidad de producto.
        // Ponemos un tiempo de espera en la creación de cada filósofo por si acaso.
        for (int i = 1; i < 5; i++) {
            filosofos[i] = new Filosofo(palillo, i, i - 1);
            hilos[i] = new Thread(filosofos[i]);
            hilos[i].start();
        }
        filosofos[0] = new Filosofo(palillo, 0, 4); // Asignamos al primer filósofo los palillos.
        hilos[0] = new Thread(filosofos[0]); // Asignamos al hilo el filósofo pertinente.
        hilos[0].start(); // Iniciamos el hilo.
        
    }
}
