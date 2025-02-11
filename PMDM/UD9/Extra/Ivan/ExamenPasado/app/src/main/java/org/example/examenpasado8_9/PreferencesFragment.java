package org.example.examenpasado8_9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class PreferencesFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferencias, rootKey);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean musica = pref.getBoolean("musica", true);


    }
}