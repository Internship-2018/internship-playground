package com.mghelas.internship_playground.sweet_screen.list.model;

import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.datasource.DataSource;

import java.util.List;

public class SweetListModelImpl implements SweetListModelIntf {
    private DataSource dataSource;

    public SweetListModelImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<Sweet> getAll() {
        return dataSource.sweetList;
    }
}
