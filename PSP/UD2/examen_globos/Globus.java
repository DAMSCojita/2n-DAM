package examen_globos;

public class Globus {

    // Declaración de atributos y constantes.
    int globos[];
    int id = 1;
    int MAX_GLOBOS = 10;
    int MAX_HINCHADO = 3;    
    int volumenGlobo = 5;      
    int hinchandoGlobo;     
    
    // Declaración de constructor.
    public Globus() { 
        globos = new int[MAX_GLOBOS]; // Le asignamos al array de globos la cantidad máxima (que es la constante).

        // Bucle 'for'.
        // Iterará desde 0 hasta la máxima cantidad de globos posible.
        for (int i = 0; i < MAX_GLOBOS; i++) {
            globos[i] = 0; // Asignamos el valor 0 a cada posición del array de 'globos', asegurándonos que comience vacío o sin valor definido.
        }
    } 
 
    // Creamos un método para obtener un globo.
    public synchronized int obtenerGlobo() {
        // Bucle 'while'.
        // Mientras el número de globos que se estén hinchando sea igual a la máxima cantidad. Los procesos esperarán con 'wait()'.
        while (hinchandoGlobo == MAX_HINCHADO)  {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }              
        System.out.println("GLOBUS "+ id +" LLIURAT A "+ Thread.currentThread().getName());
        hinchandoGlobo++; // Incrementamos la variable que hincha los globos.
        id++; // Incrementamos el ID.
        notifyAll(); // Notificamos a todos los procesos.
        return id; // Devolvemos el id.      
    }

    // Creamos un método para hinchar un globo.
    public synchronized void hincharGlobo(int id) {
        estallaGlobo(); // Llamamos al método para estallar el globo.
        // Estructura de control 'if'.
        // Verificará si el valor en la posición 'id' del array de globos sea igual al volumen esperado ('volumenGlobo + 1').
        // Si la condición es verdadera, no realiza ninguna acción, ya que el bloque está vacío.                        
        if (globos[id - 1] == volumenGlobo + 1) { 
        } else {
            System.out.println("GLOBUS " + id + " LLIURAT A "+ globos[id - 1]);
        }
        notifyAll(); // Notificamos a todos los procesos.
    }
 
    // Creamos un método para pinchar un globo.
    public synchronized void pincharGlobo() {

        // Bucle 'while'.
        // Mientras el número de globos que se estén hinchando sea igual a 0. Los procesos esperarán con 'wait()'.
        while (hinchandoGlobo == 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Bucle 'for'.
        // Iterará desde 0 hasta la máxima cantidad de globos posible.
        // Encontrará y lleva a cabo la acción de pinchar el globo en la posición 'i' del array de globos.
        // Si encuentra un globo con el volumen esperado ('volumenGlobo + 1'), se detiene la iteración.
        for (int i = 0; i < MAX_GLOBOS; i++) {
            if (globos[i] > 0 && globos[i] <= volumenGlobo) {
                pinchaGlobo(i); // Llamamos al método para pinchar el globo en la posición que se encuentre.
                break;
            }
        }
        notifyAll(); // Notificamos a todos los procesos.
    }

    // Creamos un método para estallar un globo.
    public void estallaGlobo() {
        hinchandoGlobo--; // Decrementamos la variable que hincha el globo.
        System.out.println("GLOBUS " + id + " ESTALLA");
        notifyAll(); // Notificamos a todos los procesos.
    }

    // Creamos un método para pinchar un globo.
    public void pinchaGlobo(int id) {
        System.out.println("GLOBUS "+ (id + 1) +" PUNXAT PER "+ Thread.currentThread().getName());
        globos[id] = volumenGlobo++; // Asignamos el valor actual de 'volumenGlobo' a la posición 'id' del array de 'globos'. Luego, incrementamos el valor de 'volumenGlobo' en 1.
        hinchandoGlobo--; // Decrementamos la variable que hincha el globo.
        notifyAll(); // Notificamos a todos los procesos.
    }

}

