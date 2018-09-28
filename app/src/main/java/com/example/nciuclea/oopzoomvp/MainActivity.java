package com.example.nciuclea.oopzoomvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nciuclea.oopzoomvp.WelcomeScreen.WelcomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.welcome_container) != null) {
            WelcomeFragment welcomeFragment = new WelcomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.welcome_container, welcomeFragment)
                    .commit();
        }
    }
}
