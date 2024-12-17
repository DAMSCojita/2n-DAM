package com.stefancojita.examen2023ud6i7;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // NOTA: Programa funciona per l'emulador només.

    // Declaració de variables.
    private SensorManager sensorManager;
    private Sensor accelerometre;
    private int comptador = 0;
    private TextView textComptador;
    private Button buttonPlayVideo;
    private MediaPlayer mediaPlayer;
    private boolean audioReproduint = false;

    private static final float umbral = 5.0f; // Declaram es umbral.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Assignam variables al layout.
        textComptador = findViewById(R.id.txtCounter);
        buttonPlayVideo = findViewById(R.id.btnPlayVideo);
        buttonPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityVideo(null);
            }
        });
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometre = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    // Mètode 'onResume()'.
    @Override
    protected void onResume() {
        super.onResume();
        // Comprovam que el accelometre no sigui null.
        if (accelerometre != null) {
            sensorManager.registerListener(this, accelerometre, SensorManager.SENSOR_DELAY_NORMAL); // Registram el sensor amb el accelòmetre.
        }
    }

    // Mètode 'onPause()'.
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    // Mètode 'onDestroy()'.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // Mètode per gestionar el sensor i els seus canvis.
    @Override
    public void onSensorChanged(SensorEvent event) {
        // Si el tipus del sensor es un accelòmetre...
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float y = event.values[1] * 100; // Declaram una variable per gestionar l'eix Y.

            // Si l'eix 'y' es major que l'umbral...
            if (y > umbral) {
                comptador++; // Incrementem el comptador.
                actualitzarComptador(); // Actualitzem els valors del comptador.
            } else if (y < -umbral) { // Cas contrari en que sigui menor
                // Si el comptador és major a 0.
                if (comptador > 0) {
                    comptador--; // Decrementem el comptador.
                    actualitzarComptador(); // Actualitzem els valors del comptador.
                }
            }
        }
    }

    // Mètode implementat de 'SensorEventListener' però en aquest cas no és necessari.
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    // Cream un mètode per actualitzar el comptador.
    private void actualitzarComptador() {
        textComptador.setText("Counter: " + comptador); // Posem el text per pantalla per tenir-lo.
        // Si el comptador es 0...
        if (comptador == 0) {
            buttonPlayVideo.setVisibility(Button.VISIBLE); // Feim visible el button de victòria.
            // Si l'àudio no se està reproduint...
            if (!audioReproduint) {
                audioReproduint = true; // Pasam la variable que gestiona la situació de l'audio reproduint a true.
                new Thread(this::activarAudio).start(); // Feim un altre thread trucant a la clase 'activarAudio()' i activant el so.
            }
        } else { // Cas que el comptador no sigui 0...
            buttonPlayVideo.setVisibility(Button.GONE); // Feim invisible el button.
        }
    }

    // Cream un mètode per activar l'àudio.
    private void activarAudio() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.success); // Cream un objecte MediaPlayer amb dins la referència del fitxer mp3.


        // Establim un listener amb un mètode que permet escoltar l'event quan la reproducció de l'àudio ha terminat.
        mediaPlayer.setOnCompletionListener(mp -> {
            mp.release(); // Alliberem recursos.
            audioReproduint = false; // Posam a false la variable 'audioReproduint', és a dir, no hi ha àudio.
        });

        mediaPlayer.start(); // Iniciam l'àudio.
    }

    // Mètode per guardar l'estat del comptador.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("comptador", comptador); // Afegim els canvis o números nous (si s'han incrementat o decrementat).
    }

    // Mètode per restaurar l'estat del comptador.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        comptador = savedInstanceState.getInt("comptador", 0); // Trucam al mètode amb els canvis del comptador i ho establim a la variable.
        actualitzarComptador(); // Trucam al mètode per actualitzar el comptador.
    }

    // Mètode per arrancar la segona activity.
    public void arrancarActivityVideo(View view) {
        Intent i = new Intent(this, SegonaActivity.class);
        startActivity(i);
    }
}