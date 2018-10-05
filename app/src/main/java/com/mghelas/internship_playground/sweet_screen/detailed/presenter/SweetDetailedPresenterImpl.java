package com.mghelas.internship_playground.sweet_screen.detailed.presenter;

import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.detailed.model.SweetDetailedModelImpl;
import com.mghelas.internship_playground.sweet_screen.detailed.model.SweetDetailedModel;
import com.mghelas.internship_playground.sweet_screen.detailed.view.SweetDetailedFragment;

public class SweetDetailedPresenterImpl implements SweetDetailedPresenter {
    private SweetDetailedModel sweetDetailedModel;
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
