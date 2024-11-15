package com.stefancojita.grafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ExempleView(this));
    }

    public class ExempleView extends View {

        public ExempleView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // Dibuixar aquí
            Paint pinzell = new Paint();
            pinzell.setStrokeWidth(14);
            pinzell.setStyle(Paint.Style.STROKE);
            pinzell.setColor(Color.BLUE);
            canvas.drawCircle(280, 550, 100, pinzell);
            pinzell.setColor(Color.BLACK);
            canvas.drawCircle(490, 550, 100, pinzell);
            pinzell.setColor(Color.RED);
            canvas.drawCircle(700, 550, 100, pinzell);
            pinzell.setColor(Color.YELLOW);
            canvas.drawCircle(380, 650, 100, pinzell);
            pinzell.setColor(Color.GREEN);
            canvas.drawCircle(590, 650, 100, pinzell);
        }
    }
}