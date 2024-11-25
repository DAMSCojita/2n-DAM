package ruleta;

public class Jugador extends Thread {

    // Declaración de atributos.
    int tipoJuego;
    Banca banca;
    int dineroApuesta = 1000;

    // Declaración de constructor.
    public Jugador (int tipoJuego, Banca banca) {
        this.tipoJuego = tipoJuego;
        this.banca = banca;
    }

    public int generaNumeroApuesta() {
        return (int)(Math.random() * 36 + 1);
    }

    public int parImparApostado() {
        return (Math.random() < 0.5) ? 0 : 1;
    }

    public void run() {

        int apuestaMartingala = 10;

        while (dineroApuesta >= 10) {
            int numeroRuleta = banca.girarRuleta();
            int numeroApostado = generaNumeroApuesta();
            System.out.println(Thread.currentThread().getName() + " apostó al " + numeroApostado + ". Su saldo actual: " + dineroApuesta);

            switch (tipoJuego) {
                case 1:
                    jugarNumeroConcreto(numeroApostado, numeroRuleta);
                    break;
                case 2:
                    jugarParImpar(numeroRuleta);
                    break;
                case 3:
                    if (!jugarMartingala(numeroApostado, numeroRuleta, apuestaMartingala)) {
                        return;
                    } 
                    apuestaMartingala = actualizarMartingala(apuestaMartingala, numeroApostado, numeroRuleta);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }    
        }

        System.out.println("El jugador " + Thread.currentThread().getName() + " se quedó sin dinero. Su saldo final: " + dineroApuesta);
    }

    private void jugarNumeroConcreto(int numeroApostado, int numeroRuleta) {
        dineroApuesta -= 10;
        if (numeroApostado == numeroRuleta) {
            dineroApuesta += 360;
            banca.restarBanca(360);
            System.out.println(Thread.currentThread().getName() + " ganó al número concreto! Su saldo actual: " + dineroApuesta);
        } else {
            banca.sumarBanca(10);
        }
    }

    private void jugarParImpar(int numeroRuleta) {
        int apuestaParImpar = parImparApostado();
        dineroApuesta -= 10;
        if (numeroRuleta != 0 && numeroRuleta % 2 == apuestaParImpar) {
            dineroApuesta += 20;
            banca.restarBanca(20);
            System.out.println(Thread.currentThread().getName() + " ganó al par impar! Su saldo actual: " + dineroApuesta);
        } else {
            banca.sumarBanca(10);
        }
    }

    private boolean jugarMartingala(int numeroApostado, int numeroRuleta, int apuestaMartingala) {
        if (apuestaMartingala > dineroApuesta) {
            System.out.println(Thread.currentThread().getName() + " no tiene saldo suficiente para continuar con la martingala.");
            return false;
        }
        dineroApuesta -= apuestaMartingala;
        if (numeroApostado == numeroRuleta) {
            dineroApuesta += apuestaMartingala * 36;
            banca.restarBanca(apuestaMartingala * 36);
            System.out.println(Thread.currentThread().getName() + " ganó a la martingala! Su saldo actual: " + dineroApuesta);
            apuestaMartingala = 10;
        } else {
            banca.sumarBanca(apuestaMartingala);
            apuestaMartingala *= 2; 
        }
        return true;
    }

    private int actualizarMartingala(int apuestaMartingala, int numeroApostado, int numeroRuleta) {
        return (numeroApostado == numeroRuleta) ? 10 : apuestaMartingala * 2;
    }

}
