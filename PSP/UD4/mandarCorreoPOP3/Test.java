package mandarCorreoPOP3;

import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;
import java.io.BufferedReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Test {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {

        Scanner sc = new Scanner(System.in);

        AuthenticatingSMTPClient smtpClient = new AuthenticatingSMTPClient();
        
        System.out.println("Introduce servidor SMTP: ");
        String serverSMTP = sc.nextLine();

        System.out.println("Necesita negociación TLS (S, N)?:");
        String tls = sc.nextLine();

        System.out.println("Introduce usuario: ");
        String username = sc.nextLine();

        System.out.println("Introduce password: ");
        String password = sc.nextLine();

        System.out.println("Introduce puerto SMTP: ");
        int puertoSMTP = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce correo del remitente: ");
        String remitente = sc.nextLine();

        System.out.println("Introduce correo destinatario: ");
        String destinatario = sc.nextLine();

        System.out.println("Introduce asunto: ");
        String asunto = sc.nextLine();

        System.out.println("Introduce el mensaje (finaliza con *):");
        StringBuilder mensaje = new StringBuilder();
        String linea;
        while (!(linea = sc.nextLine()).equals("*")) {
            mensaje.append(linea).append("\n");
        }

        try {
            smtpClient.connect(serverSMTP, puertoSMTP);
            System.out.println(smtpClient.getReplyString());
            
            if (!SMTPReply.isPositiveCompletion(smtpClient.getReplyCode())) {
                smtpClient.disconnect();
                System.err.println("El servidor SMTP rechazó la conexión.");
            }
            
            if (tls.equalsIgnoreCase("S")) {
                smtpClient.execTLS();
                System.out.println(smtpClient.getReplyString());
            }
            
            if (!smtpClient.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
                System.err.println("Autenticación fallida.");
            }

            System.out.println(smtpClient.getReplyString());
            
            SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destinatario, asunto);
            smtpClient.setSender(remitente);
            smtpClient.addRecipient(destinatario);
            smtpClient.sendShortMessageData(cabecera.toString() + mensaje.toString());
            System.out.println(smtpClient.getReplyString());
            
            smtpClient.logout();
            smtpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Solicitamos al usuario el servidor y el puerto POP3
        System.out.println("Introduce servidor POP3: ");
        String pop3Server = sc.nextLine();
        System.out.println("Introduce puerto POP3: ");
        int pop3Port = sc.nextInt();
        sc.nextLine();

        // Creamos un cliente POP3
        POP3Client pop3Client = new POP3Client();

        try {
            // Nos conectamos al servidor POP3
            pop3Client.connect(pop3Server, pop3Port);
            System.out.println(pop3Client.getReplyString());
            
            // Nos autenticamos en el servidor POP3
            if (!pop3Client.login(username, password)) {
                System.err.println("Error de autenticación en POP3.");
            }
            System.out.println(pop3Client.getReplyString());
            
            // Obtenemos la lista de mensajes en el buzón
            POP3MessageInfo[] messages = pop3Client.listMessages();
            if (messages != null) {
                System.out.println("Número de mensajes en el buzón: " + messages.length);
                for (POP3MessageInfo msgInfo : messages) {
                    BufferedReader reader = new BufferedReader(pop3Client.retrieveMessage(msgInfo.number));
                    String line;
                    System.out.println("Mensaje " + msgInfo.number + ":");
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                }
            }
            
            // Cerramos sesión y desconectamos el servidor POP3
            pop3Client.logout();
            pop3Client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
