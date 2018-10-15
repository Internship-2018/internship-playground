package com.mtlepberghenov.internship_playground.storage.datasource.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mtlepberghenov.internship_playground.storage.datasource.DbHelper;
import com.mtlepberghenov.internship_playground.storage.model.Vehicle;
import java.sql.SQLException;

public class DefaultDbHelper extends OrmLiteSqliteOpenHelper implements DbHelper {

  private static final String DB_NAME = "main.db";
  private static final int DATABASE_VERSION = 1;

  private static DefaultDbHelper dbHelper;

  private Dao<Vehicle, Integer> vehicleDao = null;

  public static DefaultDbHelper getInstance(Context context) {
    if (dbHelper == null) {
      dbHelper = new DefaultDbHelper(context);
    }
    return dbHelper;
  }

  private DefaultDbHelper(Context context) {
    super(context, DB_NAME, null, DATABASE_VERSION);
  }

  @Override
  public Dao<Vehicle, Integer> getVehicleDao() throws SQLException {
    if (vehicleDao == null) {
      vehicleDao = getDao(Vehicle.class);
    }
    return vehicleDao;
  }

  @Override public void onCreate(SQLiteDatabase db, ConnectionSource conSource) {
    try {
      TableUtils.createTable(conSource, Vehicle.class);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, ConnectionSource conSource, int oldVer,
      int newVersion) {
  }

}
