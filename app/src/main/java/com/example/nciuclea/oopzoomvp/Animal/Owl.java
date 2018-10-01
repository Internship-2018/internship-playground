package com.example.nciuclea.oopzoomvp.Animal;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateModelImpl;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenterImpl;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;

public class Owl extends Animal {
    public Owl() {
        super("Owl", R.drawable.owl, new ArrayList<AnimalStatePresenterImpl>() {{
            add(new AnimalStatePresenterImpl(new AnimalStateModelImpl(
                    "Hunger",
                    State.RED,
                    4000
            )));
            add(new AnimalStatePresenterImpl(new AnimalStateModelImpl(
                    "Cleanliness",
                    State.YELLOW,
                    10000
            )));
        }});
    }
}
