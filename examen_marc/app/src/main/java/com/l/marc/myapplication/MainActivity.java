package com.l.marc.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements fragment_botonera.tornar_coses, fragment_email.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

            SharedPreferences lesMeuesPref;
            Button btn_preferencies = null;
            //Podem llegir l'arxiu de preferencies de les dues maneres

            //Utilitzant el PreferentManager
            //lesMeuesPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

            //Indicant el nom de l'arxiu a llegir
            lesMeuesPref = getSharedPreferences("com.pmd.mmarc.preferncies_preferences", Context.MODE_PRIVATE);

            String color= lesMeuesPref.getString("color_de_fons","cap");
            boolean aplicar_color = lesMeuesPref.getBoolean("aplicar_background",false);

            if(aplicar_color) {
                switch (color) {
                    case "Blanc":
                        btn_preferencies.setBackgroundColor(Color.WHITE);
                        break;
                    case "Roig":
                        btn_preferencies.setBackgroundColor(Color.RED);
                        break;
                    case "Verd":
                        btn_preferencies.setBackgroundColor(Color.GREEN);
                        break;
                    case "Blau":
                        btn_preferencies.setBackgroundColor(Color.BLUE);
                        break;

                }
            }
        }

    @Override
    public void tornar_coses(int i, String destinatari, String missatge, String assumpte) {


    }
}

