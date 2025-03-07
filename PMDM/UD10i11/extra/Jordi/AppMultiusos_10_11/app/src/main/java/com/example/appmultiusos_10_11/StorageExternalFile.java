package com.example.appmultiusos_10_11;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageExternalFile implements DataStorage {
    private static final String FILE_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/contactos.txt";
    private Context context;

    public StorageExternalFile(Context context) {
        this.context = context;
    }

    @Override
    public void storeData(Contacto contacto) {
        String state = Environment.getExternalStorageState();
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(context, "No se puede escribir en la memoria externa", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) file.createNewFile(); // Crear el archivo si no existe

            FileOutputStream f = new FileOutputStream(file, true);
            String text = contacto.getNombre() + ";" + contacto.getTelefono() + ";" + contacto.getPoblacion() + "\n";
            f.write(text.getBytes());
            f.close();
        } catch (Exception e) {
            Log.e("App", "Error al guardar contacto: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Contacto> getDataList(int maxNo) {
        List<Contacto> result = new ArrayList<>();
        String state = Environment.getExternalStorageState();

        if (!state.equals(Environment.MEDIA_MOUNTED) && !state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            Toast.makeText(context, "No se puede leer la memoria externa", Toast.LENGTH_SHORT).show();
            return result;
        }

        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                Log.e("App", "El archivo de contactos no existe, creando...");
                file.createNewFile(); // Crea el archivo si no existe
                return result;
            }

            FileInputStream f = new FileInputStream(file);
            BufferedReader inReader = new BufferedReader(new InputStreamReader(f));

            String line;
            int n = 0;
            while (n < maxNo && (line = inReader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    result.add(new Contacto(parts[0], parts[1], parts[2]));
                    n++;
                }
            }
            inReader.close();
            f.close();
        } catch (Exception e) {
            Log.e("App", "Error al leer contactos: " + e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void deleteData(String telefono) {
        // Método sin implementar aún
    }
}
