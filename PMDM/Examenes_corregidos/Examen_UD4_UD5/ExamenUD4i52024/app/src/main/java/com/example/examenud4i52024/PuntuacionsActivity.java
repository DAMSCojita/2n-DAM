package com.example.examenud4i52024;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PuntuacionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacions);

        TextView tvNomUsuari = findViewById(R.id.tvNomUsuari);
        ListView lvPuntuacions = findViewById(R.id.lvPuntuacions);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String nomUsuari = prefs.getString("nom_usuari", "Usuari");
        tvNomUsuari.setText("Puntuacions de: " + nomUsuari);

        String[] puntuacions = {"1000", "950", "900", "850", "800"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, puntuacions);
        lvPuntuacions.setAdapter(adapter);
    }
}
