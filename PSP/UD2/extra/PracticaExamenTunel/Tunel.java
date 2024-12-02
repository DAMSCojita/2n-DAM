package PracticaExamenTunel;

public class Tunel {
    private boolean ocupado = false; // Indica si el túnel está ocupado

    // Método sincronizado para entrar al túnel
    public synchronized void entrar(String direccion) throws InterruptedException {
        while (ocupado) { // Si el túnel está ocupado, espera
            System.out.println("Vehículo que viene de " + direccion + " espera para entrar.");
            wait();
        }
        ocupado = true; // Marca el túnel como ocupado
        System.out.println("Vehículo entrando al túnel desde " + direccion + ".");
    }

    // Método sincronizado para salir del túnel
    public synchronized void salir(String direccion) {
        ocupado = false; // Marca el túnel como libre
        System.out.println("Vehículo saliendo del túnel hacia " + direccion + ".");
        notifyAll(); // Notifica a los otros vehículos que pueden intentar entrar
    }
}
