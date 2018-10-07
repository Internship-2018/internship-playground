package com.mghelas.internship_playground.sweet_screen.add.impl;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddFragment;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddWireframe;

import androidx.navigation.Navigation;

public class SweetAddWireframeImpl implements SweetAddWireframe {

    private SweetAddFragment sweetAddFragment;

    public SweetAddWireframeImpl(SweetAddFragment sweetAddFragment) {
        this.sweetAddFragment = sweetAddFragment;
    }

    @Override
    public void showListContent() {
        Navigation.findNavController(sweetAddFragment.getView()).navigate(R.id.action_sweetAddFragment_to_sweetListFragment);
    }
}
