package com.example.appmultiusos_10_11;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DataStorage datatorage = new StorageList(); // Inicialización por defecto

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

        configButtons();

        //PARA EL EXTERNAL FILE ESTO Y USES PERMISSIONS
        pedirPermisosAlmacenamiento();

        configAlmacenaje();
    }

    private void pedirPermisosAlmacenamiento() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) { // Android 11+
            Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
            startActivity(intent);
        }

    }
    public void configAlmacenaje() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String tipusEmmagatzematge = pref.getString("storage_type", "array");

        switch (tipusEmmagatzematge) {
            case "array":
                datatorage = new StorageList(); // Implementación con ArrayList
                break;
            case "shared_prefs":
                datatorage = new StoragePreferences(this); // Implementación con SharedPreferences
                break;
            case "memoria_interna":
                datatorage = new StorageInternalFile(this); // Implementación con archivo interno
                break;
            case "memoria_externa":
                datatorage = new StorageExternalFile(this); // Implementación con archivo externo
                break;
            case "application_file":
                datatorage = new StorageApplicationFile(this); // Implementación con archivo de la aplicación
                break;
            case "sqlite":
                datatorage = new StorageSQLite(this); // Implementación con SQLite
                break;
            case "en_servidor":
                datatorage = new StorageSocket(); // Implementación con servidor
                break;
            default:
                datatorage = new StorageList(); // Por defecto se usa ArrayList
                break;
        }
    }


    //Método para que ViewContact pueda acceder a datatorage
    public DataStorage getDataStorage() {
        return datatorage;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void abrirPreferencias() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.preferences) {
            abrirPreferencias();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void configButtons() {
        // Botón para añadir un nuevo contacto
        Button btnNuevo = findViewById(R.id.btnNewContact);
        btnNuevo.setOnClickListener(v -> {
            // Crea un intent para abrir la actividad de creación de un nuevo contacto
            Intent intent = new Intent(MainActivity.this, NewContact.class);
            // Inicia la actividad y espera un resultado (nuevo contacto creado)
            startActivityForResult(intent, 1); // Código 1 = Nuevo Contacto
        });

        // Botón para ver la lista de contactos almacenados
        Button btnVer = findViewById(R.id.btnViewContacts);
        btnVer.setOnClickListener(v -> {
            // Crea un intent para abrir la actividad que muestra los contactos
            Intent intent2 = new Intent(this, ViewContact.class);
            // Obtener los contactos desde el sistema de almacenamiento seleccionado
            ArrayList<String> contactosString = new ArrayList<>();
            for (Contacto c : datatorage.getDataList(100)) { // Usando el almacenamiento configurado
                contactosString.add(c.toString()); // Se transforma cada contacto en String
            }
            // Pasamos la lista de contactos a la nueva actividad
            intent2.putStringArrayListExtra("contactos", contactosString);
            startActivity(intent2); // Inicia la actividad de visualización de contactos
        });

        // Botón para ver el último contacto añadido
        Button btnUltimo = findViewById(R.id.btnLastContact);
        btnUltimo.setOnClickListener(v -> {
            // Obtener todos los contactos almacenados
            List<Contacto> contactos = datatorage.getDataList(100); // Obtén los primeros 100
            if (!contactos.isEmpty()) {
                Contacto ultimo = contactos.get(contactos.size() - 1); // Obtener el último contacto agregado
                // Crear intent y pasar los datos del último contacto
                Intent intent3 = new Intent(this, UltimoContact.class);
                intent3.putExtra("nombre", ultimo.getNombre());
                intent3.putExtra("telefono", ultimo.getTelefono());
                intent3.putExtra("poblacion", ultimo.getPoblacion());
                startActivity(intent3);
            } else {
                Toast.makeText(this, "No hay contactos almacenados", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Extraemos los datos enviados desde la otra actividad
            String nombre = data.getStringExtra("nombre");
            String telefono = data.getStringExtra("telefono");
            String poblacion = data.getStringExtra("poblacion");

            // Creamos un nuevo objeto Contacto con los datos recibidos
            Contacto nuevoContacto = new Contacto(nombre, telefono, poblacion);

            // Almacenamos el contacto utilizando el sistema de almacenamiento seleccionado
            datatorage.storeData(nuevoContacto);

            // Mostramos un mensaje de confirmación
            Toast.makeText(this, "Contacto guardado correctamente", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        configAlmacenaje(); // Refrescar la configuración después de volver de ajustes
    }


}
