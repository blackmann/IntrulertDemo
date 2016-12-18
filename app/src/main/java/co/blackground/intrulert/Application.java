package co.blackground.intrulert;


public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IntrulertUtils.init(this);
    }
}
