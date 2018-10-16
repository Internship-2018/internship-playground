package com.mghelas.internship_playground.storage.dao.impl;

import com.mghelas.internship_playground.storage.dao.GenericDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Ingredient;

public class IngredientDaoImpl extends GenericDaoImpl<Ingredient> implements IngredientDao {

    private DbHelper dbHelper;

    public IngredientDaoImpl(DbHelper dbHelper) {
        super(dbHelper);
        this.dbHelper = dbHelper;
    }

}
