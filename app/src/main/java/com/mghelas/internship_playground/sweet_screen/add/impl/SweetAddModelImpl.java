package com.mghelas.internship_playground.sweet_screen.add.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.mghelas.internship_playground.datasource.IngredientsReaderContract;
import com.mghelas.internship_playground.datasource.SweetReaderContract;
import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.datasource.DataSource;
import com.mghelas.internship_playground.datasource.SweetsIngredientsReaderContract;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.add.SweetAddModel;

import java.util.ArrayList;
import java.util.List;

public class SweetAddModelImpl implements SweetAddModel {

    private DataSource dataSource;
    private DbHelper dbHelper;

    public SweetAddModelImpl(DbHelper dbHelper) {
        this.dataSource = DataSource.getInstance();
        this.dbHelper = dbHelper;
    }

    @Override
    public long add(Sweet sweet) {
        long newRowId = 0;

        SQLiteDatabase db = dbHelper.getWritableDatabase();

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

    @Override
    public List<Ingredient> getAllIngredients() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
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
}
