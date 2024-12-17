package com.example.examenud4i52024;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botó per obrir ConfiguracioActivity
        Button btnConfiguracio = findViewById(R.id.btnConfiguracio);
        btnConfiguracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConfiguracioActivity.class);
                startActivity(intent);
            }
        });

        // Botó per obrir PuntuacionsActivity
        Button btnPuntuacions = findViewById(R.id.btnPuntuacions);
        btnPuntuacions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PuntuacionsActivity.class);
                startActivity(intent);
            }
        });

        // Botó per obrir AnimacioActivity
        Button btnAnimacio = findViewById(R.id.btnAnimacio);
        btnAnimacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimacioActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú i afegeix els elements a la barra d'accions
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Gestiona els clics d'elements del menú
        int id = item.getItemId();

        if (id == R.id.menu_configuracio) {
            Intent intent = new Intent(MainActivity.this, ConfiguracioActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_puntuacions) {
            Intent intent = new Intent(MainActivity.this, PuntuacionsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menu_animacio) {
            Intent intent = new Intent(MainActivity.this, AnimacioActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
