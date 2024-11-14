package com.stefancojita.examen2023ud4i5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaració de buttons i/o texts.
    Button buttonAnimacio;
    TextView txtComptadorMain;
    int comptadorAnimacio = 0;
    Button buttonVector;
    int comptadorVector;
    Button buttonMaps;
    TextView txtComptadorVector;
    int comptadorMapa = 0;
    TextView txtComptadorMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonAnimacio = findViewById(R.id.btnAnimacio);
        buttonAnimacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityAnimacio(null);
            }
        });
        txtComptadorMain = findViewById(R.id.txtTempsAnimacio);
        buttonVector = findViewById(R.id.btnVector);
        buttonVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityVector(null);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtComptadorVector = findViewById(R.id.txtExecucionsVector);
        buttonMaps = findViewById(R.id.btnMapa);
        buttonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.05295228786655,4.1301326103557034"));
                i.putExtra("Número execucions: ", comptadorMapa);
                setResult(RESULT_OK, i);
                startActivity(i);
                comptadorMapa++;
                txtComptadorMapa.setText("Número execucions: " + comptadorMapa);
            }
        });
        txtComptadorMapa = findViewById(R.id.txtExecucionsMapa);
    }

    // Cream un mètode per crear les opcions de menú.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Cream un mètode per iniciar una opció quan la pitgem.
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.preferencies) {
            arrancarActivityPreferences(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Cream un mètode per arrancar l'Activity de 'Preferences'
    public void arrancarActivityPreferences(View view) {
        Intent i = new Intent(this, PreferencesActivity.class);
        startActivity(i);
    }

    // Cream un métode per arrancar l'Activity d'Animació.
    public void arrancarActivityAnimacio(View view) {
        Intent i = new Intent(this, AnimacioActivity.class);
        startActivityForResult(i, 1234);
    }

    // Cream un mètode 'ActivityResult' per gestionar el retorn de dades dels comptadors.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            if (data != null) {
                comptadorAnimacio = data.getIntExtra("Temps_animacio", 0);
                txtComptadorMain.setText("Temps animació: " + comptadorAnimacio);
                comptadorMapa = data.getIntExtra("Número_execucions", 0);
                txtComptadorMapa.setText("Número execucions: " + comptadorMapa);
                comptadorVector = data.getIntExtra("Numero execucions: ", 0);
                txtComptadorVector.setText("Número execucions: " + comptadorVector);
            }
        }
    }

    // Cream un mètode per arrancar l'Activity del Vector.
    public void arrancarActivityVector(View view) {
        Intent i = new Intent(this, VectorActivity.class);
        i.putExtra("Número execucions: ", comptadorVector);
        setResult(RESULT_OK, i);
        startActivity(i);
        comptadorVector++;
        txtComptadorVector.setText("Número execucions: " + comptadorVector);
    }

}