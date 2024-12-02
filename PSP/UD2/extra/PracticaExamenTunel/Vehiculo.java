package PracticaExamenTunel;

public class Vehiculo extends Thread {
    private final Tunel tunel;
    private final String direccion;

    public Vehiculo(Tunel tunel, String direccion) {
        this.tunel = tunel;
        this.direccion = direccion;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) { // Cada vehículo intenta cruzar el túnel 5 veces
                tunel.entrar(direccion); // Intenta entrar al túnel
                Thread.sleep((int) (Math.random() * 2000)); // Simula el tiempo cruzando el túnel
                tunel.salir(direccion); // Sale del túnel
                Thread.sleep((int) (Math.random() * 1000)); // Simula el tiempo antes de intentar de nuevo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
