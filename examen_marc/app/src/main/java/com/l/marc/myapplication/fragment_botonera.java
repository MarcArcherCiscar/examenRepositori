package com.l.marc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_botonera.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_botonera#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_botonera extends Fragment implements View.OnClickListener {

    //Declarem les variables

 Button enviar;
 Button preferencies;

 EditText mensatje;
 EditText destinatari;
 EditText assumpte;

    private tornar_coses mListener; //Objecte que permetra la comunicacio en el activity

    public fragment_botonera() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static fragment_botonera newInstance(String param1, String param2) {
        fragment_botonera fragment = new fragment_botonera();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Unflem el layout
         View v= inflater.inflate(R.layout.fragment_fragment_botonera, container, false);

        // Assignem els objectes a elements de l'XML
        enviar=(Button)v.findViewById(R.id.btn_enviar);
        preferencies=(Button)v.findViewById(R.id.btn_configuracio);
        mensatje=(EditText)v.findViewById(R.id.tv_missatge);
        destinatari = v.findViewById(R.id.tv_destinatari);
        assumpte = v.findViewById(R.id.tv_assumpte);

        //Als dos botons els afegim un listener per a escoltar els event de click
        enviar.setOnClickListener(this);
        preferencies.setOnClickListener(this);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //comprovem si tenim l'activity que conté este fragment
        if (context instanceof tornar_coses) {
            mListener = (tornar_coses) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " implementa el fragment");
        }
    }

    @Override
    public void onDetach() {
        //Asignem null a l'objecte que ens permetrà la comunicació amb l'activity
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
//comprobem el id dels botons i depen del que siga faran
        if(v.getId()==R.id.btn_enviar){
            Intent ini=new Intent(getContext(),subactivity_pa_mostrar.class);
            if (mensatje!=null && destinatari!=null && assumpte!=null){
                mListener.tornar_coses(3,mensatje.getText().toString(), destinatari.getText().toString(), assumpte.getText().toString());
                startActivity(ini);
            }


        }
        if(v.getId()==R.id.btn_configuracio){

            Intent ini=new Intent(getContext(),preferencies.class);
            startActivity(ini);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface tornar_coses {
        // TODO: Update argument type and name
// Mètode per a tornar el destinatari, missatge y assumpte a lactivity
        void tornar_coses(int i, String destinatari, String missatge, String assumpte);
    }


}
