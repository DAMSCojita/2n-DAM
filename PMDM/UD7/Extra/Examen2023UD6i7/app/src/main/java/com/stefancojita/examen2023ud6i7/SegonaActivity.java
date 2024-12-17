package com.stefancojita.examen2023ud6i7;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class SegonaActivity extends AppCompatActivity {

    // Declaració de variables.
    private VideoView video;
    private int posicio_actual = 0;
    private boolean estaReproduintse = true;

    private float eixX; // Declaram el 'eixX'.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segona);
        // Assignam el vídeo.
        video = findViewById(R.id.videoView);
        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.windance); // Muntem el path del video.
        video.start(); // Començem el video.
        // Si l'estat del vídeo no es null...
        if (savedInstanceState != null) {
            posicio_actual = savedInstanceState.getInt("videoPosition", 0); // Agafam la posició actual i trucam al mètode per recuperar l'estat del vídeo.
            video.seekTo(posicio_actual); // Movem VideoView a la posició.
            video.start(); // Iniciam el video.
        }
        // Assignam la zona tàctil.
        findViewById(R.id.zonaTactil).setOnTouchListener(new View.OnTouchListener() {
            // Mètode per gestionar l'event de quan pitjam en la zona.
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Agafam l'event i canviam entre les accions amb un 'switch'.
                switch (motionEvent.getAction()) {
                    // Cas quan l'usuari prem la pantalla (acció de començar el gest).
                    case MotionEvent.ACTION_DOWN:
                        eixX = motionEvent.getX();  // Es guarda la posició en l'eix X on es produeix la pressió inicial.
                        return true;  // Es retorna 'true' per indicar que l'event ha estat gestionat i no cal seguir processant-lo.
                    // Cas quan l'usuari aixeca el dit de la pantalla (finalització del gest).
                    case MotionEvent.ACTION_UP:
                        float finalEixX = motionEvent.getX();  // Es guarda la posició en l'eix X en el moment en què l'usuari aixeca el dit.
                        float deltaEixX = finalEixX - eixX;  // Es calcula la diferència entre la posició inicial i final en l'eix X.

                        // Si la distància del desplaçament en l'eix X és més gran que 100 píxels.
                        if (Math.abs(deltaEixX) > 100) {
                            reiniciarVideo();  // Es crida el mètode 'reiniciarVideo()' per començar el vídeo des del principi.
                        } else {  // Cas que sigui menor.
                            pausarRetornarVideo();  // Es crida el mètode 'pausarRetornarVideo()' per pausar o reprendre el vídeo.
                        }
                        return true;  // Es retorna 'true' per indicar que l'event ha estat gestionat.
                }
                return false;  // Es retorna 'false' en cas que no coincideixi amb cap de les accions.
            }
        });
    }

    // Cream un mètode per pausar i retornar el video.
    private void pausarRetornarVideo() {
        // Si el video està reproduint-se (gestionat per la variable booleana).
        if (estaReproduintse) {
            video.pause(); // Pausem el video.
        } else { // Cas contrari.
            video.start(); // Iniciam el video de nou.
        }
        estaReproduintse = !estaReproduintse; // Passam a false la variable.
    }

    // Cream un mètode per reiniciar el vídeo.
    private void reiniciarVideo() {
        video.seekTo(0); // Retornam al principi (resumidament).
        video.start(); // Iniciam el vídeo.
        estaReproduintse = true; // Pasem la variable a true indicant que el video s'està reproduint.
    }

    // Mètode per guardar l'estat del video.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        posicio_actual = video.getCurrentPosition(); // Amb la variable declarada per tomar la posició, agafam la des video.
        outState.putInt("videoPosition", posicio_actual); // La guardem de nou (resumidament).
    }

    // Mètode per recuperar l'estat del video.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        posicio_actual = savedInstanceState.getInt("videoPosition");  // Amb la variable declarada per tomar la posició, truquem al mètode què te les dades guardades i l'assignam.
        video.seekTo(posicio_actual); // Retornam a la posició actual.
    }

}
