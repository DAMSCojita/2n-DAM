package com.stefancojita.fils;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Declaració de variables.
    Button buttonCopia;
    EditText editFitxer;
    TextView textResultat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editFitxer = findViewById(R.id.edtFitxer);
        buttonCopia = findViewById(R.id.btnRealitzarCopia);
        buttonCopia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ferCopia(null);
            }
        });
        textResultat = findViewById(R.id.txtResultat);
    }

    // Mètode per fer la còpia.
    public void ferCopia(View view) {
        String f = String.valueOf(textResultat.getText());
        MyTask task = new MyTask();
        task.execute(f);
    }

    class MyTask extends AsyncTask<String, Integer, Integer> {

        private ProgressDialog progres;

        @Override
        protected void onPreExecute() {
            progres = new ProgressDialog(MainActivity.this);
            progres.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progres.setMessage("REALITZANT CÒPIA DE SEGURETAT");
            progres.setCancelable(true);
            progres.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    MyTask.this.cancel(true);
                }
            });
            progres.setMax(100);
            progres.setProgress(0);
            progres.show();
        }

        @Override
        protected Integer doInBackground(String... f) {
            Random random = new Random(); // Feim un random per generar nombres aleatoris.
            int pes_fitxer = random.nextInt(1191) + 100; // Generam un pes aleatori per el fitxer com a mínim de 100 bytes fins a un máxim de 1191 bytes.

            // Bucle 'for'.
            // Iterará mentre la i sigui menor al tamany del fitxer.
            for (int i = 1; i <= pes_fitxer; i++) {
                // Si l'usuari per qualque motiu cancel·la la còpia sortirà del bucle.
                if (isCancelled()) {
                    break;
                }
                SystemClock.sleep(500); // Posam un temps d'espera de 500 milisegons.
                publishProgress(i * 100 / pes_fitxer); // Es simularà la còpia amb el quadre.
            }

            return pes_fitxer; // Retornam el pes aleatori del fitxer. Que després és mostrará per pantalla.
        }

        @Override
        protected void onProgressUpdate(Integer... perc) {
            progres.setProgress(perc[0]);
        }

        @Override
        protected void onPostExecute(Integer midaBytes) {
            String nomFitxer = String.valueOf(editFitxer.getText()); // Obtenim el text posat per l'usuari convertin-lo en un String i emmagatzemat en una variable.
            // Dissenyam el missatge de sortida (es a dir, el que sortirà una vegada termini la còpia.
            textResultat.append("Còpia de seguretat finalitzada.\n" + "S'ha copiat el fitxer " + nomFitxer + "\n amb un total de " + midaBytes + " bytes.\n");
            progres.dismiss();
        }

        @Override
        protected void onCancelled() {
            textResultat.append("S'ha cancelat la còpia de seguretat.\n");
        }
    }
}