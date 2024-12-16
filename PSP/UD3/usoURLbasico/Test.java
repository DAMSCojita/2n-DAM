package usoURLbasico;

import java.net.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        
        URL url;
        String urlEscogida = "";

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una URL:");
        urlEscogida = sc.nextLine();
        
        try {
            url = new URL(urlEscogida);
            Visualizar(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
            
        sc.close();
    }

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url.toString());	
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetUserInfo(): " + url.getUserInfo());
        System.out.println("\tgetPath(): " + url.getPath());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("\tgetDefaultPort(): "+ url.getDefaultPort());
        System.out.println("==================================================");
    }
}
