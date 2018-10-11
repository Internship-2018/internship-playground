package com.example.nciuclea.oopzoomvp.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.nciuclea.oopzoomvp.database.model.DBAnimal;

public class AnimalUpdateTask implements Runnable {

    private DatabaseHelper databaseHelper;
    private DBAnimal animal;

    AnimalUpdateTask(DatabaseHelper databaseHelper, DBAnimal animal) {
        this.databaseHelper = databaseHelper;
        this.animal = animal;
    }


    @Override
    public void run() {
        Log.d("ANIMAL_UPDATE_TASK", "AnimalUpdateTask started");
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBAnimal.COLUMN_OVERALL_STATE, animal.getOverallState().name());
        values.put(DBAnimal.COLUMN_TIMESTAMP, animal.getTimestamp());

        db.update(DBAnimal.TABLE_NAME, values, DBAnimal.COLUMN_ID + " = ?",
                new String[]{String.valueOf(animal.getId())});
        db.close();
        Log.d("ANIMAL_UPDATE_TASK", "AnimalUpdateTask finished");
    }
}
