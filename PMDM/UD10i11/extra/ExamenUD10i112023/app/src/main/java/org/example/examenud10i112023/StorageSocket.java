package org.example.examenud10i112023;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class StorageSocket implements ContacteStorage {

    private static final String SERVER_IP = "10.0.2.2";
    private static final int SERVER_PORT = 1234;

    public StorageSocket() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }

    @Override
    public void guardarDades(Contacte contacte) {
        try {
            Socket sk = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            pw.println("ADD " + contacte.getNom() + ";" + contacte.getTelefon() + ";" + contacte.getPoblacio());
            String resposta = br.readLine();
            if (!"OK".equals(resposta)) {
                Log.e("StorageSocket", "Error: Resposta del servidor incorrecte");
            }
            sk.close();
        } catch (Exception e) {
            Log.e("StorageSocket", "Error al guardar contacte", e);
        }
    }

    @Override
    public List<Contacte> obtenirDades(int maxNo) {
        List<Contacte> contactes = new ArrayList<>();
        try {
            Socket sk = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            pw.println("LIST");
            String linea;
            int comptador = 0;
            while ((linea = br.readLine()) != null && comptador < maxNo) {
                String[] parts = linea.split(";");
                if (parts.length == 3) {
                    contactes.add(new Contacte(parts[0], parts[1], parts[2]));
                    comptador++;
                }
            }
            sk.close();
        } catch (Exception e) {
            Log.e("StorageSocket", "Error al obtenir la llista de contactes", e);
        }
        return contactes;
    }
}
