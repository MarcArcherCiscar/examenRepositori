package com.l.marc.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragment_email.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragment_email#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_email extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

EditText destinatari;  //Declarem les variables
EditText assumpte;
EditText mensatje;

    private OnFragmentInteractionListener mListener;

    public fragment_email() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static fragment_email newInstance(String param1, String param2) {
        fragment_email fragment = new fragment_email();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Unflem el layout del fragment
           View v = inflater.inflate(R.layout.fragment_fragment_email, container, false);

        // Assignem els objectes a elements de l'XML
        destinatari = v.findViewById(R.id.tv_destinatari);
        assumpte = v.findViewById(R.id.tv_assumpte);
        mensatje=v.findViewById(R.id.tv_missatge);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
