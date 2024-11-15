package com.stefancojita.repasoexamenud4iud5;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAnimacion;
    Button btnVector;
    Button btnGraficos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnAnimacion = findViewById(R.id.btnAnimacion);
        btnAnimacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityAnimacion(null);
            }
        });
        btnVector = findViewById(R.id.btnVector);
        btnVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityVector(null);
            }
        });
        btnGraficos = findViewById(R.id.btnGraficos);
        btnGraficos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrancarActivityGraficos(null);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.preferences) {
            arrancarActivityPreferencias(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void arrancarActivityPreferencias(View view) {
        Intent i = new Intent(this, PreferencesActivity.class);
        startActivity(i);
    }

    public void arrancarActivityAnimacion(View view) {
        Intent i = new Intent(this, AnimationActivity.class);
        startActivity(i);
    }

    public void arrancarActivityVector(View view) {
        Intent i = new Intent(this, VectorActivity.class);
        startActivity(i);
    }

    public void arrancarActivityGraficos(View view) {
        Intent i = new Intent(this, GraficosActivity.class);
        startActivity(i);
    }

}