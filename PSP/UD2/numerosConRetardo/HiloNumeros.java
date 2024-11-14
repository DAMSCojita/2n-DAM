package numerosConRetardo;

public class HiloNumeros extends Thread {

    // Implementamos el método run() para la ejecución del hilo.
    @Override
    public void run() {
        // Bucle 'for'.
        // Imprimirá los números del 1 al 20 con un retardo de 1,5 segundos entre cada número (usando sleep()).
        for (int i = 1; i < 21; i++) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
