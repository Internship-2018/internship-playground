package com.mghelas.internship_playground.sweet_screen.detailed.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.mghelas.internship_playground.datasource.IngredientsReaderContract;
import com.mghelas.internship_playground.datasource.SweetReaderContract;
import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.datasource.SweetsIngredientsReaderContract;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.detailed.SweetDetailedModel;

import java.util.Arrays;

public class SweetDetailedModelImpl implements SweetDetailedModel {

    private DbHelper sweetReaderDbHelper;

    public SweetDetailedModelImpl(DbHelper sweetReaderDbHelper) {
        this.sweetReaderDbHelper = sweetReaderDbHelper;
    }

    @Override
    public Sweet findById(int id) {
        String query = "SELECT *" +
                " FROM ingredients" +
                " JOIN sweets_ingredients" +
                " ON ingredients._id = sweets_ingredients.ingredient_id" +
                " AND sweets_ingredients.sweet_id = ?";

        SQLiteDatabase db = sweetReaderDbHelper.getReadableDatabase();

        String selection = SweetsIngredientsReaderContract.SweetsIngredientsEntry.COLUMN_NAME_SWEET_ID + " = ?";

        String[] selectionArgs = {Integer.toString(id)};
        String[] projection = {
                BaseColumns._ID,
                IngredientsReaderContract.IngredientEntry.COLUMN_NAME_TITLE
        };
        Cursor cursor = db.rawQuery(query, selectionArgs);
//        Cursor cursor = db.query(
//                IngredientsReaderContract.IngredientEntry.TABLE_NAME,
//                projection,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null
//        );

        while (cursor.moveToNext()) {
            System.out.println(cursor.getString(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE)));
        }
//        String[] projection = {
//                BaseColumns._ID,
//                SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE,
//                SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE,
//                SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT,
//                SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG,
//                SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE,
//                SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR,
//        };

//        Cursor cursor = db.query(
//                SweetReaderContract.SweetEntry.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection,              // The columns for the WHERE clause
//                selectionArgs,          // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                null               // The sort order
//        );
        Sweet sweet = new Chocolate();
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE));
            Double price = cursor.getDouble(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE));
            Double weight = cursor.getDouble(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT));
            boolean pricePerKg = cursor.getInt(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG)) != 0;
            Integer percentage = cursor.getInt(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE));
            String flavour = cursor.getString(cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR));
//            String ingredient = cursor.getString(cursor.getColumnIndexOrThrow("ingredient_title"));
            if (percentage != 0) {
                sweet = new Chocolate(title, price, weight, pricePerKg, percentage);
            } else {
                sweet = new Lollipop(title, price, weight, pricePerKg, flavour);
            }
        }
        return sweet;
    }

    @Override
    public void remove(int id) {
        SQLiteDatabase db = sweetReaderDbHelper.getReadableDatabase();

        String selection = SweetReaderContract.SweetEntry._ID + " = ?";

        String[] selectionArgs = {Integer.toString(id)};

        db.delete(SweetReaderContract.SweetEntry.TABLE_NAME, selection, selectionArgs);
    }
}
