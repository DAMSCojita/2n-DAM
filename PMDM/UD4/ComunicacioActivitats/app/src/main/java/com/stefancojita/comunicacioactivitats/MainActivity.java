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

public class MainActivity extends AppCompatActivity {

    TextView textNom;
    TextView textResultat;
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textResultat = findViewById(R.id.textViewResultat);
        btnVerify = findViewById(R.id.btnVerificar);
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarInformacio();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviarInformacio() {
        textNom = findViewById(R.id.edtNom);
        String nom = textNom.getText().toString();
        Intent i = new Intent(this, SegonaActivity.class);
        i.putExtra("nom", nom);
        startActivityForResult(i, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String res = data.getStringExtra("Resultat");
            // Estructura if
            // Comprovem que res no sigui null.
            if (res != null) {
                // Si la cadena es igual a "Acceptat", el text de resultat pasa a ser "Resultat: Acceptat." i al contrari.
                if (res.equals("Acceptat")) {
                    textResultat.setText("Resultat: Acceptat.");
                } else if (res.equals("Rebutjat")) {
                    textResultat.setText("Resultat: Rebutjat.");
                }
            }
        }
    }

}
