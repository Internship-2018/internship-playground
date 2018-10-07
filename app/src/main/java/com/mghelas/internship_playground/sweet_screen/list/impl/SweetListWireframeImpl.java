package com.mghelas.internship_playground.sweet_screen.list.impl;

import android.os.Bundle;

import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.sweet_screen.list.SweetListFragment;
import com.mghelas.internship_playground.sweet_screen.list.SweetListWireframe;

import androidx.navigation.Navigation;

public class SweetListWireframeImpl implements SweetListWireframe {

    private final SweetListFragment sweetListFragment;

    public SweetListWireframeImpl(SweetListFragment sweetListFragment) {
        this.sweetListFragment = sweetListFragment;
    }

    @Override
    public void showDetailedContent(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        Navigation.findNavController(sweetListFragment.getView()).navigate(R.id.action_sweetListFragment_to_sweetDetailedFragment, bundle);
    }
}
