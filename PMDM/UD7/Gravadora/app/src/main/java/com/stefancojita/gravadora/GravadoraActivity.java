package com.stefancojita.gravadora;

import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;

public class GravadoraActivity extends AppCompatActivity {

    // NOTA: S'ha de declarar en el Android Manifest també permisos per gravar.

    // Declaració de variables.
    private static final String LOG_TAG = "Gravadora";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private boolean permissionToRecordAccepted = false;
    private String[] permissions = {Manifest.permission.RECORD_AUDIO};

    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private static String fitxer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sol·licitem permisos per gravar l'àudio.
        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);

        // Cream els objectes, un per 'mediaRecorder' i l'altre per 'mediaplayer'.
        mediaRecorder = new MediaRecorder();
        mediaPlayer = new MediaPlayer();

        // Obtenim la ruta corresponent a l'àudio.
        fitxer = getExternalFilesDir(Environment.DIRECTORY_MUSIC).getAbsolutePath() + "/audio.3gp";
    }

    // Cream un mètode per comprovar si l'usuari ha concedit el permís necessari i actuar.
    // Si no feim aquest mètode (al menys en el meu cas) al executar l'aplicació ens daràn bastants problemes
    // per aquest tema de permisos, en el meu cas quan pitjava qualque butó l'aplicació es tancava constantment.
    // També hauriem d'afegir un parell de coses més per gestionar tot això però començem desde el principi.
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // Cridem al mètode de la superclasse.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Comprovem si la sol·licitud de permís és per gravar àudio.
        if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            // Assignem "true" a permissionToRecordAccepted si s'ha concedit el permís.
            permissionToRecordAccepted = grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED;
        }

        // Si no s'ha concedit el permís:
        if (!permissionToRecordAccepted) {
            // Mostrem un missatge d'error a l'usuari.
            Toast.makeText(this, "Permiso para grabar no concedido", Toast.LENGTH_SHORT).show();
            // Tanquem l'activitat perquè no pot continuar sense permís.
            finish();
        }
    }

    // Cream un mètode per gestionar l'acció de gravar.
    public void gravar(View view) {
        // Comprovem si s'ha concedit el permís per gravar àudio.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            // Mostrem un missatge d'error si no s'ha concedit el permís i surtim des mètode.
            Toast.makeText(this, "Permís de gravació no concedit", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            // Configurem la font d'àudio del MediaRecorder per emprar el micròfon.
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            // Definim el format de sortida del fitxer de gravació.
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            // Definim el tipus de codificador d'àudio per a la gravació.
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            // Establim el fitxer on es guardarà la gravació.
            mediaRecorder.setOutputFile(fitxer);
            // Preparem el MediaRecorder per començar a gravar.
            mediaRecorder.prepare();
            // Començem a gravar àudio.
            mediaRecorder.start();
        } catch (IOException e) {
            // Mostra un missatge d'error si no s'ha pogut iniciar la gravació.
            e.printStackTrace();
        }
    }

    // Cream un mètode per gestionar l'acció d'aturar la gravació.
    public void aturarGravacio(View view) {
        // Comprovem si el MediaRecorder no és nul (si s'estava gravant àudio).
        if (mediaRecorder != null) {
            // Aturem la gravació d'àudio.
            mediaRecorder.stop();
            // Alliberem els recursos associats al MediaRecorder.
            mediaRecorder.release();
            // Posem el MediaRecorder a null per indicar que ja no està actiu.
            mediaRecorder = null;
        }
    }

    // Cream un mètode per escoltar l'àudio que hem gravat.
    public void reproduir(View view) {
        try {
            // Reiniciem el MediaPlayer per assegurar que estigui en un estat net abans de reproduir.
            mediaPlayer.reset();
            // Establim el fitxer d'àudio com a font per a la reproducció.
            mediaPlayer.setDataSource(fitxer);
            // Preparem el MediaPlayer per començar a reproduir el fitxer.
            mediaPlayer.prepare();
            // Iniciem la reproducció d'àudio.
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}