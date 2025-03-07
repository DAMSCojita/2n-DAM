package org.example.examenud10i112023;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StoragePreferences implements ContacteStorage {

    private static final String KEY_CONTACTS = "contactes";
    private SharedPreferences pref;
    private Context context;

    public StoragePreferences(Context context) {
        this.context = context;
        this.pref = context.getSharedPreferences("emmagatzematge", Context.MODE_PRIVATE);
    }

    @Override
    public void guardarDades(Contacte contacte) {
        Set<String> contactesEmmagatzemats = pref.getStringSet(KEY_CONTACTS, new HashSet<>());

        List<String> llistaContactes = new ArrayList<>(contactesEmmagatzemats);

        llistaContactes.add(0, contacte.getNom() + " - " + contacte.getTelefon() + " - " + contacte.getPoblacio());

        pref.edit().putStringSet(KEY_CONTACTS, new HashSet<>(llistaContactes)).apply();
    }

    @Override
    public List<Contacte> obtenirDades(int maxNo) {
        Set<String> contactesEmmagatzemats = pref.getStringSet(KEY_CONTACTS, new HashSet<>());
        List<Contacte> llistaContactes = new ArrayList<>();

        for (String contacteStr : contactesEmmagatzemats) {
            String[] parts = contacteStr.split(" - ");
            if (parts.length == 3) {
                llistaContactes.add(new Contacte(parts[0], parts[1], parts[2]));
            }
        }

        return llistaContactes;
    }
}