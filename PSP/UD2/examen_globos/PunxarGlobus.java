package examen_globos;

public class PunxarGlobus extends Thread {

    // Declaración de atributos.
    Globus globus;
    int id;

    // Declaración de constructor.
    public PunxarGlobus(Globus g, int p_id){
        globus = g;
        id = p_id;
        setName("PG" + id); // Le ponemos nombre al proceso.
    }
    
    @Override
    public void run(){
        // Bucle 'while'
        // Iterará infinitamente, esperará tiempo e irá pinchando.
        while (true) {
            esperarTiempo();
            globus.pincharGlobo();
        } 
    } 

    // Creamos un método para esperar tiempo.
    public void esperarTiempo() {
        try {
            Thread.sleep((int)(Math.random() * 10000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
