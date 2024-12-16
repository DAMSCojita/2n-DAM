package atenderVariosClientesVariante;

// Importación de liberías.
import java.io.*;
import java.net.Socket;
import java.util.*;

public class Test { 
    public static void main(String[] args) { 
        try {

            // Declaramos un objeto File que representa el directorio donde se encuentran los archivos Java.
            File directorio = new File("src\\atenderVariosClientesVariante");

            Scanner sc = new Scanner(System.in); // Declaramos un escáner.
            
            System.out.println("Escribe el número de clientes que quieras gestionar: "); // Pedimos al usuario que ingrese el número de clientes que desea gestionar.
            int numClientes = sc.nextInt();  // Leemos el número de clientes ingresado por el usuario.

            // Declaramos un ProcessBuilder para ejecutar el servidor como un proceso independiente.
            ProcessBuilder servidorBuilder = new ProcessBuilder("java", "-cp", ".", "Servidor.java");
            servidorBuilder.directory(directorio);  // Establecemos el directorio de trabajo para el proceso.
            Process servidorProceso = servidorBuilder.inheritIO().start();  // Iniciamos el servidor y heredamos las entradas y salidas.
            
            Thread.sleep(1000); // Esperamos 1 segundo para asegurarnos de que el servidor esté listo para aceptar conexiones.

            // Establecemos una conexión con el servidor a través de un socket en localhost en el puerto 1234.
            // Creamos un ObjectOutputStream para enviar el número de clientes al servidor.
            try (Socket socket = new Socket("localhost", 1234);
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                oos.writeObject(numClientes);  // Enviamos el número de clientes al servidor.
                oos.flush();  // Aseguramos que los datos se envíen inmediatamente.
            }

            List<Process> clientesProcesos = new ArrayList<>(); // Creamos una lista para almacenar los procesos de los clientes.

            // Bucle 'for'
            // Iniciará un proceso de cliente por cada uno de ellos especificados por el usuario.
            for (int i = 0; i < numClientes; i++) {
                // Creamos un ProcessBuilder para iniciar el proceso de cliente.
                ProcessBuilder clienteBuilder = new ProcessBuilder("java", "-cp", ".", "Cliente.java");
                clienteBuilder.directory(directorio);  // Establecemos el directorio de trabajo para el cliente.
                Process clienteProceso = clienteBuilder.inheritIO().start();  // Iniciamos el proceso de cliente y heredamos las entradas y salidas.
                clientesProcesos.add(clienteProceso);  // Agregamos el proceso a la lista de clientes.
                Thread.sleep(500);  // Hacemos una pausa de 500 ms entre el lanzamiento de cada cliente.
            }

            // Bucle 'for'.
            // Esperará a que todos los procesos de los clientes terminen antes de continuar.
            for (Process clienteProceso : clientesProcesos) {
                clienteProceso.waitFor();  // Esperamos a que el proceso de cliente termine.
            }

            // Terminamos el proceso del servidor una vez que todos los clientes han terminado.
            servidorProceso.destroy();  // Detenemos el proceso del servidor.
            System.out.println("> Ejecución completada.");  // Imprimimos un mensaje indicando que la ejecución ha terminado.

            // Cerramos el objeto Scanner para liberar los recursos.
            sc.close();
        } catch (Exception e) {  // Capturamos cualquier excepción que pueda ocurrir durante la ejecución.
            e.printStackTrace();  // Imprimimos el stack trace de la excepción para facilitar la depuración.
        }
        
    }
}
