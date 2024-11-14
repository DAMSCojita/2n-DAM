package sumadores_y_ficheros;

public class Sumador {
    public static void main(String[] args) {
        
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        System.out.println(suma(x, y));
    }
    public static int suma(int x, int y) {
        return x + y;
    }

}
