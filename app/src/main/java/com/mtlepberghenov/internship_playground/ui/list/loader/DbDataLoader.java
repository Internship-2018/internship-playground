package com.mtlepberghenov.internship_playground.ui.list.loader;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import com.mtlepberghenov.internship_playground.App;
import com.mtlepberghenov.internship_playground.storage.model.SqlVehicle;
import com.mtlepberghenov.internship_playground.storage.sql.Tables;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import timber.log.Timber;

public class DbDataLoader extends AsyncTaskLoader<List<SqlVehicle>> implements DataFetcher{

  private SQLiteDatabase db;

  public DbDataLoader(@NonNull Context context) {
    super(context);
    db = App.getInstance().getDbHelper().getReadableDatabase();
  }

  @Override protected void onStartLoading() {
    super.onStartLoading();
    Timber.d("onStartLoading");
    //getData();
  }

  @Nullable @Override public List<SqlVehicle> loadInBackground() {
    Timber.d("loadingInBackground");
    Cursor cursor = db.rawQuery(Tables.selectAllQuery(), null);
    List<SqlVehicle> sqlVehicleList = new ArrayList<>();
    if(cursor.moveToFirst()) {
      do {
        SqlVehicle sqlVehicle = new SqlVehicle();
        sqlVehicle.setId(cursor.getInt(cursor.getColumnIndex(Tables.COLUMN_ID)));
        sqlVehicle.setType(cursor.getString(cursor.getColumnIndex(Tables.COLUMN_TYPE)));
        sqlVehicle.setMaker(cursor.getString(cursor.getColumnIndex(Tables.COLUMN_MAKER)));
        sqlVehicle.setModel(cursor.getString(cursor.getColumnIndex(Tables.COLUMN_MODEL)));
        sqlVehicle.setColor(cursor.getString(cursor.getColumnIndex(Tables.COLUMN_COLOR)));
        sqlVehicle.setYear(cursor.getString(cursor.getColumnIndex(Tables.COLUMN_YEAR)));
        sqlVehicleList.add(sqlVehicle);
      } while (cursor.moveToNext());
    }
    cursor.close();
    db.close();
    return sqlVehicleList;
  }

  @Override public void fetchData() {
    onContentChanged();
  }


}
