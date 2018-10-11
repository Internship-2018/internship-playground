package com.mtlepberghenov.internship_playground.storage.sql;

public class Tables {

  /* Note: text = "Type: %s\nMake: %s\nModel: %s\nColor: %s\nYear: %s" */
  public static final String TABLE_NAME_VEHICLE = "vehicle";
  public static final String COLUMN_ID = "id";
  public static final String COLUMN_TYPE = "type";
  public static final String COLUMN_MAKER = "maker";
  public static final String COLUMN_MODEL = "model";
  public static final String COLUMN_COLOR = "color";
  public static final String COLUMN_YEAR = "year";

  static final String createVehicle() {
    return String.format(
        "create table %s ("
            + "%s integer primary key autoincrement, "
            + "%s text not null default empty, "
            + "%s text not null default empty, "
            + "%s text not null default empty, "
            + "%s text not null default empty, "
            + "%s text not null default 0);",
        TABLE_NAME_VEHICLE, COLUMN_ID, COLUMN_TYPE, COLUMN_MAKER, COLUMN_MODEL, COLUMN_COLOR, COLUMN_YEAR);
  }

  public static final String selectAllQuery() {
    return String.format("select * from %s", TABLE_NAME_VEHICLE);
  }
}
