package org.example.notificacionconbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class ReceptorBateria extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction(); // Obtenemos la acción que ha lanzado el BroadcastReceiver.

        // Mostramos un mensaje dependiendo de la acción.
        if (Intent.ACTION_POWER_CONNECTED.equals(action)) {
            Toast.makeText(context, "El móvil está enchufado.", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_BATTERY_LOW.equals(action)) {
            // Obtenemos el nivel de batería.
            int nivel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int escala = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            float batteryPct = nivel / (float) escala * 100; // Calculamos el porcentaje de batería.
            Toast.makeText(context, "Batería baja: " + batteryPct + "%", Toast.LENGTH_SHORT).show();
        }
    }
}
