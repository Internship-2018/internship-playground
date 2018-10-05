package com.example.nciuclea.oopzoomvp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nciuclea.oopzoomvp.Animal.Animal;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "animals_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating Animals table
        db.execSQL(DBAnimal.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBAnimal.TABLE_NAME);

        onCreate(db);
    }

    public long addAnimal(Animal animal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBAnimal.COLUMN_TYPE, animal.getType());
        values.put(DBAnimal.COLUMN_STATUS, animal.getGeneralState().name());
        long id = db.insert(DBAnimal.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public DBAnimal getAnimal(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DBAnimal.TABLE_NAME,
                new String[]{DBAnimal.COLUMN_ID, DBAnimal.COLUMN_TYPE, DBAnimal.COLUMN_STATUS, DBAnimal.COLUMN_TIMESTAMP},
                DBAnimal.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        DBAnimal dbAnimal = new DBAnimal(
                cursor.getInt(cursor.getColumnIndex(DBAnimal.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_TYPE)),
                cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_STATUS)),
                cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_TIMESTAMP))
        );

        cursor.close();

        return dbAnimal;
    }

    public List<DBAnimal> getAllAnimals() {
        List<DBAnimal> dbAnimals = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + DBAnimal.TABLE_NAME + " ORDER BY " + DBAnimal.COLUMN_ID + " ASC";

        SQLiteDatabase db = this.getReadableDatabase(); //getWritabale in example
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBAnimal dbAnimal = new DBAnimal(
                        cursor.getInt(cursor.getColumnIndex(DBAnimal.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_TYPE)),
                        cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_STATUS)),
                        cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_TIMESTAMP))
                );

                dbAnimals.add(dbAnimal);
            } while (cursor.moveToNext());
        }

        db.close();

        return dbAnimals;
    }

    public int getAnimalsCount() {
        String countQuery = "SELECT 8 FROM " + DBAnimal.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }
}
