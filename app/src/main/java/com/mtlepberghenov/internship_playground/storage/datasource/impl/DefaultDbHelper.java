package com.mtlepberghenov.internship_playground.storage.datasource.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.mtlepberghenov.internship_playground.storage.dao.Dao;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.util.List;

public class DefaultDbHelper extends OrmLiteSqliteOpenHelper implements DbHelper, Dao {

  private static final String DB_NAME = "main.db";
  private static final int DATABASE_VERSION = 1;

  public DefaultDbHelper(Context context) {
    super(context, DB_NAME, null, DATABASE_VERSION);
}

  @Override public void onCreate(SQLiteDatabase db, ConnectionSource conSource) {
    //todo create the main data base
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, ConnectionSource conSource, int oldVer,
      int newVersion) {
  }

  @Override public void insert(Vehicle vehicle){
    //todo
  }

  @Override public List<Vehicle> selectAll() {
    //todo
    return null;
  }
}
