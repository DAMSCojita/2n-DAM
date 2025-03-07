package org.example.examenud10i112023;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NouContacteActivity extends AppCompatActivity {

    // Declaració de variables.
    private EditText editTextNom, editTextTelefon;
    private Spinner spinnerPoblacio;
    private Button buttonEnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nou_contacte);
        editTextNom = findViewById(R.id.edtTxtNom);
        editTextTelefon = findViewById(R.id.edtTextTelefon);
        spinnerPoblacio = findViewById(R.id.spnPoblacio);
        buttonEnregistrar = findViewById(R.id.btnEnregistrar);

        // Listener per al botó de guardar contacte.
        buttonEnregistrar.setOnClickListener(v -> guardarContacte());

    }

    private void guardarContacte() {
        // Obtenim les dades dels camps.
        String nom = editTextNom.getText().toString().trim();
        String telefon = editTextTelefon.getText().toString().trim();
        String poblacio = spinnerPoblacio.getSelectedItem().toString();

        // Validem que els camps no estiguin buits.
        if (nom.isEmpty() || telefon.isEmpty()) {
            Toast.makeText(this, "Per favor, completa els camps...", Toast.LENGTH_SHORT).show();
            return;
        }

        // Creem Intent per retornar dades.
        Intent intent = new Intent();
        intent.putExtra("nom", nom);
        intent.putExtra("telefon", telefon);
        intent.putExtra("poblacio", poblacio);
        setResult(Activity.RESULT_OK, intent); // Enviem dades a l'activitat anterior.

        finish(); // Tancam l'activitat actual.
    }
}