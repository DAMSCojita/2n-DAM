package sumaNumeros;

public class Par extends Entero {

    // Creamos un método para imprimir los pares (también mostrará la suma).
    public void imprimirPares() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                suma += i;
            }
        }
        System.out.println("La suma de los pares es: " + suma);
    }
}
