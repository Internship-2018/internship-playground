package com.mghelas.internship_playground.sweet_screen.list.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.mghelas.internship_playground.datasource.SweetReaderContract;
import com.mghelas.internship_playground.datasource.DbHelper;
import com.mghelas.internship_playground.entity.Chocolate;
import com.mghelas.internship_playground.entity.Lollipop;
import com.mghelas.internship_playground.entity.Sweet;
import com.mghelas.internship_playground.sweet_screen.list.SweetListModel;

import java.util.ArrayList;
import java.util.List;

public class SweetListModelImpl implements SweetListModel {
    private DbHelper sweetReaderDbHelper;

    public SweetListModelImpl(DbHelper sweetReaderDbHelper) {
        this.sweetReaderDbHelper = sweetReaderDbHelper;
    }

    @Override
    public List<Sweet> getAll() {
        SQLiteDatabase db = sweetReaderDbHelper.getReadableDatabase();
        List<Sweet> items = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE,
                SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE,
                SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT,
                SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG,
                SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE,
                SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR,
        };

        Cursor cursor = db.query(
                SweetReaderContract.SweetEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry._ID));
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_TITLE));
            Double price = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE));
            Double weight = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_WEIGHT));
            boolean pricePerKg = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PRICE_PER_KG)) != 0;
            Integer percentage = cursor.getInt(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_PERCENTAGE));
            String flavour = cursor.getString(
                    cursor.getColumnIndexOrThrow(SweetReaderContract.SweetEntry.COLUMN_NAME_FLAVOUR));

            Sweet sweet;
            if (percentage != 0) {
                sweet = new Chocolate(title, price, weight, pricePerKg, percentage);
                sweet.setId(id);
            } else {
                sweet = new Lollipop(title, price, weight, pricePerKg, flavour);
                sweet.setId(id);
            }
            items.add(sweet);
        }
        cursor.close();

        return items;
    }
}
