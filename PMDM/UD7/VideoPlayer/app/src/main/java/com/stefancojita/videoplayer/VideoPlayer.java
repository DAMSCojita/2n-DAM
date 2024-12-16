package com.stefancojita.videoplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoPlayer extends AppCompatActivity implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, SurfaceHolder.Callback {

    // Declaració de variables.
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private EditText editText;
    private ImageButton bPlay, bPause, bStop, bLog;
    private TextView logTextView;
    private boolean pause;
    private String path;
    private int savePos = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        editText = (EditText) findViewById(R.id.path);
        editText.setText("https://download.samplelib.com/mp4/sample-5s.mp4");
        logTextView = (TextView) findViewById(R.id.Log);
        bPlay = (ImageButton) findViewById(R.id.play);
        bPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    if (pause) {
                        mediaPlayer.start();
                    } else {
                        playVideo();
                    }
                }
            }
        });
        bPause = (ImageButton) findViewById(R.id.pause);
        bPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    pause = true;
                    mediaPlayer.pause();
                }
            }
        });
        bStop = (ImageButton) findViewById(R.id.stop);
        bStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    pause = false;
                    mediaPlayer.stop();
                }
            }
        });
        bLog = (ImageButton) findViewById(R.id.logButton);
        bLog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (logTextView.getVisibility() == TextView.VISIBLE) {
                    logTextView.setVisibility(TextView.INVISIBLE);
                } else {
                    logTextView.setVisibility(TextView.VISIBLE);
                }
            }
        });
        log("");
    }


    // Mètode per carregar es video.
    private void playVideo() {
        try {
            pause = false; // Restableix l'estat de pausa a fals.
            path = editText.getText().toString(); // Obté la ruta del vídeo de l'EditText.
            mediaPlayer = new MediaPlayer(); // Crea una nova instància de MediaPlayer.
            mediaPlayer.setDataSource(path);
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.prepare();
            // mediaPlayer.prepareAsync(); // Per streaming: prepara de manera asíncrona.
            mediaPlayer.setOnBufferingUpdateListener(this); // Configura un listener per a l'actualització del buffer.
            mediaPlayer.setOnCompletionListener(this); // Listener per gestionar quan la reproducció acaba.
            mediaPlayer.setOnPreparedListener(this); // Listener per iniciar la reproducció quan estigui preparat.
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); // Configura el tipus d'àudio.
            mediaPlayer.seekTo(savePos); // Reprodueix des d'una posició específica si està guardada.
        } catch (Exception e) {
            log("ERROR: " + e.getMessage()); // Registra qualsevol error que es produeixi.
        }
    }

    // Mètode per preparar les dades bàsiques del MediaPlayer
    public void onPrepared(MediaPlayer mediaplayer) {
        log("onPrepared called");
        int mVideoWidth = mediaPlayer.getVideoWidth(); // Obtenim l'amplada del vídeo.
        int mVideoHeight = mediaPlayer.getVideoHeight(); // Obtenim l'alçada del vídeo.

        // Comprovem si les dimensions del vídeo són vàlides.
        if (mVideoWidth != 0 && mVideoHeight != 0) {
            surfaceHolder.setFixedSize(mVideoWidth, mVideoHeight); // Ajustem la superfície al vídeo.
            mediaPlayer.start();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder) {
        log("surfaceCreated called");
        playVideo();
    }
    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k) {
        log("surfaceChanged called");
    }
    public void surfaceDestroyed(SurfaceHolder surfaceholder) {
        log("surfaceDestroyed called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null & !pause) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mediaPlayer != null & !pause) {
            mediaPlayer.start();
        }
    }

    // Mètode per guardar l'estat de la posició del vídeo.
    @Override
    protected void onSaveInstanceState(Bundle guardarEstado) {
        super.onSaveInstanceState(guardarEstado);
        // Guardem l'estat actual del MediaPlayer
        if (mediaPlayer != null) {
            int pos = mediaPlayer.getCurrentPosition(); // Obtenim la posició actual de reproducció
            guardarEstado.putString("ruta", path); // Guardem la ruta del vídeo
            guardarEstado.putInt("posicion", pos);
        }
    }

    // Mètode per recuperar l'estat.
    @Override
    protected void onRestoreInstanceState(Bundle recEstado) {
        super.onRestoreInstanceState(recEstado);
        // Restaurem l'estat anterior del MediaPlayer
        if (recEstado != null) {
            path = recEstado.getString("ruta"); // Recuperem la ruta del vídeo
            savePos = recEstado.getInt("posicion");
        }
    }

    @Override
    public void onBufferingUpdate(MediaPlayer arg0, int percent) {
        log("onBufferingUpdate percent:" + percent);
    }

    @Override
    public void onCompletion(MediaPlayer arg0) {
        log("onCompletion called");
    }

    private void log(String s) {
        logTextView.append(s + "\n");
    }

}