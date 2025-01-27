package numeros;

// Importación de librerías.
import java.io.Serializable;

public class Numeros implements Serializable {

    // Declaración de atributos.
    int numero;
    long cuadrado;
    long cubo;

    // Declaración de constructor.
    Numeros(int numero, long cuadrado, long cubo) {
        this.numero = numero;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }

    // Declaración de constructor sin parámetros.
    Numeros() {}
    
    // Métodos getters y setters para cada atributo.
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }

    public long getCubo() {
        return cubo;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }

}