package sumaNumeros;

public class Test {
    public static void main(String[] args) {
        
        // Creamos instancias para 'Par' y 'Impar'.
        Par par = new Par();
        Impar impar = new Impar();
        Par par_2 = new Par();
        Impar impar_2 = new Impar();

        // Creamos otros dos hilos usando Runnable.
        Thread hiloPar = new Thread(new HiloPares(par));
        Thread hiloImpar = new Thread(new HiloImpares(impar));
        Thread hiloPar_2 = new Thread(new HiloPares(par_2));
        Thread hiloImpar_2 = new Thread(new HiloImpares(impar_2));

        // Iniciamos los hilos.
        hiloPar.start();
        hiloImpar.start();
        hiloPar_2.start();
        hiloImpar_2.start();

        // Esperamos a que terminen los hilos.
        try {
            hiloPar.join();
            hiloImpar.join();
            hiloPar_2.join();
            hiloImpar_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("************************");
    }
}

// Implementamos una clase 'HiloPares' con Runnable.
class HiloPares implements Runnable {

    private Par par; // Declaramos la variable 'par' haciéndola de tipo clase 'Par'.

    // Declaración de constructor.
    public HiloPares(Par par) {
        this.par = par;
    }

    // Sobreescribimos el método 'run()' de Runnable.
    @Override
    public void run() {
        par.imprimirPares(); // Llamamos al método para imprimir los números pares usando la variable definida con la clase.
    }   
}

// Implementamos una clase 'HiloImpares' con Runnable.
class HiloImpares implements Runnable {

    private Impar impar; // Declaramos la variable 'impar' haciéndola de tipo clase 'Impar'.

    // Declaración de constructor.
    public HiloImpares(Impar impar) {
        this.impar = impar;
    }

    // Sobreescribimos el método 'run()' de Runnable.
    @Override
    public void run() {
        impar.imprimirImpares(); // Llamamos al método para imprimir los números impares usando la variable definida con la clase.
    }
}