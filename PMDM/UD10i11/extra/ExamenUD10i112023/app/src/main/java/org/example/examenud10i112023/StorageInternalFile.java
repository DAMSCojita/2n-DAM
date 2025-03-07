package org.example.examenud10i112023;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StorageInternalFile implements ContacteStorage {

    private static final String FILE = "data.txt";
    private Context context;

    public StorageInternalFile(Context context) {
        this.context = context;
    }

    public void guardarDades(Contacte contacte) {
        try {
            FileOutputStream fos = context.openFileOutput(FILE, Context.MODE_APPEND);
            String text = contacte.getNom() + ";" + contacte.getTelefon() + ";" + contacte.getPoblacio() + "\n";
            fos.write(text.getBytes());
            fos.close();
        } catch (Exception e) {
            Log.e("App", "Error al guardar contacte: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Contacte> obtenirDades(int maxNo) {
        List<Contacte> resultat = new ArrayList<>();
        try (FileInputStream fos = context.openFileInput(FILE);
             BufferedReader br = new BufferedReader(new InputStreamReader(fos))) {

            String linea;
            int n = 0;
            while (n < maxNo && (linea = br.readLine()) != null) {
                String[] parts = linea.split(";");
                if (parts.length == 3) {
                    Contacte contacte = new Contacte(parts[0], parts[1], parts[2]);
                    resultat.add(contacte);
                    n++;
                }
            }
        } catch (Exception e) {
            Log.e("App", "Error al llegir contactes: " + e.getMessage(), e);
        }
        return resultat;
    }
}
