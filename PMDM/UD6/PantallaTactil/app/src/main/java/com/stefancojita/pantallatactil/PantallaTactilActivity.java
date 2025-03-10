package com.stefancojita.pantallatactil;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PantallaTactilActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView entrada = (TextView)findViewById(R.id.TextViewEntrada);
        entrada.setOnTouchListener((View.OnTouchListener) this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView sortida = (TextView) findViewById(R.id.TextViewSortida);
        sortida.append(motionEvent.toString()+"\n" );
        String accions[] = { "ACTION_DOWN", "ACTION_UP", "ACTION_MOVE", "ACTION_CANCEL","ACTION_OUTSIDE", "ACTION_POINTER_DOWN", "ACTION_POINTER_UP" };
        int accio = motionEvent.getAction();
        int codiAccio = accio & MotionEvent.ACTION_MASK;
        int iPunter = (accio & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        sortida.append(accions[iPunter]);
        for (int i = 0; i < motionEvent.getPointerCount(); i++) {
            sortida.append(" punter:" + motionEvent.getPointerId(i) + " x:" + motionEvent.getX(i) + " y:" + motionEvent.getY(i));
        }
        sortida.append("\n");
        return true;
    }
}