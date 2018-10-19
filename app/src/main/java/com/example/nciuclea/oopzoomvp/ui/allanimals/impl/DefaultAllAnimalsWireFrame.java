package com.example.nciuclea.oopzoomvp.ui.allanimals.impl;

import android.os.Bundle;
import android.view.View;

import com.example.nciuclea.oopzoomvp.R;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsFragment;
import com.example.nciuclea.oopzoomvp.ui.allanimals.AllAnimalsWireframe;

import androidx.navigation.Navigation;

public class DefaultAllAnimalsWireFrame implements AllAnimalsWireframe {
    private final AllAnimalsFragment allAnimalsFragment;


    public DefaultAllAnimalsWireFrame(AllAnimalsFragment allAnimalsFragment) {
        this.allAnimalsFragment = allAnimalsFragment;
    }

    @Override
    public void showAnimalDescription(View v, int animalId) {
        Bundle bundle = new Bundle();
        bundle.putInt("animalId", animalId);
        Navigation.findNavController(v).navigate(R.id.action_allAnimalsFragment_to_animalDescriptionFragment, bundle);
    }
}
