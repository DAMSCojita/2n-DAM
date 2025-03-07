package mandarCorreoBasico;

// Importación de librerías.
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Test {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {

        Scanner sc = new Scanner(System.in);

        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();

        System.out.println("Introduce servidor SMTP.........:");
        String server = sc.nextLine();

        System.out.println("Necesita negociación TLS (S, N)?:");
        String tls = sc.nextLine();

        System.out.println("Introduce usuario...............:");
        String username = sc.nextLine();

        System.out.println("Introduce password..............:");
        String pwd = sc.nextLine();

        System.out.println("Introduce puerto.................:");
        int puerto = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce correo del remitente........................:");
        String remitente = sc.nextLine();

        System.out.println("Introduce correo destinatario.........................:");
        String destinatario = sc.nextLine();

        System.out.println("Introduce asunto......................................:");
        String asunto = sc.nextLine();

        System.out.println("Introduce el mensaje, finalizará cuando se introduzca un * :");
        StringBuilder mensaje = new StringBuilder();
        String linea;
        while (!(linea = sc.nextLine()).equals("*")) {
            mensaje.append(linea).append("\n");
        }

        try {
            client.connect(server, puerto);
            System.out.println("> Se ha conectado al servidor SMTP con éxito.");

            if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
                client.disconnect();
                System.err.println("El servidor SMTP rechazó la conexión.");
                return;
            }

            if (tls.equalsIgnoreCase("S")) {
                client.execTLS();
                System.out.println("> Se ha establecido la negociación TLS.");
            }

            if (!client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, pwd)) {
                System.err.println("Autenticación fallida.");
                return;
            }
            System.out.println("> Autenticación exitosa.");

            SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destinatario, asunto);
            client.setSender(remitente);
            client.addRecipient(destinatario);
            client.sendShortMessageData(cabecera.toString() + mensaje.toString());
            System.out.println("> Correo enviado exitosamente.");

            client.logout();
            client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}