package com.example.nciuclea.oopzoomvp.database.model;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;

import java.util.Date;

public class DBAnimal {
    public static final String TABLE_NAME = "animals";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String type;
    private String status;
    private long timestamp;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TYPE + " TEXT,"
                    + COLUMN_STATUS + " TEXT,"
                    + COLUMN_TIMESTAMP + " INTEGER"
                    + ")";

    public DBAnimal() {

    }

    public DBAnimal(int id, String type, String status, long timestamp) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.timestamp = timestamp;
    }
}
