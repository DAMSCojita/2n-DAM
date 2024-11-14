package com.stefancojita.examen2023ud4i5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VectorActivity extends AppCompatActivity {

    // Declaració de l'únic button que necessitem que en aquest cas es el 'Sortir'.
    Button btnSortir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);
        btnSortir = findViewById(R.id.btnSortirVector);
        btnSortir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
