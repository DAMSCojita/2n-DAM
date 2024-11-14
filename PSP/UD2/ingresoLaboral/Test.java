package ingresoLaboral;

public class Test {
    public static void main(String[] args) {

        // Creamos los dos hilos.
        HiloEmpleado hilo1 = new HiloEmpleado();
        HiloEmpleado hilo2 = new HiloEmpleado();

        // Iniciamos los hilos.
        hilo1.start();
        hilo2.start();

    }

}
