package PracticaExamenImpresora;

public class Impresora {
    // Método sincronizado para garantizar acceso exclusivo
    public synchronized void imprimir(String empleado, int documento) {
        System.out.println(empleado + " está imprimiendo el documento " + documento + ".");
        try {
            // Simular tiempo de impresión (1 a 3 segundos)
            Thread.sleep((int) (Math.random() * 2000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(empleado + " terminó de imprimir el documento " + documento + ".");
    }
}
