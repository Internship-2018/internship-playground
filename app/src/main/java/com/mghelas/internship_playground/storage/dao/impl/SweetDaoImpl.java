package com.mghelas.internship_playground.storage.dao.impl;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.storage.dao.GenericDaoImpl;
import com.mghelas.internship_playground.storage.dao.intf.SweetDao;
import com.mghelas.internship_playground.storage.datasource.DbHelper;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.storage.entity.SweetIngredient;

import java.sql.SQLException;
import java.util.List;

public class SweetDaoImpl extends GenericDaoImpl<Sweet> implements SweetDao {

    private DbHelper dbHelper;

    public SweetDaoImpl(DbHelper dbHelper) {
        super(dbHelper);
        this.dbHelper = dbHelper;
    }

    @Override
    public int save(Sweet entity) {

        dbHelper.getSweetDao().create(entity);
        if (entity.getId() == null) {
            try {
                entity.setId(dbHelper.getSweetDao().queryBuilder().orderBy("id", false).limit(1L).query().get(0).getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(entity.getIngredients().toString());
        System.out.println(entity.getId());
        for (Ingredient ingredient : entity.getIngredients()) {
            try {
                Ingredient checkIngredient = dbHelper.getIngredientDao().queryBuilder().where().eq("name", ingredient.getName()).queryForFirst();
                if (checkIngredient == null) {
                    dbHelper.getIngredientDao().create(ingredient);
                } else {
                    ingredient.setId(checkIngredient.getId());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbHelper.getSweetIngredientDao().create(new SweetIngredient(entity, ingredient, ingredient.getQuantity()));

        }
        return entity.getId();
    }

    @Override
    public Sweet findById(int key) {
        Sweet sweet = dbHelper.getSweetDao().queryForId(key);
        PreparedQuery<Ingredient> ingredientsForSweetQuery;
        QueryBuilder<SweetIngredient, Integer> sweetIngredientQb = dbHelper.getSweetIngredientDao().queryBuilder();
        sweetIngredientQb.selectColumns(SweetIngredient.INGREDIENT_ID_FIELD_NAME);
        SelectArg userSelectArg = new SelectArg();
        try {
            sweetIngredientQb.where().eq(SweetIngredient.SWEET_ID_FIELD_NAME, userSelectArg);

            QueryBuilder<Ingredient, Integer> ingredientQb = dbHelper.getIngredientDao().queryBuilder();

            ingredientQb.where().in(Ingredient.ID_FIELD_NAME, sweetIngredientQb);

            ingredientsForSweetQuery = ingredientQb.prepare();

            ingredientsForSweetQuery.setArgumentHolderValue(0, sweet);
            List<Ingredient> ingredients = dbHelper.getIngredientDao().query(ingredientsForSweetQuery);
            sweet.setIngredients(ingredients);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sweet;
    }

    @Override
    public void update(Sweet entity) {

    }

    @Override
    public int delete(Sweet entity) {
        PreparedDelete<SweetIngredient> deleteSweetIngredientsQuery = null;
        DeleteBuilder<SweetIngredient, Integer> sweetIngredientQb = dbHelper.getSweetIngredientDao().deleteBuilder();
        SelectArg userSelectArg = new SelectArg();
        try {
            sweetIngredientQb.where().eq(SweetIngredient.SWEET_ID_FIELD_NAME, userSelectArg);
            deleteSweetIngredientsQuery = sweetIngredientQb.prepare();
            deleteSweetIngredientsQuery.setArgumentHolderValue(0, entity);
            dbHelper.getSweetIngredientDao().delete(deleteSweetIngredientsQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbHelper.getSweetDao().delete(entity);
    }

    @Override
    public void deleteAll() {
        DeleteBuilder<Sweet, Integer> db = dbHelper.getSweetDao().deleteBuilder();
        DeleteBuilder<SweetIngredient, Integer> sweetIngredientIntegerDeleteBuilder = dbHelper.getSweetIngredientDao().deleteBuilder();
        try {
            db.delete();
            sweetIngredientIntegerDeleteBuilder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByConfectionerName(String name) {
        try {
            List<Sweet> sweets = dbHelper.getSweetDao().queryBuilder().where().eq("confectioner_name", name).query();
            for (Sweet sweet : sweets) {
                dbHelper.getSweetIngredientDao().deleteBuilder().where().eq("id", sweet.getId());
            }
            dbHelper.getSweetDao().delete(sweets);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
