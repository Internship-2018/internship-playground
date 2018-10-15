package com.mghelas.internship_playground.ui.sweetscreen.add.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.storage.dao.impl.SweetDaoImpl;
import com.mghelas.internship_playground.storage.dao.impl.SweetIngredientDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.dao.intf.SweetIngredientDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.storage.entity.SweetIngredient;

import java.util.ArrayList;
import java.util.List;

public class SweetAddTask extends AsyncTask<Sweet, Void, Integer> {

    private SweetDao sweetDao;

    private SweetAddCallback addSweetCallback;

    public SweetAddTask(SweetAddCallback addSweetCallback, SweetDao sweetDao) {
        this.addSweetCallback = addSweetCallback;
        this.sweetDao = sweetDao;
    }

    @Override
    protected Integer doInBackground(Sweet... sweet) {
        return sweetDao.save(sweet[0]);

    }

    @Override
    protected void onPostExecute(Integer id) {
        super.onPostExecute(id);
        addSweetCallback.onSweetAdded();
    }


}
