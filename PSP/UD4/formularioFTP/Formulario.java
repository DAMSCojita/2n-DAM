package formularioFTP;

// Importación de librerías.
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.apache.commons.net.ftp.*;

public class Formulario {

    // Declaración de variables.
    private static FTPClient ftpClient = new FTPClient();
    static JFrame frame = new JFrame("Stefan Cojita - Actividad 4.3");
    static DefaultListModel<String> fileListModel = new DefaultListModel<>(); // Declaramos un modelo de lista para almacenar los nombres de los archivos.
    static JList<String> fileList = new JList<>(fileListModel); // Declaramos una lista para mostrar los nombres de los archivos.

    public static void creaFormulario() {
    
        Scanner sc = new Scanner(System.in); // Declaramos un escáner.

        // Pedimos al usuario que ingrese su nombre de usuario
        System.out.print("Ingrese el usuario: ");
        String user = sc.nextLine(); // Leemos la entrada del usuario y la guardamos.

        // Pedimos al usuario que ingrese su contraseña
        System.out.print("Ingrese la contraseña: ");
        String pwd = sc.nextLine(); // Leemos la entrada del usuario y la guardamos'

        // Estructura 'try-catch'.
        // Intentará conectarse al servidor FTP en localhost, en caso de que se produzca alguna excepción, se capturará y se mostrará un mensaje de error.
        try {
            ftpClient.connect("localhost"); // Intentamos conectar al servidor FTP en localhost.

            // Estructura de control 'if'.
            // Intentará iniciar sesión en el servidor FTP con las credenciales proporcionadas.
            // Si las credenciales son incorrectas, mostrará un mensaje de error y desconectará el servidor FTP.
            if (ftpClient.login(user, pwd)) {
                System.out.println("> Conexión exitosa al servidor FTP.");
                
                ftpClient.enterLocalPassiveMode(); // Configuramos el modo pasivo local para la conexión FTP.
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Establecemos el tipo de archivo a binario.
            } else {
                System.out.println("Usuario o contraseña incorrectos. Por favor, vuelva a intentarlo.");
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            System.out.println("Error al conectar al servidor FTP: " + e.getMessage());
        }

        // Configuramos el tamaño de la ventana del JFrame.
        frame.setSize(500, 400);

        // Establecemos la operación de cierre del JFrame.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecemos el diseño del JFrame a BorderLayout.
        frame.setLayout(new BorderLayout());

        // Creamos un JScrollPane para contener la lista de archivos.
        JScrollPane scrollPane = new JScrollPane(fileList);

        // Añadimos el JScrollPane al centro del JFrame.
        frame.add(scrollPane, BorderLayout.CENTER);

        // Creamos un JPanel para contener los botones.
        JPanel pnlBoton = new JPanel();

        // Creamos un botón para descargar archivos.
        JButton btnDescargar = new JButton("Descargar");
        // Añadimos un ActionListener al botón de descargar
        btnDescargar.addActionListener(new btnDescargarActionListener());

        // Creamos un botón para salir.
        JButton btnSalir = new JButton("Salir");
        // Añadimos un ActionListener al botón de salir
        btnSalir.addActionListener(new btnSalirActionListener());

        // Añadimos los botones al JPanel.
        pnlBoton.add(btnDescargar);
        pnlBoton.add(btnSalir);

        // Añadimos el JPanel al sur del JFrame.
        frame.add(pnlBoton, BorderLayout.SOUTH);

        try {
            // Bucle 'for'.
            // Obtendrá la lista de nombres de archivos del servidor FTP.
            for (String file : ftpClient.listNames()) {
                // Estructura de control 'if'.
                // Si el archivo es un archivo regular (no un directorio), lo añadimos al modelo de la lista.
                if (ftpClient.listFiles(file).length == 1) {
                    fileListModel.addElement(file);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error al obtener la lista de archivos: " + e.getMessage());
        }

        sc.close(); // Cerramos el Scanner.
        frame.setVisible(true); // Hacemos visible el JFrame.
        }

        // Creamos una clase interna para manejar el evento de descargar archivos.
        private static class btnDescargarActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String archivoSeleccionado = fileList.getSelectedValue(); // Obtenemos el archivo seleccionado de la lista guardándolo en una nueva variable.

                // Estructura de control 'if'.
                // Si no se ha seleccionado ningún archivo, mostrará un mensaje de advertencia.
                if (archivoSeleccionado == null) {
                    JOptionPane.showMessageDialog(frame, "Seleccione un archivo para descargar");
                    return;
                }

                // Creamos un JFileChooser para seleccionar la ubicación donde guardar el archivo.
                JFileChooser gestorArchivos = new JFileChooser();

                gestorArchivos.setSelectedFile(new File(archivoSeleccionado)); // Establecemos el archivo seleccionado como el archivo por defecto.
                int userSelection = gestorArchivos.showSaveDialog(frame); // Mostramos el diálogo de guardado.

                // Estructura de control 'if'.
                // Si el usuario aprueba la selección, obtendremos el archivo de guardado.
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File archivo_de_guardado = gestorArchivos.getSelectedFile();
                    // Estructura 'try-with-resources'.
                    // Intentará guardar el archivo en la ubicación seleccionada. En caso de que se produzca alguna excepción, se capturará y se mostrará un mensaje de error.
                    try (FileOutputStream fos = new FileOutputStream(archivo_de_guardado)) {
                        // Estructura de control 'if'.
                        // Si la descarga del archivo es exitosa, mostrará un mensaje de éxito.
                        // Si ocurre un error en la descarga, mostramos un mensaje de error
                        if (ftpClient.retrieveFile(archivoSeleccionado, fos)) {
                            JOptionPane.showMessageDialog(frame, "Se ha descargado el archivo con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Error en la descarga.");
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error al guardar el archivo: " + ex.getMessage());
                    }
                }
            }
        }

        // Creamos una clase interna para manejar el evento de salir.
        private static class btnSalirActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Estructura 'try-catch'.
                // Intentará cerrar la sesión y desconectar el cliente FTP. En caso de que se produzca una excepción, se capturará y se mostrará un mensaje de error.
                try {
                    // Estructura de control 'if'.
                    // Si el cliente FTP está conectado, cerramos la sesión y desconectamos.
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al desconectar: " + ex.getMessage());
                }
                System.exit(0); // Salimos del programa
            }
        }
}