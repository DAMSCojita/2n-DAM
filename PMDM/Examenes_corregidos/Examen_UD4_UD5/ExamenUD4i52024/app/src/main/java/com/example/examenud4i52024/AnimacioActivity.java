package com.example.examenud4i52024;


import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AnimacioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animacio);

        // Llegeix el color de fons seleccionat a les preferències
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String colorFons = prefs.getString("color_fons_animacio", "blanc");

        // Configura el color de fons en funció de la preferència
        if ("negre".equals(colorFons)) {
            findViewById(R.id.layoutAnimacio).setBackgroundColor(getResources().getColor(android.R.color.black));
        } else {
            findViewById(R.id.layoutAnimacio).setBackgroundColor(getResources().getColor(android.R.color.white));
        }

        // Configura una animació simple per a la imatge
        ImageView imageView = findViewById(R.id.imageViewAnimacio);

        AnimationDrawable animation = (AnimationDrawable) ContextCompat.getDrawable(this,R.drawable.animation);
        imageView.setImageDrawable(animation);
        animation.start();
    }
}
