package com.stefancojita.repasoexamenud4iud5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GraficosActivity extends AppCompatActivity {

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
            Path cami = new Path();
            cami.addCircle(150, 150, 100, Path.Direction.CCW);
            canvas.drawColor(Color.WHITE);
            Paint pinzell = new Paint();
            pinzell.setColor(Color.BLUE);
            pinzell.setStrokeWidth(8);
            pinzell.setStyle(Paint.Style.STROKE);
            canvas.drawPath(cami, pinzell);
            pinzell.setStrokeWidth(1);
            pinzell.setStyle(Paint.Style.FILL);
            pinzell.setTextSize(20);
            pinzell.setTypeface(Typeface.SANS_SERIF);
            canvas.drawTextOnPath("Prueba de dibujo", cami, 10, 40, pinzell);
        }
    }
}
