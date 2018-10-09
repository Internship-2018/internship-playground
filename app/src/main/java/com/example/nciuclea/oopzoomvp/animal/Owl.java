package com.example.nciuclea.oopzoomvp.animal;

import com.example.nciuclea.oopzoomvp.animal.state.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.animal.state.AnimalStateModelImpl;
import com.example.nciuclea.oopzoomvp.animal.state.State;
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
