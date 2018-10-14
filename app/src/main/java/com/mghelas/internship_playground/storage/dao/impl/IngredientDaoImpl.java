package com.mghelas.internship_playground.storage.dao.impl;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.storage.dao.GenericDao;
import com.mghelas.internship_playground.storage.dao.GenericDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Ingredient;

import java.util.List;

public class IngredientDaoImpl extends GenericDaoImpl<Ingredient> implements IngredientDao {

    private DbHelper dbHelper;

    public IngredientDaoImpl() {
        super();
        dbHelper = DbHelper.getInstance(App.getInstance());
    }

}
