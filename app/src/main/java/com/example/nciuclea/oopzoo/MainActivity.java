package com.example.nciuclea.oopzoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.tiger_container) != null) {
            AnimalFragment tigerAnimalFragment = new AnimalFragment();
            tigerAnimalFragment.setAnimal(new Tiger(5, 4, 6));
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.tiger_container, tigerAnimalFragment)
                    .commit();
        }
        if(findViewById(R.id.owl_container) != null) {
            AnimalFragment owlAnimalFragment = new AnimalFragment();
            owlAnimalFragment.setAnimal(new Owl(10, 10));
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.owl_container, owlAnimalFragment)
                    .commit();
        }
    }
}
