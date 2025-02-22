package com.stefancojita.animacio;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimationActivity extends AppCompatActivity {
    AnimationDrawable animacio;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animacio =
                (AnimationDrawable) ContextCompat.getDrawable(this,R.drawable.animacio)
        ;
        ImageView vista = new ImageView(this);
        vista.setBackgroundColor(Color.WHITE);
        vista.setImageDrawable(animacio);
        vista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                animacio.start();
            }
        });
        setContentView(vista);
    }
}