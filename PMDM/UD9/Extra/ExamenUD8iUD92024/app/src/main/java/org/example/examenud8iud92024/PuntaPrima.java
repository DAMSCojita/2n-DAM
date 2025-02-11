package org.example.examenud8iud92024;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PuntaPrima extends AppCompatActivity {

    TextView textPuntaPrima;
    TextView textdescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_punta_prima);
        textPuntaPrima = findViewById(R.id.txtPuntaPrima);
        textdescripcion = findViewById(R.id.txtPuntaPrimaDescripcion);
    }
}