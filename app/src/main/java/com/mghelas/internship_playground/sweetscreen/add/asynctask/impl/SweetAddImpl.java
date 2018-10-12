package com.mghelas.internship_playground.sweetscreen.add.asynctask.impl;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddCallback;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAddTask;
import com.mghelas.internship_playground.sweetscreen.add.asynctask.SweetAdd;

public class SweetAddImpl implements SweetAdd {

    private SweetAddCallback addSweetCallback;

    public SweetAddImpl(SweetAddCallback addSweetCallback) {
        this.addSweetCallback = addSweetCallback;
    }

    @Override
    public void add(Sweet sweet) {
        new SweetAddTask(addSweetCallback).execute(sweet);
    }

}
