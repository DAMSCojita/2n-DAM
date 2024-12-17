package com.example.examenud4i52024;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ConfiguracioActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences); // Carrega les preferències des de l'XML
    }
}
