package com.mtlepberghenov.internship_playground.storage.sql;

public class Tables {

  /* Note: text = "Type: %s\nMake: %s\nModel: %s\nColor: %s\nYear: %s" */
  public static final String TABLE_NAME = "vehicle";
  public static final String COLUMN_ID = "id";
  public static final String COLUMN_TYPE = "type";
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
            + "%s text not null default 0);",
        TABLE_NAME, COLUMN_ID, COLUMN_TYPE, COLUMN_MODEL, COLUMN_COLOR, COLUMN_YEAR);
  }
}
