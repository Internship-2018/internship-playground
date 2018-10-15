package com.example.nciuclea.oopzoomvp.storage.dao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "zooparks")
public class Zoopark {

    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "city")
    private String city;

    @DatabaseField(columnName = "name")
    private String zooName;

    @DatabaseField(columnName = "address")
    private String address;

    //for ORM mapping only
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "animal_id")
    private Animal animal;

    public Zoopark () {

    }

    public Zoopark(String city, String zooName, String address, Animal animal) {
        this.city = city;
        this.zooName = zooName;
        this.address = address;
        this.animal = animal;
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
