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
                while (true) {
                        boolean palillosOcupados = this.palillo.tomarPalillos(palilloIzquierdo, palilloDerecho);
                        if (palillosOcupados) {
                                comer();
                                synchronized (palillo) {
                                        this.palillo.dejarPalillos(palilloIzquierdo, palilloDerecho);
                                }
                                pensar();
                        }
                }
        }

        private void esperarTiempoAzar() {
                Random generador = new Random();
                int milisegs = 1 + generador.nextInt(5) * 1000;
                try {
                        Thread.sleep(milisegs);
                } catch (InterruptedException e) {
                        System.out.println("Se ha producido un error inesperado al esperar: " + e.getMessage());
                }
        }

        public void comer() {
                System.out.println(Thread.currentThread().getName() + " está comiendo...");
                esperarTiempoAzar();
        }

        public void pensar() {
                System.out.println(Thread.currentThread().getName() + " está pensando...");
                esperarTiempoAzar();
        }
}
