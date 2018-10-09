package com.mghelas.internship_playground.sweetscreen.detailed.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.datasource.SweetReaderContract;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweetscreen.detailed.SweetDetailedModel;

import java.util.ArrayList;
import java.util.List;

public class SweetDetailedModelImpl implements SweetDetailedModel {

    private DbHelper dbHelper;

    public SweetDetailedModelImpl() {
        this.dbHelper = App.getInstance().getDbHelper();
    }

    @Override
    public Sweet findById(int id) {
        String query = "SELECT sweets.*, ingredients.title as ingredient_title" +
                " FROM sweets" +
                " JOIN sweets_ingredients" +
                " ON sweets._id = sweets_ingredients.sweet_id" +
                " AND sweets_ingredients.sweet_id = ?" +
                " JOIN ingredients" +
                " ON ingredients._id = sweets_ingredients.ingredient_id";

        SQLiteDatabase db = dbHelper.getReadableDatabase();


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

    @Override
    public void remove(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selection = SweetReaderContract.SweetEntry._ID + " = ?";

        String[] selectionArgs = {Integer.toString(id)};

        db.delete(SweetReaderContract.SweetEntry.TABLE_NAME, selection, selectionArgs);
    }
}
