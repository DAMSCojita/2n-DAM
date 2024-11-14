package almacenes;

public class Test {
    public static void main(String[] args) {

        Puerta p = new Puerta(); // Creamos la instancia de puerta.

        // Bucle 'for'.
        // Creamos y iniciamos los hilos de clientes, cada uno con una unidad de producto.
        // Ponemos un tiempo de espera en la creación de cada cliente por si acaso.
        for (int i = 0; i < 300; i++) {
            Cliente cliente = new Cliente(p);
            cliente.start();
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
