package com.stefancojita.examen2023ud4i5;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AnimacioActivity extends AppCompatActivity {

    // Declaració de variables que necessitarem (ja siguin butons, imatges, etc...).
    AnimationDrawable animacio;
    Button btnComençar;
    Button btnAturar;
    Button btnSortir;
    ImageView imatge;
    TextView txtComptador;
    boolean run = false;
    int comptador = 0;
    Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacio);

        // Definim l'animació i sa vista.
        animacio = (AnimationDrawable) ContextCompat.getDrawable(this,R.drawable.animacio);
        ImageView vista = new ImageView(this);
        vista.setBackgroundColor(Color.WHITE);
        vista.setImageDrawable(animacio);

        imatge = findViewById(R.id.imageView);
        imatge.setImageDrawable(animacio);

        // Maneig del button 'Començar Animació'.
        btnComençar = findViewById(R.id.btnComencarAnimacio);
        btnComençar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animacio.start(); // Quan es premi el button començarà l'animació.
                startTimer();
            }
        });

        // Maneig del button 'Aturar Animació'.
        btnAturar = findViewById(R.id.btnAturarAnimacio);
        btnAturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animacio.stop(); // Quan es premi el button començarà l'animació.
                stopTimer();
            }
        });

        // Maneig del button 'Sortir'.
        btnSortir = findViewById(R.id.btnSortir);
        btnSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("Temps_animacio", comptador);
                setResult(RESULT_OK, i);
                finish();
            }
        });
        txtComptador = findViewById(R.id.txtTemps);
        runTimer();
    }

    // Mètode per començar el timer.
    private void startTimer() {
        run = true;
    }

    // Mètode per parar el timer.
    private void stopTimer() {
        run = false;
    }

    // Mètode per arrancar el timer i que el comptador es vagi incrementand.
    private void runTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (run) {
                    comptador++;
                }
                txtComptador.setText("Temps animacio: " + String.valueOf(comptador));
                handler.postDelayed(this, 1000);
            }
        });
    }
}
