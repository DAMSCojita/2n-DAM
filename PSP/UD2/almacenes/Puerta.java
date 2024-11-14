package almacenes;

public class Puerta {

    // Declaración de atributos.
    int unidadesProducto = 101;
    boolean pendiente = false;

    // Implementamos el método sincronizado pasar(), digamos que esto es lo que sería la puerta en si.
    public synchronized void pasar() throws InterruptedException {
        pendiente = true; // Empezamos poniendo 'pendiente' en true.
        // Estructura 'if'.
        // En caso de que haya alguna unidad de producto, se irá decrementando a medida que los clientes vayan pasando.
        if (unidadesProducto > 0) {
            unidadesProducto--;
            // Simulamos el tiempo que tarda en recoger el producto.
            try {
                wait(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("El cliente ha entrado y ha recogido un producto. Restantes: " + unidadesProducto); // Imprimos un mensaje que indica que el cliente recogió un producto.
        } else {
            // En caso de que no haya unidades de producto, se detiene el hilo.
            System.out.println("El cliente entró, pero no hubo productos.");
        }
        pendiente = false; // Pasamos 'pendiente' en false.
        notifyAll(); // Notificamos a todos los hilos.
    }

}
