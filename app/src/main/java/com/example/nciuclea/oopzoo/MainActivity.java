package com.example.nciuclea.oopzoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.tiger_container) != null) {
            TigerFragment firstTigerFragment = new TigerFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.tiger_container, firstTigerFragment)
                    .commit();
        }
    }
}
