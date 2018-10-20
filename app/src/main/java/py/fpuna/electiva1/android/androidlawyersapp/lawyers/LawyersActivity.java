package py.fpuna.electiva1.android.androidlawyersapp.lawyers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import py.fpuna.electiva1.android.androidlawyersapp.R;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;


public class LawyersActivity extends AppCompatActivity {

    public static final String EXTRA_LAWYER_ID = "extra_lawyer_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_lawyers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LawyersFragment fragment = (LawyersFragment)
                getSupportFragmentManager().findFragmentById(R.id.lawyers_container);

        if (fragment == null) {
            fragment = LawyersFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lawyers_container, fragment)
                    .commit();
        }
    }
}
