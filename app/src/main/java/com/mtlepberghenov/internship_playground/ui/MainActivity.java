package com.mtlepberghenov.internship_playground.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mtlepberghenov.internship_playground.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startWelcomeFragment();


    }

    private void startWelcomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, new WelcomeFragment())
                .addToBackStack(null)
                .commit();
    }
}
