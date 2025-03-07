package org.example.examenud10i112023;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class StorageApplicationFile implements ContacteStorage {

    private static final String FILE_NAME = "contactes.txt";
    private File file;

    public StorageApplicationFile(Context context) {
        file = new File(context.getFilesDir(), FILE_NAME);
    }

    @Override
    public void guardarDades(Contacte contacto) {
        try (FileOutputStream fos = new FileOutputStream(file, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw)) {

            bw.write(contacto.getNom() + "," + contacto.getTelefon() + "," + contacto.getPoblacio());
            bw.newLine();
        } catch (Exception e) {
            Log.e("StorageAppFile", "Error al emmagatzemar el contacte: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Contacte> obtenirDades(int maxNo) {
        List<Contacte> contactes = new ArrayList<>();

        if (!file.exists()) {
            return contactes;
        }

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String linea;
            int comptador = 0;
            while ((linea = br.readLine()) != null && comptador < maxNo) {
                String[] data = linea.split(",");
                if (data.length == 3) {
                    contactes.add(new Contacte(data[0], data[1], data[2]));
                }
                comptador++;
            }
        } catch (Exception e) {
            Log.e("StorageAppFile", "Error al llegir els contactes: " + e.getMessage(), e);
        }
        return contactes;
    }
}
