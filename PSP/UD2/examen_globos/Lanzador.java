package examen_globos;

public class Lanzador {
    public static void main(String[] args) {
        
        // Declaramos un objeto cada clase Globo.
        Globus globo = new Globus();
        InflarGlobus inflaGlobus = new InflarGlobus(globo, 0);
        PunxarGlobus punxaGlobus = new PunxarGlobus(globo, 0);

        // Bucle 'for'.
        // Ejecutará los hilos.
        for (int i = 1; i < globo.MAX_GLOBOS; i++) {
            inflaGlobus = new InflarGlobus(globo, i);
            punxaGlobus = new PunxarGlobus(globo, i);
            inflaGlobus.start();
            punxaGlobus.start();
        }

    }
}
