package com.stefancojita.grafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
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
            Path cami = new Path();
            cami.addCircle(150, 150, 100, Path.Direction.CW); // Aqui en es 'Path.Direction' ho canviem per 'CW'.
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
            canvas.drawTextOnPath("Desenvolupament d'aplicacions per a mòbils amb Android", cami, 10, -20, pinzell);
            // Com a primer paràmetre posam el text que volem.
            // De segon paràmetre posam l'instància des camí.
            // De tercer paràmetre es 'hOffset', que sería bàsicament la posició inicial del text endavant des del Path.
            // De quart paràmetre, 'vOffset', és el mateix que l'anterior però l'ajust vertical.
        }
    }
}