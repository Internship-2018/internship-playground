package com.example.nciuclea.oopzoomvp.Animal;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateModelImpl;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;

public class Tiger extends Animal implements ActionText {
    public Tiger() {
        super("Tiger",
                R.drawable.tiger,
                new ArrayList<AnimalStateModel>() {{
            add(new AnimalStateModelImpl(
                    "Hunger",
                    State.GREEN,
                    5000
            ));
            add(new AnimalStateModelImpl(
                    "Cleanliness",
                    State.GREEN,
                    10000
            ));
            add(new AnimalStateModelImpl(
                    "Cage",
                    State.GREEN,
                    5000
            ));
        }});
    }

    public Tiger(String name) {
        this();
        this.name = name;
    }

    @Override
    public String getActionText() {
        return "Tiger roared at you! ⚆ _ ⚆";
    }
}
