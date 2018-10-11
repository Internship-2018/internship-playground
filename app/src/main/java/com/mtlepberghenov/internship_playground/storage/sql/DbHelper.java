package com.mtlepberghenov.internship_playground.storage.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;

public class DbHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "main.db";
  private static final int DATABASE_VERSION = 1;

  public DbHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override public void onCreate(SQLiteDatabase db) {
    db.execSQL(Tables.createVehicle());
  }

  @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

  }

  public void insert(SqlVehicle vehicle) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put(Tables.COLUMN_TYPE, vehicle.getType());
    cv.put(Tables.COLUMN_MAKER, vehicle.getMaker());
    cv.put(Tables.COLUMN_MODEL, vehicle.getModel());
    cv.put(Tables.COLUMN_COLOR, vehicle.getModel());
    cv.put(Tables.COLUMN_YEAR, vehicle.getYear());
    db.insert(Tables.TABLE_NAME_VEHICLE, null, cv);
    db.close();
  }
}
