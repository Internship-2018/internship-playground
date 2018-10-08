package com.mghelas.internship_playground.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


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
}
