package org.example.examenud8iud92024;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback { // Implementem la interfície OnMapReadyCallback.

    // Declaració de variables.
    private GoogleMap mapa;
    private static final String CHANNEL_ID = "ubicacion_playas";
    Intent notificationIntent;
    private NotificationManager mNotifyManager;
    static final int NOTIFICATION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Afegim un mapFragment al layout.
        // Obtenim el SupportMapFragment i notifiquem quan el mapa estigui llest.
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapa);mapFragment.getMapAsync(this);

        createNotificationChannel(); // Truquem al métode per crear el canal de notificacions.
    }

    // Mètode que s'executa quan el mapa està llest.
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap; // Guardem el mapa en la variable global.
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true); // Habilitem controls de zoom.
    }

    // Mètode que s'executa quan es crea el menú.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Mètode que s'executa quan es selecciona un element del menú.
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // Obtenim l'identificador de l'element seleccionat.
        // En funció de l'element seleccionat, movem la càmera a una platja i mostrem una notificació.
        if (id == R.id.platja_son_bou) {
            notificationIntent = new Intent(this, SonBou.class);
            // Movem la càmera a Son Bou.
            moveCameraAnimate(new LatLng(39.90169411336773, 4.07165550351048), "Has arribat a Son Bou", notificationIntent);
            return true;
        }
        if (id == R.id.platja_punta_prima) {
            notificationIntent = new Intent(this, PuntaPrima.class);
            // Movem la càmera a Punta Prima.
            moveCameraAnimate(new LatLng(39.81379580127018, 4.280280354483435), "Has arribat a Punta Prima", notificationIntent);
            return true;
        }
        return super.onOptionsItemSelected(item); // Si no és cap dels anteriors, cridem al mètode de la superclasse.
    }

    // Cream un métode per moure la càmera a una ubicació i mostrar una notificació.
    private void moveCameraAnimate(LatLng location, String message, Intent intent) {
        // Si el mapa no és null
        // , movem la càmera a la ubicació i afegim un marcador.
        if (mapa != null) {
            // Movem la càmera a la ubicació i afegim un marcador.
            mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15), 2000, null);
            mapa.addMarker(new MarkerOptions().position(location).title(message));
            sendNotification(message, intent); // Mostrem una notificació.
        }
    }

    private void createNotificationChannel() {
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Cream un notification channel.
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Notificació", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder(String message, Intent intent) {
        // Cream un PendingIntent per obrir l'activitat quan es faci clic a la notificació.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_IMMUTABLE);
        // Construim una notificació.
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Examen UD8 i UD9")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return notifyBuilder;
    }

    public void sendNotification(String message, Intent intent) {
        // Obtenim el NotificationCompat.Builder cridant al mètode getNotificationBuilder.
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder(message, intent);
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

}