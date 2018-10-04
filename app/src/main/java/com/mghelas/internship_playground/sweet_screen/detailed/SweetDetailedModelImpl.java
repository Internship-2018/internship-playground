package com.mghelas.internship_playground.sweet_screen.detailed;

import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.datasource.DataSource;

public class SweetDetailedModelImpl implements SweetDetailedModelIntf {

    private DataSource dataSource;

    SweetDetailedModelImpl() {
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
