package intro.ejIntroductorio;

// Importación de librerías
import java.util.*;

public class Test {
    public static void main(String[] args) {
        
        // Creación de un ArrayList de procesos.
        ArrayList<Proceso> procesos = new ArrayList<>();

        generaProcesos(procesos); // Llamamos al método 'generaProcesos' para crearlos y llenar el ArrayList.

        System.out.println("-------------------------------------------------------");
        System.out.println("                          FIFO");
        for (Proceso proceso : procesos) {              
            System.out.println("Cargando procesos...");
            System.out.println("-" + proceso.id + ", " + proceso.quantum);
            try {                                       
                Thread.sleep(proceso.quantum * 1000); // Tiempo de espera.   
            } catch (Exception e) {                     
                System.out.println("Error al cargar el proceso: " + e.getMessage());
            }                                           
        }                                    
        System.out.println("\n-------------------------------------------------------");
        System.out.println("                      ROUND ROBIN ");
        while (!procesos.isEmpty()) {
            System.out.println("Cargando procesos...");
            Proceso p = procesos.get(0); // Pillamos el proceso que haya.
            p.quantum = p.quantum - 2;
            procesos.remove(0); // Borramos el proceso que haya.
            if (p.quantum < 0) {
                p.quantum = 0;
            }
            System.out.println("-" + p.id + ", " + p.quantum);
            try {
                Thread.sleep(p.quantum * 1000); // Tiempo de espera.
            } catch (Exception e) {
                System.out.println("Error al cargar el proceso: " + e.getMessage());
            }
            if (p.quantum > 0) {
                procesos.add(p);
            }
            
        }
        generaProcesos(procesos); // Llamamos al método 'generaProcesos' para crearlos y llenar el ArrayList.
        System.out.println("\n-------------------------------------------------------");
        System.out.println("                    PRIMERO MÁS PEQUEÑO ");
        Collections.sort(procesos, new ComparaTiempos()); // Implementamos el comparador para ordenar los procesos.
        for (Proceso proceso : procesos) {
            System.out.println("Cargando procesos...");
            System.out.println("-" + proceso.id + ", " + proceso.quantum);
            try {
                Thread.sleep(proceso.quantum * 1000); // Tiempo de espera.
            } catch (Exception e) {
                System.out.println("Error al cargar el proceso: " + e.getMessage());
            }
        }
        System.out.println("\n-------------------------------------------------------");
        procesos.clear(); // Eliminamos los procesos.
        generaProcesos(procesos); // Llamamos al método 'generaProcesos' para crearlos y llenar el ArrayList.
        System.out.println("              PRIMERO MÁS PRONTO EN ACABAR ");
        Collections.sort(procesos, new ComparaTiempos()); // Implementamos el comparador para ordenar los procesos.
        for (Proceso proceso : procesos) {
            System.out.println("Cargando procesos...");
            System.out.println("-" + proceso.id + ", " + proceso.quantum);
            try {
                Thread.sleep(proceso.quantum * 1000); // Tiempo de espera.
            } catch (Exception e) {
                System.out.println("Error al cargar el proceso: " + e.getMessage());
            }
        }
        System.out.println("\n-------------------------------------------------------");
    }

    // Método para generar los procesos.
    public static ArrayList<Proceso> generaProcesos(ArrayList<Proceso> procesos) {

        // Añadimos a la lista.
        procesos.add(new Proceso("P1", 5));
        procesos.add(new Proceso("P2", 4));
        procesos.add(new Proceso("P3", 3));
        procesos.add(new Proceso("P4", 2));

        return procesos; // Devolvemos la lista.
    }

}
