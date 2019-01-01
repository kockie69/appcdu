package com.example.appcdu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String KEY_HOST_PREF = "host_preference";
    public static final String KEY_PORT_PREF = "port_preference";
    public static final String KEY_CDU_PREF = "cdu_preference";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getFragmentManager().beginTransaction().replace(android.R.id.content,
//                new SettingsFragment()).commit();
        addPreferencesFromResource(R.xml.prefs);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (    key.equals(KEY_HOST_PREF) || key.equals(KEY_PORT_PREF) || key.equals(KEY_CDU_PREF)    ) {
            MainActivity.restartNetThread=true;
         } else MainActivity.reloadPrefs=true;
    }

   // @Override
    //public void onBackPressed() {

     //   System.out.println("Back gedrukt");
        // Otherwise defer to system default behavior.
    //    super.onBackPressed();
    //}
}

