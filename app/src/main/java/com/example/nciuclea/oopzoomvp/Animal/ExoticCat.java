package com.example.nciuclea.oopzoomvp.Animal;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStateModelImpl;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenter;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.AnimalStatePresenterImpl;
import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

import java.util.ArrayList;

public class ExoticCat extends Animal implements ActionText {

    public ExoticCat() {
        super("Exotic cat",
                R.drawable.cat,
                new ArrayList<AnimalStatePresenter>() {{
                        add(new AnimalStatePresenterImpl(new AnimalStateModelImpl(
                                "Hunger",
                                State.GREEN,
                                2000
                        )));
                        add(new AnimalStatePresenterImpl(new AnimalStateModelImpl(
                                "Cleanliness",
                                State.GREEN,
                                10000
                        )));
                        add(new AnimalStatePresenterImpl(new AnimalStateModelImpl(
                                "Cage",
                                State.GREEN,
                                5000
                        )));
                        add(new AnimalStatePresenterImpl(new AnimalStateModelImpl(
                                "Mood",
                                State.YELLOW,
                                10000
                        )));
                    }});
    }

    @Override
    public String getActionText() {
        return "Exotic cat showed interest in you! \n (｡◕‿‿◕｡)";
    }
}
