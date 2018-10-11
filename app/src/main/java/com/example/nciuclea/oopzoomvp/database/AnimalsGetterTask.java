package com.example.nciuclea.oopzoomvp.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nciuclea.oopzoomvp.animal.state.State;
import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;
import com.example.nciuclea.oopzoomvp.ui.allanimals.DataLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class AnimalsGetterTask implements Runnable {

    private DatabaseHelper databaseHelper;
    private DataLoadCallback<ArrayList<DBAnimal>> dataLoadCallback;

    public AnimalsGetterTask(DatabaseHelper databaseHelper, DataLoadCallback<ArrayList<DBAnimal>> dataLoadCallback) {
        this.databaseHelper = databaseHelper;
        this.dataLoadCallback = dataLoadCallback;
    }

    @Override
    public void run() {
        List<DBAnimal> dbAnimals = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + DBAnimal.TABLE_NAME + " ORDER BY " + DBAnimal.COLUMN_ID + " ASC";

        SQLiteDatabase db = databaseHelper.getWritableDatabase(); //getWritabale in example
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DBAnimal dbAnimal = new DBAnimal(
                        cursor.getInt(cursor.getColumnIndex(DBAnimal.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_TYPE)),
                        State.valueOf(cursor.getString(cursor.getColumnIndex(DBAnimal.COLUMN_OVERALL_STATE))),
                        cursor.getLong(cursor.getColumnIndex(DBAnimal.COLUMN_STATE_TRANSITION_TIME)),
                        cursor.getLong(cursor.getColumnIndex(DBAnimal.COLUMN_TIMESTAMP))
                );

                dbAnimals.add(dbAnimal);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        dataLoadCallback.onDataLoaded(new ArrayList<DBAnimal>(dbAnimals));


    }
}
