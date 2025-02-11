package org.example.notificacionconbroadcastreceiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables.
    private static final String CHANNEL_ID = "canal_notificacion";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    ReceptorBateria rb = new ReceptorBateria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        createNotificationChannel(); // Creamos el canal de notificación.

        // Iniciamos la notificación.
        Button buttonIniciarNotificacion = findViewById(R.id.btnIniciarNotificacion);
        buttonIniciarNotificacion.setOnClickListener(v -> sendNotification());

        // Registramos el receptor de batería.
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED); // Filtramos cuando se cargue el cargador.
        filter.addAction(Intent.ACTION_BATTERY_LOW); // Filtramos cuando la batería es baja.
        registerReceiver(rb, filter);
    }

    private void createNotificationChannel() {
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Creamos un NotificationChannel para las notificaciones de música.
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Notificación", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(){
        // Construimos la notificación.
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("¡PONTE RECTO!")
                .setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true);
        return notifyBuilder;
    }

    public void sendNotification() {
        // Obtenemos el NotificationCompat.Builder i enviamos la notificación.
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }
}