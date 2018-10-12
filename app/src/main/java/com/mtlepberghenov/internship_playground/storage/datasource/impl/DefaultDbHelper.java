package com.mtlepberghenov.internship_playground.storage.datasource.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.mtlepberghenov.internship_playground.storage.dao.Dao;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;

public class DefaultDbHelper extends OrmLiteSqliteOpenHelper implements DbHelper, Dao {

  private static final String DB_NAME = "main.db";
  private static final int DATABASE_VERSION = 1;
  private static DefaultDbHelper dbHelper;

  public static DefaultDbHelper getInstance (Context context) {
    if (dbHelper == null) {
      dbHelper = new DefaultDbHelper(context);
    }
    return dbHelper;
  }

  private DefaultDbHelper(Context context) {
    super(context, DB_NAME, null, DATABASE_VERSION);
}

  @Override public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
    //todo create the main data base
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion,
      int newVersion) {
  }

  @Override public void insert(String data){

  }

  @Override public String  select(String param) {
    return null;
  }
}
