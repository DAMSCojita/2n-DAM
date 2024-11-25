package ruleta;

public class Banca {

    // Dinero inicial de la banca.
    int dineroInicial = 50000;

    synchronized void sumarBanca(int perdida) {
        dineroInicial += perdida;
        System.out.println("> La banca ha ganado: " + dineroInicial);
        notifyAll();
    }

    synchronized void restarBanca(int ganado) {
        dineroInicial -= ganado;
        System.out.println("> La banca ha perdido: " + dineroInicial);
        notifyAll();
    }

    synchronized int girarRuleta() {
        return (int)(Math.random() * 37);
    }

}
