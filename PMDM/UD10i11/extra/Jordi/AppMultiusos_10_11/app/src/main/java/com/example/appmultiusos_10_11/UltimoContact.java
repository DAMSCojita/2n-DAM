package com.example.appmultiusos_10_11;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UltimoContact extends AppCompatActivity {

    private TextView txtNombre, txtTelefono, txtPoblacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimo_contact);

        // Inicializar las vistas
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtPoblacion = findViewById(R.id.txtPoblacion);

        // Obtener datos del Intent
        String nombre = getIntent().getStringExtra("nombre");
        String telefono = getIntent().getStringExtra("telefono");
        String poblacion = getIntent().getStringExtra("poblacion");

        // Mostrar los datos si existen
        if (nombre != null && telefono != null && poblacion != null) {
            txtNombre.setText(nombre);
            txtTelefono.setText(telefono);
            txtPoblacion.setText(poblacion);
        }
    }
}
