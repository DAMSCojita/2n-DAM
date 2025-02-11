package org.example.examenpasado8_9;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServeiMusica extends Service {

    MediaPlayer reproductor;

    @Override
    public void onCreate() {
        Toast.makeText(this,"Servicio de musica creado",Toast.LENGTH_SHORT).show();
        reproductor = MediaPlayer.create(this, R.raw.audio);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Servicio Arrancado",Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Servicio Apagado",Toast.LENGTH_SHORT).show();
        reproductor.stop();
    }

    //Este tiene que esar si o si
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
