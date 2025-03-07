package com.example.appmultiusos_10_11;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ViewContact extends AppCompatActivity {

    private ListView listViewContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact_layout);

        listViewContacts = findViewById(R.id.listViewContacts);

        // Obtener los datos pasados en el Intent
        ArrayList<String> contactos = getIntent().getStringArrayListExtra("contactos");

        // Mostrar los contactos en el ListView
        if (contactos != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactos);
            listViewContacts.setAdapter(adapter);
        }
    }
}
