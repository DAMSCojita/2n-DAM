package carreraMascotas;

public class HiloMascotas extends Thread {

    // Declaramos la única variable que necesitaremos (que es el nombre) y la encapsulamos como privada.
    private String nombre;

    // Declaración de constructor.
    public HiloMascotas(String nombre) {
        this.nombre = nombre;
    }

    // Implementamos el método run().
    @Override
    public void run() {
        // Bucle 'for'.
        // Simulará la carrera de las mascotas. Empezando desde "1mt" hasta "30mt".
        for (int i = 1; i < 31; i++) {
            System.out.print(i + "mt" + " ");
        }
        System.out.println("\nLlego a la meta: " + this.nombre); // Mensaje que indica quién llegó a la meta.
    }
}
