package filosofos;

import java.util.Random;

public class Filosofo implements Runnable {

        // Declaración de atributos.
        Palillo palillo;
        int palilloIzquierdo;
        int palilloDerecho;

        // Declaración de constructor.
        public Filosofo(Palillo palillo, int palilloIzquierdo, int palilloDerecho) {
                this.palillo = palillo;
                this.palilloIzquierdo = palilloIzquierdo;
                this.palilloDerecho = palilloDerecho;
        }
        // Implementamos el método run() de la clase Thread.
        public void run() {
                // Bucle 'while'.
                // Iterará infinitamente.
                while (true) {
                        boolean palillosOcupados = this.palillo.tomarPalillos(palilloIzquierdo, palilloDerecho); // Creamos una variable que representa los palillos ocupados y intentamos pillar los palillos.
                        // Estructura 'if'.
                        // Si los palillos están ocupados, comeremos, liberamos los palillos y pasamos a pensar.
                        // Si los palillos están libres, esperamos un tiempo azar y volvemos a pensar.
                        // El bucle se repite hasta que los palillos estén libres y comamos.
                        // Usamos el 'synchronized()' para asegurarnos que solo un hilo esté interactuando a la vez.
                        // Si los palillos están ocupados, esperamos un tiempo azar y volvemos a pensar.
                        // Si los palillos están libres, comeremos y pasamos a pensar.
                        // El bucle se repite hasta que los palillos estén libres y comamos.	
                        if (palillosOcupados) {
                                comer();
                                synchronized (palillo) {
                                        this.palillo.dejarPalillos(palilloIzquierdo, palilloDerecho);
                                }
                                pensar();
                        }
                }
        }

        // Creamos un método para esperar tiempo al azar.
        private void esperarTiempoAzar() {
                Random generador = new Random(); // Creamos un generador aleatorio.
                // Declaramos una variable que representará los milisegundos. Multiplica este valor por 1000 para obtener un rango en milisegundos: 0, 1000, 2000, ..., 4000.
                // Suma 1 para que el resultado final sea entre 1 y 5000 milisegundos.
                int milisegs = 1 + generador.nextInt(5) * 1000;
                // Bloque 'try-catch'.
                // Espera un tiempo aleatorio en milisegundos.
                // Si se produce una excepción durante la espera, se imprime un mensaje de error.
                try {
                        Thread.sleep(milisegs);
                } catch (InterruptedException e) {
                        System.out.println("Se ha producido un error inesperado al esperar: " + e.getMessage());
                }
        }

        // Creamos un método para comer.
        public void comer() {
                System.out.println("Filosofo " + Thread.currentThread().getName() + " comiendo");
                esperarTiempoAzar();
        }

        // Creamos un método para pensar.
        public void pensar() {
                System.out.println("Filosofo " + Thread.currentThread().getName() + " está pensando");
                esperarTiempoAzar();
        }
}
