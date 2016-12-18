package co.blackground.intrulert;


import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class IntrulertUtils {
    public static final String USER_NAME_KEY = "user_name";
    private static final String ACTIVATED_KEY = "intrulert_activated";
    private static SharedPreferences preferences;

    static void init(Application application) {
        preferences = PreferenceManager.getDefaultSharedPreferences(application);
    }

    public static boolean isActivated() {
        return preferences.getBoolean(ACTIVATED_KEY, true);
    }

    public static void setActivated(boolean state) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(ACTIVATED_KEY, state);
        editor.apply();

        deactivateSystem(state);
    }

    private static void deactivateSystem(boolean state) {
        // deactivate system here
    }

    public static String getUserName() {
        return preferences.getString(USER_NAME_KEY, null);
    }
}
