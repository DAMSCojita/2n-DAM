package almacenes;

public class Cliente extends Thread {
    
    // Declaración de atributo.
    private Puerta puerta;

    // Declaración de constructor.
    public Cliente(Puerta c) {
        puerta = c;
    }

    // Implementamos el método run() de la clase Thread.
    // Aquí gestionaremos lo referente a los intentos.
    public void run() {
        int contadorIntentos = 1; // Declaramos una variable para los intentos.
        boolean haSalido = false; // Declaramos una variable para controlar si ha salido un cliente.
        // Bucle 'while'.
        // Mientras el cliente no haya salido y lleve menos de 10 intentos...
        while (haSalido == false && contadorIntentos < 10) {
            // Usamos el 'syncronized()' para asegurarnos que solo un hilo esté interactuando a la vez.
            synchronized (puerta) {
                // Bucle 'if'.
                // Para resumir, en caso de que la puerta esté disponible llamaríamos al método de paso de la clase Puerta.
                // También agregamos un 'try-catch' para poder gestionar alguna excepción en caso de que haya.
                if (!puerta.pendiente) { 
                    try {
                        puerta.pasar();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    haSalido = true; // Pasamos la variable 'haSalido' a true, indicando que el hilo ha pasado exitosamente.
                } else {
                    // Aquí, en caso de que la puerta no esté disponible, el contador de intentos aumentará. También agregamos un 'wait()' para que el hilo espere.
                    try {
                        contadorIntentos++;
                        puerta.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // Bucle 'if'.
        // En el caso de que el cliente haya necesitado 10 intentos, desistirá y se marchará.
        if (contadorIntentos == 10) {
            System.out.println("El cliente desiste y se marcha.");
        }   
    }

}
