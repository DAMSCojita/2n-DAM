package org.example.examenud10i112023;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DarrerContacteActivity extends AppCompatActivity {

    // Declaració de variables.
    private TextView txtNom, txtTelefon, txtPoblacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_darrer_contacte);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtNom = findViewById(R.id.txtNom);
        txtTelefon = findViewById(R.id.txtTelefon);
        txtPoblacio = findViewById(R.id.txtPoblacio);

        // Obtenim dades des Intent.
        String nom = getIntent().getStringExtra("nom");
        String telefon = getIntent().getStringExtra("telefon");
        String poblacio = getIntent().getStringExtra("poblacio");

        // Mostrem les dades en cas que existeixen.
        if (nom != null && telefon != null && poblacio != null) {
            txtNom.setText(nom);
            txtTelefon.setText(telefon);
            txtPoblacio.setText(poblacio);
        }

    }
}