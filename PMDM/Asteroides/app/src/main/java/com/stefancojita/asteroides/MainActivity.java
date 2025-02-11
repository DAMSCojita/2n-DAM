package com.stefancojita.asteroides;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

    // Declaració de variables.
    TextView txtTitol;
    Button buttonJugar;
    Button buttonConfigurar;
    Button buttonSobre;
    Button buttonPuntuacions;
    public static ScoreStorage scoreStorage = new ScoreStorageList();
    ReceptorBateria rb = new ReceptorBateria(); // Declaram aquí el receptor de la bateria.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startService(new Intent(MainActivity.this, ServeiMusica.class)); // Iniciam el servei de música aquí.
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

        // Creem un IntentFilter i afegim l'acció ACTION_BATTERY_LOW.
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(rb, filter); // Registram el receptor de la bateria.

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
        if (ServeiMusica.reproductor != null) {
            int pos = ServeiMusica.reproductor.getCurrentPosition();
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
            if (ServeiMusica.reproductor != null) {
                ServeiMusica.reproductor.seekTo(pos); // Seguir reproduïnt des de la posició pos
            }
        }
    }

    // Intents per a arrancar les diferents activitats.
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

    // Intent per mostrar les puntuacions.
    public void showScores(View view) {
        Intent i = new Intent(this, Scores.class);
        startActivity(i);
    }

//    public void arrancarSortida(View view) {
//        finish();
//    }

    // Cicles de vida.
    @Override
    protected void onPause() {
        // Pausem la música si està sonant.
        if (ServeiMusica.reproductor != null) {
            ServeiMusica.reproductor.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this); // Declaram es SharedPreferences.
        // Comprovem si la música està habilitada a les preferències.
        if (pref.getBoolean("musica", true)) {
            // Iniciem el servei de música si està habilitat
            startService(new Intent(MainActivity.this, ServeiMusica.class));
            if (ServeiMusica.reproductor != null) {
                ServeiMusica.reproductor.start();
            }
        } else {
            // Aturem el servei de música si no està habilitat.
            stopService(new Intent(MainActivity.this, ServeiMusica.class));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Aturem el servei de música quan l'activitat es destrueix-
        stopService(new Intent(MainActivity.this, ServeiMusica.class));
    }

}