package com.example.nciuclea.oopzoomvp.database.model;

import com.example.nciuclea.oopzoomvp.Animal.AnimalState.State;
import com.example.nciuclea.oopzoomvp.R;

public class DBAnimal {
    public static final String TABLE_NAME = "animals";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_OVERALL_STATE = "overall_state";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TYPE + " TEXT,"
                    + COLUMN_OVERALL_STATE + " TEXT,"
                    + COLUMN_TIMESTAMP + " INTEGER"
                    + ")";

    private int id;
    private String type;
    private State overallState;
    private long timestamp;


    public DBAnimal(String type, State overallState, long timestamp) {
        this.type = type;
        this.overallState = overallState;
        this.timestamp = timestamp;
    }

    public DBAnimal(int id, String type, State overallState, long timestamp) {
        this.id = id;
        this.type = type;
        this.overallState = overallState;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public State getOverallState() {
        return overallState;
    }

    public void setOverallState(State overallState) {
        this.overallState = overallState;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getImageID() {
        switch (type) {
            case "Tiger":
                return R.drawable.tiger;
                default:
                    return R.drawable.ic_launcher_foreground;
        }
    }
}
