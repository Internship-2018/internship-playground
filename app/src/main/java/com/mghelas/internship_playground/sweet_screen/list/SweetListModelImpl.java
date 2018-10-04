package com.mghelas.internship_playground.sweet_screen.list;

import com.mghelas.internship_playground.Entity.Sweet;
import com.mghelas.internship_playground.datasource.DataSource;

import java.util.List;

public class SweetListModelImpl implements SweetListModelIntf {
    private DataSource dataSource;

    SweetListModelImpl() {
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public List<Sweet> getAll() {
        return dataSource.sweetList;
    }

    @Override
    public Sweet findById(int id) {
        return dataSource.sweetList.get(id);
    }

    @Override
    public void remove(int id) {
        dataSource.sweetList.remove(id);
    }

    @Override
    public void add(Sweet sweet) {
        dataSource.sweetList.add(sweet);
    }
}
