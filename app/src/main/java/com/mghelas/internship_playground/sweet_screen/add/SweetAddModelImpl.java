package com.mghelas.internship_playground.sweet_screen.add;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.datasource.DataSource;

public class SweetAddModelImpl implements SweetAddModelIntf {

    private DataSource dataSource;

    public SweetAddModelImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public void add(Sweet sweet) {
        dataSource.sweetList.add(sweet);
    }
}
