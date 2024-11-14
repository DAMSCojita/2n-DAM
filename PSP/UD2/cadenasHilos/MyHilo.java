package cadenasHilos;

public class MyHilo extends Thread {

    private SolicitaSuspender suspender = new SolicitaSuspender();
    int contador = 0; // Declaramos la variable del contador.
    boolean controla = true; // Declaramos una variable para contorlar el bucle.

    public void Suspende() { suspender.set(true);}

    public void Reanuda() { suspender.set(false);}

    // Creamos el método para visualizar el contenedor al detener el hilo. 
    public void visualizaContador() {
        System.out.println("Fin del hilo. Contador: " + contador);
    }
    public void run() {
        // Bucle 'while'.
        // Mientras la variable que se encarga de controlar sea verdad, irá iterando repetidamente.
        while (controla) {
            contador++; // Iremos incrementando el contador en 1 por cada iteración.
            System.out.println(contador); // Iremos mostrando el valor del contador por cada iteración.
            try {
                Thread.sleep(1000); // Establecemos que el hilo espere 1 segundo.
                suspender.esperandoParaReanudar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
