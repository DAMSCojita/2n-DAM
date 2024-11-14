package ingresoMascotas;

import java.util.Random;

public class HiloMascotas implements Runnable {

    // Declaración de atributos.
    private String tipo;
    private int num;
    private String tipoExtra; 
    private int numExtra;

    // Declaración de constructor.
    public HiloMascotas(String tipo, int num, String tipoExtra, int numExtra) {
        this.tipo = tipo;
        this.num = num;
        this.tipoExtra = tipoExtra;
        this.numExtra = numExtra;
    }

    // Implementamos y sobreescribimos el método 'run()' de Runnable.
    @Override
    public void run() {
        Random random = new Random(); // Creamos una variable random para generar valores aleatorios.
        // Bucle 'for'.
        // El bucle se ejecuta 'num' veces, y también se ejecuta si 'numExtra' es menor o igual a 'num'.
        // Si el número aleatorio generado es verdadero, ingresaremos un animal con dos tipos de mascota, si no, ingresaremos un animal con un solo tipo.
        for (int i = 1; i <= num; i++) {
            if (random.nextBoolean() && i <= numExtra) {
                System.out.println("Ingresan " + i + " " + tipo + " y " + tipoExtra);
            } else {
                System.out.println("Ingresan " + i + " " + tipo);
            }
            try {
                Thread.sleep(500); // Simulamos el retraso de tiempo entre ingresos.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
