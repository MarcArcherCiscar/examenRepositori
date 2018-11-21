package com.l.marc.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

public abstract class ActivityPreferencies extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    SharedPreferences pref;//definim la variable

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // llegim les preferencies i actualitzem el  valor del summaries
        actualitzaSummaries();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        //Si es igual a aplicar background se cambiara de color
        if (key.equals("aplicar_background")) {
            Preference pref = findPreference(key);
            boolean aplicar = sharedPreferences.getBoolean(key, false);
            pref.setSummary(aplicar ? getString(R.string.etiqueta_si) : getString(R.string.etiqueta_no));
        }
    }

    public void actualitzaSummaries() {
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Preference pref;
        pref = findPreference("aplicar_background");
       // boolean aplicar = pref.getBoolean("aplicar_background", false);
        //pref.setSummary(aplicar ? getString(R.string.etiqueta_si) : getString(R.string.etiqueta_no));

    }
}
