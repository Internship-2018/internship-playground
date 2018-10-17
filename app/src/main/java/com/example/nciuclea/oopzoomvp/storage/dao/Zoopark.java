package com.example.nciuclea.oopzoomvp.storage.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "zoopark")
public class Zoopark {

    public static final String ID_FIELD_NAME = "id";
    @SerializedName("id")
    @Expose
    @DatabaseField(id = true, columnName = ID_FIELD_NAME)
    private int id;

    @SerializedName("city")
    @Expose
    @DatabaseField(columnName = "city")
    private String city;

    @SerializedName("zooparkName")
    @Expose
    @DatabaseField(columnName = "name")
    private String zooName;

    @SerializedName("address")
    @Expose
    @DatabaseField(columnName = "address")
    private String address;

    public Zoopark () {

    }

    public Zoopark(String city, String zooName, String address) {
        this.city = city;
        this.zooName = zooName;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
