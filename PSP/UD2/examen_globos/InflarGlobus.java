package examen_globos;

public class InflarGlobus extends Thread {
    
    // Declaración de atributos.
    Globus globus;
    int id;
 
    // Declaración de constructor.
    public InflarGlobus(Globus g, int p_id) {
        globus = g;
        id = p_id;
        setName("IG" + id); // Le ponemos nombre al proceso.
    }
 
    @Override
    public void run(){

        // Declaración de variables.
        int globoPillado;
 
        // Bucle 'while' infinito.
        // Se ejecutará mientras haya globos en el globo.
        // Cuando no haya globos, el hilo esperará hasta que se produzca un nuevo globo.
        // Cuando se produzca un nuevo globo, el hilo se activará y volverá a ejecutar el bucle.
        // Cuando se produzca un hilo que espera por un globo (el que se ha inflado),
        // el hilo se activará y volverá a ejecutar el bucle.
        while (true) {
            if ((globoPillado = globus.obtenerGlobo()) == -1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            esperarTiempo(); // Llamamos al método para esperar un tiempo.
            globus.hincharGlobo(globoPillado); // Llamamos al método de la clase Globus para hinchar el globo.
        } 
    }
    
    // Creamos un método para esperar tiempo.
    public void esperarTiempo() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 

