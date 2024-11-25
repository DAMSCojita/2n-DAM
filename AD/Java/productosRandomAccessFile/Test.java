package productosRandomAccessFile;

// Importación de librerías.
import java.io.*;

public class Test {
    public static void main(String[] args) {

        // Declaramos los arrays con los datos de los productos.
        int id[] = new int[] {1, 2, 3, 4, 5};
        String nombre[] = new String[] {"Manzana", "Pera", "Cheetos", "Croquetas", "Natillas"};
        double precio[] = new double[] {0.20, 0.25, 2.50, 2.75, 2.80};
        boolean descuento[] = new boolean[] {false, false, true, true, true};
        char tipos[] = new char[] {'A', 'A', 'D', 'B', 'C'};

        // Bloque 'try-catch'.
        // Intentará abrir el fichero binario usando con RandomAccessFile. No hará falta cerrarlo.
        // En caso de que se produzca una excepción, el programa nos lo indicará.
        try (RandomAccessFile raf = new RandomAccessFile("src\\productosRandomAccessFile\\fichero.dat", "rw")) {
            // Bucle 'for'.
            // Irá escribiendo los datos de los 5 productos.
            for (int i = 0; i < 5; i++) {
                raf.writeInt(id[i]); // Escribimos el id.
                String nombreAjustado = String.format("%-10s", nombre[i]); // Ajustamos el nombre a 10 carácteres.
                // Bucle 'for-each'.
                // Escribirá carácter por carácter el nombreAjustado.
                for (char c : nombreAjustado.toCharArray()) {
                    raf.writeChar(c);
                }
                raf.writeDouble(precio[i]); // Escribimos el precio.
                raf.writeBoolean(descuento[i]); // Escribimos el descuento.
                raf.writeChar(tipos[i]); // Escribimos el tipo.
            }
            raf.seek(35); // Leemos el segundo registro (que empieza por la posición 35, porque cada registro ocupa 35 bytes).
            int idLeido = raf.readInt(); // Leemos el id.
            StringBuilder nombreLeido = new StringBuilder(); // Hacemos un StringBuilder del nombreLeido para almacenar los carácteres del nombre que se leerán del archivo.
            // Bucle 'for'.
            // Iterará leeyendo 10 carácteres (ya que es lo que le especificamos antes).
            //  Usamos 'append()' para agregar el carácter leído al StringBuilder, recostruyéndolo carácter por carácter.
            for (int i = 0; i < 10; i++) {
                nombreLeido.append(raf.readChar());
            }
            double precioLeido = raf.readDouble(); // Leemos el precio.
            boolean descuentoLeido = raf.readBoolean(); // Leemos el descuento.
            char tipoLeido = raf.readChar(); // Leemos el tipo.

            // Mostramos los datos del segundo registro.
            System.out.println("Datos del segundo registro: ");
            System.out.println("ID: " + idLeido);
            System.out.println("Nombre: " + nombreLeido.toString().trim()); // Leemos el nombre devolviendo nuevamente el String del nombre y eliminamos los espacios extra con el 'trim()' en caso de que haya.
            System.out.println("Precio: " + precioLeido);
            System.out.println("Descuento: " + descuentoLeido);
            System.out.println("Tipo: " + tipoLeido);
        } catch (IOException e) {
            System.out.println("Error al abrir el fichero: " + e.getMessage());
        }
    }
}
