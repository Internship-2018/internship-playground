package com.mghelas.internship_playground.ui.sweetscreen.detailed.impl;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedFragment;
import com.mghelas.internship_playground.ui.sweetscreen.detailed.SweetDetailedWireframe;

import androidx.navigation.Navigation;

public class SweetDetailedWireframeImpl implements SweetDetailedWireframe {
    private final SweetDetailedFragment sweetDetailedFragment;

    public SweetDetailedWireframeImpl(SweetDetailedFragment sweetDetailedFragment) {
        this.sweetDetailedFragment = sweetDetailedFragment;
    }

    @Override
    public void showListContent() {
        Navigation.findNavController(sweetDetailedFragment.getView()).navigate(R.id.action_sweetDetailedFragment_to_sweetListFragment);
    }
}
