package PracticaExamenAcensor;

class Ascensor {
    private int pisoActual = 0; // El ascensor empieza en el piso 0.
    private boolean solicitudPendiente = false; // Indica si hay una solicitud activa.
    private int pisoDestino; // Piso al que se dirige el ascensor.

    // Método sincronizado para que las personas llamen al ascensor.
    public synchronized void llamar(int pisoOrigen, int pisoDestino) {
        while (solicitudPendiente) { // Espera si ya hay una solicitud en proceso.
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Registrar la nueva solicitud.
        this.solicitudPendiente = true;
        this.pisoDestino = pisoDestino;

        System.out.println("Persona llama al ascensor desde el piso " + pisoOrigen +
                " con destino al piso " + pisoDestino);
        notifyAll(); // Notifica al ascensor que hay una nueva solicitud.
    }

    // Método sincronizado para que el ascensor atienda una solicitud.
    public synchronized void atender() {
        while (!solicitudPendiente) { // Espera hasta que haya una solicitud.
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simular movimiento del ascensor.
        System.out.println("Ascensor moviéndose desde el piso " + pisoActual +
                " al piso " + pisoDestino);
        moverAscensor(pisoDestino);

        // Solicitud completada.
        solicitudPendiente = false;
        System.out.println("Ascensor llegó al piso " + pisoDestino +
                " y completó la solicitud.");
        notifyAll(); // Notifica a las personas que el ascensor está disponible.
    }

    // Método para mover el ascensor simulando tiempo de desplazamiento.
    private void moverAscensor(int pisoDestino) {
        try {
            Thread.sleep(Math.abs(pisoDestino - pisoActual) * 1000); // Simula tiempo de movimiento.
            pisoActual = pisoDestino;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}