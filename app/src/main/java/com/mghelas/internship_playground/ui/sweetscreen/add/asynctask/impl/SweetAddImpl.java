package com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.impl;

import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAddCallback;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAddTask;
import com.mghelas.internship_playground.ui.sweetscreen.add.asynctask.SweetAdd;

public class SweetAddImpl implements SweetAdd {

    private SweetAddCallback addSweetCallback;
    private SweetDao sweetDao;

    public SweetAddImpl(SweetAddCallback addSweetCallback, SweetDao sweetDao) {
        this.addSweetCallback = addSweetCallback;
        this.sweetDao = sweetDao;
    }

    @Override
    public void add(Sweet sweet) {
        new SweetAddTask(addSweetCallback, sweetDao).execute(sweet);
    }

}
