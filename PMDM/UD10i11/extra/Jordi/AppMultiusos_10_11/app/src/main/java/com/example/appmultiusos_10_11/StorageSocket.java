package com.example.appmultiusos_10_11;

import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class StorageSocket implements DataStorage {
    private static final String SERVER_IP = "10.0.2.2"; // Cambia esto a la IP de tu servidor
    private static final int SERVER_PORT = 1234;

    public StorageSocket() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());
    }

    @Override
    public void storeData(Contacto contacto) {
        try {
            Socket sk = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            // Enviar datos al servidor
            out.println("ADD " + contacto.getNombre() + ";" + contacto.getTelefono() + ";" + contacto.getPoblacion());
            String response = in.readLine();
            if (!"OK".equals(response)) {
                Log.e("StorageSocket", "Error: Respuesta del servidor incorrecta");
            }
            sk.close();
        } catch (Exception e) {
            Log.e("StorageSocket", "Error al guardar contacto", e);
        }
    }

    @Override
    public List<Contacto> getDataList(int maxNo) {
        List<Contacto> contactos = new ArrayList<>();
        try {
            Socket sk = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            out.println("LIST");
            String line;
            int count = 0;
            while ((line = in.readLine()) != null && count < maxNo) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    contactos.add(new Contacto(parts[0], parts[1], parts[2]));
                    count++;
                }
            }
            sk.close();
        } catch (Exception e) {
            Log.e("StorageSocket", "Error al obtener lista de contactos", e);
        }
        return contactos;
    }

    @Override
    public void deleteData(String telefono) {
        try {
            Socket sk = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            out.println("DELETE " + telefono);
            String response = in.readLine();
            if (!"OK".equals(response)) {
                Log.e("StorageSocket", "Error: Respuesta del servidor incorrecta");
            }
            sk.close();
        } catch (Exception e) {
            Log.e("StorageSocket", "Error al eliminar contacto", e);
        }
    }
}
