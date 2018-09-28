package com.example.nciuclea.oopzoomvp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nciuclea.oopzoomvp.WelcomeScreen.WelcomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startFragment(R.id.fragment_container, new WelcomeFragment());
    }

    public void startFragment(int containerId, Fragment fragment) {
        if (findViewById(containerId) != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(containerId, fragment)
                    .commit();
        }
    }
}
