package com.mghelas.internship_playground.storage.datasource;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mghelas.internship_playground.R;
import com.mghelas.internship_playground.storage.entity.Chocolate;
import com.mghelas.internship_playground.storage.entity.Ingredient;
import com.mghelas.internship_playground.storage.entity.Lollipop;
import com.mghelas.internship_playground.storage.entity.Sweet;
import com.mghelas.internship_playground.storage.entity.SweetIngredient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DbHelper extends OrmLiteSqliteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sweets_factory.db";
    private static DbHelper instance;
//    private Dao<Sweet, Integer> sweetDao = null;
    private Dao<Ingredient, Integer> ingredientDao = null;
    private Dao<SweetIngredient, Integer> sweetIngredientDao = null;

    private RuntimeExceptionDao<Sweet, Integer> sweetRuntimeDao = null;
    private RuntimeExceptionDao<Ingredient, Integer> ingredientRuntimeDao = null;
    private RuntimeExceptionDao<SweetIngredient, Integer> sweetIngredientRuntimeDao = null;


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
            Log.e(DbHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
        RuntimeExceptionDao<Sweet, Integer> dao = getSweetRuntimeDao();
        RuntimeExceptionDao<Ingredient, Integer> dao = getSweetRuntimeDao();
        RuntimeExceptionDao<SweetIngredient, Integer> dao = getSweetRuntimeDao();
        // create some entries in the onCreate
        Sweet sweet = new Sweet("Meteorit", 15.0, 100.0, true);
        dao.create(sweet);

        Ingredient ingredient = new Ingredient("Sugar");
        dao.create(ingredient);

        SweetIngredient sweetIngredient = new SweetIngredient(sweet, ingredient);
        dao.create(sweetIngredient);

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

    public Dao<Sweet, Integer> getDao() throws SQLException {
        if (sweetDao == null) {
            sweetDao = getDao(Sweet.class);
        }
        return sweetDao;
    }

    public RuntimeExceptionDao<Sweet, Integer> getSweetRuntimeDao() {
        if (sweetRuntimeDao == null) {
            sweetRuntimeDao = getRuntimeExceptionDao(Sweet.class);
        }
        return sweetRuntimeDao;
    }

    @Override
    public void close() {
        super.close();
//        sweetDao = null;
        sweetRuntimeDao = null;
    }

    public List<Sweet> getAllSweets() {
        SQLiteDatabase db = getReadableDatabase();
        List<Sweet> items = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE,
                SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE,
                SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT,
                SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG,
                SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE,
                SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR,
        };

        Cursor cursor = db.query(
                SweetReaderContract.SweetEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry._ID));
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE));
            Double price = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE));
            Double weight = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT));
            boolean pricePerKg = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG)) != 0;
            Integer percentage = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE));
            String flavour = cursor.getString(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR));

            Sweet sweet;
            if (percentage != 0) {
                sweet = new Chocolate(title, price, weight, pricePerKg, percentage);
                sweet.setId(id);
            } else {
                sweet = new Lollipop(title, price, weight, pricePerKg, flavour);
                sweet.setId(id);
            }
            items.add(sweet);
        }
        cursor.close();
        return items;
    }

    public Sweet findSweetById(int id) {
        String query = "SELECT sweets.*, ingredients.title as ingredient_title" +
                " FROM sweets" +
                " JOIN sweets_ingredients" +
                " ON sweets._id = sweets_ingredients.sweet_id" +
                " AND sweets_ingredients.sweet_id = ?" +
                " JOIN ingredients" +
                " ON ingredients._id = sweets_ingredients.ingredient_id";

        SQLiteDatabase db = getReadableDatabase();


        String[] selectionArgs = {Integer.toString(id)};
        Cursor cursor = db.rawQuery(query, selectionArgs);


        Sweet sweet = new Chocolate();
        List<Ingredient> ingredients = new ArrayList<>();
        while (cursor.moveToNext()) {

            String title = cursor.getString(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE));
            Double price = cursor.getDouble(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE));
            Double weight = cursor.getDouble(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT));
            boolean pricePerKg = cursor.getInt(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG)) != 0;
            Integer percentage = cursor.getInt(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE));
            String flavour = cursor.getString(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR));
            String ingredientTitle = cursor.getString(cursor.getColumnIndexOrThrow("ingredient_title"));
            if (percentage != 0) {
                sweet = new Chocolate(title, price, weight, pricePerKg, percentage);
            } else {
                sweet = new Lollipop(title, price, weight, pricePerKg, flavour);
            }
            ingredients.add(new Ingredient(ingredientTitle));
        }
        cursor.close();
        sweet.setIngredients(ingredients);

        return sweet;
    }

    public int remove(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = SweetReaderContract.SweetEntry._ID + " = ?";

        String[] selectionArgs = {Integer.toString(id)};

        return db.delete(SweetReaderContract.SweetEntry.TABLE_NAME, selection, selectionArgs);
    }

    public List<Ingredient> getAllIngredients() {
        SQLiteDatabase db = getReadableDatabase();
        List<Ingredient> items = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                IngredientsReaderContract.IngredientEntry.COLUMN_NAME_TITLE,
        };

        Cursor cursor = db.query(
                IngredientsReaderContract.IngredientEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(
                    cursor.getColumnIndexOrThrow(IngredientsReaderContract.IngredientEntry._ID));
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(IngredientsReaderContract.IngredientEntry.COLUMN_NAME_TITLE));

            Ingredient ingredient = new Ingredient(id, title);
            items.add(ingredient);
        }
        cursor.close();

        return items;

    }

    public long add(Sweet sweet) {
        long newRowId = 0;

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE, sweet.getTitle());
        values.put(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE, sweet.getPrice());
        values.put(SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT, sweet.getWeight());
        values.put(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG, sweet.getPricePerKg());

        if (sweet instanceof Chocolate) {
            values.put(SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE, ((Chocolate) sweet).getPercentage());
        } else {
            values.put(SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR, ((Lollipop) sweet).getFlavour());
        }
        newRowId = db.insert(SweetReaderContract.SweetEntry.TABLE_NAME, null, values);

        ContentValues foreignValues = new ContentValues();
        for (Ingredient ingredient : sweet.getIngredients()) {
            foreignValues.put(SweetsIngredientsReaderContract.SweetsIngredientsEntry.COLUMN_NAME_SWEET_ID, newRowId);
            foreignValues.put(SweetsIngredientsReaderContract.SweetsIngredientsEntry.COLUMN_NAME_INGREDIENT_ID, ingredient.getId());
            db.insert(SweetsIngredientsReaderContract.SweetsIngredientsEntry.TABLE_NAME, null, foreignValues);
        }

        return newRowId;
    }
}
