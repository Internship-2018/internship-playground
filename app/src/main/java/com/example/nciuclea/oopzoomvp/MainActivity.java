package com.example.nciuclea.oopzoomvp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nciuclea.oopzoomvp.WelcomeScreen.WelcomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment welcomeFragment = new WelcomeFragment();

        replaceFragment(R.id.fragment_container, welcomeFragment);
    }

    private void replaceFragment(int containerId, Fragment fragment) {
        if(findViewById(containerId) != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(containerId, fragment)
                    .commit();
        }
    }
}
