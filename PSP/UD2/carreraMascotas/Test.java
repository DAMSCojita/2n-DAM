package carreraMascotas;

public class Test {
    public static void main(String[] args) {
        
        // Declaramos los hilos añadiéndoles a cada uno el nombre de la mascota.
        HiloMascotas hilo1 = new HiloMascotas("Loqui");
        HiloMascotas hilo2 = new HiloMascotas("Ness");
        HiloMascotas hilo3 = new HiloMascotas("Blacky");

        // Iniciamos los hilos.
        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
