package com.example.yangyang.loginapp;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by yangyang on 14-9-18.
 */
public class SettingsActivity extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
