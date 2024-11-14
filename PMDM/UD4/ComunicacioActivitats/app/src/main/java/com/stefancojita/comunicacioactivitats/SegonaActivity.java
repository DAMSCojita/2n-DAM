package com.stefancojita.comunicacioactivitats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegonaActivity extends AppCompatActivity {

    TextView textReceptor;
    Button btnVerificar;
    Button btnRebutjar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segona);

        textReceptor = findViewById(R.id.txtReceptor);
        Intent i = getIntent();
        String nom = i.getStringExtra("nom");
        textReceptor.setText("Benvingut " + nom + ", acceptes les condicions?");
        btnVerificar = findViewById(R.id.btnAcceptar);
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarResultat("Acceptat");
            }
        });
        btnRebutjar = findViewById(R.id.btnRebutjar);
        btnRebutjar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarResultat("Rebutjat");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void enviarResultat(String resultat) {
        Intent intent = new Intent();
        intent.putExtra("Resultat", resultat);
        setResult(RESULT_OK, intent);
        finish();
    }
}
