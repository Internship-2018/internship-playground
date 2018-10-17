package com.example.nciuclea.oopzoomvp.ui.animaldescription.impl;

import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionFragment;
import com.example.nciuclea.oopzoomvp.ui.animaldescription.AnimalDescriptionWireframe;

public class DefaultAnimalDescriptionWireframe implements AnimalDescriptionWireframe {
    private final AnimalDescriptionFragment animalDescriptionFragment;

    public DefaultAnimalDescriptionWireframe(AnimalDescriptionFragment animalDescriptionFragment) {
        this.animalDescriptionFragment = animalDescriptionFragment;
    }

    @Override
    public void showZooDescription(int id) {

    }
}
