package com.stefancojita.asteroides;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declaració de variables necessàries.
    TextView txtTitol;
    Button buttonJugar;
    Button buttonConfigurar;
    Button buttonSobre;
    Button buttonPuntuacions;
    public static ScoreStorage scoreStorage = new ScoreStorageList();
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Definim buttons.
        buttonJugar = findViewById(R.id.btnJugar);
        buttonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityJugar(null);
            }
        });
        buttonSobre = findViewById(R.id.btnSobre);
        Animation animacioGirSobre = AnimationUtils.loadAnimation(this, R.anim.gir_amb_zoom);
        buttonSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivitySobre(null);
                buttonSobre.startAnimation(animacioGirSobre);
            }
        });
        buttonPuntuacions = findViewById(R.id.btnPuntuacions);
        buttonPuntuacions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScores(null);
            }
        });
        buttonConfigurar = findViewById(R.id.btnConfigurar);
        buttonConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityPreferences(null);
            }
        });

        // Definim les animacions.
        txtTitol = findViewById(R.id.txtTitol);
        Animation animacioTitol = AnimationUtils.loadAnimation(this, R.anim.gir_amb_zoom);
        txtTitol.startAnimation(animacioTitol);

        buttonJugar = findViewById(R.id.btnJugar);
        Animation animacioJugar = AnimationUtils.loadAnimation(this, R.anim.apareixer);
        buttonJugar.startAnimation(animacioJugar);

        buttonConfigurar = findViewById(R.id.btnConfigurar);
        Animation animacioConfigurar = AnimationUtils.loadAnimation(this, R.anim.despl_dreta);
        buttonConfigurar.startAnimation(animacioConfigurar);

        buttonSobre = findViewById(R.id.btnSobre);
        Animation animacioTercer = AnimationUtils.loadAnimation(this, R.anim.animaciotercerboto);
        buttonSobre.startAnimation(animacioTercer);

        buttonPuntuacions = findViewById(R.id.btnPuntuacions);
        Animation animacioQuart = AnimationUtils.loadAnimation(this, R.anim.animacioquartboto);
        buttonPuntuacions.startAnimation(animacioQuart);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        mp = MediaPlayer.create(this, R.raw.audio); // Afegim aquí el MediaPlayer que contindrà l'àudio de fons.
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.preferences) {
            // arrancar activitat preferències
            arrancarActivityPreferences(null);
            return true;
        }
        if (id == R.id.about) {
            // arrancar activitat sobre...
            arrancarActivitySobre(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Cridam a la superclase
        super.onSaveInstanceState(savedInstanceState);
        // Comprovem si el reproductor d'àudio (mp) no és nul
        if (mp != null) {
            int pos = mp.getCurrentPosition();
            savedInstanceState.putInt("audio_position", pos); // Guardem la posició
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Cridam a la superclase
        super.onRestoreInstanceState(savedInstanceState);
        // Comprovem si l'estat de l'instància conté la clau "audio_position".
        if (savedInstanceState.containsKey("audio_position")) {
            int pos = savedInstanceState.getInt("audio_position");
            // Comprovem si el reproductor d'àudio (mp) no és nul
            if (mp != null) {
                mp.seekTo(pos); // Seguir reproduïnt des de la posició pos
            }
        }
    }

    public void arrancarActivityJugar(View view) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }

    public void arrancarActivitySobre(View view) {
        Intent i = new Intent(this, MainActivitySobre.class);
        startActivity(i);
    }

    public void arrancarActivityPreferences(View view) {
        Intent i = new Intent(this, PreferencesActivity.class);
        startActivity(i);
    }

    public void showScores(View view) {
        Intent i = new Intent(this, Scores.class);
        startActivity(i);
    }

//    public void arrancarSortida(View view) {
//        finish();
//    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause(); // Pausam sa música quan entrem al 'onPause()'.
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if (pref.getBoolean("musica", true)) {
            mp.start(); // Retornam sa música quan entrem al 'onResume()'.
        }
    }

}