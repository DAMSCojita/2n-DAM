package com.stefancojita.asteroides;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class AsteroidsView extends View implements SensorEventListener {
    // //// THREAD I TEMPS //////
    // Thread encarregat de processar el joc
    private GameThread thread = new GameThread();
    // Cada quan volem processar canvis (ms)
    private static int ANIM_INTERVAL = 50;
    // Quan es va realitzar el darrer procés
    private long prevUpdate = 0;

    // //// ASTEROIDS //////
    private List<AsteroidsGraphic> asteroids;
    private int numAsteroids = 5;
    private int numFragments = 3; // Fragments en que es divideix

    /////// SPACESHIP //////
    private AsteroidsGraphic ship;
    private int angleShip;
    private float accelShip;
    private static final double SHIP_MAX_SPEED = 50;
    private static final int STEPSIZE_ROT_SHIP = 5;
    private static final float STEPSIZE_ACCEL_SHIP = 0.5f;
    Drawable drawableMissile;

    ////// MISIL //////
    private List<AsteroidsGraphic> missiles = new ArrayList<AsteroidsGraphic>();
    private static int MISSILE_SPEED = 12;
    private List<Double> missileLifetimes = new ArrayList<Double>();
    private boolean fire = false;

    float mX;
    float mY;

    /////// SENSORS //////
    SensorManager mSensorManager;
    Sensor accelerometerSensor;

    private SharedPreferences pref; // Declaram es SharedPreferences per poder aaccedir a elles.

    /////// SOROLL //////
    SoundPool soundPool;

    int idFire, idExplosion;

    private Drawable drawableAsteroid[]= new Drawable[3]; // Reemplaçem el antic drawableAsteroid per un nou array.

    public AsteroidsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Definim variables al constructor.
        Drawable drawableShip;
        pref = PreferenceManager.getDefaultSharedPreferences(getContext()); // Molt important definir el pref en el constructor.
        soundPool = new SoundPool( 10, AudioManager.STREAM_MUSIC , 0);
        idFire = soundPool.load(context, R.raw.dispar, 0);
        idExplosion = soundPool.load(context, R.raw.explosio, 0);
        numFragments = Integer.parseInt(pref.getString("fragments", "3")); // Definim el num de fragments per poder dividr el asteroide, accedim a ell amb la variable pref.
        // Gestió de gràfics a Prefèrencies.
        if (pref.getString("grafics", "1").equals("0")) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            Path pathAsteroid = new Path();
            pathAsteroid.moveTo((float) 0.3, (float) 0.0);
            pathAsteroid.lineTo((float) 0.6, (float) 0.0);
            pathAsteroid.lineTo((float) 0.6, (float) 0.3);
            pathAsteroid.lineTo((float) 0.8, (float) 0.2);
            pathAsteroid.lineTo((float) 1.0, (float) 0.4);
            pathAsteroid.lineTo((float) 0.8, (float) 0.6);
            pathAsteroid.lineTo((float) 0.9, (float) 0.9);
            pathAsteroid.lineTo((float) 0.8, (float) 1.0);
            pathAsteroid.lineTo((float) 0.4, (float) 1.0);
            pathAsteroid.lineTo((float) 0.0, (float) 0.6);
            pathAsteroid.lineTo((float) 0.0, (float) 0.2);
            pathAsteroid.lineTo((float) 0.3, (float) 0.0);
            // Cas que volguem treballar amb gràfics vectorials després de canviar el drawableAsteroid.
            // Al ser un array ara recorrem per a cada posició.
            for (int i=0; i<3; i++) {
                ShapeDrawable dAsteroid = new ShapeDrawable(new PathShape(pathAsteroid, 1, 1));
                dAsteroid.getPaint().setColor(Color.WHITE);
                dAsteroid.getPaint().setStyle(Paint.Style.STROKE);
                dAsteroid.setIntrinsicWidth(50 - i * 14);
                dAsteroid.setIntrinsicHeight(50 - i * 14);
                drawableAsteroid[i] = dAsteroid;
            }
            setBackgroundColor(Color.BLACK);
            Path pathNau = new Path();
            ShapeDrawable dNau = new ShapeDrawable(new PathShape(pathNau, 1, 1));
            pathNau.moveTo((float) 0.0, (float) 1.0);
            pathNau.lineTo((float) 1.0, (float) 0.5);
            pathNau.lineTo((float) 0.0, (float) 0.0);
            pathNau.lineTo((float) 0.0, (float) 1.0);
            dNau.getPaint().setColor(Color.WHITE);
            dNau.getPaint().setStyle(Paint.Style.STROKE);
            dNau.setIntrinsicWidth(50);
            dNau.setIntrinsicHeight(50);
            drawableShip = dNau;
            ShapeDrawable dMissile = new ShapeDrawable(new RectShape());
            dMissile.getPaint().setColor(Color.WHITE);
            dMissile.getPaint().setStyle(Paint.Style.STROKE);
            dMissile.setIntrinsicWidth(15);
            dMissile.setIntrinsicHeight(3);
            drawableMissile = dMissile;
        } else {
            // Com hem canviat el drawableAsteroid i l'hem fet un array inicialitzam cada posició per defecte.
            drawableAsteroid[0] = context.getResources().getDrawable(R.drawable.asteroide1);
            drawableAsteroid[1] = context.getResources().getDrawable(R.drawable.asteroide2);
            drawableAsteroid[2] = context.getResources().getDrawable(R.drawable.asteroide3);
            // Inicialitzem la nau i el missil.
            drawableShip = context.getResources().getDrawable(R.drawable.nave);
            drawableMissile = context.getResources().getDrawable(R.drawable.misil1); // Aquí declaram es DrawableMissile
        }
        asteroids = new ArrayList<AsteroidsGraphic>();
        for (int i = 0; i < numAsteroids; i++) {
            AsteroidsGraphic asteroid = new AsteroidsGraphic(this, drawableAsteroid[0]);
            asteroid.setIncY(Math.random() * 4 - 2);
            asteroid.setIncX(Math.random() * 4 - 2);
            asteroid.setRotAngle((int) (Math.random() * 360));
            asteroid.setRotSpeed((int) (Math.random() * 8 - 4));
            asteroids.add(asteroid);
        }
        ship = new AsteroidsGraphic(this, drawableShip);
        // Estructura de control 'if'.
        // Verifiquem les preferències per als sensors.
        // Comprovem si l'usuari ha seleccionat utilitzar sensors (valor "2").
        if (pref.getString("sensors", "1").equals("2")) {
            // Si els sensors estan habilitats, s'activen.
            activateSensors();
        } else {
            // Si no, es desactiven per defecte.
            deactivateSensors();
        }
    }

    protected void activateSensors() {
        if (pref.getString("sensors", "1").equals("2")) { // Comprovem preferències.
            if (mSensorManager == null) {
                mSensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);
            }
            // Comprovem el sensor d'acceleròmetre.
            if (accelerometerSensor == null) {
                List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
                if (!sensorList.isEmpty()) {
                    accelerometerSensor = sensorList.get(0); // Seleccionem el primer sensor disponible.
                }
            }
            // Registrem el listener per al sensor d'acceleròmetre.
            if (accelerometerSensor != null) {
                mSensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_GAME);
            }
        }
    }

    protected void deactivateSensors() {
        if (mSensorManager != null) {
            // Cancel·lem el registre del listener per evitar ús de recursos
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    protected void onSizeChanged(int width, int height, int prevWidth, int prevHeight) {
        super.onSizeChanged(width, height, prevWidth, prevHeight);
        // Un cop coneixem el nostre ample i alt.
        ship.setCenX(width / 2);
        ship.setCenY(height / 2);
        for (AsteroidsGraphic asteroid: asteroids) {
            do {
                asteroid.setCenX((int) (Math.random() * width));
                asteroid.setCenY((int) (Math.random() * height));
            } while (asteroid.distance(ship) < (width+height)/5);
        }
        prevUpdate = System.currentTimeMillis();
        thread.start();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ship.drawGraphic(canvas);

        // Dibuixam asteroides fent un bucle i recorrent el seu array.
        for (AsteroidsGraphic asteroid : asteroids) {
            asteroid.drawGraphic(canvas);
        }

        // Dibuixam missils fent un bucle i recorrent el seu array.
        for (AsteroidsGraphic missile : missiles) {
            missile.drawGraphic(canvas);
        }
    }

    protected synchronized void updateView() {
        long now = System.currentTimeMillis();
        if (prevUpdate + ANIM_INTERVAL > now) {
            return;
        }

        double delay = (now - prevUpdate) / ANIM_INTERVAL;
        prevUpdate = now;

        ship.setRotAngle((int) (ship.getRotAngle() + ship.getRotSpeed() * delay));
        double nIncX = ship.getIncX() + accelShip * Math.cos(Math.toRadians(ship.getRotAngle())) * delay;
        double nIncY = ship.getIncY() + accelShip * Math.sin(Math.toRadians(ship.getRotAngle())) * delay;
        if (Math.hypot(nIncX, nIncY) <= SHIP_MAX_SPEED) {
            ship.setIncX(nIncX);
            ship.setIncY(nIncY);
        }
        ship.updatePos(delay);

        for (AsteroidsGraphic asteroid : asteroids) {
            asteroid.updatePos(delay);
        }

        for (int i = 0; i < missiles.size(); i++) {
            AsteroidsGraphic missile = missiles.get(i);
            missile.updatePos(delay);
            missileLifetimes.set(i, missileLifetimes.get(i) - delay);

            // Eliminem el missil si termina la seva vida útil o golpetja a un asteroide.
            if (missileLifetimes.get(i) < 0) {
                missiles.remove(i);
                missileLifetimes.remove(i);
            } else {
                for (int j = 0; j < asteroids.size(); j++) {
                    if (missile.checkCollision(asteroids.get(j))) {
                        destroyAsteroid(j);
                        missiles.remove(i);
                        missileLifetimes.remove(i);
                        break;
                    }
                }
            }
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        boolean processed = true;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                accelShip = +STEPSIZE_ACCEL_SHIP;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                ship.setRotSpeed(-STEPSIZE_ROT_SHIP);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                ship.setRotSpeed(STEPSIZE_ROT_SHIP);
                break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                fireMissile();
                break;
            default:
                // Si estem aquí, no hi ha pulsació que ens interessi
                processed = false;
                break;
        }
        return processed;
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        // Processam la pulsació
        boolean processada = true;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                accelShip = 0;
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                ship.setRotSpeed(0);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                ship.setRotSpeed(0);
                break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
                fireMissile();
                break;
            default:
                // Si estem aquí, no hi ha pulsació que ens interessi
                processada = false;
                break;
        }
        return processada;
    }

    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                fire = true;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - mX);
                float dy = Math.abs(y - mY);
                if (dy<6 && dx>6){
                    ship.setRotSpeed(Math.round((x - mX) / 2));
                    fire = false;
                } else if (dx<6 && dy>6){
                    accelShip = Math.round((mY - y) / 50);
                    fire = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                ship.setRotSpeed(0);
                if (fire){
                    fireMissile();
                }
                break;
        }
        mX = x; mY = y;
        return true;
    }

    class GameThread extends Thread {
        private boolean paused, running;

        public synchronized void pause() {
            paused = true;
        }

        public synchronized void unpause() {
            paused = false;
            notify();
        }

        public void halt() {
            running = false;
            if (paused) unpause();
        }

        @Override
        public void run() {
            running = true;
            while (running) {
                updateView();
                synchronized (this) {
                    while (paused)
                        try {
                            wait();
                        } catch (Exception e) {
                        }
                }
            }
        }
    }

    private float initValue;
    private boolean initValueValid = false;
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float value = sensorEvent.values[1];
        if (!initValueValid){
            initValue = value;
            initValueValid = true;
        }
        ship.setRotSpeed((int) (value-initValue)/3);
        accelShip = sensorEvent.values[2]/10;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    private void destroyAsteroid(int i) {
        if (asteroids.get(i).getDrawable() != drawableAsteroid[2]){
            int size;
            if (asteroids.get(i).getDrawable() == drawableAsteroid[1]){
                size = 2;
            } else {
                size = 1;
            }
            for(int n = 0; n < numFragments;n++){
                AsteroidsGraphic asteroid = new AsteroidsGraphic(this,drawableAsteroid[size]);
                asteroid.setCenX(asteroids.get(i).getCenX());
                asteroid.setCenY(asteroids.get(i).getCenY());
                asteroid.setIncX(Math.random() * 4 - 2);
                asteroid.setIncY(Math.random() * 4 - 2);
                asteroid.setRotAngle((int)(Math.random() * 360));
                asteroid.setRotSpeed((int)(Math.random() * 8 - 4));
                asteroids.add(asteroid);
            }
        }

        // Eliminem l'asteroide de la llista d'asteroides actius.
        asteroids.remove(i);

        // Reproduim el so d'explosió (quan es destrueix):
        // - idExplosion: identificador del so d'explosió.
        // - Volum esquerre i dret (1,1): reproduir amb el volum màxim.
        // - Prioritat (2): nivell d'importància per al sistema de so.
        // - Loop (0): no repetir el so.
        // - Rate (1): velocitat de reproducció normal.
        soundPool.play(idExplosion, 1, 1, 2, 0, 1);
    }


    private void fireMissile() {
        // So que es reprodueix quan disparem, les explicacions de cada paràmetre ja les tenim a l'anterior mètode.
        soundPool.play(idFire, 1, 1, 1, 0, 1);
        AsteroidsGraphic missils = new AsteroidsGraphic(this, drawableMissile);

        // Configuram missils.
        missils.setCenX(ship.getCenX());
        missils.setCenY(ship.getCenY());
        missils.setRotAngle(ship.getRotAngle());
        missils.setIncX(Math.cos(Math.toRadians(missils.getRotAngle())) * MISSILE_SPEED);
        missils.setIncY(Math.sin(Math.toRadians(missils.getRotAngle())) * MISSILE_SPEED);

        // Afegim missils.
        missiles.add(missils);

        missileLifetimes.add((double) Math.min(this.getWidth() / Math.abs(missils.getIncX()), this.getHeight() / Math.abs(missils.getIncY())) - 2);
    }

    public GameThread getThread() {
        return thread;
    }


}
