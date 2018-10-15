package com.mghelas.internship_playground.storage.datasource;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.storage.entity.SweetIngredient;

import java.sql.SQLException;


public class DbHelper extends OrmLiteSqliteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sweets_factory.db";
    private static DbHelper instance;

//    private Dao<Sweet, Integer> sweetDao = null;
//    private Dao<Ingredient, Integer> ingredientDao = null;
//    private Dao<SweetIngredient, Integer> sweetIngredientDao = null;

    private RuntimeExceptionDao<Sweet, Integer> sweetDao = null;
    private RuntimeExceptionDao<Ingredient, Integer> ingredientDao = null;
    private RuntimeExceptionDao<SweetIngredient, Integer> sweetIngredientDao = null;


    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    public static DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {

            Log.i(DbHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Sweet.class);
            TableUtils.createTable(connectionSource, Ingredient.class);
            TableUtils.createTable(connectionSource, SweetIngredient.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(DbHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
        sweetDao = getSweetDao();
        ingredientDao = getIngredientDao();
        sweetIngredientDao = getSweetIngredientDao();
        // create some entries in the onCreate

        Log.i(DbHelper.class.getName(), "created new entries in onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DbHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Sweet.class, true);
            TableUtils.dropTable(connectionSource, Ingredient.class, true);
            TableUtils.dropTable(connectionSource, SweetIngredient.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DbHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public RuntimeExceptionDao<Sweet, Integer> getSweetDao() {
        if (sweetDao == null) {
            sweetDao = getRuntimeExceptionDao(Sweet.class);
        }
        return sweetDao;
    }

    public RuntimeExceptionDao<Ingredient, Integer> getIngredientDao() {
        if (ingredientDao == null) {
            ingredientDao = getRuntimeExceptionDao(Ingredient.class);
        }
        return ingredientDao;
    }

    public RuntimeExceptionDao<SweetIngredient, Integer> getSweetIngredientDao() {
        if (sweetIngredientDao == null) {
            sweetIngredientDao = getRuntimeExceptionDao(SweetIngredient.class);
        }
        return sweetIngredientDao;
    }

    @Override
    public void close() {
        super.close();
        sweetDao = null;
        ingredientDao = null;
        sweetIngredientDao = null;
    }
}
