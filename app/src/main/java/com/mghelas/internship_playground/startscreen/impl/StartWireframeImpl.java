package com.mghelas.internship_playground.startscreen.impl;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.startscreen.StartFragment;
import com.mghelas.internship_playground.startscreen.StartWireframe;

import androidx.navigation.Navigation;

public class StartWireframeImpl implements StartWireframe {

    private final StartFragment startFragment;

    public StartWireframeImpl(StartFragment startFragment) {
        this.startFragment = startFragment;
    }

    @Override
    public void showStockContent() {
        Navigation.findNavController(startFragment.getView()).navigate(R.id.action_startFragment_to_sweetFragment);
    }

    @Override
    public void showAddContent() {
        Navigation.findNavController(startFragment.getView()).navigate(R.id.action_startFragment_to_sweetAddFragment);
    }
}
