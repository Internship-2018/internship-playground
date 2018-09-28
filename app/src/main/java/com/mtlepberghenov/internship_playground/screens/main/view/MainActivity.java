package com.mtlepberghenov.internship_playground.screens.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mtlepberghenov.internship_playground.R;
import com.mtlepberghenov.internship_playground.screens.welcome.WelcomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
