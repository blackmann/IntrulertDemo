package co.blackground.intrulert.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.blackground.intrulert.IntrulertUtils;
import co.blackground.intrulert.R;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    SharedPreferences preferences;

    @BindView(R.id.settings)
    ImageButton btnSettings;

    @BindView(R.id.statusImage)
    ImageView ivStatus;

    @BindView(R.id.intrulertSwitch)
    Switch swIntrulert;

    @BindView(R.id.statusText)
    TextView tvStatus;

    @BindView(R.id.userName)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        swIntrulert.setOnCheckedChangeListener(this);
        swIntrulert.setChecked(IntrulertUtils.isActivated());
        setUpNameAndId();
    }

    @OnClick({R.id.settings})
    protected void launchSettings() {
        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) activateSystem();
        else {
            deactivateSystem();
        }
    }

    private void setUpNameAndId() {
        tvName.setText(IntrulertUtils.getUserName());
    }

    private void activateSystem() {
        IntrulertUtils.setActivated(true);
        showActivatedStatus();
        ivStatus.setImageDrawable(getResources().getDrawable(R.drawable.intrulert_status_safe));
        ivStatus.setColorFilter(getResources().getColor(R.color.black));
    }

    private void deactivateSystem() {
        IntrulertUtils.setActivated(false);
        showDeactivatedStatus();
        ivStatus.setImageDrawable(getResources().getDrawable(R.drawable.intrulert_status_deactivated));
        ivStatus.setColorFilter(getResources().getColor(R.color.white));
    }

    private void showActivatedStatus() {
        tvStatus.setText(R.string.intrulert_safe);
    }

    private void showDeactivatedStatus() {
        tvStatus.setText(R.string.intrulert_insecure);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpNameAndId();
    }
}
