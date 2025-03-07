package org.example.examenud10i112023;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class VeureContactesActivity extends AppCompatActivity {

    // Declaració de variables.
    private ListView listViewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_veure_contactes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewContacts = findViewById(R.id.lstViewContactes);

        // Obtenim les dades passades del Intent.
        ArrayList<String> contactes = getIntent().getStringArrayListExtra("contactes");

        // Mostrem els contactes amb el ListView.
        if (contactes != null) {
            ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactes);
            listViewContacts.setAdapter(adaptador);
        }

    }
}