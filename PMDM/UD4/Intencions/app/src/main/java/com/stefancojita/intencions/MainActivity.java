package com.stefancojita.intencions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonPagina;
    Button buttonTelefon;
    Button buttonGoogleMaps;
    Button buttonFoto;
    Button buttonCorreu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonPagina = findViewById(R.id.btnPaginaWeb);
        buttonPagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.iesjoanramis.org/"));
                startActivity(i);
            }
        });
        buttonTelefon = findViewById(R.id.btnTelefon);
        buttonTelefon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:971000000"));
                startActivity(i);
            }
        });
        buttonGoogleMaps = findViewById(R.id.btnGoogleMaps);
        buttonGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:39.887642,4.254319"));
                startActivity(i);
            }
        });
        buttonFoto = findViewById(R.id.btnFoto);
        buttonFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
        buttonCorreu = findViewById(R.id.btnCorreu);
        buttonCorreu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "assumpte");
                i.putExtra(Intent.EXTRA_TEXT, "text del correu");
                i.putExtra(Intent.EXTRA_EMAIL, new String[] {"info@iesjoanramis.org"});
                startActivity(i);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}