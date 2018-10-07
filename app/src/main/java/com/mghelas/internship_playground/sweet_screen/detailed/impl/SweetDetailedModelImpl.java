package com.mghelas.internship_playground.sweet_screen.detailed.impl;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.datasource.DataSource;
import com.mghelas.internship_playground.sweet_screen.detailed.SweetDetailedModel;

public class SweetDetailedModelImpl implements SweetDetailedModel {

    private DataSource dataSource;

    public SweetDetailedModelImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public Sweet findById(int id) {
        return dataSource.sweetList.get(id);
    }

    @Override
    public void remove(int id) {
        dataSource.sweetList.remove(id);
    }
}
