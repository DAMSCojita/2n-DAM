package com.example.appmultiusos_10_11;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StorageInternalFile implements DataStorage{

    private static final String FILE = "data.txt";
    private Context context;


    public StorageInternalFile(Context context) {
        this.context = context;

    }
    public void storeData(Contacto contacto) {
        try {
            FileOutputStream f = context.openFileOutput(FILE, Context.MODE_APPEND);
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
        try (FileInputStream f = context.openFileInput(FILE);
             BufferedReader inReader = new BufferedReader(new InputStreamReader(f))) {

            String line;
            int n = 0;
            while (n < maxNo && (line = inReader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {  // Verifica que haya tres elementos
                    Contacto contacto = new Contacto(parts[0], parts[1], parts[2]);
                    result.add(contacto);
                    n++;
                }
            }
        } catch (Exception e) {
            Log.e("App", "Error al leer contactos: " + e.getMessage(), e);
        }
        return result;
    }


    @Override
    public void deleteData(String telefono) {

    }
}
