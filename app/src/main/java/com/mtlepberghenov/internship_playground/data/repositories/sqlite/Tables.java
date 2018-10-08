package com.mtlepberghenov.internship_playground.data.repositories.sqlite;

public class Tables {

  /* Note: text = "Type: %s\nMake: %s\nModel: %s\nColor: %s\nYear: %s" */
  private static final String TABLE_NAME = "vehicle";
  private static final String COLUMN_ID = "id";
  private static final String COLUMN_TYPE = "type";
  private static final String COLUMN_MODEL = "model";
  private static final String COLUMN_COLOR = "color";
  private static final String COLUMN_YEAR = "year";

  static final String createVehicle() {
    return String.format(
        "create table %s ("
            + "%s integer primary key autoincrement, "
            + "%s text not null default empty, "
            + "%s text not null default empty, "
            + "%s text not null default empty, "
            + "%s integer not null default 0);",
        TABLE_NAME, COLUMN_ID, COLUMN_TYPE, COLUMN_MODEL, COLUMN_COLOR, COLUMN_YEAR);
  }
}
