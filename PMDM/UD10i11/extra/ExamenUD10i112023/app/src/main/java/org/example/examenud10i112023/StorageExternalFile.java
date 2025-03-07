package org.example.examenud10i112023;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StorageExternalFile implements ContacteStorage {

    private static final String FILE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/contactes.txt";
    private Context context;

    public StorageExternalFile(Context context) {
        this.context = context;
    }

    @Override
    public void guardarDades(Contacte contacte) {
        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(context, "No es pot escriure en la memòria externa", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file, true);
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
        String state = Environment.getExternalStorageState();

        if (!state.equals(Environment.MEDIA_MOUNTED) && !state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            Toast.makeText(context, "No es pot llegir la memòria externa", Toast.LENGTH_SHORT).show();
            return resultat;
        }

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                Log.e("App", "El fitxer de contactes no existeix, creant...");
                file.createNewFile();
                return resultat;
            }

            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String linea;
            int n = 0;
            while (n < maxNo && (linea = br.readLine()) != null) {
                String[] parts = linea.split(";");
                if (parts.length == 3) {
                    resultat.add(new Contacte(parts[0], parts[1], parts[2]));
                    n++;
                }
            }
            br.close();
            fis.close();
        } catch (Exception e) {
            Log.e("App", "Error al llegir contactes: " + e.getMessage(), e);
        }
        return resultat;
    }
}
