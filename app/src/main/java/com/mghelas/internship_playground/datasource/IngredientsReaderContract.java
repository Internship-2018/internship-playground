package com.mghelas.internship_playground.datasource;

import android.provider.BaseColumns;

public final class IngredientsReaderContract {
    private IngredientsReaderContract() {
    }

    public static class IngredientEntry implements BaseColumns {
        public static final String TABLE_NAME = "ingredients";
        public static final String COLUMN_NAME_TITLE = "title";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + IngredientEntry.TABLE_NAME + " (" +
                        IngredientEntry._ID + " INTEGER PRIMARY KEY," +
                        IngredientEntry.COLUMN_NAME_TITLE + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + IngredientEntry.TABLE_NAME;

        public static final String SQL_CREATE_RECORDS =
                "INSERT INTO " + IngredientEntry.TABLE_NAME + "(" + IngredientEntry.COLUMN_NAME_TITLE +
                        ") VALUES ('Sugar'), ('Milk'), ('Cocoa');";

    }

}
