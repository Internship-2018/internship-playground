package com.mghelas.internship_playground.storage.datasource;

import android.provider.BaseColumns;

public final class SweetReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

   private SweetReaderContract() {
    }

    /* Inner class that defines the table contents */
    public static class SweetEntry implements BaseColumns {
        public static final String TABLE_NAME = "sweets";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_PRICE_PER_KG = "price_per_kg";
        public static final String COLUMN_NAME_PERCENTAGE = "percentage";
        public static final String COLUMN_NAME_FLAVOUR = "flavour";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + SweetEntry.TABLE_NAME + " (" +
                        SweetEntry._ID + " INTEGER PRIMARY KEY," +
                        SweetEntry.COLUMN_NAME_TITLE + " TEXT," +
                        SweetEntry.COLUMN_NAME_PRICE + " DOUBLE," +
                        SweetEntry.COLUMN_NAME_WEIGHT + " DOUBLE," +
                        SweetEntry.COLUMN_NAME_PRICE_PER_KG + " BOOLEAN," +
                        SweetEntry.COLUMN_NAME_PERCENTAGE + " INT," +
                        SweetEntry.COLUMN_NAME_FLAVOUR + " TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + SweetEntry.TABLE_NAME;
    }
}