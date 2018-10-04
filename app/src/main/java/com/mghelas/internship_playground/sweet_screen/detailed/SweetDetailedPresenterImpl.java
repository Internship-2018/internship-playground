package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.Entity.Sweet;

public class SweetDetailedPresenterImpl implements SweetDetailedPresenterIntf {
    private SweetDetailedModelIntf sweetDetailedModel;
    private SweetDetailedFragment sweetDetailedFragment;

    public SweetDetailedPresenterImpl(SweetDetailedFragment sweetDetailedFragment) {
        this.sweetDetailedModel = new SweetDetailedModelImpl();
        this.sweetDetailedFragment = sweetDetailedFragment;
    }

    @Override
    public void findById(int id) {

        sweetDetailedFragment.setData(sweetDetailedModel.findById(id));
    }

    @Override
    public void onRemove(int id) {
        sweetDetailedModel.remove(id);
        sweetDetailedFragment.remove();
    }

    @Override
    public void onMix(Sweet sweet) {
        sweetDetailedFragment.mix(sweet.manufacture());
    }
}
