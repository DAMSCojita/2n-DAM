package org.example.examenpasado8_9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MusicaActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_musica);

        Button arrancar = findViewById(R.id.boton_arrancar);
        //Aqui una funcion lambda para arancar
        arrancar.setOnClickListener(v -> startService(new Intent(MusicaActivity.this, ServeiMusica.class)));

        Button detener = findViewById(R.id.boton_detener);
        detener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MusicaActivity.this, ServeiMusica.class));
            }
        });
    }
}
