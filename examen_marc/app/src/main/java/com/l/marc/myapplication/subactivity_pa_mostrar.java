package com.l.marc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class subactivity_pa_mostrar extends AppCompatActivity {

    Button enviar;
    Button no;
    EditText nom;
    EditText assumpte;
    EditText mensatge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subpa_mostrar);

        enviar=(Button)findViewById(R.id.enviar);
        no=(Button)findViewById(R.id.no);
        nom=(EditText)findViewById(R.id.tv_destinatari);
        assumpte=(EditText)findViewById(R.id.tv_assumpte);
        mensatge=(EditText)findViewById(R.id.tv_missatge);
    }


    public void enviar() {
        Intent prin=new Intent(this, MainActivity.class);
        startActivity(prin);
    }


    public void no() {
        Intent prin=new Intent(this, MainActivity.class);
        nom.setText("");
        assumpte.setText("");
        mensatge.setText("");
        startActivity(prin);
    }
    }

