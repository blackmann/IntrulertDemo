package co.blackground.intrulert.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import co.blackground.intrulert.R;

import static co.blackground.intrulert.IntrulertUtils.USER_NAME_KEY;

public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
    SharedPreferences preferences;

    EditTextPreference namePref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        namePref = (EditTextPreference) findPreference(USER_NAME_KEY);
        String name = preferences.getString(USER_NAME_KEY, null);
        setUpNamePref(name);
        namePref.setOnPreferenceChangeListener(this);
    }

    private void setUpNamePref(String name) {
        if (name != null && !name.isEmpty()) {
            namePref.setSummary(name);
        } else {
            namePref.setSummary(R.string.name_description);
        }
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        switch (preference.getKey()) {
            case USER_NAME_KEY:
                setUpNamePref((String) o);
        }
        return true;
    }
}
