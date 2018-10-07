package com.mghelas.internship_playground.sweet_screen.list.impl;

import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.datasource.DataSource;
import com.mghelas.internship_playground.sweet_screen.list.SweetListModel;

import java.util.List;

public class SweetListModelImpl implements SweetListModel {
    private DataSource dataSource;

    public SweetListModelImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<Sweet> getAll() {
        return dataSource.sweetList;
    }
}
