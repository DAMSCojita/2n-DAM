package PracticaExamenImpresora;

public class Main {
    public static void main(String[] args) {
        // Crear la impresora compartida
        Impresora impresora = new Impresora();

        // Crear dos empleados que usan la misma impresora
        Empleado empleado1 = new Empleado(impresora, "Empleado 1");
        Empleado empleado2 = new Empleado(impresora, "Empleado 2");

        // Iniciar los hilos
        empleado1.start();
        empleado2.start();
    }
}
