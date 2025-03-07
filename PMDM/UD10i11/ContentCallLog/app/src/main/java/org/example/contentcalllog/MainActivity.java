package org.example.contentcalllog;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] TIPUS_CRIDADA = {"", "entrant", "sortint", "perduda"};
        TextView salida = (TextView) findViewById(R.id.sortida);
        Uri cridades = Uri.parse("content://call_log/calls");
        Cursor c = managedQuery(cridades, null, null, null, null);
        while (c.moveToNext()) {
            salida.append("\n" + DateFormat.format("dd/MM/yy k:mm (",
                    c.getLong(c.getColumnIndex(CallLog.Calls.DATE)))
                    + c.getString(c.getColumnIndex(CallLog.Calls.DURATION)) + ") "
                    + c.getString(c.getColumnIndex(CallLog.Calls.NUMBER)) + ", ");
        }
    }
}