package com.example.appmultiusos_10_11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewContact extends AppCompatActivity {

    private EditText editTextNombre, editTextTelefono;
    private Spinner spinnerPoblacion;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        // Asociar elementos del layout
        editTextNombre = findViewById(R.id.editTextText3);
        editTextTelefono = findViewById(R.id.editTextText4);
        spinnerPoblacion = findViewById(R.id.spinner);
        btnGuardar = findViewById(R.id.button);

        // Evento del botón para guardar el contacto
        btnGuardar.setOnClickListener(v -> guardarContacto());
    }

    private void guardarContacto() {
        String nombre = editTextNombre.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String poblacion = spinnerPoblacion.getSelectedItem().toString();

        // Validamos que los campos no estén vacíos
        if (nombre.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear Intent para devolver datos
        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("telefono", telefono);
        intent.putExtra("poblacion", poblacion);
        setResult(Activity.RESULT_OK, intent); // Enviar datos de vuelta

        finish(); // Cerrar actividad y regresar a MainActivity
    }
}
