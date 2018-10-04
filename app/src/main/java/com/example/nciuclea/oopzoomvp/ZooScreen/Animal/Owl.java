package com.example.nciuclea.oopzoomvp.ZooScreen.Animal;

import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.AnimalStateModelImpl;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;

public class Owl extends Animal {
    public Owl() {
        super("Owl",
                R.drawable.owl,
                new ArrayList<AnimalStateModel>() {{
            add(new AnimalStateModelImpl(
                    "Hunger",
                    State.RED,
                    4000
            ));
            add(new AnimalStateModelImpl(
                    "Cleanliness",
                    State.YELLOW,
                    10000
            ));
        }});
    }

    public Owl(String name){
        this();
        this.name = name;
    }
}
