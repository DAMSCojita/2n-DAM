package PracticaExamenImpresora;

public class Empleado extends Thread {
    private Impresora impresora; // La impresora compartida
    private String nombre; // Nombre del empleado

    public Empleado(Impresora impresora, String nombre) {
        this.impresora = impresora;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        // Generar aleatoriamente el número de documentos a imprimir (1 a 5)
        int documentos = (int) (Math.random() * 5) + 1;
        for (int i = 1; i <= documentos; i++) {
            impresora.imprimir(nombre, i); // Llamar al método sincronizado de la impresora
        }
    }
}
