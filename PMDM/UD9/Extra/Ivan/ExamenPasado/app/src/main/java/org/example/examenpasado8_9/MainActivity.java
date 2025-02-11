package org.example.examenpasado8_9;

import static java.security.AccessController.getContext;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.preference.PreferenceManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    //All lo relacionado a googlemaps
    private GoogleMap mapa = null;
    private final LatLng PuntaPrima = new LatLng(39.81501907147153, 4.28130705992184);
    private final LatLng SonBou = new LatLng(39.898659471377975, 4.078061713577195);

    //Notificaciones
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private String nombre_noti = null;
    private static final int NOTIFICATION_ID = 0;
    NotificationCompat.Builder notifyBuilder = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtenim el mapa de forma asíncrona (notificarà quanestigui llest)
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

        //Get preferences
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean musica = pref.getBoolean("musica", true);
        if (musica) {
            Toast.makeText(this,"musica on",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"musica off",Toast.LENGTH_SHORT).show();
        }

        createNotificationChannel();

        //Broadcast Reviever
        MyReceiver hola = new MyReceiver();

        IntentFilter filtro = new IntentFilter();
        filtro.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(hola,filtro);
    }

    //EL mapa
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;

        //La vista por el satelite
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        //Que haga zoom
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(PuntaPrima, 15));

        //Añade marcadores en el mapa
        mapa.addMarker(new MarkerOptions().position(PuntaPrima).title("Punta Prima"));
        mapa.addMarker(new MarkerOptions().position(SonBou).title("Son bou"));

    }

    //Creacion del menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.SonBou) {
            mapa.moveCamera(CameraUpdateFactory.newLatLng(SonBou));
            nombre_noti = "Son bou";
            Toast.makeText(this, "Son bou", Toast.LENGTH_SHORT).show();
            sendNotification(1);
        }
        if (id == R.id.PuntaPrima) {
            mapa.moveCamera(CameraUpdateFactory.newLatLng(PuntaPrima));
            nombre_noti = "Punta prima";
            Toast.makeText(this, "Punta Prima", Toast.LENGTH_SHORT).show();
            sendNotification(2);
        }
        if (id == R.id.Broatcast) {
            //Esto abrira una nueva actividad que hara lo que se suponga que hace el broadcast
            Toast.makeText(this, "Broadcast", Toast.LENGTH_SHORT).show();
            switchBroad(null);

        }
        if (id == R.id.segundoPlano) {
            //Esto lanzara la musica en segundo plano (estaria guay que se lanzara mientras se desliza la app hasta el sitio)
            Toast.makeText(this, "Segundo Plano", Toast.LENGTH_SHORT).show();
            switchMusic(null);

        }
        if (id == R.id.preferencia) {
            startActivity(new Intent(MainActivity.this, PreferencesActivity.class));

            return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

    private void switchMusic(View view) {
        Intent musica = new Intent(this, MusicaActivity.class);
        startActivity(musica);
    }

    private void switchBroad(View view) {
        //Intent broadcast = new Intent(this, BroadCastActivity.class);
        //startActivity(broadcast);
    }

    //Creacion de la notificaciones
    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "movimiento", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Moviendote a: ");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        notifyBuilder = new
                NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle(nombre_noti)
                .setContentText("Moviendote a: " + nombre_noti)
                //petaba porque le faltaba el icono
                .setSmallIcon(R.drawable.info);


        return notifyBuilder;
    }

    public void sendNotification(int id) {

        // Si queremos que haga algo mas la app
        if (id == 1) {
            //Esto lanza la notificacion y al pulsar encima lanzara la actividad
            Intent notificationPlaya = new Intent(this, PlayaActivity.class);
            PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, notificationPlaya, PendingIntent.FLAG_IMMUTABLE);

            //Esto son los ajustes de la notificacion (tiene que ser asi) o mejor dicho lo que hara que se espere
            NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
            notifyBuilder.setContentTitle("Son Bou")
                    .setContentIntent(notificationPendingIntent).
                    setAutoCancel(true);
        } else if (id == 2) {

            Intent notificationPlaya = new Intent(this, PlayaActivity2.class);
            PendingIntent notificationPendingIntent = PendingIntent.getActivity(this, NOTIFICATION_ID, notificationPlaya, PendingIntent.FLAG_IMMUTABLE);

            NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
            notifyBuilder.setContentTitle("Punta Prima")
                    .setContentIntent(notificationPendingIntent).
                    setAutoCancel(true);
        }
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

    // El broadcast (mi no entender)
    public class ResultadoReciever extends BroadcastReceiver {
        public static final String ACTION_RESP = "org.exaple.intentservice.RESPUESTA_OPERACION";


        @Override
        public void onReceive(Context context, Intent intent) {


        }
    }

}
