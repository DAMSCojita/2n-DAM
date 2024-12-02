package PracticaExamenAcensor;

class Persona extends Thread {
    private Ascensor ascensor;
    private int pisoOrigen;
    private int pisoDestino;

    public Persona(Ascensor ascensor, int pisoOrigen, int pisoDestino) {
        this.ascensor = ascensor;
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
    }

    @Override
    public void run() {
        ascensor.llamar(pisoOrigen, pisoDestino); // Llama al ascensor.
    }
}