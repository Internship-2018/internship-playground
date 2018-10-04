package com.example.nciuclea.oopzoomvp.ZooScreen.Animal;

import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.AnimalStateModel;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.AnimalStateModelImpl;
import com.example.nciuclea.oopzoomvp.ZooScreen.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;

public class ExoticCat extends Animal implements ActionText {

    public ExoticCat() {
        super("Exotic cat",
                R.drawable.cat,
                new ArrayList<AnimalStateModel>() {{
                        add(new AnimalStateModelImpl(
                                "Hunger",
                                State.GREEN,
                                2000
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
                        add(new AnimalStateModelImpl(
                                "Mood",
                                State.YELLOW,
                                10000
                        ));
                    }});
    }

    @Override
    public String getActionText() {
        return "Exotic cat showed interest in you! \n (｡◕‿‿◕｡)";
    }
}
