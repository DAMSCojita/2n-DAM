package com.stefancojita.gravadora;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class GravadoraActivity extends AppCompatActivity {

    // Declaració de variables.
    private static final String LOG_TAG = "Gravadora";
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;
    private static String fitxer = Environment.getExternalStorageDirectory().getAbsolutePath()+"/audio.3gp";

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gravar(View view) throws IOException { // Al mètode afegim la gestió de la excepció que ens demanen al preparar la gravació.
        // Cream un objecte MediaRecorder.
        mediaRecorder = new MediaRecorder();

        // Establim el fitxer declarat a l’inici com a fitxer de sortida.
        mediaRecorder.setOutputFile(fitxer);

        // Establim el micròfon com a font d'entrada d'àudio.
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

        // Estableix el format de sortida com a THREE_GPP.
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

        // Estableix el codificador com a AMR_NB.
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        // Preparem i iniciem la gravació.
        mediaRecorder.prepare();
        mediaRecorder.start();
    }

    public void aturarGravacio(View view) {
        // Aturem la gravació i alliberem els recursos.
        mediaRecorder.stop();
        mediaRecorder.release();
    }

    public void reproduir(View view) throws IOException { // Al mètode afegim la gestió de la excepció que ens demanen al establir la font.
        // Cream un objecte MediaPlayer.
        mediaPlayer = new MediaPlayer();

        // Establim la font com el fitxer.
        mediaPlayer.setDataSource(fitxer);
    }
}