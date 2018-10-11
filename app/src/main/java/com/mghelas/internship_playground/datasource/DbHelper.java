package com.mghelas.internship_playground.datasource;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.mghelas.internship_playground.App;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Ingredient;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sweets.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SweetReaderContract.SweetEntry.SQL_CREATE_ENTRIES);

        db.execSQL(IngredientsReaderContract.IngredientEntry.SQL_CREATE_ENTRIES);
        db.execSQL(IngredientsReaderContract.IngredientEntry.SQL_CREATE_RECORDS);

        db.execSQL(SweetsIngredientsReaderContract.SweetsIngredientsEntry.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SweetReaderContract.SweetEntry.SQL_DELETE_ENTRIES);
        db.execSQL(IngredientsReaderContract.IngredientEntry.SQL_DELETE_ENTRIES);
        db.execSQL(SweetsIngredientsReaderContract.SweetsIngredientsEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public List<Sweet> getAllSweets() {
        SQLiteDatabase db = App.getInstance().getDbHelper().getReadableDatabase();
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

        SQLiteDatabase db = App.getInstance().getDbHelper().getReadableDatabase();


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
        SQLiteDatabase db = App.getInstance().getDbHelper().getReadableDatabase();
        String selection = SweetReaderContract.SweetEntry._ID + " = ?";

        String[] selectionArgs = {Integer.toString(id)};

       return db.delete(SweetReaderContract.SweetEntry.TABLE_NAME, selection, selectionArgs);
    }
}
