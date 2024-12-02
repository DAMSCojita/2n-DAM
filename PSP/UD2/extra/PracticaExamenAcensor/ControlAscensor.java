package PracticaExamenAcensor;

class ControlAscensor extends Thread {
    private Ascensor ascensor;

    public ControlAscensor(Ascensor ascensor) {
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        while (true) { // El ascensor trabaja indefinidamente.
            ascensor.atender(); // Atiende solicitudes.
        }
    }
}
