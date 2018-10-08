package com.mghelas.internship_playground.datasource;

import android.provider.BaseColumns;

public final class SweetsIngredientsReaderContract {
    public SweetsIngredientsReaderContract() {
    }

    public static class SweetsIngredientsEntry implements BaseColumns {
        public static final String TABLE_NAME = "sweets_ingredients";
        public static final String COLUMN_NAME_SWEET_ID = "sweet_id";
        public static final String COLUMN_NAME_INGREDIENT_ID = "ingredient_ID";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + SweetsIngredientsEntry.TABLE_NAME + " (" +
                        SweetsIngredientsEntry._ID + " INTEGER PRIMARY KEY," +
                        SweetsIngredientsEntry.COLUMN_NAME_SWEET_ID + " INTEGER," +
                        SweetsIngredientsEntry.COLUMN_NAME_INGREDIENT_ID + " INTEGER)";


        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + SweetsIngredientsEntry.TABLE_NAME;
    }
}
