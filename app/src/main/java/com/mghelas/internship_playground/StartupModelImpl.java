package com.mghelas.internship_playground;

import com.mghelas.internship_playground.network.sweet.SweetServiceCall;
import com.mghelas.internship_playground.storage.dao.intf.IngredientDao;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.entity.Sweet;

import java.util.List;

public class StartupModelImpl implements StartupModel {
    private SweetDao sweetDao;
    private IngredientDao ingredientDao;
    private SweetServiceCall sweetServiceCall;

    public StartupModelImpl(SweetDao sweetDao, IngredientDao ingredientDao) {
        this.sweetDao = sweetDao;
        this.ingredientDao = ingredientDao;
    }

    @Override
    public void updateData() {
        sweetServiceCall.getAll();
    }

    @Override
    public void syncDb(List<Sweet> sweets) {
        sweetDao.deleteAll();
        ingredientDao.deleteAll();
        for (Sweet sweet : sweets) {
            sweetDao.save(sweet);
        }
    }

    @Override
    public void setSweetServiceCall(SweetServiceCall sweetServiceCall) {
        this.sweetServiceCall = sweetServiceCall;
    }

}
