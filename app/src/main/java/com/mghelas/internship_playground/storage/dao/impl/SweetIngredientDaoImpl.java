package com.mghelas.internship_playground.storage.dao.impl;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.storage.dao.GenericDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetIngredientDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.SweetIngredient;

import java.util.List;

public class SweetIngredientDaoImpl extends GenericDaoImpl<SweetIngredient> implements SweetIngredientDao {

    private DbHelper dbHelper;

    public SweetIngredientDaoImpl(DbHelper dbHelper) {
        super(dbHelper);
        this.dbHelper = dbHelper;
    }
}
