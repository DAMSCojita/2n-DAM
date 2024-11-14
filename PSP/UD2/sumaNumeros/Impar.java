package sumaNumeros;

public class Impar extends Entero {

    // Creamos un método para imprimir los impares (también mostrará la suma).
    public void imprimirImpares() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                suma += i;
            }
        }
        System.out.println("La suma de los impares es: " + suma);
    }
}
