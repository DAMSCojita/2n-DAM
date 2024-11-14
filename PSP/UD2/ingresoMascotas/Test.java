package ingresoMascotas;

public class Test {
    public static void main(String[] args) {

        // Creamos los hilos de mascotas con posibles combinaciones.
        Thread hiloLoritos = new Thread(new HiloMascotas("loritos", 4, "palomas", 2));
        Thread hiloGatitos = new Thread(new HiloMascotas("gatitos", 4, "pollitos", 2));
        Thread hiloPeriquitos = new Thread(new HiloMascotas("periquitos", 4, "perico", 2));
        Thread hiloPollitos = new Thread(new HiloMascotas("pollitos", 4, "", 0));
        Thread hiloPalomas = new Thread(new HiloMascotas("palomas", 2, "loritos", 4));
        Thread hiloPerritos = new Thread(new HiloMascotas("perritos", 2, "", 0)); 
        Thread hiloPerico = new Thread(new HiloMascotas("perico", 2, "periquitos", 4));

        // Iniciamos los hilos.
        hiloLoritos.start();
        hiloGatitos.start();
        hiloPeriquitos.start();
        hiloPollitos.start();
        hiloPalomas.start();
        hiloPerritos.start();
        hiloPerico.start();
    }
}
