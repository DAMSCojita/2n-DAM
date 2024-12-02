package PracticaExamenAcensor;

public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();

        // Crear y lanzar el hilo del ascensor.
        ControlAscensor controlAscensor = new ControlAscensor(ascensor);
        controlAscensor.start();

        // Crear y lanzar hilos de personas que llaman al ascensor.
        for (int i = 1; i <= 10; i++) {
            int pisoOrigen = (int) (Math.random() * 5); // Piso de origen aleatorio.
            int pisoDestino = (int) (Math.random() * 5); // Piso de destino aleatorio.

            // Evitar que la persona elija el mismo piso como origen y destino.
            while (pisoOrigen == pisoDestino) {
                pisoDestino = (int) (Math.random() * 5);
            }

            Persona persona = new Persona(ascensor, pisoOrigen, pisoDestino);
            persona.start();

            try {
                Thread.sleep((int) (Math.random() * 2000)); // Tiempo aleatorio entre llamadas.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
