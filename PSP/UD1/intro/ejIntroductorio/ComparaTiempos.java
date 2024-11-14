package intro.ejIntroductorio;

// Importación de librerías.
import java.util.Comparator;

public class ComparaTiempos implements Comparator<Proceso> {

    // Implementamos el comparador de Comparator y comparamos restando los quantums.
    @Override
    public int compare(Proceso o1, Proceso o2) {
        return o1.quantum - o2.quantum;
    }



}
