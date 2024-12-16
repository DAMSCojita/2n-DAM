package com.stefancojita.videoview;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView =(VideoView)findViewById(R.id.video_view); // Definim es Video View aquí.
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video; // Definim una variable amb es path aquí (i es video).
        Uri videoUri = Uri.parse(videoPath);
        mVideoView.setVideoURI(videoUri);
        // Controlem la reproducció del video mitjançant un objecte 'MediaControll'
        mVideoView.setMediaController(new MediaController(this));
        mVideoView.start();
        mVideoView.requestFocus();
    }
}