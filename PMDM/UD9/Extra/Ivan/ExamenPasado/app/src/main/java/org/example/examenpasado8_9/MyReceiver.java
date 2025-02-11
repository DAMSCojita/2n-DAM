package org.example.examenpasado8_9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String intentAction = intent.getAction();
        if(intentAction != null){
            String toastMessage = "Unknown Intent";
            switch (intentAction){
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    toastMessage = "Modo avion encendido";
                    break;
            }
            Toast.makeText(context, toastMessage,Toast.LENGTH_SHORT).show();
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}