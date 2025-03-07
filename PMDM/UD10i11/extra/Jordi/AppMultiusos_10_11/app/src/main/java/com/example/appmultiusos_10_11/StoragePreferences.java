package com.example.appmultiusos_10_11;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StoragePreferences implements DataStorage {

    private static final String PREF_NAME = "contactos_prefs";
    private static final String KEY_CONTACTS = "contactos";
    private SharedPreferences preferences;

    public StoragePreferences(Context context) {
        this.preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void storeData(Contacto contacto) {
        // Obtener los contactos actuales
        Set<String> contactosGuardados = preferences.getStringSet(KEY_CONTACTS, new HashSet<>());

        // Convertir a una lista mutable
        List<String> contactosList = new ArrayList<>(contactosGuardados);
        // Añadir el nuevo contacto al principio de la lista
        contactosList.add(0, contacto.getNombre() + " - " + contacto.getTelefono() + " - " + contacto.getPoblacion());

        // Guardar en SharedPreferences
        preferences.edit().putStringSet(KEY_CONTACTS, new HashSet<>(contactosList)).apply();
    }

    @Override
    public List<Contacto> getDataList(int maxNo) {
        Set<String> contactosGuardados = preferences.getStringSet(KEY_CONTACTS, new HashSet<>());
        List<Contacto> listaContactos = new ArrayList<>();

        for (String contactoStr : contactosGuardados) {
            String[] partes = contactoStr.split(" - ");
            if (partes.length == 3) {
                listaContactos.add(new Contacto(partes[0], partes[1], partes[2]));
            }
        }

        return listaContactos;
    }

    @Override
    public void deleteData(String telefono) {
        Set<String> contactosGuardados = preferences.getStringSet(KEY_CONTACTS, new HashSet<>());
        Set<String> contactosActualizados = new HashSet<>();

        for (String contactoStr : contactosGuardados) {
            if (!contactoStr.contains(telefono)) { // Mantiene los que no coincidan con el teléfono
                contactosActualizados.add(contactoStr);
            }
        }

        // Guardar cambios
        preferences.edit().putStringSet(KEY_CONTACTS, contactosActualizados).apply();
    }
}

