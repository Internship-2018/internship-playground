package com.mghelas.internship_playground.sweet_screen.add;

import com.mghelas.internship_playground.entity.Sweet;

public class SweetAddPresenterImpl implements SweetAddPresenterIntf {

    private SweetAddFragment sweetAddFragment;
    private SweetAddModelIntf sweetAddModel;

    public SweetAddPresenterImpl(SweetAddFragment sweetAddFragment) {
        this.sweetAddFragment = sweetAddFragment;
        this.sweetAddModel = new SweetAddModelImpl();
    }

    @Override
    public void onAdd(Sweet sweet) {
        sweetAddModel.add(sweet);
    }
}
