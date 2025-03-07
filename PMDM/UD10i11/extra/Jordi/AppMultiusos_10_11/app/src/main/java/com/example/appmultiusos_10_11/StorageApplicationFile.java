package com.example.appmultiusos_10_11;

import android.content.Context;
import android.util.Log;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageApplicationFile implements DataStorage {
    private static final String FILE_NAME = "contactos.txt";
    private File file;

    public StorageApplicationFile(Context context) {
        file = new File(context.getFilesDir(), FILE_NAME);
    }

    @Override
    public void storeData(Contacto contacto) {
        try (FileOutputStream fos = new FileOutputStream(file, true);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter writer = new BufferedWriter(osw)) {

            writer.write(contacto.getNombre() + "," + contacto.getTelefono() + "," + contacto.getPoblacion());
            writer.newLine();
        } catch (Exception e) {
            Log.e("StorageAppFile", "Error al guardar contacto: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Contacto> getDataList(int maxNo) {
        List<Contacto> contactos = new ArrayList<>();

        if (!file.exists()) return contactos;

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader reader = new BufferedReader(isr)) {

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < maxNo) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    contactos.add(new Contacto(data[0], data[1], data[2]));
                }
                count++;
            }
        } catch (Exception e) {
            Log.e("StorageAppFile", "Error al leer contactos: " + e.getMessage(), e);
        }
        return contactos;
    }

    @Override
    public void deleteData(String telefono) {
        List<Contacto> contactos = getDataList(Integer.MAX_VALUE);
        List<Contacto> nuevosContactos = new ArrayList<>();

        for (Contacto c : contactos) {
            if (!c.getTelefono().equals(telefono)) {
                nuevosContactos.add(c);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(file, false);
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter writer = new BufferedWriter(osw)) {

            for (Contacto c : nuevosContactos) {
                writer.write(c.getNombre() + "," + c.getTelefono() + "," + c.getPoblacion());
                writer.newLine();
            }
        } catch (Exception e) {
            Log.e("StorageAppFile", "Error al eliminar contacto: " + e.getMessage(), e);
        }
    }
}
