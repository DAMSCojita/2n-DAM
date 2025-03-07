package org.example.examenud10i112023;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Inicialitzem ContacteStorage.
    private ContacteStorage dataStorage = new StorageList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button buttonNouContacte = findViewById(R.id.btnNouContacte);
        buttonNouContacte.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, NouContacteActivity.class);
            startActivityForResult(i, 1);
        });

        Button buttonVeureContactes = findViewById(R.id.btnVeureContactes);
        buttonVeureContactes.setOnClickListener(v -> {
            Intent i = new Intent(this, VeureContactesActivity.class);

            ArrayList<String> contactesString = new ArrayList<>();
            for (Contacte c : dataStorage.obtenirDades(100)) {
                contactesString.add(c.toString());
            }

            i.putStringArrayListExtra("contactes", contactesString);
            startActivity(i);
        });

        Button buttonDarrerContacte = findViewById(R.id.btnDarrerContacte);
        buttonDarrerContacte.setOnClickListener(v -> {
            List<Contacte> contactos = dataStorage.obtenirDades(100);
            if (!contactos.isEmpty()) {
                Contacte ultim = contactos.get(contactos.size() - 1);

                Intent i = new Intent(this, DarrerContacteActivity.class);
                i.putExtra("nom", ultim.getNom());
                i.putExtra("telefon", ultim.getTelefon());
                i.putExtra("poblacio", ultim.getPoblacio());
                startActivity(i);
            } else {
                Toast.makeText(this, "No hi ha contactes", Toast.LENGTH_SHORT).show();
            }
        });

        demanarPermisos();

        // Inicialitzem scoreStorage segons el valor de les preferències.
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this); // Declaram es SharedPreferences.
        int tipusGuardat = Integer.parseInt(pref.getString("emmagatzematge", "0")); // Obtenim el tipus de guardat en una nova variable.
        switch (tipusGuardat) {
            case 0:
                dataStorage = new StorageList();
                break;
            case 1:
                dataStorage = new StoragePreferences(this);
                break;
            case 2:
                dataStorage = new StorageInternalFile(this);
                break;
            case 3:
                dataStorage = new StorageExternalFile(this);
                break;
            case 4:
                dataStorage = new StorageApplicationFile(this);
                break;
            case 5:
                dataStorage = new StorageSQLite(this);
                break;
            case 6:
                dataStorage = new StorageSocket();
                break;
            // Cas default.
            default:
                dataStorage = new StorageList();
                break;
        }

    }

    // Mètode per obtenir l'objecte DataStorage.
    public ContacteStorage getContacteStorage() {
        return dataStorage;
    }

    private void demanarPermisos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // Android 11+
            Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
            startActivity(intent);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.preferences) {
            arrancarActivityPreferences(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void arrancarActivityPreferences(View view) {
        Intent i = new Intent(this, PreferencesActivity.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            String nom = data.getStringExtra("nom");
            String telefon = data.getStringExtra("telefon");
            String poblacio = data.getStringExtra("poblacio");

            Contacte nouContacte = new Contacte(nom, telefon, poblacio);

            dataStorage.guardarDades(nouContacte);

            Toast.makeText(this, "Contacte emmagatzemat correctament!", Toast.LENGTH_SHORT).show();
        }
    }

}