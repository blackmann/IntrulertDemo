package co.blackground.intrulert.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import co.blackground.intrulert.R;
import co.blackground.intrulert.fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        setTitle("");

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, new SettingsFragment())
                .commit();
    }
}
