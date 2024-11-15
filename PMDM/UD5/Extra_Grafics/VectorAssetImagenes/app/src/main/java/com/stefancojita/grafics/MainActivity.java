package com.stefancojita.grafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

        private Drawable laMevaImatge;

        public ExempleView (Context context) {
            super(context);
            laMevaImatge= ContextCompat.getDrawable(MainActivity.this,R.drawable.rebel_love_blade_png_sticker_5693491);
            laMevaImatge.setBounds(30,30,400,400);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            laMevaImatge.draw(canvas);
        }
    }
}