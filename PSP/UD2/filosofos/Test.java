package filosofos;

public class Test {
    public static void main(String[] args) {

        Palillo palillo;
        palillo = new Palillo(5);

        Filosofo filosofos[] = new Filosofo[5];

        Thread hilos[] = new Thread[5];

        for (int i = 1; i < 5; i++) {
            filosofos[i] = new Filosofo(palillo, i, i - 1);
            hilos[i] = new Thread(filosofos[i]);
            hilos[i].start();
        }
        filosofos[0] = new Filosofo(palillo, 0, 4);
        hilos[0] = new Thread(filosofos[0]);
        hilos[0].start();
        
    }
}
