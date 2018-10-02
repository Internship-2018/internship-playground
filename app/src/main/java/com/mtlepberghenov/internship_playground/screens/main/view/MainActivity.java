package com.mtlepberghenov.internship_playground.screens.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.screens.welcome.WelcomeFragment;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        startWelcomeFragment();
    }

    private void startWelcomeFragment() {
        if (findViewById(R.id.main_container) != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, new WelcomeFragment())
                    .commit();
        }
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }
}
